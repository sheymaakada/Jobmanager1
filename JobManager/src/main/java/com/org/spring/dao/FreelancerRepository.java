package com.org.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.spring.entities.Freealancer;



@Repository
public interface FreelancerRepository extends JpaRepository<Freealancer, Integer> {

}
