package ru.ngs.summerjob.springboot.spring_boot_rest.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ngs.summerjob.springboot.spring_boot_rest.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("FROM Employee", Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        if (employee.getId() == 0) {
            session.persist(employee);
        } else {
            session.merge(employee);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        MutationQuery mutationQuery = session.createMutationQuery("DELETE FROM Employee WHERE id = :employeeID");
        mutationQuery.setParameter("employeeID", id);
        mutationQuery.executeUpdate();
    }
}
