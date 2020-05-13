package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Su
 * @className SwaggerConfiguration
 * @Description TODO
 * @Date 2020/5/12 20:25
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     *
     * @param userName
     * @return User
     */
    User findByUserName(String userName);

    /**
     *
     * @param username
     * @param email
     * @return User
     */
    User findByUserNameOrEmail(String username,String email);

    /**
     *
     * @param userName
     * @return Long
     */
    Long countByUserName(String userName);

    /**
     *
     * @param email
     * @return List<User>
     */
    List<User> findByEmailLike(String email);

    /**
     *
     * @param userName
     * @return User
     */
    User findByUserNameIgnoreCase(String userName);


    /**
     *
     * @param email
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String email);

    /**
     * 自定义JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param id
     * @return
     */
    @Query("select u from User u where u.id = ?1")
    User findById(long id);

    /**
     * 按id修改nickName
     *
     * @param nickName
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update user set nick_name = ?1 where id = ?2", nativeQuery = true)
    int updateNickName(String nickName, long id);


    /**
     * 插入
     *
     * @param userName
     * @param password
     * @param email
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into user(user_name, password,email) values (:userName, :password,:email)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("email") String email);


    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    @Query(value = "select * from user u where u.nick_name = ?1", nativeQuery = true)
    Page<User> findByNickName(String nickName, Pageable pageable);


    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String  userName, Long id);


    User findTopByOrderByAgeDesc();





}