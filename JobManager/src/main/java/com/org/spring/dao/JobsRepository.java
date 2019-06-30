package com.org.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.spring.entities.Jobs;


@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {

}
