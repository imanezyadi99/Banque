package com.example.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
