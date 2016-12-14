package com.company.employees.service;

import com.company.employees.dao.interfaces.GenderDao;
import com.company.employees.model.Gender;
import com.company.employees.service.interfaces.GenderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Cслой сервис для пола сотрудника
 */
@Service
public class GenderServiceImpl implements GenderService {
    private static final Logger log = Logger.getLogger(GenderServiceImpl.class);

    @Autowired
    private GenderDao genderDaoDatabase;

    @Override
    @Transactional
    public List<Gender> getAll() {
        log.info("Пол сотрудника");
        return genderDaoDatabase.getAll();
    }
}
