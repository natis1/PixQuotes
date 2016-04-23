public class Main {

    public static void main(String[] args) {
	// write your code here

        if (args.length != 4 && args.length != 3){
            System.out.println("Improper syntax, please try again using the following command:");
            System.out.println("java -jar pixQuotes.jar (chains to generate) (chain length) (words or letters) (optional input file)");
            System.out.println("For example: \"java -jar pixQuotes.jar 200 5 letters\"");
            System.exit(0);
        } else {
            int chainsGenerated = Integer.parseInt(args[0]);
            int chainLength = Integer.parseInt(args[1]);
            if (args[2].toLowerCase().contains("words")){
                if (args.length == 4){
                    new Lulu(chainLength, true, args[3], chainsGenerated);
                } else {
                    new Lulu(chainLength, true, chainsGenerated);
                }
            } else if (args[2].toLowerCase().contains("letters")){
                if (args.length == 4){
                    new Lulu(chainLength, false, args[3], chainsGenerated);
                } else {
                    new Lulu(chainLength, false, chainsGenerated);
                }
            } else {
                System.out.println("Improper syntax, please try again using the following command:");
                System.out.println("java -jar pixQuotes.jar (chains to generate) (chain length) (\"words\" or \"letters\") (optional input file)");
                System.out.println("For example: \"java -jar pixQuotes.jar 200 4 letters\"");
                System.exit(0);
            }
        }


    }
}
