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
            //started the application
            System.out.println("Press X to launch application -->");
            String userLaunch = theScanner.nextLine();
            //create file writer
            FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt");
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            //giving title to log
            buffWriter.write("User Action Log\n");
            //seeing if user started app
            if(userLaunch.equalsIgnoreCase("x")){
                //getting time
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy  HH:mm:ss");
                String formattedLog = now.format(fmt);
                //logging the launch
                buffWriter.write( formattedLog + " Launched \n");

                //looping while app is launched
                for(int i = 0; userLaunch != null; i++){
                    System.out.println("What are you looking for?(Press X to exit):");
                    String userSearch = theScanner.nextLine();
                    LocalDateTime searchTime = LocalDateTime.now();
                    String formattedSearch = searchTime.format(fmt);
                    //storing search in log
                    buffWriter.write(formattedSearch + " " + userSearch + "\n");
                    //initializing the exit
                    if(userSearch.equalsIgnoreCase("x")){
                        System.out.println("Bye!");
                        buffWriter.write(formattedSearch + " exit");
                        break;
                    }
                    }

                // giving output if the app isnt actually launched
                }else {
                System.out.println("Good bye!");
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy  HH:mm:ss");
                String formattedLog = now.format(fmt);
                buffWriter.write( formattedLog + " Exit");

            }

            buffWriter.close();
        }catch(Exception e){
            System.out.println("Actions not logged");
        }

    }
}
