
package com.trayis.test;

import static org.junit.Assert.assertEquals;

import com.trayis.geocache.Location;
import com.trayis.geocache.GeoChache;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SpatialTest {

    static List<Location> mPointList = null;

    private void LoadPointsFromFile(String source) {
        String[] item;
        String[] lines = readAllTextFileLines(source);
        for (String line : lines) {
            item = line.split(",");
            mPointList.add(new Location(Double.parseDouble(item[2]), Double.parseDouble(item[1]), Double.parseDouble(item[0])));
        }
    }

    private static String[] readAllTextFileLines(String fileName) {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));

            String textLine;
            while ((textLine = br.readLine()) != null) {
                sb.append(textLine);
                sb.append('\n');
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (sb.length() == 0) {
                sb.append("\n");
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // Do nothing
                }
            }
        }
        return sb.toString().split("\n");
    }

    @Test
    public void testTree() {
        mPointList = new ArrayList<Location>();
        URL classpathResource = Thread.currentThread().getContextClassLoader().getResource("");
        String resourcePath = classpathResource.getPath() + "points.txt";
        LoadPointsFromFile(resourcePath);
        assertEquals("Expecting 844 points", 844, mPointList.size());

        // http://spatialreference.org/ref/epsg/4326/
        GeoChache qt = new GeoChache(-180.000000, -90.000000, 180.000000, 90.000000);
        for (Location pt : mPointList) {
            qt.set(pt.getX(), pt.getY(), pt.getData());
        }
        Location[] points = qt.searchIntersect(-84.375, 27.059, -78.75, 31.952);
        // System.out.print( Arrays.asList(points).toString());
        assertEquals(60, points.length);

    }

}
