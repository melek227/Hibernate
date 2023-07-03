package com.melek.yilmaz.human.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Departmant {
	
    //--------------------------------ATTRİBUTE-------------------------//
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//İd değeri ıdentity mantığına göre üretilecek kendiliğinden artan
	private long _departmentId;
	private String _departmentName;
	
	@OneToMany (//Yapılan her işlemi Employee entitysine yansıtmayı sağlar
			mappedBy="deparment", //mappedby  employee nesnesinde  hangi fieldin ilişkiyi kurduğunu belirtir.
			//	İlişki kurulan sınıfı gösterir
			cascade=CascadeType.ALL, //Bölümü kaydederken içindeki çalışanları da kaydetmesi için
			fetch=FetchType.EAGER) //LazyİnitializationException hatasını önler
	        //Departmanı getirirken employeeleri de getirecek
	        //sıkı sıkıya bağlı olan entitylerde birini getirirken diğerini de getirmeliyiz.EAGER kullanılır
	        //composit?
	        //provider //implementasyon??
	
	@JoinColumn(name="departmentId") 
	//manyToOne ilişkisi olduğu sınıftan çağırılacak attributeyi gösterir
	// set ve get metotları kullanılır fakat constructorda kullanılmaz

	private List<Employee> _employeeList; //employee entitysinin asssocistion ilişkisi kuran attributesi
	
	
	//----------------------BOŞ CONSTRUCTOR------------------------------//
	public Departmant() { //bean sağlamak için constructoru boş tanımladık
		
	}
	
	public Departmant(long departmentId, String departmentName) {
		_departmentName=departmentName;
		_departmentId=departmentId;
	}
	
	//----------------------GETTER-SETTER----------------------------//
	public long getDepartmentId(){
		return  _departmentId;
	}
	
	public void setDepartmentId(String departmentId) {
		
	}
	
	public String getDepartmentName() {
		return _departmentName;
		
	}
	
	public void setDepartmentName(String departmentName) {
		
		_departmentName=departmentName;
	}

	public void setEmployeeList(List myList) {
		
		
	}
	
	public List<Employee> getEmployeeList(){
		return _employeeList;
		
	}



}
