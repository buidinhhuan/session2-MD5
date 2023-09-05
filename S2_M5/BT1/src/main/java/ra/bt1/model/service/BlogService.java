package ra.bt1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.bt1.model.entity.blogs;
import ra.bt1.model.repository.blog.IBlogRepository;

import java.util.List;

@Service
public class BlogService implements  IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<blogs> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public blogs findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(blogs blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
