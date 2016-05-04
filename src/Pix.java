import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kogmaw on 4/20/16.
 */
public class Pix {
    private String[] parsedStrings;
    private int chainLength = 3;
    private boolean usingWords = false;
    private int chainsGenerated = 200;

    public Pix(String unparsedString, boolean usingWords, int chainLength, int chainsGenerated){
        this.usingWords = usingWords;
        this.chainLength = chainLength;
        this.chainsGenerated = chainsGenerated;
        if (this.chainLength < 1){
            this.chainLength = 1;
        }

        System.out.println();//Return
        unparsedString = parseString(unparsedString);
        if (usingWords){
            parsedStrings = parseWords(unparsedString);
            generateWordChain();
        } else {
            parsedStrings = parseChars(unparsedString);
            generateLetterChain();
        }



        System.out.println();//End it with a return
        System.out.println();//Or 2

    }


    private String parseString(String unparsedString){

        if (!unparsedString.endsWith(".")){
            unparsedString += ".";//End it with a period
        }
        while (unparsedString.contains("\n")){
            unparsedString = unparsedString.replace("\n", " ");//Replace returns with space
        }
        while (unparsedString.contains("  ")){
            unparsedString = unparsedString.replace("  ", " "); //2 becomes 1
        }
        return unparsedString;
    }

    private String[] parseWords(String unparsedString){
        return unparsedString.split(" ");
    }


    private String[] parseChars(String unparsedString){
        String s = "";
        for (int i = 0; i < chainLength; i++){
            s += ".";
        }

        return unparsedString.split("(?<=\\G" + s + ")");
    }

    private void generateWordChain(){
        Random stringPicker = new Random(System.nanoTime());
        int stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble()) - chainLength;
        for (int i = 0; i < chainsGenerated; i++){

            String stringPickedByStringPicker = "";

            for  (int currentLength = 0; currentLength < chainLength; currentLength++) {
                stringPickedByStringPicker += parsedStrings[stringPicked + currentLength];
                if (usingWords){
                    stringPickedByStringPicker += " ";
                }
            }


            String lastWord = parsedStrings[stringPicked + chainLength - 1];


            System.out.print(stringPickedByStringPicker);
            if (stringPickedByStringPicker.endsWith(". ")){
                System.out.println();//for readability, feel free to turn off if you hate readability.
                System.out.println();
            }

            ArrayList<Integer> pickableStrings = new ArrayList<>();
            for (int j = 0; j < parsedStrings.length - chainLength - 2; j++){


                if (parsedStrings[j].replace(".", "") == lastWord.replace(".", "")){
                    pickableStrings.add(j + 1);
                }


            }
            if (pickableStrings.isEmpty() || stringPicked + chainLength == parsedStrings.length){
                stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble() - chainLength - 1);
                if (stringPicked < 0){
                    stringPicked = 4;//that's a good number
                }
            } else {
                stringPicked = pickableStrings.get((int) Math.floor(pickableStrings.size() * stringPicker.nextDouble()));
            }
        }

    }

    private void generateLetterChain(){
        Random stringPicker = new Random(System.nanoTime());
        int stringPicked;

        do {
            stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble()) - 1;
            if (stringPicked < 1){
                break;
            }

        } while (!parsedStrings[stringPicked - 1].endsWith(" "));



        for (int i = 0; i < chainsGenerated; i++){

            String stringPickedByStringPicker = parsedStrings[stringPicked];
            System.out.print(stringPickedByStringPicker);
            if (stringPickedByStringPicker.endsWith(".")){
                System.out.println();//for readability, feel free to turn off if you hate readability.
            } else if (stringPickedByStringPicker.endsWith(". ")){
                System.out.println();
            }

            ArrayList<Integer> pickableStrings = new ArrayList<>();
            for (int j = 0; j < parsedStrings.length - 1; j++){
                if (parsedStrings[j].contains(stringPickedByStringPicker)){
                    pickableStrings.add(j + 1);
                }
            }
            if (pickableStrings.isEmpty() || stringPicked + chainLength == parsedStrings.length){
                stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble() - chainLength - 1);
                if (stringPicked < 0){
                    stringPicked = 4;//that's a good number
                }
            } else {
                stringPicked = pickableStrings.get((int) Math.floor(pickableStrings.size() * stringPicker.nextDouble()));
            }
        }
    }

}



