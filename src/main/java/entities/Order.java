package entities;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtProcessing;
import java.util.Date;

@Entity
@Table(name="ORDERS")
public class Order {

    private int orders_id;
    private User user;
    private Address address;
    private double totalPrice;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDERS_ID")
    public int getOrders_id() {
        return orders_id;
    }
    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    @OneToOne
    @JoinColumn(name="USERS_ID")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name="ADDRESS_ID")
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name="TOTALPRICE")
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name="ORDERDATE")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Order(double totalPrice, Date date) {
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public Order() {
    }
}
