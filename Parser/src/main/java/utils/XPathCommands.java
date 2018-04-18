package utils;

public class XPathCommands {
	
	public static String GET_TIME = "/XFDU/metadataSection/metadataObject[@ID='acquisitionPeriod']/metadataWrap/xmlData/acquisitionPeriod/%s";
	public static String GET_PROPERTY = "/XFDU/metadataSection/metadataObject[@ID='generalProductInformation']/metadataWrap/xmlData/generalProductInformation/%s";
	public static String GET_PLATFORM = "/XFDU/metadataSection/metadataObject[@ID='processing']/metadataWrap/xmlData/processing[@name='DataProcessing']/facility/hardware";
	public static String GET_ORBIT = "/XFDU/metadataSection/metadataObject[@ID='measurementOrbitReference']/metadataWrap/xmlData/orbitReference/relativeOrbitNumber[@type='start']";
}
