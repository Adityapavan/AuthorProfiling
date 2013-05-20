//bin/mallet import-dir --input text --output script_test/10s.data --use-pipe-from 10s.mallet --remove-stopwords --keep-sequence

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class MergeSeparate {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String afile=args[0];//"/home/dharmesh/aditya/mallet-2.0.7/enage10.out";
		String afile2=args[1];//"/home/dharmesh/aditya/mallet-2.0.7/enage20.out";
		String afile3=args[2];//"/home/dharmesh/aditya/mallet-2.0.7/enage30.out";
		
		String bfile=args[3];//"/home/dharmesh/aditya/mallet-2.0.7/enfullage.csv";
		FileReader inStream1 = new FileReader(afile);
		FileReader inStream1_ = new FileReader(afile2);
		FileReader inStream1__ = new FileReader(afile3);

		FileWriter inStream2 = new FileWriter(bfile);
		
		BufferedReader  br1    = new BufferedReader(inStream1);
		BufferedReader  br1_    = new BufferedReader(inStream1_);
		BufferedReader  br1__    = new BufferedReader(inStream1__);
		BufferedWriter  br2   = new BufferedWriter(inStream2);
		int i=0;//,fcorrect=0,fincorrect=0,mcorrect=0,mincorrect=0;
		String line="",line_="",line2="0",line__="";
		for(i=1;i<203;i++){
			line2+=","+i;
		}
		//inStream2.write(line2+"\n");
		int ii=0;
		br1.readLine();
		br1_.readLine();
		br1__.readLine();
		while((line=br1.readLine())!=null)
		{
			line_=br1_.readLine();
			
			String s[] = line.split(" ");
			String s_[]=line_.split(" ");
			String s__[]=line_.split(" ");
			String put = "";
			
			//System.out.println("h"+s__.length);
			put = put + s[1].split("_")[7].charAt(0);
			Double[] num=new Double[751];
			for(i = 3;i<s.length;i+=2){
				//System.err.println(s[i]);
				num[Integer.parseInt(s[i-1])]=Double.parseDouble(s[i]);
			}
			for(i = 3;i<s_.length;i+=2){
				//System.err.println(s[i]);
				num[Integer.parseInt(s_[i-1])+250]=Double.parseDouble(s_[i]);
			}
			for(i = 3;i<s_.length;i+=2){
				//System.err.println(s[i]);
				num[Integer.parseInt(s__[i-1])+500]=Double.parseDouble(s_[i]);
			}
			for(i=0;i<750;i++){
				put+=","+num[i];
			}
			System.out.println(ii++);
			inStream2.write(put+"\n");
		}
		inStream1.close();
		inStream1_.close();
		inStream2.close();
		inStream1__.close();
	}
}
