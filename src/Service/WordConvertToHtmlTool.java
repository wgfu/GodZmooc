package Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;

public class WordConvertToHtmlTool {
public boolean WordConvertToHtml(File file,String path,String filename)throws Exception
{
	
	  InputStream input = new FileInputStream(file);
	  HWPFDocument wordDocument = new HWPFDocument(input);
	  WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
	    DocumentBuilderFactory.newInstance().newDocumentBuilder()
	      .newDocument());
	  wordToHtmlConverter.setPicturesManager(new PicturesManager() {
	   public String savePicture(byte[] content, PictureType pictureType,
	     String suggestedName, float widthInches, float heightInches) {
	    return suggestedName;
	   }
	  });
	  wordToHtmlConverter.processDocument(wordDocument);
	  List pics = wordDocument.getPicturesTable().getAllPictures();
	  if (pics != null) {
	   for (int i = 0; i < pics.size(); i++) {
	    Picture pic = (Picture) pics.get(i);
	    try {
	     pic.writeImageContent(new FileOutputStream(path
	       + pic.suggestFullFileName()));
	    } catch (FileNotFoundException e) {
	     e.printStackTrace();
	    }
	   }
	  }
	  Document htmlDocument = wordToHtmlConverter.getDocument();
	  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	  DOMSource domSource = new DOMSource(htmlDocument);
	  StreamResult streamResult = new StreamResult(outStream);
	  TransformerFactory tf = TransformerFactory.newInstance();
	  Transformer serializer = tf.newTransformer();
	  serializer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
	  serializer.setOutputProperty(OutputKeys.INDENT, "yes");
	  serializer.setOutputProperty(OutputKeys.METHOD, "html");
	  serializer.transform(domSource, streamResult);
	  outStream.close();
	  String content = new String(outStream.toByteArray());
	  FileUtils.write(new File(path,filename), content, "GB2312");
	  return true;
	 }

}
