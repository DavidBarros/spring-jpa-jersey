package br.com.cinq.spring.data.sample.repository;

import org.springframework.stereotype.Repository;

import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.generic.GenericRepository;

@Repository
public class CountryRepository extends GenericRepository<Country>{

	protected CountryRepository() {
		super(Country.class);
	}

}
