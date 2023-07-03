package com.melek.yilmaz.inventory.test;




import javax.persistence.EntityManagerFactory;


//veritabanından çıkarma işlemlerinin yapıldığı class

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import com.melek.yilmaz.inventory.entity.Product;
import javax.persistence.Persistence;

public class ProductRemove {

    public static void main(String[] args) {
        long productId=1;

        EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();

        //jpa nesne tabanlı çalışır.id ile silme işlemi yapmaz.
        //önce nesneyi bulmalıyız
        //nesnenin altında başka nesneler olabilir
        //Bu durum performansı düşürdüğü için find yerine getReference
        //getReference bellekte varsa getirir veritabanına gitmesi gerekmez
        Product product=entityManager.getReference(Product.class, productId);
        //sonra silmeliyiz
        entityManager.remove(product);


        entityManager.getTransaction().commit();

        entityManager.close();



    }

}