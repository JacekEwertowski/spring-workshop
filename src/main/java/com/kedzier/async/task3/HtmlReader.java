package com.kedzier.async.task3;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author kedzierm
 */
@Component
public class HtmlReader {

    public String readHtml(URL url) throws IOException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Http response: " + conn.getResponseCode());
        }

        String readContent = readContent(conn);
        conn.disconnect();

        return readContent;
    }

    private String readContent(HttpURLConnection conn) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())))) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line).append('\n');
            }

            return result.toString();
        }
    }


}
