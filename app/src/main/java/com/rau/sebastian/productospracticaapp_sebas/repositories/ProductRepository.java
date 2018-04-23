package com.rau.sebastian.productospracticaapp_sebas.repositories;

import com.orm.SugarRecord;
import com.rau.sebastian.productospracticaapp_sebas.models.Product;

import java.util.List;

public class ProductRepository {


    public static List<Product> list(){
        List<Product> products = SugarRecord.listAll(Product.class);
        return products;
    }



    public static Product read(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        return product;
    }


    public static void create(String productname, String productprice, String productdesc, String procuctstate, Long id_user){
        Product product = new Product(productname, productprice,  productdesc, procuctstate, id_user);
        SugarRecord.save(product);
    }


    public static void update(String productname, String productprice, String productdesc, String procuctstate, Long id_user, Long id){
        Product product= SugarRecord.findById(Product.class, id);
        product.setProductname(productname);
        product.setProductprice(productprice);
        product.setProductdesc(productdesc);
        product.setProcuctstate(procuctstate);
        product.setId_user(id_user);
        SugarRecord.save(product);
    }

    public static void delete(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        SugarRecord.delete(product);
    }

}
