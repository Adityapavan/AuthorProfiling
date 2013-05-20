import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class finalXML {
	public static void main(String args[]) throws IOException{
		// TODO Auto-generated method stub
		String afile1=args[0];//"/home/dharmesh/aditya/mallet-2.0.7/enfullagelibsvmtested.txt";
		String afile2=args[1];//"/home/dharmesh/aditya/mallet-2.0.7/enfullgenderlibsvmtested.txt";
		String afile3=args[2];//"/home/dharmesh/aditya/mallet-2.0.7/entestingforsvmage10.out";


		FileReader inStream1 = new FileReader(afile1);
		FileReader inStream2 = new FileReader(afile2);
		FileReader inStream3 = new FileReader(afile3);



		BufferedReader  br1    = new BufferedReader(inStream1);
		BufferedReader  br2    = new BufferedReader(inStream2);
		BufferedReader  br3    = new BufferedReader(inStream3);
		
		int i=0;//,fcorrect=0,fincorrect=0,mcorrect=0,mincorrect=0;
		String line="",line_="",line__="";
		//br1.readLine();
		//br1_.readLine();
		br3.readLine();
		while((line=br1.readLine())!=null)
		{
			line_=br2.readLine();
			line__=br3.readLine();
			//System.out.println(line__.split(" ")[1].split("/")[line__.split(" ")[1].split("/").length-1]);
			String authorid = line__.split(" ")[1].split("/")[line__.split(" ")[1].split("/").length-1].split("_")[0];
			String lang = line__.split(" ")[1].split("/")[line__.split(" ")[1].split("/").length-1].split("_")[1];
			String bfile=args[3]+"/"+authorid+".xml";
			FileWriter outStream = new FileWriter(bfile);
			BufferedWriter  bout   = new BufferedWriter(outStream);
			String s1[] = line.split("\t");
			String s2[] = line_.split("\t");
			//System.out.println(line.split("\t")[3]);
			Double agescore = Double.parseDouble(s1[2]);
			String ageclass = s1[1];
			for(int j=4;j<7;j+=2){
				if(agescore  < Double.parseDouble(s1[j]))
					ageclass = s1[j-1];
			}
			Double genderscore = Double.parseDouble(s2[2]);
			String genderclass = s2[1];
			for(int j=4;j<5;j+=2){
				if(genderscore  < Double.parseDouble(s2[j]))
					genderclass = s2[j-1];
			}
			String output = "";
			if(genderclass.equals("-1"))
				genderclass = "female";
			else
				genderclass = "male";
			output = "<author id=\""+authorid+"\" lang=\""+lang+"\" age_group=\""+ageclass+"0s\" gender=\""+genderclass+"\"/>";
			bout.write(output);
			bout.close();
			
		}
	}

}
/*<author 
   id="<author-id>"
   lang="en|es"
   age_group="10s|20s|30s"
   gender="male|female"
/>*/
