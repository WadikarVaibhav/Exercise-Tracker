package com.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

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
	
	/**
	 * @param activityId
	 * @return
	 */
	@GET
	@Path("{activityId}") //http:localhosy:8080/rest/test/activities/id
	@Produces(MediaType.APPLICATION_JSON)
	public Activity getActivity(@PathParam("activityId") int activityId) {
		return repository.getActivityById(activityId);
	}
	
	/**
	 * @param activityId
	 * @return
	 */
	@GET
	@Path("{activityId}/user") //http:localhosy:8080/rest/test/activities/id/user
	@Produces(MediaType.APPLICATION_JSON)
	public User getActivityUser(@PathParam("activityId") int activityId) {
		return repository.getActivityUser(activityId);
	}
	
	/**
	 * @param activityId
	 * @return
	 */
	@GET
	@Path("{activityId}/username") //http:localhosy:8080/rest/test/activities/id/user/name
	@Produces(MediaType.APPLICATION_JSON)
	public String getActivityUserName(@PathParam("activityId") int activityId) {
		return repository.getActivityUserName(activityId);
	}
	
	/**
	 * @param formParams
	 * @return
	 */
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("duration"));
		System.out.println(formParams.getFirst("name"));
		return null;
	}
	
	
	/**
	 * @param activity
	 * @return
	 */
	@POST
	@Path("activitybind")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> createActivityParams(Activity activity) {
		List<Activity> activities = repository.createActivity(activity);
		return activities;
	}
	
	/**
	 * @param activity
	 * @return
	 */
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> updateActivity(Activity activity) {
		List<Activity> activities = repository.updateActivity(activity);
		return activities;
	}
	
}
