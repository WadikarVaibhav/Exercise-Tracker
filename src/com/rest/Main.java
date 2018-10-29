package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

@Path("/main") //path annotation
public class Main {
	
	@GET //accessed using get http
	@Produces(MediaType.TEXT_PLAIN) //returns text plane
	public String hello() throws JSONException {
		return "hello world";
	}
}
