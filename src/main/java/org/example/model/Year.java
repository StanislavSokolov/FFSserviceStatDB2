package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "year2023")
public class Year {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cdate")
    private String cdate;

    @Column(name = "orders")
    private int orders;

    @Column(name = "sales")
    private int sales;

    public int getReturns() {
        return returns;
    }

    public void setReturns(int returns) {
        this.returns = returns;
    }

    @Column(name = "returns")
    private int returns;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Year(String cdate, int orders, int sales, int returns) {
        this.cdate = cdate;
        this.orders = orders;
        this.sales = sales;
        this.returns = returns;
    }

    public Year() {
    }
}