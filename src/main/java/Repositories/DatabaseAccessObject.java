package Repositories;

import entities.*;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class DatabaseAccessObject {
    @PersistenceContext
    protected EntityManager entityManager;
    @Inject
    UserRepository userRepository;
    @Inject
    AddressRepository addressRepository;
    @Inject
    ProductRepository productRepository;
    @Inject
    OrderItemsRepository orderItemsRepository;
    @Inject
    OrderRepository orderRepository;


    @Transactional
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Transactional
    public void saveAddress(Address address) {
        this.addressRepository.save(address);
    }

    @Transactional
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Transactional
    public void saveOrderItem(OrderItem orderItem) {
        this.orderItemsRepository.save(orderItem);
    }

    @Transactional
    public void saveOrder(Order order) {
        this.orderRepository.save(order);
    }

    //checks data entered on sign in page with db
    @Transactional
    public Boolean isVerifiedUser(User user) {
        Boolean verified = false;//start false and show is user
        Query query;
        query = entityManager.createNativeQuery("SELECT * FROM users WHERE LOGON_ID = :logon_id AND PASSWORD = :password");
        query.setParameter("logon_id", user.getLogon_id());
        query.setParameter("password", user.getPassword());

        List<Object[]> users = query.getResultList();
        if (!users.isEmpty()) {

            for (Object[] a : users) {
                if (a[1].equals(user.getLogon_id()) && a[2].equals(user.getPassword())) {
                    user.setUser_id((int) a[0]);
                    verified = true;
                }
            }

        }
        return verified;
    }

    //check email on registration page--will only create new entry in db if email isnt taken
    @Transactional
    public Boolean isEmailTaken(User user) {
        Boolean isEmailTaken = false;//start false and show is user
        Query query;
        query = entityManager.createNativeQuery("SELECT * FROM users WHERE LOGON_ID = :logon_id");
        query.setParameter("logon_id", user.getLogon_id());

        List<Object[]> emails = query.getResultList();
        if (!emails.isEmpty()) {

            for (Object[] a : emails) {
                if (a[1].equals(user.getLogon_id())) {
                    isEmailTaken = true;
                }
            }

        }
        return isEmailTaken;
    }

    @Transactional
    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Transactional
    public byte[] loadImage(int productId) {
        return entityManager.find(Product.class, productId).getImage();
    }

    @Transactional
    public Product getProductById(int id) {
        return productRepository.findOne(id);
    }

    @Transactional
    public Address getAddressByUserId(User u){
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a where a.user.user_id = :user_id", Address.class);
        query.setParameter("user_id", u.getUser_id());
        List<Address> a = query.getResultList();
        if(a.isEmpty()) return null;
        return a.get(0);
    }

    @Transactional
    public Order getOrderById(int order_id){
        return orderRepository.findOne(order_id);
    }

    @Transactional
    public ArrayList<OrderItem> getOrderItemsByOrderId(int order_id){
        TypedQuery<OrderItem> query = entityManager.createQuery("SELECT oI FROM OrderItem oI where oI.order.orders_id = :order_id", OrderItem.class);
        query.setParameter("order_id", order_id);
        List<OrderItem> a = query.getResultList();
        if(a.isEmpty()) return null;
        return (ArrayList<OrderItem>) a;
    }

    @Transactional
    public ArrayList<Order> getOrderByUserId(int userId){
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o where o.user.user_id = :user_id", Order.class);
        query.setParameter("user_id", userId);
        List<Order> a = query.getResultList();
        if(a.isEmpty()) return null;
        return (ArrayList<Order>) a;
    }
}
