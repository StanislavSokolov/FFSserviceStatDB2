package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cdate")
    private String cdate;
    @Column(name = "ctime")
    private String ctime;
    @Column(name = "sdate")
    private String sdate;
    @Column(name = "stime")
    private String stime;
    @Column(name = "finishedPrice")
    private int finishedPrice;
    @Column(name = "forPay")
    private int forPay;
    @Column(name = "odid")
    private String odid;
    @Column(name = "oblastOkrugName")
    private String oblastOkrugName;
    @Column(name = "warehouseName")
    private String warehouseName;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product owner;

    public Item() {
    }

    public Item(String cdate, String sdate, int finishedPrice, int forPay, String odid, String oblastOkrugName, String warehouseName, String status, Product owner) {
        if (cdate.equals("")) {
            this.cdate = "";
            this.ctime = "";
        } else {
            this.cdate = cdate.substring(0, 10);
            this.ctime = cdate.substring(11, 19);
        }
        if (sdate.equals("")) {
            this.sdate = "";
            this.stime = "";
        } else {
            this.sdate = sdate.substring(0, 10);
            this.stime = sdate.substring(11, 19);
        }
        this.finishedPrice = finishedPrice;
        this.forPay = forPay;
        this.odid = odid;
        this.oblastOkrugName = oblastOkrugName;
        this.warehouseName = warehouseName;
        this.status = status;
        this.owner = owner;
    }

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

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getFinishedPrice() {
        return finishedPrice;
    }

    public void setFinishedPrice(int finishedPrice) {
        this.finishedPrice = finishedPrice;
    }

    public int getForPay() {
        return forPay;
    }

    public void setForPay(int forPay) {
        this.forPay = forPay;
    }

    public String getOdid() {
        return odid;
    }

    public void setOdid(String odid) {
        this.odid = odid;
    }

    public String getOblastOkrugName() {
        return oblastOkrugName;
    }

    public void setOblastOkrugName(String oblastOkrugName) {
        this.oblastOkrugName = oblastOkrugName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getOwner() {
        return owner;
    }

    public void setOwner(Product owner) {
        this.owner = owner;
    }
}
