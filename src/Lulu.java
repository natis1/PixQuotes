import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Lulu created herself on 4/20/16.
 */
public class Lulu {
    String userString;
    private static boolean IDE_MODE = false;

    public Lulu(int chainLength, boolean textMode, int chainsGenerated){
        userString = "The Awakening of kings was an event marked by the ultimate battle of the century. It lead to the" +
                "\nultimate battle between good and evil. If there were ever an event which needed more popularity, it would" +
                "\n      be this one. This string is to simulate different kinds of grammar and also the parsing that would be" +
                "\nrequired to get this thing working. slash n should become space and multiple      spaces in a row should be removed" +
                "\n Using Regex makes this whole thing possible if I do it right. I hope   ";

        int userTextMode = 0;

        if (!IDE_MODE){
            userString = "";

            System.out.println("Enter the input text to use. End the text with \"%end%\"");
            Scanner inputScanner = new Scanner(System.in);
            while(inputScanner.hasNextLine()) {
                userString += inputScanner.nextLine();
                if (userString.endsWith("%end%")){
                    userString = userString.replace("%end%", "");
                    break;
                }
            }

        } else {
            setUserText(userTextMode);
        }




        if (userString.length() < 30){
            System.out.println("Please add some more text");
            System.exit(2);
        }

        new Pix(userString, textMode, chainLength, chainsGenerated);
    }

    public Lulu(int chainLength, boolean textMode, String inputFile, int chainsGenerated){


        byte[] fileByteData = new byte[0];
        try {
            fileByteData = Files.readAllBytes(Paths.get(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        userString = new String(fileByteData, StandardCharsets.UTF_8);


        new Pix(userString, textMode, chainLength, chainsGenerated);
    }

    public Lulu(){

        Console systemInput = System.console();

        System.out.println("Give me your facts");
        System.out.println("How many chains do you want, anyway?");
        int chainsGenerated = Integer.parseInt(systemInput.readLine());

        System.out.println("How long are we making these?");
        int chainLength = Integer.parseInt(systemInput.readLine());

        System.out.println("Do you like your chains wordy or lettery?");

        char firstChar = systemInput.readLine().charAt(0);
        boolean wordy = false;
        if (firstChar == 'w' || firstChar == 'W'){
            wordy = true;
            System.out.println("Wordy it is");
            System.out.println();
        } else if (firstChar == 'l' || firstChar == 'L'){
            wordy = false;
            System.out.println("Lettery it is");
            System.out.println();
        } else {
            System.out.println("Just get to the point. I will just assume you meant lettery because I like letters.");
        }


        System.out.println("Put some text here and end it with %end%");
        System.out.println();


        if (!IDE_MODE){
            userString = "";

            System.out.println("Enter the input text to use. End the text with \"%end%\"");
            Scanner inputScanner = new Scanner(System.in);
            while(inputScanner.hasNextLine()) {
                userString += inputScanner.nextLine();
                if (userString.endsWith("%end%")){
                    userString = userString.replace("%end%", "");
                    break;
                }
            }

        }


        if (userString.length() < 30){
            System.out.println("Please add some more text next time");
            System.exit(2);
        }

    }


    public Lulu(String inputFile){

        Console systemInput = System.console();

        System.out.println("Give me your facts");
        System.out.println("How many chains do you want, anyway?");
        int chainsGenerated = Integer.parseInt(systemInput.readLine());

        System.out.println("How long are we making these?");
        int chainLength = Integer.parseInt(systemInput.readLine());

        System.out.println("Do you like your chains wordy or lettery?");

        char firstChar = systemInput.readLine().charAt(0);
        boolean wordy = false;
        if (firstChar == 'w' || firstChar == 'W'){
            wordy = true;
            System.out.println("Wordy it is");
            System.out.println();
        } else if (firstChar == 'l' || firstChar == 'L'){
            wordy = false;
            System.out.println("Lettery it is");
            System.out.println();
        } else {
            System.out.println("Just get to the point. I will just assume you meant lettery because I like letters.");
        }

        System.out.println("Let'sa go");
        System.out.println();
        System.out.println();


        byte[] fileByteData = new byte[0];
        try {
            fileByteData = Files.readAllBytes(Paths.get(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        userString = new String(fileByteData, StandardCharsets.UTF_8);


        if (userString.length() < 30){
            System.out.println("Please add some more text to your file");
            System.exit(2);
        }

        new Pix(userString, wordy, chainLength, chainsGenerated);

    }


    private void setUserText(int typeToSet){

        if (typeToSet == 0){

            try {
                byte[] fileByteData = Files.readAllBytes(Paths.get("src/inputs/jungle.txt"));
                userString = new String(fileByteData, StandardCharsets.UTF_8);
            }
            catch(IOException ex) {
                System.out.println("Error reading file");
            }

        }


    }



}
