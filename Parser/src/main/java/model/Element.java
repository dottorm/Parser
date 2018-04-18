package model;

import java.util.List;

public class Element {
	
	private String name;
	private String type;
	private String startTime;
	private String stopTime;
	private String genTime;
	private String surface;
	private String platform;
	private String baseLine;
	private String cycle;
	private String timeliness;
	private String orbit;
	private String fullName;
	
	private List<DataObject> dataObjects;
	
	
	public Element(){}
	
	public Element(String fullName){
		this.fullName = fullName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getGenTime() {
		return genTime;
	}

	public void setGenTime(String genTime) {
		this.genTime = genTime;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getBaseLine() {
		return baseLine;
	}

	public void setBaseLine(String version) {
		this.baseLine = version;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getTimeliness() {
		return timeliness;
	}

	public void setTimeliness(String timeliness) {
		this.timeliness = timeliness;
	}

	public String getOrbit() {
		return orbit;
	}

	public void setOrbit(String orbit) {
		this.orbit = orbit;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public List<DataObject> getDataObjects() {
		return dataObjects;
	}

	public void setDataObjects(List<DataObject> dataObjects) {
		this.dataObjects = dataObjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseLine == null) ? 0 : baseLine.hashCode());
		result = prime * result + ((cycle == null) ? 0 : cycle.hashCode());
		result = prime * result + ((dataObjects == null) ? 0 : dataObjects.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((genTime == null) ? 0 : genTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orbit == null) ? 0 : orbit.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((stopTime == null) ? 0 : stopTime.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		result = prime * result + ((timeliness == null) ? 0 : timeliness.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (baseLine == null) {
			if (other.baseLine != null)
				return false;
		} else if (!baseLine.equals(other.baseLine))
			return false;
		if (cycle == null) {
			if (other.cycle != null)
				return false;
		} else if (!cycle.equals(other.cycle))
			return false;
		if (dataObjects == null) {
			if (other.dataObjects != null)
				return false;
		} else if (!dataObjects.equals(other.dataObjects))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (genTime == null) {
			if (other.genTime != null)
				return false;
		} else if (!genTime.equals(other.genTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orbit == null) {
			if (other.orbit != null)
				return false;
		} else if (!orbit.equals(other.orbit))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (stopTime == null) {
			if (other.stopTime != null)
				return false;
		} else if (!stopTime.equals(other.stopTime))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		if (timeliness == null) {
			if (other.timeliness != null)
				return false;
		} else if (!timeliness.equals(other.timeliness))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Product [name=%s, type=%s, startTime=%s, stopTime=%s, genTime=%s, surface=%s, platform=%s, baseLine=%s, cycle=%s, timeliness=%s, orbit=%s, fullName=%s]",
				name, type, startTime, stopTime, genTime, surface, platform, baseLine, cycle, timeliness, orbit,
				fullName);
	}

}
