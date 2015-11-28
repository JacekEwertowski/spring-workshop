package com.kedzier.async.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(HtmlReader.class);

    public String readHtml(URL url) throws IOException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Http response: " + conn.getResponseCode());
        }

        return readContent(conn);
    }

    private String readContent(HttpURLConnection conn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) {
            result.append(line).append('\n');
        }
        conn.disconnect();
        return result.toString();
    }


}
