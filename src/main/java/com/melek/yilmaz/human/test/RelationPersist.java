package com.melek.yilmaz.human.test;

import java.util.ArrayList;

import javax.persistence.*;
import com.melek.yilmaz.human.entity.*;

public class RelationPersist {
	
	public static void main(String [] args) {
		
		//-----------------Nesneler Arası İlişkilerin tanımlanması-------------//
		Departmant departmentA=new Departmant(0,"Muhasebe");
		
		departmentA.setEmployeeList(new ArrayList<>());
		
		
		Employee employee1=new Employee(0,"melek yılmaz", 5430);
		
		
		employee1.setDepartment(departmentA);
	
		departmentA.getEmployeeList().add(employee1);
		
		//Entity örnekleri oluşturulur
		//Oluşturulan entity örneklerine assocation ilişkisi kuran attributenin set fonksiyonuna uygulanır.
		//set fonksiyonuna parametre olarak association ilişkisi olan attributenin örneği verilir
		
		
		//------------------------------------------------------------------//
		
		
		Employee employee2=new Employee(0,"yılmaz", 5430);
		employee2.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee2);
		
		
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager=factory.createEntityManager();
		
		//Java Persistence API (JPA) sini kullanarak EntityManagerFactory örneği tanımla
		//EntityManagerFactory  örneğiyle EntityManager yarat
		//EntityManager veritabanıyla etkileşimde bulunmak için kullanılır
		
		
		//--------------------------------------------------------------------//
		
		entityManager.getTransaction().begin();
		
		//EntityManager aracılığıyla EntityTransaction nesnesini alıp begin metoduyla veritabanına uygula
		
		
		//EntityTransaction nesnesi Java Persistence API içinde bir işlemi (transaction) temsil eden arayüzdür.
		//Bu arayüz EntityManager örneği üzerindeki işlemleri yönetmek için kullanılır
		//Java Persistence API Java uygulamalarındaki ilişkisel veri tabanlarıyla etkileşimde bulunmayı sağlar.
		//Nesne ilişkisel haritalama(Object Relational Mapping) için kullanılır
		
		//---------------------------------------------------------------------//
		
		entityManager.persist(departmentA); //departmentA nesnesini ve ilgili employeeleri kaydeder

		//EntityManager örneğine persist metodunu uygulayarak entity nesnesini veritabanına eklemek üzere zamanla.
		//Böylece varlık eşlemelerine dayalı olarak SQL ifadeleri oluşacak ve nesnenin durumuyla ilgili tablo kaydedilecek
		
		//-----------------------------------------------------------------------------------//
		
		
		entityManager.getTransaction().commit();
		
		/*EntityManager aracılığıyla alınan  EntityTransaction nesnesinin commit metodunu  çağırarak varlıklarda yapılan
		  değişiklikleri veritabanına kalıcı olarak kaydet.
		*/
		
		//----------------------------------------------------------------------------------//
		
		entityManager.close(); //entity örneğini kapat
		
		
		
		
		
	}

	
	
}
