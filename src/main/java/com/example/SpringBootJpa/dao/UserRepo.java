package com.example.SpringBootJpa.dao;

import com.example.SpringBootJpa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    //custom finder Methods
    public List<User> findByName(String name);

    /*
    * how to write my own query
    @Query
       JPQL
       Native query
    * */

    @Query("select u from User u")
    public List<User> getAllUser();

    @Query("select u from User u WHERE u.name= :n")
    //parameterized query bind with @Param
    public List<User> getUserByName(@Param("n") String name);

    @Query("select u from User u WHERE u.name=:n and u.country=:c")
    public List<User> getUserByNameAndCountry(@Param("n") String name,@Param("c") String country);

    @Query(value = "select * from User where User.name=:n",nativeQuery = true)
    public List<User> getUserByNameNativeQuery(@Param("n") String name);

}

/*
* by default from CRUD Repo we fet
* findALL()
* findById()
* what if we need find by name and password
* data like
* data containing
* ....n no. cases based on my requirments
*
* */
