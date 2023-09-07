public class VigenereCipher {
public static void main(String[] args) {

        if (args.length != 3) {

            System.err.println("Incorrect number of parameters");

            System.exit(2);

        }

 

        String operation = args[0];

        String input = args[1];

        String keyword = args[2];

 

        if (!operation.equals("encode") && !operation.equals("decode")) {

            System.err.println("Valid options are \"encode\" or \"decode\"");

            System.exit(1);

        }

 

        if (!isValid(input) || !isValid(keyword)) {

            System.err.println("Input and keyword must consist only of lowercase characters");

            System.exit(1);

        }

 

        if (operation.equals("encode")) {

            String ciphertext = encode(input, keyword);

            System.out.println(ciphertext);

        } else {

            String plaintext = decode(input, keyword);

            System.out.println(plaintext);

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

    public static String encode(String input, String keyword) {

        StringBuilder ciphertext = new StringBuilder();

        int inputLength = input.length();

        int keywordLength = keyword.length();

 

        for (int i = 0; i < inputLength; i++) {

            char ch = input.charAt(i);

            char keyChar = keyword.charAt(i % keywordLength);

            int base = (int) 'a';

            int result = (ch - base + keyChar - base) % 26;

            if (result < 0) {

                result += 26;

            }

            ciphertext.append((char) (result + base));

        }

 

        return ciphertext.toString();

    }
 /*Precondition: String input
  * Postcondition: returns the decodes for the input
  */
 

    public static String decode(String input, String keyword) {

        StringBuilder plaintext = new StringBuilder();

        int inputLength = input.length();

        int keywordLength = keyword.length();

 

        for (int i = 0; i < inputLength; i++) {

            char ch = input.charAt(i);

            char keyChar = keyword.charAt(i % keywordLength);

            int base = (int) 'a';

            int result = (ch - base - keyChar + base) % 26;

            if (result < 0) {

                result += 26;

            }

            plaintext.append((char) (result + base));

        }

 

        return plaintext.toString();

    }

}
