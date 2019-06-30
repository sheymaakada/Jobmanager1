package com.org.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.spring.entities.Client;
import com.org.spring.entities.Jobs;


@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {

}
