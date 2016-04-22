import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kogmaw on 4/20/16.
 */
public class Pix {
    private String[] parsedStrings;
    private int chainLength = 3;
    private boolean usingWords = false;

    public Pix(String unparsedString){
        if (chainLength < 1){
            chainLength = 1;
        }
        unparsedString = parseString(unparsedString);
        if (usingWords){
            parsedStrings = parseWords(unparsedString);
        } else {
            parsedStrings = parseChars(unparsedString);
        }

        generateChain();
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

    private void generateChain(){
        Random stringPicker = new Random(System.nanoTime());
        int stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble()) - chainLength;
        for (int i = 0; i < 200; i++){

            String stringPickedByStringPicker = "";

            for  (int currentLength = 0; currentLength < chainLength; currentLength++) {
                stringPickedByStringPicker += parsedStrings[stringPicked + currentLength] + " ";
            }
            String lastWord = parsedStrings[stringPicked + chainLength - 1];

            System.out.print(stringPickedByStringPicker);
            if (i % 10 == 9){
                System.out.println();//return
            }

                ArrayList<Integer> pickableStrings = new ArrayList<>();
                for (int j = 0; j < parsedStrings.length - chainLength - 2; j++){

                    if (usingWords){
                        if (parsedStrings[j].replace(".", "") == lastWord.replace(".", "")){
                            pickableStrings.add(j + 1);
                        }
                    } else {
                        if (parsedStrings[j] == lastWord){
                            pickableStrings.add(j + 1);
                        }
                    }

                }
                if (pickableStrings.isEmpty() || stringPicked + chainLength == parsedStrings.length){
                    stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble() - chainLength - 1);
                } else {
                    stringPicked = pickableStrings.get((int) Math.floor(pickableStrings.size() * stringPicker.nextDouble()));
                }
            }


        }



    }



