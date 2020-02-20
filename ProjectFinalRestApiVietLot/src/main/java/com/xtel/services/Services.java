package com.xtel.services;

import com.google.gson.Gson;
import com.xtel.connnectionPool.ExportResult;
import com.xtel.connnectionPool.InsertServices;
import com.xtel.model.User;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("services")
public class Services {
    Gson gson = new Gson();
    private LinkedBlockingQueue<User> queueOfUser = new LinkedBlockingQueue<User>(100);
    private ArrayList<User> listOfUser;
    
    
    
    public Services() {
    	listOfUser = new ArrayList<User>();
    	ExportResult export = new ExportResult();
		listOfUser = export.getListOfUser();
	}


	public ArrayList<User> getListOfUser() {
		return listOfUser;
	}
    

	@POST
    @Path("add")
    public Response addUser(String body){
        User user = parseBody(body,User.class);
        queueOfUser.add(user);
        InsertServices insert = new InsertServices(user);
        insert.start();
        return Response.ok().entity("complete").build();
    }

    @GET
    @Path("user")
    public String selectAll(){
        return gson.toJson(listOfUser);
    }
    private <T> T parseBody(String body, Class<T> t) {
        return gson.fromJson(body, t);
    }


}
