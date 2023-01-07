package com.example.jpabasic.repository;

import com.example.jpabasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Method Query (sử dụng các từ khóa được định nghĩa sẵn để tự động tạo method query)
    // Tham khảo: https://learn.techmaster.vn/learn/98X4bxNQ/W9lBeyjc/2qnl5x5q
    List<User> findByName(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByAgeGreaterThan(Integer age);

    boolean existsByEmail(String email);

    long countByAgeBetween(Integer min, Integer max);

    Optional<User> findByEmail(String email);


    // JPQL (mô tả câu lệnh query bằng JPA Query Language)
    @Query("select u from User u where u.name = ?1") // ?1 trỏ đến tham số thứ nhất trong method (tức là name)
    List<User> findByNameJPQL(String name);

    @Query("select count(u) from User u where u.age between ?1 and ?2")
    long countByAgeBetweenJPQL(Integer min, Integer max);

    @Query("select u from User u where u.email = :emailValue") // đây là cách khác để trỏ đến tham số trong method (emailValue)
    Optional<User> findByEmailJPQL(@Param("emailValue") String email);


    // Native Query (sử dụng câu lệnh query thông thường)
    @Query(nativeQuery = true, value = "select * from user u where u.name = ?1")
    List<User> findByNameNative(String name);




}