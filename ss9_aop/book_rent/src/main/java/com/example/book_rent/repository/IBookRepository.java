package com.example.book_rent.repository;


import com.example.book_rent.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book where book_name like :name", nativeQuery = true)
    Page<Book> findAll(Pageable pageable, @Param("name") String searchName);

    @Query(value = "update book set quantity = :#{#book.quatity where book_id like :id",nativeQuery = true)
    void update(Book book,@Param("id") int bookId);
}

