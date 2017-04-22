package tiralaba;

public class Converter {

    public String stringToBinary(String input) {
        String b = "";
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            temp = Integer.toBinaryString(input.charAt(i));
            for (int j = temp.length(); j < 8; j++) {
                temp = "0" + temp;
            }
            b += temp + " ";
        }

        return b;
    }

    public String binaryToString(String binary) {
        String[] text = binary.split(" ");
        String word = "";
        for (int i = 0; i < text.length; i++) {
            word += (char) Integer.parseInt(text[i], 2);
        }

        return word;
    }
}

