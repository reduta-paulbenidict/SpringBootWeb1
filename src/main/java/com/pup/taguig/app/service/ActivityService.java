package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.ActivityRequestDTO;
import com.pup.taguig.app.dto.ActivityResponseDTO;
import com.pup.taguig.app.model.Activity;

public interface ActivityService {
	public Activity createActivity(ActivityRequestDTO activity);
	public List<ActivityResponseDTO> getAllActivities();
	public ActivityResponseDTO getActivityById(Long id);
	public ActivityResponseDTO updateActivity(Long id, ActivityRequestDTO updatedActivity);
	public boolean deleteActivity(Long id);
}
