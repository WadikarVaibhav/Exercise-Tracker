package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.model.Activity;
import com.rest.model.User;

public class ActivityRepository {
	
	List<Activity> activities = new ArrayList<Activity>();
	
	public List<Activity> getAllActivities() {
		
		User user1 = new User();
		user1.setId(11);
		user1.setName("Paul");
		
		Activity activity1 = new Activity();
		activity1.setName("Swimming");
		activity1.setDuration(20);
		activity1.setId(1);
		activity1.setUser(user1);
		
		User user2 = new User();
		user2.setId(12);
		user2.setName("Andrew");
		
		Activity activity2 = new Activity();
		activity2.setName("Football");
		activity2.setDuration(50);
		activity2.setId(2);
		activity2.setUser(user2);
		
		activities.add(activity1);
		activities.add(activity2);
		
		return activities;
	}

	/**
	 * @param activityId
	 * @return
	 */
	public Activity getActivityById(int activityId) {
		List<Activity> activities = getAllActivities();
		for (Activity activity: activities) {
			if (activityId == activity.getId()) {
				return activity;
			}
		}
		return null;
	}
	
	/**
	 * @param activityId
	 * @return
	 */
	public User getActivityUser(int activityId) {
		List<Activity> activities = getAllActivities();
		for (Activity activity: activities) {
			if (activityId == activity.getId()) {
				return activity.getUser();
			}
		}
		return null;
	}

	/**
	 * @param activityId
	 * @return
	 */
	public String getActivityUserName(int activityId) {
		List<Activity> activities = getAllActivities();
		for (Activity activity: activities) {
			if (activityId == activity.getId()) {
				return activity.getUser().getName();
			}
		}
		return null;
	}
	
	/**
	 * @param activity
	 * @return
	 */
	public List<Activity> createActivity(Activity activity) {
		List<Activity> activities = getAllActivities();
		activities.add(activity);
		return activities;
	}
	
	/**
	 * @param activity
	 * @return
	 */
	public List<Activity> updateActivity(Activity activity) {
		List<Activity> activities = getAllActivities();
		boolean found = false;
		for (Activity act: activities) {
			if (act.getId() == activity.getId()) {
				act.setDuration(activity.getDuration());
				act.setUser(activity.getUser());
				act.setId(activity.getId());
				act.setName(activity.getName());
				found = true;
			}
		}
		if (!found) {
			activities.add(activity);
		}
		return activities;
	}
	
}
