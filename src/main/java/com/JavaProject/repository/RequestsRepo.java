package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.JavaProject.entity.Requests;


public interface RequestsRepo extends JpaRepository<Requests, Integer> {
    
    // Method to retrieve all requests
    @Query("SELECT r FROM Requests r")
    List<Requests> findAllRequests();
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Requests r WHERE r.req_sender = :reqSender")
    void deleteByReqSender(String reqSender);
}
