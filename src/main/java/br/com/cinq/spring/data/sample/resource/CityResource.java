package br.com.cinq.spring.data.sample.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.representation.CityPack;

@Component
@Path("/cities")
public class CityResource {

	@Autowired
	CityRepository cityRepository;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response findById(@PathParam(value = "id") Long id) {
		return Response.ok(cityRepository.findById(id)).build();
	}

	@GET
	@Produces("application/json")
	public Response findAllbyCountry(@QueryParam("country") String country) {
		if (country == null) {
			return Response.ok(cityRepository.findAll()).build();
		} else {
			return Response.ok(cityRepository.findCitiesByCountryName(country)).build();
		}
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/load")
	public Response insertCities(CityPack pack) {
		cityRepository.insert(pack.getCityList());
		return Response.ok().build();
	}
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertCity(City city) {
		cityRepository.insert(city);
		return Response.ok().build();
	}
}
