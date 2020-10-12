package com.joannagajzler;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ListOfPositions listOfPositions = new ListOfPositions();
        XMLParser xmlParser = new XMLParser();

        try {
            xmlParser.parseXML(listOfPositions);
            UserInterface userInterface = new UserInterface(listOfPositions);
            userInterface.menu();
        } catch (ParserConfigurationException |
                SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
