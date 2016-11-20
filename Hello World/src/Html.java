import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Роман Лотоцький on 02.10.2016.
 */
public class Html {

    public static void main(String[] args) throws IOException{

        String html = "<div><h1>This is test HTML</h1><p>This is paragraph our html file</p>"
        		+ "<p>Web Hosting Company</p></div>";
        File f = new File("test.html");
        System.out.println(f.getAbsolutePath());
        if (f.createNewFile()){
            System.out.println("File is created!");
          }else{
            System.out.println("File already exists.");
          }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(html);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
