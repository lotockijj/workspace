/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MindCastr.persistent;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Hackintosh
 */
public class DirectoryManager {
    public static boolean CreateFolderIfNotExist(String s)
    {
    // Here we are assuming that D:\Gautam\testing folder exists but first
        // and second folder is not there and user
        // has privilege to create directory in testing folder
        File file = new File(s);
 
        boolean b = false;
 
        /*
         * exists() method tests whether the file or directory denoted by this
         * abstract pathname exists or not accordingly it will return TRUE /
         * FALSE.
         */
 
        if (!file.exists()) {
            /*
             * mkdirs() method creates the directory mentioned by this abstract
             * pathname including any necessary but nonexistent parent
             * directories.
             * 
             * Accordingly it will return TRUE or FALSE if directory created
             * successfully or not. If this operation fails it may have
             * succeeded in creating some of the necessary parent directories.
             */
            b = file.mkdirs();
        }
        return b;
    }
    
    public static String getMindCastrFolder()
    {
    String MindCastrFolder = "";    
    if (System.getProperty("os.name").contains("Mac"))
        {
            MindCastrFolder = System.getProperty("user.home")+File.separator+"Documents" + File.separator + "MindCastr";           
        } 
    if (System.getProperty("os.name").contains("Win"))
        {            
            JFileChooser f = new JFileChooser();
            f.setCurrentDirectory(null);
            MindCastrFolder = f.getCurrentDirectory().toString() + File.separator + "MindCastr";           
        }   
    //JOptionPane.showMessageDialog(null, MindCastrFolder);
    return MindCastrFolder;
    }
}
