package com.company.employees.dao;

import com.company.employees.dao.interfaces.GenderDao;
import com.company.employees.model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * класс dao для доступа к таблице "пол" из БД
 */
@Repository
public class GenderDaoDatabase implements GenderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Gender> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Gender> genderList = session.createQuery("FROM Gender").list();

        return genderList;
    }
}
