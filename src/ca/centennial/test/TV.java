package ca.centennial.test;
/**
 * TV bean
 * @author Chen Feng
 *
 */

public class TV {
	private int channel = 0;
	private int volumeLevel = 0;
	private String status = "Centennial tv is off now";

	public TV() {
	}

	public TV(int channel, int volumeLevel, String status) {
		this.channel = channel;
		this.volumeLevel = volumeLevel;
		this.status = status;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolumeLevel() {
		return volumeLevel;
	}

	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	public String getStatus() {
		return status;
	}
	
	public void turnOn(){
		this.status = "Your tv is on now!!!";
	}
	
	public void turnOff(){
		this.status = "Your tv is off now.";
	}
	
	
}
