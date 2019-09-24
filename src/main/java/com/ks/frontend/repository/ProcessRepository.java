package com.ks.frontend.repository;

import com.ks.frontend.model.Processes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProcessRepository extends JpaRepository<Processes, Integer>{

    Processes findByApiKey(String ApiKey);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Processes SET get_customer = :#{#processes.getCustomer}, get_order = :#{#processes.getOrder}, get_product = :#{#processes.getProduct}, set_product_categories = :#{#processes.setProductCategories}, set_stock = :#{#processes.setStock}, set_customer = :#{#processes.setCustomer}, set_order = :#{#processes.setOrder}, set_product = :#{#processes.setProduct} where api_key = :#{#processes.apiKey}")
    void setProcesses(@Param("processes") Processes processes);
}