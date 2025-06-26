import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class InValidParenthese {

    public List<String> removeInvalidParentheses(String s) {
        int min = getMinRemoval(s);
        HashSet<String> ans = new HashSet<>();
        HashSet<String> vis = new HashSet<>();

        removeInvalidParenthesis_(s, min, ans, vis);

        return new ArrayList<>(ans);
    }

    public static void removeInvalidParenthesis_(String s, int min, HashSet<String> ans, HashSet<String> vis){
        if (vis.contains(s)) return;
        vis.add(s);
        
        if(min == 0){
            if(getMinRemoval(s) == 0){
                ans.add(s);
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            // Only remove '(' or ')'
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

            String ros = s.substring(0, i) + s.substring(i + 1);
            removeInvalidParenthesis_(ros, min - 1, ans, vis);
        }
    }

    public static int getMinRemoval(String s){
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c=='('){
                st.push(c);
            }else if(c==')'){
                if(st.size() != 0 && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
        
    }
    
}
