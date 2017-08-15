package MindCastr.autoUpdate;

import MindCastr.constants.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonReader {
    private String serverVersion;
    private String zipUrl;
    private boolean valid;

    public void check() {
        try {
            JsonObject mainObject = new JsonParser().parse(readUrl(Constants.SETTINGS_JSON)).getAsJsonObject();
            JsonObject updateServer = mainObject.get("latest_mindcastr_version").getAsJsonObject();
            serverVersion = updateServer.get("version").getAsString();
            zipUrl = updateServer.get("update_files").getAsJsonObject().get
                    (Constants.osType).getAsString();
            valid = !empty(serverVersion) && !empty(zipUrl) && zipUrl.matches("^(https?)://(.*).zip");
        } catch (Exception e) {
            valid = false;
        }
    }

    private String readUrl(String urlString) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()))) {
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        }
    }

    public String version() {
        return serverVersion;
    }

    public String zipUrl() {
        return zipUrl;
    }

    public boolean validate() {
        return valid;
    }

    public boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
}

