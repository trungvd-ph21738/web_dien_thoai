package com.poly.ph21738.repositories;

import java.util.List;

public interface ICommomRepository<T,K>{
    List<T> findAll();
    T findById(K id);
    Boolean add(T t);
    Boolean update(T t);
    Boolean delete(T t);
    List<T> findByName(String keyword);
}
