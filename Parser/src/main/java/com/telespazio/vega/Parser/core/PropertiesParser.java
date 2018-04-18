package com.telespazio.vega.Parser.core;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class PropertiesParser {
	
	private XmlManager manager;

	public PropertiesParser() throws ParserConfigurationException, SAXException, IOException {
		manager = new XmlManager(null);
	}

}
