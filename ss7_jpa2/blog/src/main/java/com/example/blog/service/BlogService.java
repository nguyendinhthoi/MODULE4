package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog.getDescription(), blog.getName(), blog.getCategory().getIdCategory());
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByName(Pageable pageable, String searchName) {
        return blogRepository.findBlogByNameContaining(pageable, "%" + searchName + "%");
    }
}
