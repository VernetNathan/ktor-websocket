package com.vernet.modeles;

import com.google.gson.annotations.SerializedName;

public class ReadingsItem{

	@SerializedName("temperature")
	private Object temperature;

	@SerializedName("humidity")
	private int humidity;

	public Object getTemperature(){
		return temperature;
	}

	public int getHumidity(){
		return humidity;
	}
}