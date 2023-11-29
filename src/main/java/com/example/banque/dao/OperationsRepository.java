package com.example.banque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.banque.entities.Operations;

public interface OperationsRepository extends JpaRepository<Operations, Long> {

    @Query("select o from Operations o where o.compte.codecompte =:x order by o.datecreation desc")
   public Page<Operations> listOperation(@Param("x") String codecompte, Pageable pageable);
}