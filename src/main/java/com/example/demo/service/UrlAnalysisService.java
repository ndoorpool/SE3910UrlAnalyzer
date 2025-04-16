package com.example.demo.service;
import com.example.demo.domain.Url;
import com.example.demo.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UrlAnalysisService {

    private final UrlRepository urlRepository;

    public Map<String, Object> analyzeUrlById(Long url_id) {
        Optional<Url> url = urlRepository.findById(url_id);

        return analyzeUrl(url.get().getUrl());
    }

    public Map<String, Object> analyzeUrl(String url){

        try{
            if(!isValidUrl(url)){
                return Map.of("error", "Invalid URL format");
            }

            //response code
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            //retrieve the response headers
            Map<String, List<String>> headers = connection.getHeaderFields();

            //cipher info
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            String cipher = null;
            cipher = httpsURLConnection.getCipherSuite();

            //ssl info
            String protocol = connection.getURL().getProtocol();

            return Map.of(
                    "responseCode", responseCode,
                    "responseHeader", headers,
                    "protocol", protocol,
                    "cipher", cipher
            );

        }
        catch (Exception e) {
            return Map.of("error", "Error analyzing the URL: " + e.getMessage());
        }
    }

    //making sure the URL inputted in the front end is valid
    private boolean isValidUrl(String url) {
        return url != null && url.matches("^(ftp|http|https):\\/\\/[^\\s/$.?#].\\S*$");
    }
}
