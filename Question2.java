public class Question2 {

    public String decimalColorToHexValues(int r, int g, int b) {
        return new StringBuffer("#")
                .append(decimalToHex(r))
                .append(decimalToHex(g))
                .append(decimalToHex(b)).toString();
    }

    public String decimalToHex(int dec) {
        int rem = dec % 16;
        String result;

        if (dec - rem == 0)
            result = toChar(rem);
        else
            result = decimalToHex((dec - rem) / 16) + toChar(rem);
        return result;
    }

    private String toChar(int pos) {
        final String chars = "0123456789ABCDEF";
        return String.valueOf(chars.charAt(pos));
    }

    public static void main(String args[]) {
        Question2 app = new Question2();
        System.out.println("Hex Color : " + app.decimalColorToHexValues(68, 58, 197));
    }

}
