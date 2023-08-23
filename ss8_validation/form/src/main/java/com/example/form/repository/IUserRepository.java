package com.example.form.repository;

import com.example.form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into User(first_name,last_name,phone_number,age,email) " +
            "values (:#{#user.firstName},:#{#user.lastName},:#{#user.phoneNumber},:#{#user.age},:#{#user.email})",nativeQuery = true)
    void saveUser(User user);
}
