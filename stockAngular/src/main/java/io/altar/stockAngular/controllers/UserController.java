package io.altar.stockAngular.controllers;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.DTOS.UserDTO;
import io.altar.stockAngular.models.converters.UserConverter;
import io.altar.stockAngular.repositories.UserRepository;
import io.altar.stockAngular.services.UserService;
import io.altar.stockAngular.utils.EmailUtils;

@RequestScoped
@Path("users")
public class UserController extends EntityController<UserService, UserRepository,UserConverter, User, UserDTO> {

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(UserDTO userDTO){
		service.createUser(userDTO);
		try {
			EmailUtils.sendNewUser(userDTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.ok().build();
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UserDTO userDTO){
		try {
			User user = service.checkIfUserValid(userDTO);
			return Response.ok().entity(converter.toDTO(user)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}
