package com.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.model.Activity;
import com.rest.model.User;
import com.rest.repository.ActivityRepository;

@Path("activities") //http:localhosy:8080/rest/test/activities
public class ActivityResource {
	
	ActivityRepository repository = new ActivityRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> getAllActivities() {
		return repository.getAllActivities();
	}
	
	@GET
	@Path("{activityId}") //http:localhosy:8080/rest/test/activities/id
	@Produces(MediaType.APPLICATION_JSON)
	public Activity getActivity(@PathParam("activityId") int activityId) {
		return repository.getActivityById(activityId);
		
	}
	
	@GET
	@Path("{activityId}/user") //http:localhosy:8080/rest/test/activities/id
	@Produces(MediaType.APPLICATION_XML)
	public User getActivityUser(@PathParam("activityId") int activityId) {
		return repository.getActivityUser(activityId);
		
	}
	
}
