package com.example.book_rent.repository;

import com.example.book_rent.model.Book;
import com.example.book_rent.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into order_detail(book_id,code,customer_id) values (:bookId,:code,:customerId)", nativeQuery = true)
    void save(@Param("bookId") int bookId, @Param("code") int code, @Param("customerId") int customerId);

    @Query(value = "select * from order_detail", nativeQuery = true)
    Page<OrderDetail> findAll(Pageable pageable);

    @Query(value = "select * from order_detail where code = :code", nativeQuery = true)
    OrderDetail findByCode(@Param("code") int code);
}
