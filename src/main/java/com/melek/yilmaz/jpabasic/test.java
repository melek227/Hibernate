package com.melek.yilmaz.jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {

    public static void main(String[] args) {

        EntityManagerFactory factory=Persistence.createEntityManagerFactory("sample");//jpa ya bağlanmak için
        EntityManager entityManager=factory.createEntityManager();//veritabanına bağlanan classın adı
        Data data=new Data();
        data.setDataName("godoro");
        data.setDataValue(123.45);

        entityManager.getTransaction().begin();


        entityManager.persist(data);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
