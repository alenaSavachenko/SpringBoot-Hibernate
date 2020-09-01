package springBoot.jpa.SpringBoot.dao;

import springBoot.jpa.SpringBoot.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

}
