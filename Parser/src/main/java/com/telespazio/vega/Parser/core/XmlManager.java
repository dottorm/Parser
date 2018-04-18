package com.telespazio.vega.Parser.core;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlManager {
	
	private final Document doc;
	private File manifest;
	
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	
	private XPathFactory xPathfactory;
	private XPath xpath;
	private XPathExpression expr;
	
	public XmlManager(final File xml) throws ParserConfigurationException, SAXException, IOException{
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xml);
		
		xPathfactory = XPathFactory.newInstance();
		xpath = xPathfactory.newXPath();
	}
	
	public XPathExpression compileXpath(String path) throws XPathExpressionException{
		expr = xpath.compile(path);
		return expr;
	}
	
	public File getManifest() {
		return manifest;
	}
	public void setManifest(File manifest) {
		this.manifest = manifest;
	}
	public DocumentBuilderFactory getDbFactory() {
		return dbFactory;
	}
	public void setDbFactory(DocumentBuilderFactory dbFactory) {
		this.dbFactory = dbFactory;
	}
	public DocumentBuilder getdBuilder() {
		return dBuilder;
	}
	public void setdBuilder(DocumentBuilder dBuilder) {
		this.dBuilder = dBuilder;
	}
	public XPathFactory getxPathfactory() {
		return xPathfactory;
	}
	public void setxPathfactory(XPathFactory xPathfactory) {
		this.xPathfactory = xPathfactory;
	}
	public XPath getXpath() {
		return xpath;
	}
	public void setXpath(XPath xpath) {
		this.xpath = xpath;
	}
	public XPathExpression getExpr() {
		return expr;
	}
	public void setExpr(XPathExpression expr) {
		this.expr = expr;
	}
	public Document getDoc() {
		return doc;
	}

}
