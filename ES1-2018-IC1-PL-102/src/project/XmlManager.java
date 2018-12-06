package project;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlManager {

	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;
	Element root;
	
	public XmlManager() {

	}
	
	void createXmlFile() {
		try {
			dbFactory= DocumentBuilderFactory.newInstance();
			dBuilder= dbFactory.newDocumentBuilder();
			doc= dBuilder.newDocument();
			
			/// root element
			root= doc.createElement("root");
			doc.appendChild(root);		
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("C:\\cars.xml"));
	        transformer.transform(source, result);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	void createUser(String userEmail, String password) {
		/// user creation
		try {
		Element user= doc.createElement("user");
		root.appendChild(user);
		
		/// setting user and password
		Attr attrEmail= doc.createAttribute("email");
		attrEmail.setValue(userEmail);
		user.setAttributeNode(attrEmail);
		
		Attr attrPassword= doc.createAttribute("password");
		attrPassword.setValue(password);
		user.setAttributeNode(attrPassword);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("C:\\cars.xml"));
        transformer.transform(source, result);
        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}	/// END
