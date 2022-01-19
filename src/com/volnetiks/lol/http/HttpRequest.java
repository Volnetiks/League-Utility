package com.volnetiks.lol.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Created by Volnetiks
 * Date: 19/01/2022
 * Time: 7:38 PM
 */
public class HttpRequest {

     public static String sendRequest(String address, String body, String method, boolean input, boolean output) throws IOException {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(address).openConnection();
            connection.setRequestMethod(method);
            connection.setDoInput(input);
            connection.setDoOutput(output);
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (X11; Linux x86_64; rv:77.0) Gecko/20100101 Firefox/77.0");
            PrintWriter pw = null;
            if(output && method.equalsIgnoreCase("POST")) {
                pw = new PrintWriter(connection.getOutputStream());
                pw.write(body);
                pw.flush();
            }

            StringBuilder result = null;

            if(input) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
                result = new StringBuilder();
                String f = br.readLine();
                while(f != null) {
                    result.append(f).append("\n");
                    f = br.readLine();
                }

                br.close();
            }
            if(pw != null)
                pw.close();
            connection.disconnect();
            return (result != null) ? result.toString() : "";

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

}
