package com.company.employees.dao.interfaces;

import com.company.employees.model.abstracts.Model;

import java.util.List;

/**
 * интерфейс для интерфейсов dao
 */
public interface ItemDao<T extends Model> {

    default List<T> getAll() {
        return null;
    }

    default T getById(int id) {
        return null;
    }

    default void add(T model) {
    }

    default void update(T model) {
    }

    default void delete(int id) {
    }
}
