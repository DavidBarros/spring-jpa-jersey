package br.com.cinq.spring.data.sample.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/sample")
public class SampleResource {

	@GET
	@Produces("application/json")
	public Response teste() {
		return Response.ok("Teste").build();
	}
}
