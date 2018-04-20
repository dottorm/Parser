package com.telespazio.vega.Parser.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.DataObject;
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
			getObjects();
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
	
	public List<DataObject> getObjects() throws XPathExpressionException{
		manager.setExpr(manager.compileXpath(XPathCommands.GET_OBJECTS_LIST));
		NodeList result = (NodeList) manager.getExpr().evaluate(manager.getDoc(), XPathConstants.NODESET);
		
		Node node;
		Element ele;
		DataObject dataOject;
		
		List<DataObject> objectyList = new ArrayList<DataObject>();
		
		for(int i = 0; i<result.getLength(); i++){
			dataOject = new DataObject();
			node = result.item(i);
			
			if(!node.hasChildNodes()){continue;}
			
			NodeList nodes = node.getChildNodes();
			for(int j=0; j< nodes.getLength(); j++){
				if(!nodes.item(j).getNodeName().equals("byteStream")){
					continue;
				}
				node = nodes.item(j);
				ele = (Element) node;
				dataOject.setSize(ele.getAttribute("size"));
				
				if(!node.hasChildNodes()){continue;}
				
				NodeList nodesl = node.getChildNodes();
				Node n;
				Element e;
				for(int k=0; k< nodesl.getLength(); k++){
					if(nodesl.item(k).getNodeName().equals("fileLocation")){
						n = nodesl.item(k);
						e = (Element) n;
						dataOject.setName(e.getAttribute("href"));
					}
					if(nodesl.item(k).getNodeName().equals("checksum")){
						dataOject.setCheckSum(nodesl.item(k).getTextContent());
					}
					
				}
			}
			
			System.out.println(dataOject.toString());
			objectyList.add(dataOject);
		}
		
		return objectyList;
		
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
