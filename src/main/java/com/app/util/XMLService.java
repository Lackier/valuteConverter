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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

            doc.getDocumentElement().normalize();
            Node nodeValCurs = doc.getElementsByTagName("ValCurs").item(0);
            Element elemValCurs = (Element) nodeValCurs;

            String date = elemValCurs.getAttribute("Date");

            valCurs = new ValCurs(
                    stringToDate(date),
                    elemValCurs.getAttribute("name")
                    );

            NodeList nodeList = doc.getElementsByTagName("Valute");
            List<Valute> valutes = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Valute valute = new Valute(
                            elem.getAttribute("ID"),
                            elem.getElementsByTagName("NumCode").item(0).getTextContent(),
                            elem.getElementsByTagName("CharCode").item(0).getTextContent(),
                            Integer.parseInt(elem.getElementsByTagName("Nominal").item(0).getTextContent()),
                            elem.getElementsByTagName("Name").item(0).getTextContent(),
                            elem.getElementsByTagName("Value").item(0).getTextContent()
                    );
                    valutes.add(valute);
                }
            }
            valCurs.setValuteList(valutes);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return valCurs;
    }

    private Date stringToDate(String dateString) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sourceFormat.parse(dateString);
        date.setDate(date.getDay() + 1);
        return date;
    }
}