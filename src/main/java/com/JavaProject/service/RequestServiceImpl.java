package com.JavaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JavaProject.repository.RequestsRepo;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestsRepo requestsRepo;

    @Override
    public void acceptRequest(String  reqSender) {
        // Implement logic to accept request
        // For example, you might update the status of the request in the database
        // requestsRepo.acceptRequest(requestId);
    }

    @Override
    public void rejectRequestBySender(String reqSender) {
        // Delete the request from the database based on sender's name
        requestsRepo.deleteByReqSender(reqSender);
    }
}
