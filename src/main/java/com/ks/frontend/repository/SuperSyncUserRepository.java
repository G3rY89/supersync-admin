package com.ks.frontend.repository;

import java.util.List;
import java.util.Optional;

import com.ks.frontend.model.SuperSyncWebshops;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuperSyncUserRepository extends JpaRepository<SuperSyncWebshops, Integer> {

    SuperSyncWebshops findByWebIdentifierAndWebPassword(String WebIdentifier, String WebPassword);

    Optional<SuperSyncWebshops> findById(Integer id);

    List<SuperSyncWebshops> findByWebIdentifier(String webIdentifier);
    
}