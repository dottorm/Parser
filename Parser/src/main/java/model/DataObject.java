package model;

public class DataObject {
	
	private String name;
	private String checkSum;
	
	public DataObject(String name, String checkSum){
		this.name = name;
		this.checkSum = checkSum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	@Override
	public String toString() {
		return String.format("DataObject [name=%s, checkSum=%s]", name, checkSum);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkSum == null) ? 0 : checkSum.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DataObject other = (DataObject) obj;
		if (checkSum == null) {
			if (other.checkSum != null)
				return false;
		} else if (!checkSum.equals(other.checkSum))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
