package com.habuma.spel.cities;

import java.util.Arrays;

/**
 * ³ÇÊÐ×é
 * @author Administrator
 *
 */
public class Cities {

	public Cities(){}
	
	private City chosenCity;
    private City[] bigCities;
    private City aBigCity;
	private String[] cityNames;
	
	public String[] getCityNames() {
		return cityNames;
	}

	public void setCityNames(String[] cityNames) {
		this.cityNames = cityNames;
	}

	public City[] getBigCities() {
		return bigCities;
	}

	public void setBigCities(City[] bigCities) {
		this.bigCities = bigCities;
	}

	public City getaBigCity() {
		return aBigCity;
	}

	public void setaBigCity(City aBigCity) {
		this.aBigCity = aBigCity;
	}

	public City getChosenCity() {
		return chosenCity;
	}

	public void setChosenCity(City chosenCity) {
		this.chosenCity = chosenCity;
	}

	@Override
	public String toString() {
		return "Cities [chosenCity=" + chosenCity + ", bigCities=" + Arrays.toString(bigCities) + ", aBigCity="
				+ aBigCity + ", cityNames=" + Arrays.toString(cityNames) + "]";
	}
	
	
}
