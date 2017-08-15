package MindCastr.autoUpdate;

import MindCastr.constants.Constants;
import MindCastr.utils.Utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UpdateService {
	private final String curVers;

	public UpdateService(String version) {
		curVers = version;
	}

	public void autoUpdate() {
		try {
			if (!Utils.exists(new File(Constants.DIRTMP, Constants.APPNAME))) {
				JsonReader json = new JsonReader();
				json.check();
				if (json.validate()) {
					if (json.version().compareToIgnoreCase(curVers) > 0) {
						File zip = new File(Utils.getJarFilePath(), "tmp/update.zip");
						wget(new URL(json.zipUrl()), zip);
						unzip(zip.getCanonicalPath(), Constants.DIRTMP);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void wget(URL url, File destination) throws IOException {
		createDir(new File(destination.getParent()));
		URLConnection conn = url.openConnection();
		try (InputStream in = conn.getInputStream();
			 OutputStream out = new FileOutputStream(destination)) {
			byte[] buffer = new byte[512];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
		}
	}

	private void unzip(String zipfile, String destDir) throws IOException {
		createDir(new File(destDir));
		byte[] buffer = new byte[1024];
		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipfile))) {
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				File newFile = new File(destDir, ze.getName());
				createDir(new File(newFile.getParent()));
				try (FileOutputStream fos = new FileOutputStream(newFile)) {
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
				}
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			zis.closeEntry();
		}
	}

	private void createDir(File dir) throws IOException {
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException(String.format("Unable to create %s", dir.getAbsolutePath()));
		}
	}

	public static String getCurrentVersion() {
		Enumeration resEnum;
		try {
			resEnum = Thread.currentThread().getContextClassLoader().getResources(JarFile.MANIFEST_NAME);
			while (resEnum.hasMoreElements()) {
				try {
					URL url = (URL)resEnum.nextElement();
					InputStream is = url.openStream();
					if (is != null) {
						Manifest manifest = new Manifest(is);
						Attributes mainAttribs = manifest.getMainAttributes();
						String version = mainAttribs.getValue("MindCastrVersion");
						if(version != null) {
							return version;
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return "";
	}
}
