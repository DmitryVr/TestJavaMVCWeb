package com.company.employees.service;

import com.company.employees.dao.interfaces.PositionDao;
import com.company.employees.model.Position;
import com.company.employees.service.interfaces.PositionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * слой сервис для должности сотрудника
 */
@Service
public class PositionServiceImpl implements PositionService {
    private static final Logger log = Logger.getLogger(PositionServiceImpl.class);

    @Autowired
    private PositionDao positionDaoDatabase;

    @Override
    @Transactional
    public List<Position> getAll() {
        log.info("Должность сотрудника");
        return positionDaoDatabase.getAll();
    }
}
