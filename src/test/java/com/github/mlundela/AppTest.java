package com.github.mlundela;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.io.PrintWriter;

public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() throws IOException {
        String str = "[\n" +
                "\n" +
                " {\n" +
                "\n" +
                " _id: 377078,\n" +
                " key: null,\n" +
                " name: \"Potsdam\",\n" +
                " fullName: \"Potsdam, Germany\",\n" +
                " iata_airport_code: null,\n" +
                " type: \"location\",\n" +
                " country: \"Germany\",\n" +
                "\n" +
                " geo_position: {\n" +
                " latitude: 52.39886,\n" +
                " longitude: 13.06566\n" +
                " },\n" +
                " location_id: 377078,\n" +
                " inEurope: true,\n" +
                " countryCode: \"DE\",\n" +
                " coreCountry: true,\n" +
                " distance: null\n" +
                " },\n" +
                "\n" +
                " {\n" +
                " _id: 410978,\n" +
                " key: null,\n" +
                " name: \"Potsdam\",\n" +
                " fullName: \"Potsdam, USA\",\n" +
                " iata_airport_code: null,\n" +
                " type: \"location\",\n" +
                " country: \"USA\",\n" +
                "\n" +
                " geo_position: {\n" +
                " latitude: 44.66978,\n" +
                " longitude: -74.98131\n" +
                " },\n" +
                "\n" +
                " location_id: 410978,\n" +
                " inEurope: false,\n" +
                " countryCode: \"US\",\n" +
                " coreCountry: false,\n" +
                " distance: null\n" +
                " }\n" +
                " ]";

        LocationMapper parser = new LocationMapper();
        String csv = parser.toCSV(str);
        String exp = "377078,Potsdam,location,52.39886,13.06566\n" +
                "410978,Potsdam,location,44.66978,-74.98131";

        assertEquals(exp, csv.trim());

        PrintWriter out = new PrintWriter("query.csv");
        out.println(csv);
        out.close();
    }
}
