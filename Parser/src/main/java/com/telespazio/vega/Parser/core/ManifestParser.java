package com.telespazio.vega.Parser.core;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import utils.CheckName;
import utils.XPathCommands;

public class ManifestParser {
	
	private XmlManager manager;
	
	public ManifestParser(final File manifest) throws ParserConfigurationException, SAXException, IOException{
		
		manager = new XmlManager(manifest);
		
		try {
			System.out.println(getTime("startTime"));
			System.out.println(getTime("stopTime"));
			System.out.println(getProductInformation("productType"));
			System.out.println(getProductInformation("productName"));
			System.out.println(getProductInformation("timeliness"));
			System.out.println(getProductInformation("baselineCollection"));
			System.out.println(getProductInformation("creationTime"));
			System.out.println(getPlatform());
			System.out.println(getOrbit());
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPlatform() throws XPathExpressionException{
		
		manager.setExpr(manager.compileXpath(XPathCommands.GET_PLATFORM));
		Node node = (Node) manager.getExpr().evaluate(manager.getDoc(), XPathConstants.NODE);
		
		if(node == null){
			return null;
		}
		
		Element ele = (Element) node;
		
		String result = ele.getAttribute("name");
		
		if(result == null){
			return null;
		}
		
		result = CheckName.checkPlatform(result);
		
		return result;
	}
	
	public String getOrbit() throws XPathExpressionException{
		
		manager.setExpr(manager.compileXpath(XPathCommands.GET_ORBIT));
		String result = (String) manager.getExpr().evaluate(manager.getDoc(), XPathConstants.STRING);
		
		return result;
	}
	
	public String getProductInformation(String value) throws XPathExpressionException{
		
		manager.setExpr(manager.compileXpath(String.format(XPathCommands.GET_PROPERTY,value)));
		String result = (String) manager.getExpr().evaluate(manager.getDoc(), XPathConstants.STRING);
		
		return result;
	}
	
	public String getTime(String time) throws XPathExpressionException{
		
		manager.setExpr(manager.compileXpath((String.format(XPathCommands.GET_TIME, time))));
		String result = (String) manager.getExpr().evaluate(manager.getDoc(), XPathConstants.STRING);
		
		result = result.replaceAll("-", "").replaceAll(":", "");
		result = result.substring(0, 15);
		
		return result;
        //System.out.println(writer.toString());
		//NodeList book = (NodeList) xpath.evaluate("/", doc, XPathConstants.NODESET);
	
		
		/*doc.getDocumentElement().normalize(); /metadataSection/metadataObject[@ID='acquisitionPeriod']/metadataWrap/xmlData/sentinel-safe:acquisitionPeriod/sentinel-safe:startTime/text()

		NodeList nList = doc.getElementsByTagName("metadataObject");
		Node node;
		for(int i=0; i<nList.getLength(); i++){
			node = nList.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) node;
				if(element.getAttribute("ID").equals("acquisitionPeriod")){
					element.getBaseURI();
					
					//expr.evaluate(expr);
					
				}
			
			}
		}*/
	}
	
}
