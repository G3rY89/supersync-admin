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
@XmlRootElement(name = "PROCESSES")
public class Processes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    public Integer id;
    @Column(nullable = false, unique = true)
    @XmlTransient
    public String apiKey;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "DOWNLOAD_PRODUCT")
    public Integer getProduct;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "UPLOAD_PRODUCT")
    public Integer setProduct;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "DOWNLOAD_CUSTOMER")
    public Integer getCustomer;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "UPLOAD_CUSTOMER") 
    public Integer setCustomer;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "DOWNLOAD_ORDER")
    public Integer getOrder;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "UPLOAD_ORDER")
    public Integer setOrder;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "DOWNLOAD_PRODUCTCATEGORIES")
    public Integer getProductCategories;
    @Column(nullable = false, unique = true)
    @XmlElement(name = "DOWNLOAD_STOCK")
    public Integer getStock;

    public Processes(int getProduct, int setProduct, int getCustomer, int setCustomer, int getOrder, int setOrder, int getProductCategories, int getStock, String apiKey){
        this.getProduct = getProduct;
        this.setProduct = setProduct;
        this.getCustomer = getCustomer;
        this.setCustomer = setCustomer;
        this.getOrder = getOrder;
        this.setOrder = setOrder;
        this.getProductCategories = getProductCategories;
        this.getStock = getStock;
        this.apiKey = apiKey;
    }

    public Processes(){

    }

}