package com.joannagajzler;


import java.io.IOException;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser {

    public void parseXML(ListOfPositions listOfPositions) throws ParserConfigurationException, IOException, SAXException {

        NIODownload.downloadXML();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File(NIODownload.getAbsolutePath()));

        NodeList nodeList = document.getElementsByTagName("pozycja");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String currencyName = element.getElementsByTagName("nazwa_waluty")
                        .item(0).getChildNodes().item(0).getNodeValue();

                Integer converter = Integer.parseInt(element.getElementsByTagName("przelicznik").item(0)
                        .getChildNodes().item(0).getNodeValue());

                String currencyCode = element.getElementsByTagName("kod_waluty")
                        .item(0).getChildNodes().item(0).getNodeValue();

                String averageExchangeRate = element.getElementsByTagName("kurs_sredni")
                        .item(0).getChildNodes().item(0).getNodeValue();

                listOfPositions.getPositionList().add(new Position(currencyName, converter, currencyCode, averageExchangeRate));
            }
        }
    }
}
