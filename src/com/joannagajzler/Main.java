package com.joannagajzler;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Positions positionsList = new Positions();
        XMLParser xmlParser = new XMLParser();

        try {
            xmlParser.parseXML(positionsList);
        } catch (ParserConfigurationException |
                SAXException | IOException e) {
            e.printStackTrace();
        }

        UserInterface userInterface = new UserInterface(positionsList);
        userInterface.menu();

    }

}
