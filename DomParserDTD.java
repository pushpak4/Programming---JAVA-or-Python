import java.io.*;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {

	public static void main(String[] args) {
		
		boolean flag=true;
		try {
			validate("course.xml");
		} 
		catch (ParserConfigurationException e) 
		{
			flag=false;
		} 
		
		catch (FileNotFoundException e) 
		{
			flag=false;
		} 
		catch (SAXException e) 
		{
			flag=false;
		} 
		catch (IOException e) 
		{
			flag=false; 
		}
		System.out.println("XML file is Valid against DTD : " +flag);

	}
	public static void validate(String xml) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {

			public void warning(SAXParseException exception) throws SAXException {throw exception;}
			public void error(SAXParseException exception) throws SAXException {throw exception;}
			public void fatalError(SAXParseException exception) throws SAXException {throw exception;}
			
	});
		
		
		documentBuilder.parse(new FileInputStream(xml));
}
}
