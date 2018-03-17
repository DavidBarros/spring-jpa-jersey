package br.com.cinq.spring.data.sample.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Teste {

//	@GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<String> teste(){
		return new ResponseEntity<String>("TESTEZAO",HttpStatus.OK);
	}
}
