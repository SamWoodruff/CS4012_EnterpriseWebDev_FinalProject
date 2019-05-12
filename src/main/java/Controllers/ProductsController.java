package Controllers;
import Forms.ProductForm;
import Repositories.DatabaseAccessObject;
import entities.OrderItem;
import entities.Product;
import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class ProductsController {
    @Inject
    DatabaseAccessObject dao;

    @RequestMapping("/Products")
    public String mainProductPage(HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";
        ArrayList<Product> products= dao.getProducts();
        session.setAttribute("products",products);

        return "/Products/ProductListingPage";
    }

    @RequestMapping(value = "/addToCart/{current}", method = RequestMethod.POST)
    public String addToCart(@PathVariable("current")int current, HttpSession session, int quantity)
    {
        ArrayList<OrderItem> shoppingCart = (ArrayList<OrderItem>)session.getAttribute("shoppingCart");
        if(shoppingCart == null)
            shoppingCart = new ArrayList<>();
        boolean itemExists = false;
        for(OrderItem oI: shoppingCart){
            if(oI.getProduct().getProduct_id()==current){
                oI.setQuantity(oI.getQuantity() + quantity);
                oI.setTotalPrice(oI.getQuantity() * oI.getProduct().getPrice());
                itemExists = true;
                break;
            }
        }
        if(!itemExists){
            Product product = dao.getProductById(current);
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(quantity);
            item.setTotalPrice(quantity * product.getPrice());
            shoppingCart.add(item);
        }
        session.setAttribute("shoppingCart",shoppingCart);
        return "redirect:/Products";

    }

    @RequestMapping("/SellProduct")
    public String sellProducts(Map<String, Object> model, HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";
        model.put("productForm", new ProductForm());
        return "/Products/SellProduct";
    }

    @RequestMapping(value="/SellProduct", method= RequestMethod.POST)
    public String getProduct(ProductForm form) throws IOException
    {
        Product product;
        MultipartFile picture = form.getImage();
        byte[] bytes = picture.getBytes();
        product = new Product(form.getPartNumber(),form.getName(),form.getPrice(),bytes);
        dao.saveProduct(product);

        return "redirect:/Products";
    }

    @RequestMapping("/image/{current}")
    public void ShowProductImage(@PathVariable("current") int current, HttpServletResponse response)throws IOException {
        byte[] image = dao.loadImage(current);
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(image);
        outputStream.close();
    }

    @RequestMapping(value="/ViewCart")
    public String viewCart(HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";
        return "/Products/ShoppingCart";
    }

    @RequestMapping("/removeFromCart/{current}")
    public String removeFromCart(@PathVariable("current")int current, HttpSession session)
    {
        User u = (User)session.getAttribute("user");
        if(u == null) return "redirect:/";
        ArrayList<OrderItem> shoppingCart = (ArrayList<OrderItem>)session.getAttribute("shoppingCart");
        if(shoppingCart != null){
            OrderItem tmp = new OrderItem();
            for(OrderItem oI: shoppingCart){
                if(oI.getProduct().getProduct_id()==current) {
                    tmp = oI;
                    break;
                }
            }
            shoppingCart.remove(tmp);
            session.setAttribute("shoppingCart",shoppingCart);
        }
        return "redirect:/ViewCart";
    }

    @RequestMapping(value = "/updateCart/{current}", method = RequestMethod.POST)
    public String updateCart(@PathVariable("current")int current, HttpSession session, int quantity)
    {
        ArrayList<OrderItem> shoppingCart = (ArrayList<OrderItem>)session.getAttribute("shoppingCart");
        if(shoppingCart != null){
            for(OrderItem oI: shoppingCart){
                if(oI.getProduct().getProduct_id()==current) {
                    oI.setQuantity(quantity);
                    oI.setTotalPrice(oI.getProduct().getPrice() * oI.getQuantity());
                }
            }
            session.setAttribute("shoppingCart",shoppingCart);
        }
        return "redirect:/ViewCart";
    }

}
