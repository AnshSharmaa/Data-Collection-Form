package com.upgrad.dcf.repository;

import com.upgrad.dcf.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class UserRepo {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    public boolean addNewUser(User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    public List<User> getAllPosts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u from user u",User.class);
        List<User> result = query.getResultList();
        return result;
    }

    public void deleteUser(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, userId);
            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }


    public void updateUser(User updateuser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(updateuser);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public boolean check(String userName) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<User> query = entityManager.createQuery( "select u from user u where Lower(u.name) = :userName",User.class);
            query.setParameter("userName", userName.toLowerCase());
            query.getSingleResult();
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public User getUser(String userName) {
        /*EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(user.class,userName);*/
        User found;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<User> query = entityManager.createQuery( "select u from user u where Lower(u.name) = :userName",User.class);
            query.setParameter("userName", userName.toLowerCase());
            found = query.getSingleResult();
        } catch (Exception e){
            found = null;
        }
        return found;
    }

}
