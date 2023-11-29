package com.example.banque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banque.entities.Comptes;


public interface CompteRepository extends JpaRepository<Comptes,String> {



}
