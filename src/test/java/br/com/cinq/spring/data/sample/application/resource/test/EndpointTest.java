package br.com.cinq.spring.data.sample.application.resource.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cinq.spring.data.sample.entity.City;

/**
 * @author marina-sm
 */

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EndpointTest {
    Logger logger = LoggerFactory.getLogger(EndpointTest.class);
    @Autowired
	private TestRestTemplate restTemplate;

    @Test
    public void testGetCities() throws InterruptedException {
		ResponseEntity<Object[]> entity = this.restTemplate.getForEntity("/rest/cities", Object[].class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    @Test
    public void testGetCitiesByCountry() throws InterruptedException {
		ResponseEntity<Object[]> entity = this.restTemplate.getForEntity("/rest/cities?country=fra", Object[].class);
		assertThat(entity.getBody().length).isEqualTo(2);
    }
}
