package stackhunter;

/**
 * User: gardiary
 * Date: 11/21/15, 12:22 PM
 */
public class Keyword {
    private String str;

    public Keyword(String str) {
        this.str = str;
    }

    public boolean matches(String text) {
        if(this.str == null || text == null || this.str.trim().equals("") || text.trim().equals("")) {
            return false;
        }

        String smallText = text.toLowerCase();

        String arrStr[] = str.toLowerCase().split(" ");

        boolean result = true;
        for(int i = 0; i < arrStr.length; i++) {
            String word = arrStr[i];

            if(!smallText.toLowerCase().contains(word.toLowerCase())) {
                result = false;
            }

        }

        return result;
    }
}
