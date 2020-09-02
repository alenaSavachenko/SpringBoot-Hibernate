package springBoot.jpa.SpringBoot.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springBoot.jpa.SpringBoot.entity.Employee;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        //get the currrent hibernate session
        Session currentSession =entityManager.unwrap(Session.class);
        //create and wxecute the query
        Query<Employee> theQuery=currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees=theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {


        //get the current hibernate session

        Session currentSession=entityManager.unwrap(Session.class);

        Employee  theEmpl=currentSession.get(Employee.class, theId);

        return theEmpl;

    }

    @Override
    public void save(Employee theEmpl) {

        Session currentSession= entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theEmpl);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession= entityManager.unwrap(Session.class);

        currentSession.delete(theId);

        Query  query= currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",theId );

        query.executeUpdate();

    }
}
