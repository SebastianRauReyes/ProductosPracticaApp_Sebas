package com.rau.sebastian.productospracticaapp_sebas.models;

import com.orm.dsl.Table;

@Table
public class Product {

    private Long id;
    private String productname;
    private String productprice;
    private String productdesc;
    private String procuctstate;
    private Long id_user;


    public  Product(){

    }

    public Product(String productname, String productprice, String productdesc, String procuctstate, Long id_user) {
        this.productname = productname;
        this.productprice= productprice;
        this.productdesc = productdesc;
        this.procuctstate = procuctstate;
        this.id_user = id_user;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getProcuctstate() {
        return procuctstate;
    }

    public void setProcuctstate(String procuctstate) {
        this.procuctstate = procuctstate;
    }

}
