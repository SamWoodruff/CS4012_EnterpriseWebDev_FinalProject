package entities;

import javax.persistence.*;

@Entity
@Table(name="ORDERITEMS")
public class OrderItem {

    private int ordersItems_id;
    private Order order;
    private Product product;
    private int quantity;
    private double totalPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDERITEMS_ID")
    public int getOrdersItems_id() {
        return ordersItems_id;
    }
    public void setOrdersItems_id(int orders_id) {
        this.ordersItems_id= orders_id;
    }

    @OneToOne
    @JoinColumn(name="ORDERS_ID")
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToOne
    @JoinColumn(name="PRODUCTS_ID")
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name="QUANTITY")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name="TOTALPRICE")
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
