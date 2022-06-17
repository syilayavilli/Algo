package Challenge.Strings;

public class Test {

    public static void main(String[] args) {
        System.out.println(encode(23456789, "https://www.edureka.co/blog/character-array-in-java/"));
    }

    public static String encode(long num, String url) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] BASE = str.toCharArray();
        int base_len = BASE.length;
        String encodesurl = "";
        while(num>0) {
             //keep on dividing
            long digit = (num / base_len);
            //encodesurl = encodesurl + BASE.charAt(digit);
            num = base_len;
        }
        return encodesurl;

    }
}
