package com.pup.taguig.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind. annotation.RequestMapping;
import org.springframework.web.bind. annotation.RestController;

import com.pup.taguig.app.dto.ActivityRequestDTO;
import com.pup.taguig.app.dto.ActivityResponseDTO;
import com.pup.taguig.app.model.Activity;
import com.pup.taguig.app.service.ActivityService;

import java.util.List;
@RestController
@RequestMapping("activity")
public class ActivityController {
	private final ActivityService activityService;
	
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	@PostMapping("create")
	public Activity createActivity(@RequestBody ActivityRequestDTO activity) {
		return activityService.createActivity(activity);
	}
	
	@GetMapping("all")
	public List<ActivityResponseDTO> getAllActivities() {
		return activityService.getAllActivities();
	}
	
	@GetMapping("show/{id}")
	public ActivityResponseDTO getActivityById(@PathVariable Long id) {
		return activityService.getActivityById(id);
	}
	
	@PutMapping("edit/{id}")
	public ActivityResponseDTO updateActivity(@PathVariable Long id, @RequestBody ActivityRequestDTO updatedActivity) {
		return activityService.updateActivity(id, updatedActivity);
	}
	
	
	@DeleteMapping("delete/{id}")
	public boolean deleteActivity(@PathVariable Long id) {
		return activityService.deleteActivity(id);
	}
		
}
