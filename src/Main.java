public class Main {

    public static void main(String[] args) {
	// write your code here

        if (args.length != 3 && args.length != 2){
            System.out.println("Improper syntax, please try again using the following command:");
            System.out.println("java -jar pixQuotes.jar (chain length) (words or letters) (optional input file)");
            System.out.println("For example: \"java -jar pixQuotes.jar 5 letters\"");
            System.exit(0);
        } else {
            int chainLength = Integer.parseInt(args[0]);
            if (args[1].toLowerCase().contains("words")){
                if (args.length == 3){
                    new Lulu(chainLength, true, args[2]);
                } else {
                    new Lulu(chainLength, true);
                }
            } else if (args[1].toLowerCase().contains("letters")){
                if (args.length == 3){
                    new Lulu(chainLength, false, args[2]);
                } else {
                    new Lulu(chainLength, false);
                }
            } else {
                System.out.println("Improper syntax, please try again using the following command:");
                System.out.println("java -jar pixQuotes.jar (chain length) (\"words\" or \"letters\") (optional input file)");
                System.out.println("For example: \"java -jar pixQuotes.jar 4 letters\"");
                System.exit(0);
            }
        }


    }
}
