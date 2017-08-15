/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.components.visionboard;

import MindCastr.persistent.MouseDragHandler;

import static MindCastr.persistent.DirectoryManager.CreateFolderIfNotExist;
import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author Ash
 */
public class UsageComponentUtil {
    
    public static JComponent createUsageComponent(MouseDragHandler mouseDragHandler, JScrollPane contentComponent) {
        assert(mouseDragHandler != null);
        assert(contentComponent != null);
        String linkStr = readLinkFileContent();
        if(linkStr == null || linkStr.trim().isEmpty()) {
            return null;
        }
        JEditorPane content = new JEditorPane();
        content.setContentType("text/html");
        content.setEditable(false);
        int padding = contentComponent.getPreferredSize().height/3/*I thought this should be 2 (???)*/;
        content.setText("<html>" 
                + "<div style=\"padding-top:" + padding + "px;padding-bottom:" + padding + "px;text-align:center;\">"
                + "<a href=\"" + linkStr + "\">How do I use MindCastr?</a>" 
                + "</div>"
                + "</html>");
        content.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    } catch (Exception e1) {
                        System.out.println("browse failed: " + e1.getMessage());
                    }
                }
            }
        });
        JPanel panel = new JPanel();
        panel.add(content);
        panel.addMouseMotionListener(mouseDragHandler);
        return panel;
    }
    
    private static String readLinkFileContent() {
        String linkStr = null;
        File linkFile = getLinkFile();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(linkFile));
            StringBuilder sb = new StringBuilder();
            linkStr = br.readLine();
        } catch (Exception ex) {
            System.out.println("cannot read youtubelink file: " + ex.getMessage());
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println("cannot close BufferedReader: " + ex.getMessage());
            }
        }
        return linkStr;
    }
    
    public static void deleteLinkFileContent() {
        File linkFile = getLinkFile();
        PrintWriter writer = null;
        try {
                writer = new PrintWriter(linkFile);
                writer.print("");
                writer.close();
            } catch (FileNotFoundException ex) {
                System.out.println("cannot delete linkfile content: " + ex.getMessage());
            } finally {
                if(writer != null) {
                    writer.close();
                }
            }
    }
    
    private static File getLinkFile() {
        CreateFolderIfNotExist(getMindCastrFolder() + File.separator + "Configuration");
        File linkFile = new File(getMindCastrFolder() + File.separator + "Configuration//youtubelink");
        
        assert(linkFile.exists()) : "Configuration//youtubelink file does not exist";
        return linkFile;
    }
    
}
