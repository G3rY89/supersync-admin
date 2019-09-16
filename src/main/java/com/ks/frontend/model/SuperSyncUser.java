package com.ks.frontend.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "users")
public class SuperSyncUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(nullable = false, unique = true)
    public String webIdentifier;
    @Column(nullable = false, unique = true)
    public String webPassword;

    public SuperSyncUser(){
        
    }

    public SuperSyncUser(String webIdentifier, String webPassword){
        this.webIdentifier = webIdentifier;
        this.webPassword = webPassword;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the webIdentifier
     */
    public String getWebIdentifier() {
        return webIdentifier;
    }

    /**
     * @return the webPassword
     */
    public String getWebPassword() {
        return webPassword;
    }

}
