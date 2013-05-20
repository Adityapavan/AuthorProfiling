import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TrainnTest {
	public static void main(String argv[]){
		File fullfolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enoutput/");
		File trainfolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/entraining/");
		File testfolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/entesting/");
		trainfolder.mkdirs();
		testfolder.mkdirs();
//		File fullfolder = new File("/home/dharmesh/aditya/sampleroutput/");
//		File trainfolder = new File("/home/dharmesh/aditya/samplertrainoutput/");
//		File testfolder = new File("/home/dharmesh/aditya/samplertestoutput/");
//		File fullfolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/esoutput/");
//		File trainfolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/estraining/");		
//		File testfolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/estesting/");
		
		File f[]=fullfolder.listFiles();
		File afile=fullfolder.listFiles()[0];
		for(int i = 0; i<(f.length);i++){
			if(i<=(f.length)*.65){
				System.out.println(i);
				afile= f[i];			
	//			System.out.println(bfile);
				try{
					String bfile=trainfolder.getAbsolutePath() + "/" + afile.getName();
					FileInputStream inStream = new FileInputStream(afile);
					FileOutputStream outStream = new FileOutputStream(bfile);
					byte[] buffer = new byte[1024];	
					int length;
					//copy the file content in bytes 
						while ((length = inStream.read(buffer)) > 0){		
							outStream.write(buffer, 0, length);		
						}	
					inStream.close();
					outStream.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}	
			}
			else{
				System.out.println(i);
				afile= f[i];			
	//			System.out.println(bfile);
				try{
					String bfile=testfolder.getAbsolutePath() + "/" + afile.getName();
					FileInputStream inStream = new FileInputStream(afile);
					FileOutputStream outStream = new FileOutputStream(bfile);
					byte[] buffer = new byte[1024];	
					int length;
					//copy the file content in bytes 
						while ((length = inStream.read(buffer)) > 0){		
							outStream.write(buffer, 0, length);		
						}	
					inStream.close();
					outStream.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}	
			}
        }
        
	}
}
