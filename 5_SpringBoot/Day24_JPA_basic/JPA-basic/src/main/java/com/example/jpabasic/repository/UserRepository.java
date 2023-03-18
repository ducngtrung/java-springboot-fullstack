package com.example.jpabasic.repository;

import com.example.jpabasic.dto.UserDto;
import com.example.jpabasic.dto.UserInfo;
import com.example.jpabasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// interface Repository kế thừa class JpaRepository, cần chỉ rõ entity (User) và kiểu dữ liệu của primary key (Integer)
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

    @Query(name = "User.findByAge")
    List<User> findByAgeJPQL(Integer age);

    @Transactional
    @Modifying
    @Query("update User u set u.name = :name, u.email = :email, u.age = :age where u.id = :id")
    void updateUserInfoJPQL(@Param("name") String name, @Param("email") String email, @Param("age") Integer age, @Param("id") Integer id);


    // Native Query (sử dụng câu lệnh query thông thường)
    // (Native Query lấy table name từ annotation @Table trong entity)
    @Query(nativeQuery = true, value = "select * from user u where u.name = ?1")
    List<User> findByNameNative(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update user u set u.name = ?2 where u.id = ?1")
    void updateUserNameNative(Integer id, String name);


    // Lấy Dto bằng JPQL
    @Query("select new com.example.jpabasic.dto.UserDto(u.id, u.name, u.email) from User u " +
            "where upper(u.email) like upper(concat('%', ?1, '%'))")
    List<UserDto> findByEmailContainingIgnoreCase(String email);

    // Lấy Dto bằng Native Query
    @Query(nativeQuery = true, name = "findAllUserDto")
    List<UserDto> findAllUserDto();

    // Lấy entity rồi map sang Dto tương ứng
    List<User> findByNameStartingWith(String prefix);

    // Lấy Dto bằng Query Projection
    // Tham khảo: https://thorben-janssen.com/spring-data-jpa-query-projections/#JPA8217s_DTOs
    // - Bước 1: định nghĩa một interface (UseInfo) để lấy dữ liệu từ entity thông qua getter
    // - Bước 2: viết phương thức trong repository để lấy dữ liệu trả về interface
    List<UserInfo> findUserInfoByNameStartingWith(String prefix);

}