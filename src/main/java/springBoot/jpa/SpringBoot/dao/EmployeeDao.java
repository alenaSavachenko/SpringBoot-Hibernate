package springBoot.jpa.SpringBoot.dao;

import springBoot.jpa.SpringBoot.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();
  
    public  Employee findById(int theId);

    public  void save (Employee  theEmpl);


    public void deleteById (int theId);



    
}
