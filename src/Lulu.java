/**
 * Created by kogmaw on 4/20/16.
 */
public class Lulu {
    String userString;

    public Lulu(){
        userString = "The Awakening of kings was an event marked by the ultimate battle of the century. It lead to the" +
                "\nultimate battle between good and evil. If there were ever an event which needed more popularity, it would" +
                "\n      be this one. This string is to simulate different kinds of grammar and also the parsing that would be" +
                "\nrequired to get this thing working. slash n should become space and multiple      spaces in a row should be removed" +
                "\n Using Regex makes this whole thing possible if I do it right. I hope   ";



        setUserText(50);

        if (userString.length() < 30){
            System.out.println("Please add some more text");
            System.exit(2);
        }

        new Pix(userString);
    }

    public Lulu(String input){


        new Pix(input);
    }


    private void setUserText(int typeToSet){

        if (typeToSet == 0){


        }


    }



}
