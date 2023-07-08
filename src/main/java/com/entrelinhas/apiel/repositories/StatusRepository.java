package com.entrelinhas.apiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrelinhas.apiel.models.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

};
