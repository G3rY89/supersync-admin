package com.ks.frontend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "processes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Processes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    public Integer id;
    @Column(nullable = false, unique = true)
    public String apiKey;
    @Column(nullable = false, unique = true)
    public Integer getProduct;
    @Column(nullable = false, unique = true)
    public Integer setProduct;
    @Column(nullable = false, unique = true)
    public Integer getCustomer;
    @Column(nullable = false, unique = true)
    public Integer setCustomer;
    @Column(nullable = false, unique = true)
    public Integer getOrder;
    @Column(nullable = false, unique = true)
    public Integer setOrder;
    @Column(nullable = false, unique = true)
    public Integer setProductCategories;
    @Column(nullable = false, unique = true)
    public Integer setStock;

    public Processes(int getProduct, int setProduct, int getCustomer, int setCustomer, int getOrder, int setOrder, int setProductCategories, int setStock, String apiKey){
        this.getProduct = getProduct;
        this.setProduct = setProduct;
        this.getCustomer = getCustomer;
        this.setCustomer = setCustomer;
        this.getOrder = getOrder;
        this.setOrder = setOrder;
        this.setProductCategories = setProductCategories;
        this.setStock = setStock;
        this.apiKey = apiKey;
    }

    public Processes(){

    }

}