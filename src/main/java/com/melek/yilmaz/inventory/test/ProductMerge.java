package com.melek.yilmaz.inventory.test;



import javax.persistence.Persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import com.melek.yilmaz.inventory.entity.Product;

//var olan kaydı güncellemek için

public class ProductMerge {

    public static void main(String [] args) {

        long productId=1;

        EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product=entityManager.find(Product.class, productId);

        product.setProductName("masaüstü bilgisayar");
        product.setSalesPrice(3456);
        entityManager.merge(product);

        entityManager.getTransaction().commit();

        entityManager.close();
    }



}