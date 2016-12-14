package com.company.employees.service;

import com.company.employees.dao.interfaces.EmployeeDao;
import com.company.employees.model.Employee;
import com.company.employees.service.interfaces.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * слой сервис для сотрудника
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDaoDatabase;

    @Override
    @Transactional
    public List<Employee> getAll() {
        log.info("Получить список всех сотрудников");
        return employeeDaoDatabase.getAll();
    }

    @Override
    @Transactional
    public Employee getById(int id) {
        log.info("Получить конкректного сотрудника по id");
        return employeeDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public void add(Employee model) {
        log.info("Добавление нового сотрудника");
        employeeDaoDatabase.add(model);
    }

    @Override
    @Transactional
    public void update(Employee model) {
        log.info("Обновление информации о существующем сотруднике");
        employeeDaoDatabase.update(model);
    }

    @Override
    @Transactional
    public void delete(int id) {
        log.info("Удаление существующего сотрудника");
        employeeDaoDatabase.delete(id);
    }
}
