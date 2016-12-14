package com.company.employees.dao;

import com.company.employees.dao.interfaces.PositionDao;
import com.company.employees.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * класс dao для доступа к таблице "должность" из БД
 */
@Repository
public class PositionDaoDatabase implements PositionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Position> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Position> positionList = session.createQuery("FROM Position").list();

        return positionList;
    }
}
