package updater;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private static final String appPath = getJarFilePath();
	//	private static String tmpPath;
	private static final boolean isWindows = (System.getProperty("os.name").contains("Windows"));
	private static final String osType = (isWindows) ? "win" : "mac";
	private static final String APPNAME = (isWindows) ? "MindCastr.exe" : "MindCastr.jar";
	private static final String DIRTMP = getJarFilePath() + "/tmp/";
	private static final String XMLUPDATE = DIRTMP + "update.xml";
	private static final String LOG = getJarFilePath() + "backup/LogFile.log";

	private static String getJarFilePath() {
		String result = "";
		try {
			String path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getCanonicalPath();
			result = path.substring(0, path.lastIndexOf(File.separator) + 1).replace("%20", " ").replace("\\", "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static void initLogger() {
		try {
			File dir = new File(new File(LOG).getParent());
			if (!dir.exists()) dir.mkdirs();
			FileHandler fh = new FileHandler(new File(LOG).getPath(), true);
			LOGGER.addHandler(fh);
			fh.setFormatter(new SimpleFormatter());
			LOGGER.info("Updater started!");
			LOGGER.info(String.format("Updater app path: %s", appPath));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	public static void main(String args[]) throws IOException {
		initLogger();

		new Main().Run();
	}

	private void Run() {
		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
			new Backuper().backup(appPath, "backup", String.format("backup%s_v%s", timeStamp, appversion(new File(getJarFilePath(), APPNAME))));
			LOGGER.info("> backup done");
			new Updater(appPath, DIRTMP).update(new File(XMLUPDATE));
			LOGGER.info("> upgrade done!");
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, ex.toString(), ex);
		} finally {
			try {
				launch();
				LOGGER.info("> launch done!");
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			} finally {
				LOGGER.info("Updater finished!\n");
			}
		}
	}

	private void launch() throws IOException, InterruptedException {
		if (isWindows)
			Runtime.getRuntime().exec(APPNAME, null, new File(getJarFilePath()));
		else
			Runtime.getRuntime().exec(new String[]{"open", "/Applications/MindCastr.app"});
//        EDIT: Even better would be using Desktop.getDesktop().open(new File("MyLineInInput.app"));
	}

	private String appversion(File file) throws IOException {
		String version = "";
		try (JarFile jar = new JarFile(file)) {
			Manifest manifest = jar.getManifest();
			java.util.jar.Attributes attributes = manifest.getMainAttributes();
			if (attributes != null) {
				Iterator it = attributes.keySet().iterator();
				while (it.hasNext()) {
					Attributes.Name key = (Attributes.Name) it.next();
					String keyword = key.toString();
					if (keyword.equals("MindCastrVersion")) {
						version = (String) attributes.get(key);
						break;
					}
				}
			}
		}
		if (version.isEmpty())
			throw new IOException("Cannot get current app version");
		return version;
	}
}
