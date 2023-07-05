package com.brijesh.springboot.taskApp.doa;

import com.brijesh.springboot.taskApp.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDoaImpl implements UserDoa{

    @Autowired
    private EntityManager entityManager;

    public UserDoaImpl() {
    }





    @Override
    @Transactional
    public void addUserAndTask(Users theUser) {
        entityManager.persist(theUser);
    }

    @Override
    public Users findUserWithTasksById(int userId) {

        TypedQuery<Users> theQuery= entityManager.createQuery("select u from Users u "
                +"JOIN FETCH u.tasks "
                +"where u.userId=:data", Users.class);
        theQuery.setParameter("data",userId);
        Users newUser=theQuery.getSingleResult();

        return newUser;
    }


}
