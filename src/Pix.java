import java.util.Random;

/**
 * Created by kogmaw on 4/20/16.
 */
public class Pix {
    String[] parsedStrings;
    String outputString;
    public Pix(String unparsedString){
        parsedStrings = parseString(unparsedString);
        generateChain();

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

        for (int i = 0; i < 5000; i++){
            outputString += parsedStrings[stringPicked];

            if (stringPicker.nextDouble() > 0.8){
                //TODO custom randomness
                stringPicked = (int) Math.floor(parsedStrings.length * stringPicker.nextDouble());


            }


        }



    }


}
