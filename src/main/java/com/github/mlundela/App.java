package com.github.mlundela;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Calling api...");
        URL url = new URL("http://api.goeuro.com/api/v2/position/suggest/en/" + args[0]);
        InputStream is = url.openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            PrintWriter out = new PrintWriter(args[0] + ".csv");
            String csv = new LocationMapper().toCSV(readAll(rd));
            out.println(csv);
            out.close();
            System.out.println("CSV output: \n" + csv);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
