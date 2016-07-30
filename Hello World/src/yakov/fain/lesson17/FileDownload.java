package yakov.fain.lesson17;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownload {
	
	public static void main(String[] args){


		if(args.length != 2){
			System.out.println("Proper Usage: java  File Download URL OutputFileName");
			System.exit(0);
		}

		InputStream in = null;
		FileOutputStream fOut = null;
		//index.html or index.jsp or some other default URL at google;
		try{
			URL remoteFile = new URL(args[0]);
			URLConnection fileStream = remoteFile.openConnection();
			// Open output and input stream 
			fOut = new FileOutputStream(args[1]);
			in = fileStream.getInputStream();
			//save the file
			int data;

			while((data = in.read()) != -1){
				fOut.write(data);
			}


		} catch (Exception e){
			e.printStackTrace();
		} 
		finally {
			System.out.println("The file " + args[0] + " has been downloaded successfully as " + args[1]);
			try{
				in.close();
				fOut.flush();
				fOut.close();
			} catch (Exception e1){
				e1.printStackTrace();
			}
		}
	}

}
