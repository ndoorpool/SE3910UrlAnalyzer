package com.example.demo.service;
import com.example.demo.domain.Url;
import org.springframework.stereotype.Service;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

@Service
public class UrlAnalysisService {

    public Map<String, Object> analyzeUrl(String url){

        try{

            if(!isValidUrl(url)){
                return Map.of("error", "Invalid URL format");

            }
            //retrieve the response code for the URL
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            //retrieve the response headers
            Map<String, List<String>> headers = connection.getHeaderFields();

            //ssl info
            String protocol = connection.getURL().getProtocol();
            String cipher = connection.getURL().getHost();

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
        return url != null && url.matches("^(ftp|http|https):\\/\\/[^\\s/$.?#].[^\\s]*$");
    }
}
