package com.eco.resouce;

import com.eco.model.UserComplaint;
import com.eco.service.UserComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/complaint")
public class UserComplaintResource {
    private final UserComplaintService userComplaintService;

    public UserComplaintResource(UserComplaintService userComplaintService) {
        this.userComplaintService = userComplaintService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserComplaint>> getUserComplaints() {
        List<UserComplaint> userComplaints = userComplaintService.findAllUserComplaints()
                .stream().limit(10).collect(Collectors.toList());
        return new ResponseEntity<>(userComplaints, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserComplaint> getUserComplaintById(@PathVariable("id") Long id) {
        UserComplaint userComplaint  = userComplaintService.findUserComplaintById(id);
        return new ResponseEntity<>(userComplaint, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserComplaint> addUserComplaint(@RequestBody UserComplaint userComplaint) {
        UserComplaint newUserComplaint = userComplaintService.addUserComplaint(userComplaint);
        return new ResponseEntity<>(newUserComplaint, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserComplaint> updateUserComplaint(@RequestBody UserComplaint userComplaint) {
        UserComplaint updateUserComplaint = userComplaintService.updateUserComplaint(userComplaint);
        return new ResponseEntity<>(updateUserComplaint, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserComplaint(@PathVariable("id") Long id) {
        userComplaintService.deleteUserComplaintById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
