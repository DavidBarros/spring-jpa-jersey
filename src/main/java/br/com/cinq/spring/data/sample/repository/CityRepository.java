package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.generic.GenericRepository;

@Repository
public class CityRepository extends GenericRepository<City> {

	protected CityRepository() {
		super(City.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<City> findCitiesByCountryName(String country) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CI.* FROM CITY CI, COUNTRY CO ");
		sb.append("WHERE CI.COUNTRY_ID = CO.ID ");
		sb.append("AND CO.NAME LIKE CONCAT( :country ,'%') ");
		
		final Query q = getEm().createNativeQuery(sb.toString(),City.class);
		q.setParameter("country", country);
		
		return q.getResultList();
		
	}

}
