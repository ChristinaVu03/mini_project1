public class CaesarCipher {
public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Incorrect number of parameters"); //print error if not enough parameters entered
            System.exit(2);
        } 

 

        String operation = args[0]; 
        String input = args[1]; 

 

        if (!operation.equals("encode") && !operation.equals("decode")) {
            System.err.println("Valid options are \"encode\" or \"decode\"");
            System.exit(1);
        }

 

        if (!isValid(input)) {
            System.err.println("Input must consist only of lowercase characters");
            System.exit(1);
        }

 

        if (operation.equals("encode")) {
            encode(input);
        } else {
            decode(input);
        }
    }

 
/*Precondition: String input
 * Postcondition: function determines if it is true or false
 */
    public static boolean isValid(String input) {
        return input.matches("^[a-z]+$");
    }

/*Precondition: String input
 * Postcondition: function prints the encryption code for the input
 */

    public static void encode(String input) {
        for (int n = 0; n < 26; n++) {
            System.out.print("n = " + n + ": ");
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                int base = (int) 'a';
                int result = (ch - base + n) % 26;
                if (result < 0) {
                    result += 26;
                }
                System.out.print((char) (result + base));
            }
            System.out.println();
        }
    }

 /*Precondition: String input
  * Postcondition: returns the decodes for the input
  */

    public static void decode(String input) {
        for (int n = 0; n < 26; n++) {
            System.out.print("n = " + n + ": ");
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i); 
                int base = (int) 'a';
                int result = (ch - base - n) % 26;
                if (result < 0) {
                    result += 26;
                }
                System.out.print((char) (result + base));
            }
            System.out.println();
        }
    }
}