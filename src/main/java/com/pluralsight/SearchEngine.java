package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngine {

    static Scanner theScanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("Press X to launch application -->");
            String userLaunch = theScanner.nextLine();

            FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt");
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);

            buffWriter.write("User Action Log\n");
            if(userLaunch.equalsIgnoreCase("x")){

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy  HH:mm:ss");
                String formattedLog = now.format(fmt);
                buffWriter.write( formattedLog + " Launched \n");


                for(int i = 0; userLaunch != null; i++){
                    System.out.println("What are you looking for?(Press X to exit):");
                    String userSearch = theScanner.nextLine();
                    LocalDateTime searchTime = LocalDateTime.now();
                    //DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy  HH:mm:ss");
                    String formattedSearch = searchTime.format(fmt);
                    buffWriter.write(formattedSearch + " " + userSearch + "\n");
                    if(userSearch.equalsIgnoreCase("x")){
                        System.out.println("Bye!");
                        buffWriter.write(formattedSearch + " exit");
                        break;
                    }
                }


            }

            buffWriter.close();
        }catch(Exception e){
            System.out.println("Actions not logged");
        }

    }
}
