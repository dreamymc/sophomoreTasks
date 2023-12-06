public class logronioCipher extends myAbstract {
    public String caesarCipher(String text, int shift) { // Necessary correct caesar cipher that will be used on the
                                                         // inner part of the encryption
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public String reverse(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--)
            res += s.charAt(i);
        return res;
    }

    public String encrypted(String s, int number) {
        int n = (s.length() * number) + s.length();
        String result = caesarCipher(s, n);
        System.out.println("Key is " + number);
        return reverse(result);
    }
}
