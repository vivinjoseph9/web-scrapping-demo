
/**
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * TODO Please enter the description of this type. This is mandatory!
 *
 * @author vjoseph, (c) Copyright 2019 Rockwell Automation Technologies, Inc. All Rights Reserved.
 */
public class source {
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + " a4cb90e4-e42a-45f7-978f-35f4b292c265");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getHTML("https://api.sandbox.transferwise.tech/v1/rates?source=EUR&target=INR"));
    }
}
