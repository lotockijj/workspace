package MindCastr.autoUpdate;

import MindCastr.constants.Constants;
import MindCastr.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class UpgrageService {

    public void upgrade() {
        File tmpApp = new File(Constants.DIRTMP, Constants.APPNAME);
        File updaterJar = new File(Utils.getJarFilePath(), "updater.jar");
        try {
            if (Utils.exists(tmpApp) && Utils.exists(updaterJar)) {
                if (appversion(tmpApp).compareToIgnoreCase(UpdateService.getCurrentVersion()) > 0) {
                    String[] cmd = {"java", "-jar", updaterJar.getCanonicalPath()};
                    Runtime.getRuntime().exec(cmd, null, new File(Utils.getJarFilePath()));
                    System.exit(0);
                } else {
                    Utils.cleanup(new File(Constants.DIRTMP));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
