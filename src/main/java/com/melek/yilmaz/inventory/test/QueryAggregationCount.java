package com.melek.yilmaz.inventory.test;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.melek.yilmaz.inventory.entity.Product;

public class QueryAggregation {
	
public static void main(String [] args) {
		
		Product product;
		//sorguda tabloda değer yoksa NoResultException hatası fırlatır.
		//try catch bloğuna alıp sorgudan geriye değer dönmüyorsa null değer döndürmeliyiz
		try {
			
			
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
			EntityManager entityManager=factory.createEntityManager();
			
			double salesPriceMin=4000.0;
			
			//sorgu sonucunda gelen ürünleri productlits e aldık
			String jpql="select count(product.productId) from Product as product where product.salesPrice< :salesPriceMin";	
			Query query=entityManager.createQuery(jpql);
			query.setParameter("salesPriceMin", salesPriceMin);
			
			
			long count=(Long)query.getSingleResult(); //tek bir sonuç geleceği için singleresult kullandık
			
			
			
			entityManager.close();
			
			System.out.println("Sayi"+count);
			
			
			
			
		}catch(NoResultException e){
			
			product=null;
			
		}
		
		if(product!=null) {
			
			System.out.println(
					product.getProductId(product)+" "
		            +product.getProductName(jpql)+" " 
				    +product.getSalesPrice(0));
			
		
	        }else {
	        	System.out.println("Hiç ürün yok");
	        }

		}
			
}
		
		



