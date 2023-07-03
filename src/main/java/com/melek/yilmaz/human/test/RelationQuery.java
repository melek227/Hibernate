package com.melek.yilmaz.human.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.melek.yilmaz.human.entity.Employee;
import com.melek.yilmaz.inventory.entity.Product;


//-------------------JPQL SORGUSUYLA İLİŞKİLİ NESNENİN FİELDİNİ GETİRMEK------------------------//

//employeeleri alırken departmanı da alıp almayacağına baktık
public class RelationQuery {

	public static void main(String [] args) {
		
		long departmentId=2;
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager=factory.createEntityManager();
		
		
		//---------------------------------------------------------------------------------------//
		
		String jpql="select employee from Employee as employee"
				+"where employee.department.departmentId=: departmentId ";
		
		//İlişkili bir yerden sorgu sonucu almak istersek
		//department classının departmentId fieldini almak istedik
		//ilişki kurulan nesneyi bulup fieldi class ismiyle çağardık
		
		//------------------------------------------------------------------------------------//
		Query query=entityManager.createQuery(jpql);
		//Sorgu nesnesi oluşturmak için EntityManager örneğinde createQuery() yöntemi çağrılır. 
		//Bu yöntem parametre olarak bir JPQL (Java Persistence Query Language) sorgu dizesi alır.
		
		
		//--------------------------------------------------------------------------------------//
		
		query.setParameter("departmentId", departmentId );
		//departmanId 2 olarak ayarlanır
		
		
		//------------------------------------------------------------------------------------//
		
		List<Employee>employeeList=query.getResultList();
		// Sorguyu yürütmek ve sonuçları almak için Sorgu nesnesinde getResultList() yöntemi çağrılır.
		//Bu yöntem, sorgu sonuçlarını nesnelerin listesi olarak döndürür.
		
		
		//------------------------------------------------------------------------------------//
		entityManager.close();
		
		
	}
	
}
