import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kogmaw on 4/20/16.
 */
public class Pix {
    String[] parsedStrings;
    String outputString;
    int chainLength = 3;

    public Pix(String unparsedString){
        parsedStrings = parseString(unparsedString);
        generateChain();
        System.out.println(outputString);
    }


    private String[] parseString(String unparsedString){

        if (!unparsedString.endsWith(".")){
            unparsedString += ".";//End it with a period
        }
        while (unparsedString.contains("\n")){
            unparsedString.replace("\n", " ");//Replace returns with space
        }
        while (unparsedString.contains("  ")){
            unparsedString.replace("  ", " "); //2 becomes 1
        }

        return unparsedString.split(" ");
    }

    private void generateChain(){
        Random stringPicker = new Random(System.nanoTime());
        int stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble());
        int currentChainLength = 0;
        for (int i = 0; i < 5000; i++){
            String stringPickedByStringPicker = parsedStrings[stringPicked];
            outputString += stringPickedByStringPicker;
            currentChainLength++;
            if (currentChainLength >= chainLength || stringPicked + 1 == parsedStrings.length){
                //TODO custom randomness
                stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble());
                currentChainLength = 0;
            } else {
                ArrayList<Integer> pickableStrings = new ArrayList<>();
                for (int j = 0; j < parsedStrings.length - 1; j++){
                    if (parsedStrings[j].replace(".", "") == stringPickedByStringPicker.replace(".", "")){
                        pickableStrings.add(j + 1);
                    }
                }
                if (pickableStrings.isEmpty()){
                    stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble());
                    currentChainLength = 0;
                } else {
                    stringPicked = pickableStrings.get((int) Math.floor(pickableStrings.size() * stringPicker.nextDouble()));
                    currentChainLength++;
                }


            }


        }



    }


}
