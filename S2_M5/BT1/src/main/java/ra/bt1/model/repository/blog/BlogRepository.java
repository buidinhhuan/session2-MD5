package ra.bt1.model.repository.blog;

import org.springframework.stereotype.Repository;
import ra.bt1.model.entity.blogs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BlogRepository implements  IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<blogs> findAll() {
        return entityManager.createQuery("SELECT b FROM blogs AS b", blogs.class)
                .getResultList();
    }

    @Override
    public blogs findById(Long id) {
        return entityManager.createQuery("SELECT b FROM blogs AS b WHERE id=:id", blogs.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(blogs blogs) {
        if (blogs.getId() == null) {
            entityManager.persist(blogs);
        } else {
            entityManager.merge(blogs);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
