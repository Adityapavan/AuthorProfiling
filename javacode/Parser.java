import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class Parser extends DefaultHandler {
	String temp;
	//    StringBuffer tmpValue=new StringBuffer();   
	static String conversationdata;
	boolean bconverse = false;

	@Override
	public void startElement (String uri, String localName, String qName, Attributes attributes) { 
		if(qName.equalsIgnoreCase("conversation")){
			bconverse = true;
		}          
	}

	@Override
	public void characters (char[] ch, int start, int length) {
		if(bconverse == true){
			String str = new String(ch,start,length);
			temp =temp + " " +str.trim();
			temp = temp.replaceAll("(?i)(<)(.+?)(>)"," ");
			temp = temp.replaceAll("\\s+", " ");
		}
	}

	@Override
	public void endElement (String uri, String localName, String qName) {
		if ( qName.equalsIgnoreCase("conversation") ) {
			conversationdata = temp.trim();
		}         
		bconverse = false;  
	}   

	public void parse(String filename) throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		try {
			saxParser = factory.newSAXParser();    
			saxParser.parse(filename, this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main (String[] args) throws IOException, ParserConfigurationException, SAXException {
		Parser ps = new Parser();
		//        File indirectory = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/en/"); 
		//        File outdirectory = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enoutput/");
		//        File indirectory = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/es/"); 
		//        File outdirectory = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/esoutput/");
		//    File indirectory = new File("/home/dharmesh/aditya/sampler/"); 
		//   File outdirectory = new File("/home/dharmesh/aditya/sampleroutput/");

		{
			File indirectory = new File(args[0]+"/en"); 

			File outdirectory = new File(args[1]+"/en");
			outdirectory.mkdirs();
			File[] inarray;  
			inarray=new File[10];        
			inarray=indirectory.listFiles();
			System.out.println("starting");
			for (int j = 0; j < inarray.length; j++)
			{
				File path=inarray[j];
				String name = path.getName();
				String filepath = indirectory+"/"+name;
				ps.parse(filepath);              
				String trimname = name.substring(0,name.lastIndexOf('.'));
				String outfilepath = "/"+trimname+".txt"; 
				File outfile = new File(outdirectory, outfilepath);
				BufferedWriter bout = new BufferedWriter(new FileWriter(outfile));
				bout.write(conversationdata);
				bout.close();
				ps.temp="";
				System.out.println(j);
			}
		}
		{
			File indirectory = new File(args[0]+"/es"); 

			File outdirectory = new File(args[1]+"/es");
			outdirectory.mkdirs();
			File[] inarray;  
			inarray=new File[10];        
			inarray=indirectory.listFiles();
			System.out.println("starting");
			for (int j = 0; j < inarray.length; j++)
			{
				File path=inarray[j];
				String name = path.getName();
				String filepath = indirectory+"/"+name;
				ps.parse(filepath);              
				String trimname = name.substring(0,name.lastIndexOf('.'));
				String outfilepath = "/"+trimname+".txt"; 
				File outfile = new File(outdirectory, outfilepath);
				BufferedWriter bout = new BufferedWriter(new FileWriter(outfile));
				bout.write(conversationdata);
				bout.close();
				ps.temp="";
				System.out.println(j);
			}
		}
		System.out.println("finished");
	}

}
