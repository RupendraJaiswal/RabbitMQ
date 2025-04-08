package com.springboot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpCaller {

    public static void main(String[] args) {
        try {
            for (int i = 1; i <= 5; i++) { // You can change the count here
                String url = "http://localhost:8081/api/send?message=HelloRabbit";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                System.out.println("Request #" + i + " | Response Code: " + responseCode);

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    System.out.println("Response: " + response);
                }
                i=1;

                Thread.sleep(1000); // wait 1 second between calls
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
