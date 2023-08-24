package com.example.book_rent.repository;

import com.example.book_rent.model.Book;
import com.example.book_rent.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
