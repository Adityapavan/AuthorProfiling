/**
 * 
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author aditya
 *
 */
public class Separator {
	/**
	 * @param args
	 */
	public static void main(String[] argv) throws IOException {
		File folder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/entraining/");
        File femalefolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enseparate/enfemale/");
        File malefolder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enseparate/enmale/");
        File age10folder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enseparate/enage10/");
        File age20folder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enseparate/enage20/");
        File age30folder = new File("/home/dharmesh/aditya/author_profiling/pan_author_profiling_training_data/enseparate/enage30/");
        femalefolder.mkdirs();
        malefolder.mkdirs();
//        age10folder.mkdirs();
//        age20folder.mkdirs();
//        age30folder.mkdirs();
		File f[]=folder.listFiles();
		File afile=folder.listFiles()[0];
		for(int i = 0; i<f.length;i++){

			System.out.println(i);
			afile= f[i];

//			if(afile.getName().contains("_10s_")){
//				String bfile=age10folder.getAbsolutePath() + "/" + afile.getName();
//				FileInputStream inStream = new FileInputStream(afile);
//				FileOutputStream outStream = new FileOutputStream(bfile);
//
//				byte[] buffer = new byte[1024];
//
//				int length;
//				//copy the file content in bytes 
//				while ((length = inStream.read(buffer)) > 0){
//
//					outStream.write(buffer, 0, length);
//
//				}
//
//				inStream.close();
//				outStream.close();
//			}
//			else if(afile.getName().contains("_20s_"))
//			{
//
//				String bfile=age20folder.getAbsolutePath() + "/" + afile.getName();
//				FileInputStream inStream = new FileInputStream(afile);
//				FileOutputStream outStream = new FileOutputStream(bfile);
//
//				byte[] buffer = new byte[1024];
//
//				int length;
//				//copy the file content in bytes 
//				while ((length = inStream.read(buffer)) > 0){
//
//					outStream.write(buffer, 0, length);
//
//				}
//
//				inStream.close();
//				outStream.close();
//			}
//			else
//			{
//
//				String bfile=age30folder.getAbsolutePath() + "/" + afile.getName();
//				FileInputStream inStream = new FileInputStream(afile);
//				FileOutputStream outStream = new FileOutputStream(bfile);
//
//				byte[] buffer = new byte[1024];
//
//				int length;
//				//copy the file content in bytes 
//				while ((length = inStream.read(buffer)) > 0){
//
//					outStream.write(buffer, 0, length);
//
//				}
//
//				inStream.close();
//				outStream.close();
//			}
			if(afile.getName().contains("female")){
				String bfile=femalefolder.getAbsolutePath() + "/" + afile.getName();
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
			}
			else
			{

				String bfile=malefolder.getAbsolutePath() + "/" + afile.getName();
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
			}
		}

	}
}
