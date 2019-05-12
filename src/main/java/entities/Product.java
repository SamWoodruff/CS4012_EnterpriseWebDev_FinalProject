package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable {
    private int product_id;
    private String partNumber;
    private String name;
    private double price;
    private byte[] image;

    public Product() {
    }

    @Id
    @GeneratedValue
    @Column(name="PRODUCTS_ID")
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Column(name="PARTNUMBER")
    public String getPartNumber() {
        return partNumber;
    }
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="PRICE")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="IMAGE")
    public byte[] getImage(){

        return image;
    }
    public void setImage(byte[] image) {
        this.image= image;
    }


    public Product(String partNumber, String name, double price, byte[] image) {
        this.partNumber = partNumber;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}

