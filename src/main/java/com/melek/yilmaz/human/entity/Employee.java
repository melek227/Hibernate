package com.melek.yilmaz.human.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.List;


@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//İd değeri ıdentity mantığına göre üretilecek kendiliğinden artan
	
	private long _employeeId;
	private String _employeeName;
	private double _monthlySalary;
	
	@ManyToOne (fetch=FetchType.EAGER)
	//employeeleri alırken departmanı da alacağımızda hata vermemesi için EAGER
	
	private Departmant department; //bire çok iliskiyi sağlar.(Assocation) Yapılayıcı constructoruna konmaz.getter setteri var
	
	
	private List<Employee> _employeeList; //ilişkisi çok olan nesneyi tutacak liste 
	
	public Employee(long employeeId, String employeeName, double monthlySalary){
		_employeeId=employeeId;
		_employeeName=employeeName;
		_monthlySalary=monthlySalary;
		
	}
	
	public long getEmployeeId(){
		return _employeeId;
	}
	
	public String getEmployeeName() {
		return _employeeName;
	}
	
	public double getMonthlySalary() {
		return _monthlySalary;
	}
	
	
	public void setEmployeeId(long employeeId) {
		_employeeId=employeeId;

		
	}
	
	public void setEmployeeName(String employeeName) {
		_employeeName=employeeName;

		
	}
	
	public void setMonthlySalary(double monthlySalary) {
		_monthlySalary=monthlySalary;

	}
	
	
	public void setDepartment(Departmant department) {
		
		
	}
	
	public Departmant department() {
		return department;
	}
	
	
	public List<Employee> getEmplooyeList(){
		return _employeeList;
	}
	
	public void setEmployeeList(List<Employee> employeeList) {
		_employeeList=employeeList;
		
	}
	
	
	
	

}
