package com.vernet.modeles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CapteurTemp{

	@SerializedName("correlation_ids")
	private List<String> correlationIds;

	@SerializedName("end_device_ids")
	private EndDeviceIds endDeviceIds;

	@SerializedName("received_at")
	private String receivedAt;

	@SerializedName("uplink_message")
	private UplinkMessage uplinkMessage;

	public List<String> getCorrelationIds(){
		return correlationIds;
	}

	public EndDeviceIds getEndDeviceIds(){
		return endDeviceIds;
	}

	public String getReceivedAt(){
		return receivedAt;
	}

	public UplinkMessage getUplinkMessage(){
		return uplinkMessage;
	}
}