package rikkei.academy.Service;

import java.util.List;

public interface IGenericService <T>{
    List<T> findAll();
    T findById(Long id);
    void  save(T t);
    void  remove(Long id);
}
