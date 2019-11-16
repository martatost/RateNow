package com.ratenow.provatecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratenow.provatecnica.model.TestGraph;

@Repository
public interface TestGraphRepository extends JpaRepository<TestGraph, Long> {

}
