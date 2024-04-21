package com.JavaProject.service;

import com.JavaProject.entity.Requests;

public interface RequestService {
    void acceptRequest(String reqSender);
    void rejectRequestBySender(String reqSender);
}
