package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "year2023")
public class Year2023 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cdate")
    private String cdate;

    @Column(name = "csum")
    private int csum;

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

    public int getCsum() {
        return csum;
    }

    public void setCsum(int csum) {
        this.csum = csum;
    }

    public Year2023(String cdate, int csum) {
        this.cdate = cdate;
        this.csum = csum;
    }

    public Year2023() {
    }
}