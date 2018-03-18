package br.com.cinq.spring.data.sample.representation;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cinq.spring.data.sample.entity.City;

/**
 * 
 * @author marina-sm
 *
 */
@XmlRootElement
public class CityPack implements Serializable{

	private static final long serialVersionUID = -8478151134677687120L;
	
	private List<City> cityList;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	protected static long getSerialversionuid() {
		return serialVersionUID;
	}
}
