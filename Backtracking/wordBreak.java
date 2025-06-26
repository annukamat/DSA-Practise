import java.util.HashSet;

public class wordBreak {
    public static void wordBreak(String str, String ans, HashSet<String> dict) {
        int len = 0;
        for (String s : dict)
            len = Math.max(len, s.length());
        wordBreak(str, 0, ans, len, dict);
    }
    public static int wordBreak(String str, int idx, String ans, int len, HashSet<String> dict) {
        if (idx >= str.length()) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i <= str.length(); i++) {
            String word = str.substring(idx, i);
            if (word.length() > len)
                break;
            if (dict.contains(word)) {
                count += wordBreak(str, i, ans + word + " ", len, dict);
            }
        }
        return count;
    }

    public static void wordBreak_simple(String str, String ans, HashSet<String> dict){
        if(str == ""){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++){
            String left = str.substring(0, i);
            if(dict.contains(left)){
                String ros = str.substring(i+1);
                wordBreak_simple(ros, ans+left, dict);
            }
        }
    }

    public static void main(String[] args) {
        String str = "microsofthiring";
        wordBreak(str, null, null);
    }
}
