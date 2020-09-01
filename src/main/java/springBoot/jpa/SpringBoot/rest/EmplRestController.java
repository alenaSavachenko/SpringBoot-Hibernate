package springBoot.jpa.SpringBoot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBoot.jpa.SpringBoot.dao.EmployeeDao;
import springBoot.jpa.SpringBoot.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmplRestController {

    private EmployeeDao employeeDao;


    //inject empl dao

    @Autowired
    public EmplRestController(EmployeeDao theEmployeDao)
    {
     employeeDao=theEmployeDao;
    }
    //endpoint, return list with all employes
     @GetMapping("/employees")

    public List<Employee> findAll()
     {
         return employeeDao.findAll();
     }


}
