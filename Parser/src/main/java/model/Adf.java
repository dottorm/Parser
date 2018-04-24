package model;

public class Adf extends Element {
	
	public Adf(){super();}
	
	public Adf(String fullName){
		super(fullName);
	}

	@Override
	public String toString() {
		return String.format(
				"Adf [Name=%s, Type=%s, StartTime=%s, StopTime=%s, GenTime=%s, Surface=%s, Platform=%s, BaseLine=%s, Cycle=%s, Timeliness=%s, Orbit=%s, FullName=%s, PacketCount=%s]",
				getName(), getType(), getStartTime(), getStopTime(), getGenTime(), getSurface(), getPlatform(),
				getBaseLine(), getCycle(), getTimeliness(), getOrbit(), getFullName(), getPacketCount());
	}

}
