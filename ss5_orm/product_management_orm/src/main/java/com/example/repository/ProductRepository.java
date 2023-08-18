package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> display() {
      TypedQuery<Product> query=entityManager.createQuery("from Product ",Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void add(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findID(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void update(Product product) {
        try{
            entityManager.merge(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Transactional
    @Override
    public void delete(int id) {
        try{
        entityManager.remove(findID(id));
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public Product findByName(String name) {
        name = "%"+name+"%";
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.name like:name1"
                , Product.class);
        query.setParameter("name1",name);
        return query.getSingleResult();
    }
}
