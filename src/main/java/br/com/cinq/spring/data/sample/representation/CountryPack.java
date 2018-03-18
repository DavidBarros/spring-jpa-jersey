package br.com.cinq.spring.data.sample.representation;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cinq.spring.data.sample.entity.Country;

/**
 * 
 * @author marina-sm
 *
 */
@XmlRootElement
public class CountryPack implements Serializable{

	private static final long serialVersionUID = -165665120456873425L;
	
	private List<Country> countryList;

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	protected static long getSerialversionuid() {
		return serialVersionUID;
	}
}
