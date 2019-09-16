package com.ks.frontend.repository;

import com.ks.frontend.model.SuperSyncUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperSyncUserRepository extends JpaRepository<SuperSyncUser, Integer> {

    SuperSyncUser findByWebIdentifierAndWebPassword(String WebIdentifier, String WebPassword);
    
}