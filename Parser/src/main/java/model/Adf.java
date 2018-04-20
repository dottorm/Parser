package model;

public class Adf extends Element {
	
	public Adf(){super();}
	
	public Adf(String fullName){
		super(fullName);
	}

	@Override
	public String toString() {
		return String.format(
				"Adf [getName()=%s, getType()=%s, getStartTime()=%s, getStopTime()=%s, getGenTime()=%s, getSurface()=%s, getPlatform()=%s, getBaseLine()=%s, getCycle()=%s, getTimeliness()=%s, getOrbit()=%s, getFullName()=%s, getPacketCount()=%s]",
				getName(), getType(), getStartTime(), getStopTime(), getGenTime(), getSurface(), getPlatform(),
				getBaseLine(), getCycle(), getTimeliness(), getOrbit(), getFullName(), getPacketCount());
	}

}
