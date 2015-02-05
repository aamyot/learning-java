package com.alexandreamyot.school;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;
import static org.junit.Assert.assertThat;

public class XmlTest {

    @Test
    public void illegalCharactersAreAllowedInsideCDATA() {
        String illegalCharacters = "&><";
        String xml = "<path><![CDATA[" + illegalCharacters + "]]></path>";

        assertThat(document(xml), hasXPath("/path", equalTo("&><")));
    }

    private Document document(String xml) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return db.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}