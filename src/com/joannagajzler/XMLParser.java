package com.joannagajzler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLParser {

    private final static String absolutePath = System.getProperty("user.dir") + "\\nbpXML.xml";
//       private final Positions positionsList = new Positions();


    public void NIODownload() throws IOException {
        final String urlString = "https://www.nbp.pl/kursy/xml/lasta.xml";
        URL url = new URL(urlString);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(this.absolutePath);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

        fileOutputStream.close();
        readableByteChannel.close();
    }

    public ArrayList<Position> parseXML() throws ParserConfigurationException, IOException, SAXException {

        ArrayList<Position> positionList = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File(this.absolutePath));

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

//                positionsList.addToList(new Position(currencyName, converter, currencyCode, averageExchangeRate));
                positionList.add(new Position(currencyName, converter, currencyCode, averageExchangeRate));
            }
        }
        return positionList;
    }
}
