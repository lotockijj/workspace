package MindCastr.persistent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import MindCastr.constants.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public interface Transport {

    public Result signUp(Map<String, String> call);

    public Result signIn(String email);


    public class Mock implements Transport {

        @Override
        public Result signUp(Map call) {
            return new Result(true);
        }

        @Override
        public Result signIn(String email) {
            return new Result(true);
        }

    }

    public class Http implements Transport {

        @Override
        public Result signUp(Map<String, String> call) {
            HttpPost httpPost = new HttpPost(Constants.
                    SERVER_URL + "user/signup?mailaddr=" + call.get("email"));
            List<NameValuePair> nvp = new ArrayList<>();
            for (Map.Entry<String, String> entry : call.entrySet()) {
                nvp.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            String jsonString;
            try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                httpPost.setEntity(new UrlEncodedFormEntity(nvp));
                CloseableHttpResponse response = httpclient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                jsonString = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                return new Result(false, "Can't establish connect to server.");
            }
            if (jsonString.length() > 0) {
                JsonParser parser = new JsonParser();
                JsonObject mainObject = parser.parse(jsonString).getAsJsonObject();
                if (mainObject.has("error")) {
                    return new Result(false,  mainObject.get("error").getAsString());
                }
                System.out.println(jsonString);
                return new Result(mainObject.has("success"), "Trying to " +
                        "register new user.");
            }
            return new Result(false, "Received an empty response from the " +
                    "server.");
        }

        @Override
        public Result signIn(String email) {
            String jsonString;
            HttpGet httpGet = new HttpGet(Constants.
                    SERVER_URL + "user/signin?mailaddr=" + email);
            try (CloseableHttpClient httpclient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpclient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                jsonString = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            } catch (IOException e) {
                return new Result(false, "Can't establish connect to server.");
            }
            if (jsonString.length() > 0) {
                JsonParser parser = new JsonParser();
                JsonObject mainObject = parser.parse(jsonString).getAsJsonObject();
                String status = "registered";
                if (mainObject.has(status)) {
                    return new Result(
                            mainObject.get(status).getAsBoolean(),
                            status,
                            mainObject.get("paid").getAsBoolean()
                                    );
                } else {
                    return new Result(false, mainObject.get("error")
                            .getAsString());

                }
            }
            return new Result(false, "Received an empty response from the " +
                    "server.");
        }
    }

    public class Result {
        private boolean status;
        private String details;
        private boolean paid;

        public Result(boolean status) {
            this(status, "", false);
        }

        public Result(boolean status, boolean paid) {
            this(status, "", paid);
        }

        public Result(boolean status, String details) {
            this(status, details, false);
        }

        public Result(boolean status, String details, boolean paid) {
            this.status = status;
            this.details = details;
            this.paid = paid;
        }

        public boolean status() {
            return this.status;
        }

        public String details() {
            return this.details;
        }

        public boolean paid() {
            return this.paid;
        }
    }
}
