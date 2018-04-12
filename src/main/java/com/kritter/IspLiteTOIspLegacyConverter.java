package com.kritter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class IspLiteTOIspLegacyConverter
{
    public static void convert() throws IOException {
        File outputFile = new File("/home/sam/Desktop/netcore_data/GeoIPASNum2Modified.csv");
        String file = FileUtils.readFileToString(new File("/home/sam/Desktop/netcore_data/GeoIPASNum2.csv"));
        String[] lines = file.split("\n");
        String outputString = "";
        int lineCount = 0;
        for(String line : lines){
            String col1 = line.substring(0,line.indexOf(","));

            line = line.substring(line.indexOf(",")+1);
            String col2 = line.substring(0,line.indexOf(","));

            if(line.contains(" ")) {
                line = line.substring(line.indexOf(",") + 1);
                String col3 = line.substring(line.indexOf(" ")+1);
                String modified = col1 + "," + col2 + "," + "\"" + col3 + "\n";
                outputString += modified;
            }
        }

        FileUtils.writeStringToFile(outputFile,outputString,"UTF-8");
    }
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        IspLiteTOIspLegacyConverter.convert();
    }
}
