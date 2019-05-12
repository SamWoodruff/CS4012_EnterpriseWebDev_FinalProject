package Controllers;

import Repositories.DatabaseAccessObject;
import entities.Order;
import entities.OrderItem;
import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
public class OrdersController {
    @Inject
    DatabaseAccessObject dao;

    @RequestMapping(value="/confirmOrder")
    public String confirmOrder(HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";

        ArrayList<OrderItem> shoppingCart = (ArrayList<OrderItem>)session.getAttribute("shoppingCart");
        Order o = new Order();
        o.setUser(u);
        o.setAddress(dao.getAddressByUserId(u));
        o.setDate(new Date());
        double sum = 0;
        for (OrderItem oI: shoppingCart) {
            sum += oI.getTotalPrice();
        }
        o.setTotalPrice(sum);
        this.dao.saveOrder(o);
        for(OrderItem oI: shoppingCart){
            oI.setOrder(o);
            this.dao.saveOrderItem(oI);
        }
        session.setAttribute("shoppingCart", new ArrayList<OrderItem>());
        return "redirect:/orderDetails/" + o.getOrders_id();
    }

    @RequestMapping(value="/orderDetails/{order_id}")
    public String orderDetails(Map<String, Object> model, HttpSession session, @PathVariable int order_id)
    {
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";

        Order o = this.dao.getOrderById(order_id);
        ArrayList<OrderItem> oI = this.dao.getOrderItemsByOrderId(order_id);

        model.put("order", o);
        model.put("orderItems", oI);
        return "/Orders/OrderDetailPage";
    }

    @RequestMapping(value = "/orders")
    public String orderPage(Map<String, Object> model, HttpSession session){
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";

        ArrayList<Order> orders = this.dao.getOrderByUserId(u.getUser_id());
        model.put("orders", orders);

        return "/Orders/OrdersPage";
    }
}
