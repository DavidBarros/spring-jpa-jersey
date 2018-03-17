package br.com.cinq.spring.data.sample.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/teste")
public class Teste {

	@GET
	@Produces("text/plain")
	@Path("/error")
	public String error() {
		return "Error handling";
	}
	
//
//	@GetMaping(value="/teste",method=MethodType)
//	public String teste() {
//		return "sdfsfs";
//
//	}
}
