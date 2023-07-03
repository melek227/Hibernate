package com.melek.yilmaz.inventory.test;



//var olan kaydı bulmak için oluşturulan class
//persist(veritabanında değişiklik) yapmayacağımız için transactiona ihtiyacımız yok
//transaction ???????

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import com.melek.yilmaz.inventory.entity.Product;


public class ProductFind {

  public static void main(String[] args) {


      long productId=1; //bulmak istediğimiz kaydın idsi

      EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
      EntityManager entityManager=factory.createEntityManager();


      Product product=entityManager.find(Product.class, productId);

      entityManager.close();





  }

}