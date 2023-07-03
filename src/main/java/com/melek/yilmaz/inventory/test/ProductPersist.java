package com.melek.yilmaz.inventory.test;



import javax.persistence.Persistence;
import com.melek.yilmaz.inventory.entity.Product;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;


public class ProductPersist {

    public static void main(String[]args) {


        Product product=new Product("cep telefonu",134.56, 0);



        EntityManagerFactory factory=Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();


        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();


        entityManager.persist(product);




        entityManager.close();



    }

}