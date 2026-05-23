package com.pup.taguig.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.ActivityRequestDTO;
import com.pup.taguig.app.dto.ActivityResponseDTO;
import com.pup.taguig.app.model.Activity;
import com.pup.taguig.app.repository.ActivityRepository;
import com.pup.taguig.app.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public Activity createActivity(ActivityRequestDTO request) {
//		LocalDateTime date = LocalDateTime.now();
//		long id = date.getDayOfYear() +
//				 date.getDayOfMonth() +
//				 date.getDayOfWeek().getValue() +
//				 date.getHour() +
//				 date.getMinute() +
//				 date.getSecond() +
//				 date.getNano();
//	
//		activity.setCreatedAt(date);
//		activity.setId(id);
//		activities.add(activity);
//		return activity;
		LocalDateTime date = LocalDateTime.now();
		Activity activity = new Activity(
				request.getName(),
				request.getDescription(),
				date
				
		);
		
		activity = activityRepository.save(activity);
		return activity;
	}

	@Override
	public List<ActivityResponseDTO> getAllActivities() {
		List<Activity> activities = activityRepository.findAll();
		List<ActivityResponseDTO> response = new ArrayList<ActivityResponseDTO>();
		
		for (Activity activity : activities) {
			ActivityResponseDTO dto = new ActivityResponseDTO(
					activity.getId(),
					activity.getName(),
					activity.getDescription(),
					activity.getCreatedAt()
			);
			response.add(dto);
		}
		return response;
	}

	@Override
	public ActivityResponseDTO getActivityById(Long id) {
//			for (Activity activity: activities) {
//				if (activity.getId().equals(id)) {
//					return activity;
//				}
//			}	
//		System.out.println(activities.size());
		return null;
	}

	@Override
	public ActivityResponseDTO updateActivity(Long id, ActivityRequestDTO updatedActivity) {
//		for (Activity activity : activities) {
//			if (activity.getId().equals(id)) {
//				activity.setName(updatedActivity.getName());
//				activity.setDescription(updatedActivity.getDescription());
//			}
//		}	
		return null;
	}

	@Override
	public boolean deleteActivity(Long id) {
//		for (Activity activity : activities) {
//			if (activity.getId().equals(id)) {
//				activities.remove(activity);
//			}
//		}	
		return true;
	}

}
