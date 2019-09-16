package com.ks.frontend.repository;

import com.ks.frontend.model.UserWebshops;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWebshopsRepository extends JpaRepository<UserWebshops, Integer> {

    UserWebshops findByUserId(int id);

}