package com.pup.taguig.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pup.taguig.app.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
