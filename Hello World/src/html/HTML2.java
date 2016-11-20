package html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ðîìàí Ëîòîöüêèé on 02.10.2016.
 */
public class HTML2 {

    public static void main(String[] args) throws IOException{

        String html;
        File f = new File("test2.html");
        System.out.println(f.getAbsolutePath());
        if (f.createNewFile()){
            System.out.println("File is created!");
          }else{
            System.out.println("File already exists.");
          }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write("<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Strict//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd”><html xmlns=”http://www.w3.org/1999/xhtml” lang=”en” xml:lang=”en”><head><meta http-equiv=“Content-Type”content=”text/html; charset=ISO-8859-1” /><title>Head First Lounge</title><style type=”text/css”>p {color: maroon;}</style></head><body><h1>Welcome to the Head First Lounge</h1><p><img src=“images/drinks.gif” alt=“Drinks” /></p><p>Join us any evening for refreshing<a href=“beverages/elixir.html”>elixirs</a>,conversation and maybe a game or twoof <em>Dance Dance Revolution</em>.Wireless access is always provided;BYOWS (Bring your own web server).</p><h2>Directions</h2><p>You’ll fnd us right in the centerof downtown Webville. If you needhelp fnding us, check out our<a href=“about/directions.html”>detailed directions</a>.Come join us!</p></body></html>");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}