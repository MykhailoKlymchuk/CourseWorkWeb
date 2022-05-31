package com.eco.repository;

import com.eco.model.UserComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserComplaintRepo extends JpaRepository<UserComplaint, Long> {
    void deleteUserComplaintById(Long id);
    Optional<UserComplaint> findUserComplaintById(Long id);
}
