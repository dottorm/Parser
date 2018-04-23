package utils;

public class XPathCommands {
	
	public static String GET_TIME = "/XFDU/metadataSection/metadataObject[@ID='acquisitionPeriod']/metadataWrap/xmlData/acquisitionPeriod/%s";
	public static String GET_PROPERTY = "/XFDU/metadataSection/metadataObject[@ID='generalProductInformation']/metadataWrap/xmlData/generalProductInformation/%s";
	public static String GET_PLATFORM = "/XFDU/metadataSection/metadataObject[@ID='processing']/metadataWrap/xmlData/processing[@name='DataProcessing']/facility/hardware";
	public static String GET_SURFACE = "/XFDU/metadataSection/metadataObject[@ID='processing']/metadataWrap/xmlData/processing[@name='DataProcessing']/facility";
	public static String GET_CYCLE_NUMBER = "/XFDU/metadataSection/metadataObject[@ID='measurementOrbitReference']/metadataWrap/xmlData/orbitReference/cycleNumber";
	public static String GET_ORBIT = "/XFDU/metadataSection/metadataObject[@ID='measurementOrbitReference']/metadataWrap/xmlData/orbitReference/relativeOrbitNumber[@type='start']";
	public static String GET_OBJECTS_LIST = "/XFDU/dataObjectSection/dataObject";
	public static String GET_OBJECT_NAME = "/XFDU/dataObjectSection/dataObject/byteStream/fileLocation";
	public static String GET_OBJECT_MD5 = "/XFDU/dataObjectSection/dataObject/byteStream/checksum";
	public static String GET_OBJECT_SIZE = "/XFDU/dataObjectSection/dataObject/byteStream";
	
	public static String GET_REGEX = "/Mex_Spec/fileNamePattern";
	public static String GET_TYPE = "/Mex_Spec/specId";
}
