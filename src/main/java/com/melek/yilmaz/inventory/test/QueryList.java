package com.melek.yilmaz.inventory.test;

import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.melek.yilmaz.inventory.entity.Product;

public class QueryList {
	
	public static void main(String [] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager=factory.createEntityManager();
		
		double salesPriceMin=4000.0;
		
		//sorgu sonucunda gelen ürünleri productlits e aldık
		String jpql="select product from Product as product where product.salesPrice> :salesPriceMin";	
		Query query=entityManager.createQuery(jpql);
		query.setParameter("salesPriceMin", salesPriceMin);
		
		
		List<Product>productList=query.getResultList();
		
		
		entityManager.close();
		
		for(Product product:productList) {
			System.out.println(
					product.getProductId(product)+" "
		            +product.getProductName(jpql)+" " 
				    +product.getSalesPrice(0));
			
		}
	}

}



