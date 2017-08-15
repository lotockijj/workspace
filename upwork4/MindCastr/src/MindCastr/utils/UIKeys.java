/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MindCastr.utils;
import java.awt.Color;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.UIManager;

/**
 * Generate a list of UIManager color keys.
 */
public class UIKeys
{
  public static void main(String[] args) throws Exception
  {
      
      UIManager.setLookAndFeel( //
//                    UIManager.getSystemLookAndFeelClassName()); // NO to have the same L&F
//                    "com.jgoodies.looks.plastic.PlasticLookAndFeel");
//                    "com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
                    "com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
      
    List<String> colorKeys = new ArrayList<String>();
    Set<Entry<Object, Object>> entries = UIManager.getLookAndFeelDefaults().entrySet();
    for (Entry entry : entries)
    {
      if (entry.getValue() instanceof Color)
      {
        colorKeys.add((String) entry.getKey());
      }
    }

    // sort the color keys
    Collections.sort(colorKeys);
    
    // print the color keys
    for (String colorKey : colorKeys)
    {
      System.out.println(colorKey);
    }

  }
}