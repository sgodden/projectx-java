package org.sgodden.tom.model;

import java.util.List;

public interface BaseRepository<T> {

    void remove(T entity);

    List<T> findAll();

    void persist(T entity);

    void merge(T entity);

    T findById(String id);

    long count();

}
