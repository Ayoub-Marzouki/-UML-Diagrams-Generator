package org.mql.java.xml.structure;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Enum {
    private String name;
    private List<Relationship> relationships;

    public Enum(String name) {
        this.name = name;
        this.relationships = new ArrayList<>();
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    @Override
    public String toString() {
        return "Enum: " + name + "\nRelationships: " + relationships;
    }
    
    public void toXml(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("enum");
        xmlWriter.writeAttribute("name", name);

        writeRelationships(xmlWriter);

        xmlWriter.writeEndElement();
    }

    private void writeRelationships(XMLStreamWriter xmlWriter) throws XMLStreamException {
        if (!relationships.isEmpty()) {
            xmlWriter.writeStartElement("relationships");
            for (Relationship relationship : relationships) {
                relationship.toXml(xmlWriter);
            }
            xmlWriter.writeEndElement();
        }
    }
    
    
}