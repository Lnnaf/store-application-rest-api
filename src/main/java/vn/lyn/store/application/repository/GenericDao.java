package vn.lyn.store.application.repository;

import vn.lyn.store.application.bo.entity.CustomerEntity;

import java.util.List;

public interface GenericDao<T> {
    List<T> getAll();
    T save(T object);
    void delete(T object);
    Boolean isExistById(Long id);
    T update(T object);
}
