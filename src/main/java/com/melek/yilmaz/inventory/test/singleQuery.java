package com.melek.yilmaz.inventory.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.melek.yilmaz.inventory.entity.Product;

public class singleQuery {
	
	public static void main(String [] args) {
		
		Product product;
		//sorguda tabloda değer yoksa NoResultException hatası fırlatır.
		//try catch bloğuna alıp sorgudan geriye değer dönmüyorsa null değer döndürmeliyiz
		try {
			
			
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
			EntityManager entityManager=factory.createEntityManager();
			
			double salesPriceMin=4000.0;
			
			//sorgu sonucunda gelen ürünleri productlits e aldık
			String jpql="select product from Product as product where product.salesPrice< :salesPriceMin";	
			Query query=entityManager.createQuery(jpql);
			query.setParameter("salesPriceMin", salesPriceMin);
			
			
			Object product1=query.getSingleResult();
			
			
			entityManager.close();
			
			
			
		}catch(NoResultException e){
			
			product=null;
			
		}
		
		if(product!=null) {
			
			System.out.println(
					product.getProductId(product)+" "
		            +product.getProductName()+" " 
				    +product.getSalesPrice(0));
			
		
	      }else {
	        	System.out.println("Hiç ürün yok");
	      }

	}
			
}
		
		

		
		


