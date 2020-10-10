package com.joannagajzler;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Positions positionsList = new Positions();
        XMLParser xmlParser = new XMLParser();

        try {
            xmlParser.NIODownload();
            positionsList = xmlParser.parseXML();
        } catch (ParserConfigurationException |
                SAXException | IOException e) {
            e.printStackTrace();
        }

        View view = new View(positionsList);
        view.menu();


    }


}
