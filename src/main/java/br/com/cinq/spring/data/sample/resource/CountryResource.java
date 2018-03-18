package br.com.cinq.spring.data.sample.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CountryRepository;
import br.com.cinq.spring.data.sample.representation.CountryPack;

/**
 * @author marina-sm
 */
@Component
@Path("/countries")
public class CountryResource {

	@Autowired
	CountryRepository countryRepository;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findById(@PathParam(value = "id") Long id) {
		return Response.ok(this.countryRepository.findById(id)).build();
	}

	@GET
	@Produces("application/json")
	public Response findAllbyCountry() {
			return Response.ok(this.countryRepository.findAll()).build();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/load")
	public Response insertCountries(CountryPack pack) {
		this.countryRepository.insert(pack.getCountryList());
		return Response.ok().build();
	}
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertCountry(Country country) {
		this.countryRepository.insert(country);
		return Response.ok().build();
	}
}
