package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JavaProject.entity.Accepted;

public interface AcceptedRepo extends JpaRepository<Accepted, Integer> {
    // Define custom methods if needed
    @SuppressWarnings("unchecked")
    default
    Accepted save(Accepted accepted) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    
}
