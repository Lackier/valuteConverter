package com.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLService {

    private final Logger logger = LoggerFactory.getLogger(XMLService.class);


    public ValCurs parseCourse(String URL) {

        ValCurs valCurs = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            // normalize XML response
            doc.getDocumentElement().normalize();

            //read course details first
            valCurs = new ValCurs(
                    //Integer.parseInt(doc.getElementsByTagName("id").item(0).getTextContent()),
                    );

            //read students list
            NodeList nodeList = doc.getElementsByTagName("Valute");

            //create an empty list for students
            List<Valute> valutes = new ArrayList<>();

            //loop all available student nodes
            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Valute valute = new Valute(
                            "",
                            elem.getElementsByTagName("NumCode").item(0).getTextContent(),
                            elem.getElementsByTagName("CharCode").item(0).getTextContent(),
                            Integer.parseInt(elem.getElementsByTagName("Nominal").item(0).getTextContent()),
                            elem.getElementsByTagName("Name").item(0).getTextContent(),
                            elem.getElementsByTagName("Value").item(0).getTextContent()
                    );
                    valutes.add(valute);
                }
            }

            valCurs.setValutes(valutes);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return valCurs;
    }
}