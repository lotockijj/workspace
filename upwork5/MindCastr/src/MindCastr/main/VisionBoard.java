package MindCastr.main;

import MindCastr.autoUpdate.UpgrageService;
import MindCastr.persistent.Membership;
import MindCastr.utils.Utils;
import MindCastr.panels.MainWindow;
import MindCastr.OS.Info.*;
import MindCastr.constants.Constants;
import static MindCastr.persistent.DirectoryManager.CreateFolderIfNotExist;
import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.LightGray;
import org.apache.commons.io.FileUtils;



public class VisionBoard {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// Setting L&F used by program
		try {
			RandomAccessFile randomFile = new RandomAccessFile(new File(Utils.getJarFilePath(), "mindcastr.single"), "rw");
			FileChannel channel = randomFile.getChannel();
			if (channel.tryLock() == null) {
				System.exit(0);
			}

			new UpgrageService().upgrade();

			PlasticLookAndFeel.set3DEnabled(true);
			PlasticLookAndFeel.setPlasticTheme(new LightGray());

			UIManager.put("jgoodies.useNarrowButtons", Boolean.FALSE);
            UIManager.setLookAndFeel( //
//                    UIManager.getSystemLookAndFeelClassName()); // NO to have the same L&F
//                    "com.jgoodies.looks.plastic.PlasticLookAndFeel");
//                    "com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
                    "com.jgoodies.looks.plastic.PlasticXPLookAndFeel");


             UIManager.put("Panel.background", Constants.MAIN_PANEL_COLOR);





        } catch (Exception e) {
            e.printStackTrace();
        }
		new Membership.Fork(Constants.REG_FILE).check();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					File file = new File(Utils.getJarFilePath()
							+ Constants.NET_MAC_FILE_NAME_ENCRYPTED);
                                        File source = new File(Utils.getJarFilePath() + "default.properties");
                                              //  JOptionPane.showMessageDialog(null, source.toString());
                                        CreateFolderIfNotExist(getMindCastrFolder() + File.separator + "Configuration");
                                        File dest  = new File(getMindCastrFolder() + File.separator + "Configuration" + File.separator + "configuration.properties");
					if (source.exists())
                                            if (!dest.exists())
                                            {
                                                FileUtils.copyFile(source, dest);
                                              //  JOptionPane.showMessageDialog(null, "perfect");
                                            }

					MainWindow mainWin = MainWindow.getInstance();
					mainWin.setIconImage(ImageIO.read(VisionBoard.class
							.getClass().getResource("/icon.png")));

                                      //  JOptionPane.showMessageDialog(null, Utils.getJarFilePath()
					//		+ Constants.NET_MAC_FILE_NAME_ENCRYPTED);

					if (!file.exists()) {
						Utils.msgBox("ERROR");
					} else if (file.exists() && file.length() < 1024) {
						//file.createNewFile();
						NetCardWin.setNetMacToFile();
						mainWin.setVisible(true);
					} else {
						if (NetCardWin.checkNetMac()) {
							mainWin.setVisible(true);
						} else {
							Utils.msgBox("ERROR");
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					System.exit(1);
				}
			}
		});
	}
}
