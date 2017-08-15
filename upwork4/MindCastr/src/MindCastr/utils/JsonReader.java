/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MindCastr.utils;

import MindCastr.constants.Constants;
import static MindCastr.persistent.DirectoryManager.getMindCastrFolder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

/**
 *
 * @author Alex
 */
public class JsonReader {

    private static final File JSON_LOCAL_FILE;

    static {
            JSON_LOCAL_FILE = new File(new File(getMindCastrFolder(), "Configuration"), "mindcastr_settings.json");
    }

    private final String ads1img;
    private final String ads1url;
    private final String ads2img;
    private final String ads2url;
    private final String tutorialUrl;

    private final String serverVersion;
    private final String updateUrl;
    private static volatile JsonReader instance = null;

    private JsonReader() throws IOException {

        String jsonString = readUrl(Constants.SETTINGS_JSON);

        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(jsonString).getAsJsonObject();
        JsonObject ads1 = mainObject.get("ads1").getAsJsonObject();
        JsonObject ads2 = mainObject.get("ads2").getAsJsonObject();
        tutorialUrl = mainObject.get("tutorialUrl").getAsString();
        ads1img = ads1.get("img").getAsString();
        ads1url = ads1.get("url").getAsString();
        ads2img = ads2.get("img").getAsString();
        ads2url = ads2.get("url").getAsString();

        JsonObject updateServer = mainObject.get("latest_mindcastr_version").getAsJsonObject();
        serverVersion = updateServer.get("version").getAsString();
        updateUrl = updateServer.get("url").getAsString();

    }

    public static synchronized JsonReader getInstance() throws IOException {
        if (instance == null) {
            instance = new JsonReader();
        }
        return instance;
    }

    public String getAds1img() {
        return ads1img;
    }

    public String getAds1url() {
        return ads1url;
    }

    public String getAds2img() {
        return ads2img;
    }

    public String getAds2url() {
        return ads2url;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public String getTutorialUrl() {
        return tutorialUrl;
    }


    private static String readUrl(String urlString) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            writeToLocalFile(buffer.toString());
            return buffer.toString();
        }
        catch(IOException ex) {
            reader = new BufferedReader(new FileReader(JSON_LOCAL_FILE.getAbsoluteFile()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        }
        finally {
            if (reader != null)
                reader.close();
        }
    }

    private static void writeToLocalFile(String text) {
        try {
            if(!JSON_LOCAL_FILE.exists()) {
                JSON_LOCAL_FILE.createNewFile();
            }
            PrintWriter out = new PrintWriter(JSON_LOCAL_FILE.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

