package com.brijesh.springboot.taskApp.doa;

import com.brijesh.springboot.taskApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepo extends JpaRepository<Users,Integer> {

        @Query("SELECT u FROM Users u JOIN FETCH u.tasks WHERE u.userId = :userId")
        Optional<Users> findUserWithTasksById(@Param("userId") int userId);

}
