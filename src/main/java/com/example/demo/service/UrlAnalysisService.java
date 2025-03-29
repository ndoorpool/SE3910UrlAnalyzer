package com.example.demo.service;

import com.example.demo.domain.Url;
import com.example.demo.repository.LogRepository;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class UrlAnalysisService {

    public Map<String, Object> analyzeUrl(String url){

        try{

            if(!isValidUrl(url)){
                return Map.of("error", "Invalid URL format");

            }
            //retrieve the response code for the URL (FINISHED)
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            //retrieve the response headers (NOT FINISHED)
            Map<String, List<String>> headers = connection.getHeaderFields();

            //add response header and sslcertificates once fetched from above
            return Map.of(
                    "responseCode", responseCode
            );

        }
        catch (Exception e) {
            return Map.of("error", "Error analyzing the URL: " + e.getMessage());
        }
    }

    //making sure the URL inputted in the front end is valid
    private boolean isValidUrl(String url) {
        return url != null && url.matches("^(ftp|http|https):\\/\\/[^\\s/$.?#].[^\\s]*$");
    }
}