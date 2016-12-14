package com.company.employees.dao;

import com.company.employees.dao.interfaces.EmployeeDao;

import com.company.employees.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * класс dao для доступа к таблице "сотрудники" из БД
 */
@Repository
public class EmployeeDaoDatabase implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("FROM Employee").list();

        return employeeList;
    }

    @Override
    public Employee getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void add(Employee model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Employee model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);

        if(employee != null){
            session.delete(employee);
        }
    }
}
