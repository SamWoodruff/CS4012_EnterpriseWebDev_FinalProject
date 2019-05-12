package entities;

import org.springframework.context.annotation.ComponentScan;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="Address")
public class Address implements Serializable{
    private int addressId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    private User user;

    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @OneToOne
    @JoinColumn(name="USERS_ID")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    @Column(name="FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name="LASTNAME")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name="ADDRESS")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name="CITY")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Column(name="STATE")
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    @Column(name="ZIPCODE")
    public String getZipCode() {
        return zipcode;
    }
    public void setZipCode(String zipCode) {
        this.zipcode = zipCode;
    }

    protected Address(){}

    public Address(String firstName, String lastName, String address, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipCode;
    }
}
