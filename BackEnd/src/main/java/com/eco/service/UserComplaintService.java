package com.eco.service;

import com.eco.exception._NotFoundException;
import com.eco.model.UserComplaint;
import com.eco.repository.UserComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class UserComplaintService {
    private final UserComplaintRepo userComplaintRepo;

    @Autowired
    public UserComplaintService(UserComplaintRepo userComplaintRepo) {
        this.userComplaintRepo = userComplaintRepo;
    }

    public UserComplaint addUserComplaint(UserComplaint userComplaint) {
        if (userComplaint.getDate() == null)
            userComplaint.setDate(
                    new SimpleDateFormat("yyyy-MM-dd")
                            .format(Calendar.getInstance()
                                    .getTime())
            );
        return userComplaintRepo.save(userComplaint);
    }

    public List<UserComplaint> findAllUserComplaints() {
        return userComplaintRepo.findAll();
    }

    public UserComplaint updateUserComplaint(UserComplaint userComplaint) {
        return userComplaintRepo.save(userComplaint);
    }

    public UserComplaint findUserComplaintById(Long id) {
        return userComplaintRepo.findUserComplaintById(id)
                .orElseThrow(() -> new _NotFoundException("Object UserComplaint by id " + id + "was not found"));
    }

    public void deleteUserComplaintById(Long id) {
        userComplaintRepo.deleteUserComplaintById(id);
    }
}
