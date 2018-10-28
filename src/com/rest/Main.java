package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/main")
public class Main {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() throws JSONException {
		JSONObject json = new JSONObject();
		JSONArray array=new JSONArray();
	    array.put("1");
	    array.put("22");
	    json.put("friends", array);
		return json.toString();
	}
}
