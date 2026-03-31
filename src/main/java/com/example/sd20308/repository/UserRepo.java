package com.example.sd20308.repository;

import com.example.sd20308.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = """
            SELECT * FROM users where full_name = ?1 OR role =?2
            """, nativeQuery = true)
    List<User> getByFullNameOrRole(String fullName, Boolean role);
}
