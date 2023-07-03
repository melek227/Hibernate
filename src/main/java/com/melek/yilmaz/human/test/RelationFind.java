package com.melek.yilmaz.human.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.melek.yilmaz.human.entity.Departmant;
import com.melek.yilmaz.human.entity.Employee;
import com.melek.yilmaz.inventory.entity.Product;


//-------------------ENTİTYNİN PRİMARY KEYİ İLE İLİŞKİLİ OLDUĞU ENTİTYNİN FİELDLERİNE ULAŞMA------------------------//

public class RelationFind {
	
	public static void main(String [] args) {

	long departmentId=1;
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("MyPersistUnit");
	EntityManager entityManager=factory.createEntityManager();
	
	Departmant department=entityManager.find(Departmant.class, departmentId);
	//Varlığı primary keyi ile almak için entityManager örneğinde find  yöntemini çağır
	//Parametre olarak varlığın sınıfını ve birincil anahtarı ver
	
	entityManager.close();
	
	//departman alındığında employeelerin de alınması için
	
	/*İlişkili varlıkta assocation ilişkisini sağlayan attributenin get metodunu çağırarak entity türündeki değişkenle
	  for döngüsü oluştur
	*/
	for(Employee employee: department.getEmployeeList()) {  //Fetch (Getirme)
		System.out.println("\t" +employee.getEmployeeId()+" "
				+employee.getEmployeeName()+" "
				+employee.getMonthlySalary()
				);
		
	}
	
	//departmenti bağlantıyı kapattıktan sonra aldığımızda lazyİnitializationException hatası oluşur
	//departmanda employeeList hemen getirilecek şekilde kurgulanmadığında verilen hata
	//kod bloğu çalışmaya başladığında listeyi getirecektir.
	//Fakat öncesinde manager kapanmış olacaktır.
	
	
	
	
	
	}
	
}
