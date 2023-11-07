package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nameShopWB")
    private String nameShopWB;
    @Column(name = "tokenStandartWB")
    private String tokenStandartWB;
    @Column(name = "tokenStatisticWB")
    private String tokenStatisticWB;
    @Column(name = "tokenAdvertisingWB")
    private String tokenAdvertisingWB;

    @Column(name = "nameShopOzon")
    private String nameShopOzon;
    @Column(name = "tokenClientOzon")
    private String tokenClientOzon;
    @Column(name = "tokenStatisticOzon")
    private String tokenStatisticOzon;

    public User() {
    }

    public User(String nameShopWB, String tokenStandartWB, String tokenStatisticWB, String tokenAdvertisingWB, String nameShopOzon, String tokenClientOzon, String tokenStatisticOzon) {
        this.nameShopWB = nameShopWB;
        this.tokenStandartWB = tokenStandartWB;
        this.tokenStatisticWB = tokenStatisticWB;
        this.tokenAdvertisingWB = tokenAdvertisingWB;
        this.nameShopOzon = nameShopOzon;
        this.tokenClientOzon = tokenClientOzon;
        this.tokenStatisticOzon = tokenStatisticOzon;
    }

    public String getNameShopWB() {
        return nameShopWB;
    }

    public void setNameShopWB(String nameShopWB) {
        this.nameShopWB = nameShopWB;
    }

    public String getTokenStandartWB() {
        return tokenStandartWB;
    }

    public void setTokenStandartWB(String tokenStandartWB) {
        this.tokenStandartWB = tokenStandartWB;
    }

    public String getTokenStatisticWB() {
        return tokenStatisticWB;
    }

    public void setTokenStatisticWB(String tokenStatisticWB) {
        this.tokenStatisticWB = tokenStatisticWB;
    }

    public String getTokenAdvertisingWB() {
        return tokenAdvertisingWB;
    }

    public void setTokenAdvertisingWB(String tokenAdvertisingWB) {
        this.tokenAdvertisingWB = tokenAdvertisingWB;
    }

    public String getNameShopOzon() {
        return nameShopOzon;
    }

    public void setNameShopOzon(String nameShopOzon) {
        this.nameShopOzon = nameShopOzon;
    }

    public String getTokenClientOzon() {
        return tokenClientOzon;
    }

    public void setTokenClientOzon(String tokenClientOzon) {
        this.tokenClientOzon = tokenClientOzon;
    }

    public String getTokenStatisticOzon() {
        return tokenStatisticOzon;
    }

    public void setTokenStatisticOzon(String tokenStatisticOzon) {
        this.tokenStatisticOzon = tokenStatisticOzon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
