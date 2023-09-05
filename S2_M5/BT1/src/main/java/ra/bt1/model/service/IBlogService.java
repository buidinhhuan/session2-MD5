package ra.bt1.model.service;

import ra.bt1.model.entity.blogs;

import java.util.List;

public interface IBlogService {
    List<blogs> findAll();
    blogs findById(Long id);
    void save(blogs blog);
    void delete(Long id);
}
