/**
 * User: gardiary
 * Date: 01/10/15, 21:19
 */
public class Anagram {

    private String parent;
    private String query;

    public Anagram(String parent, String query) {
        this.parent = parent;
        this.query = query;
    }

    public static void main(String args[]) {

        if(args == null || args.length < 2) {
            System.out.println("Please input two parameters");
            System.exit(0);
        }

        String parent = args[0];
        String query = args[1];

        if(parent.length() < query.length()) {
            System.out.println("First parameter length must equals or more than second parameter length");
            System.exit(0);
        }

        Anagram anagram = new Anagram(parent, query);

        System.out.println("Parent : " + parent);
        System.out.println("Query : " + query);
        System.out.println("Anagram count : " + anagram.count());

    }

    public int count() {
        int count = 0;
        int queryLength = query.length();

        for(int i = 0; i < parent.length(); i++) {
            int endIndex = i + queryLength;

            if(endIndex <= parent.length()) {
                String part = parent.substring(i, endIndex);

                boolean result = isAnagram(part);

                if(result) {
                    System.out.println("- " + part + " is anagram of " + query);
                    count++;
                }

            }
        }

        return count;
    }

    public boolean isAnagram(String part) {
        boolean result = false;

        for(int i = 0; i < query.length(); i++) {
            Character char1 = query.charAt(i);

            for(int j = 0; j < part.length(); j++) {
                Character char2 = part.charAt(j);

                if(char2.equals(char1)) {
                    StringBuffer sb = new StringBuffer(part);
                    sb.deleteCharAt(j);

                    part = sb.toString();
                    break;
                }
            }
        }

        if(part == null || part.equals("")) {
            result = true;
        }

        return result;
    }
}
