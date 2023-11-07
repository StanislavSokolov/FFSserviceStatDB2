package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "supplierArticle")
    private String supplierArticle;
//    @Column(name = "quantity")
//    private String quantity;
//    @Column(name = "quantityFull")
//    private String quantityFull;
    @Column(name = "nmId")
    private String nmId;
    @Column(name = "subject")
    private String subject;
//    @Column(name = "warehouseName")
//    private String warehouseName;
    @Column(name = "price")
    private int price;
    @Column(name = "discount")
    private int discount;
    @Column(name = "shopName")
    private String shopName;

    @OneToMany(mappedBy = "owner")
    private List<Stock> stocks;

    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    public Product() {
    }

    public Product(String supplierArticle, String nmId, String subject, int price, int discount, String shopName) {
        this.supplierArticle = supplierArticle;
        this.nmId = nmId;
        this.subject = subject;
        this.price = price;
        this.discount = discount;
        this.shopName = shopName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierArticle() {
        return supplierArticle;
    }

    public void setSupplierArticle(String supplierArticle) {
        this.supplierArticle = supplierArticle;
    }

    public String getNmId() {
        return nmId;
    }

    public void setNmId(String nmId) {
        this.nmId = nmId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}


