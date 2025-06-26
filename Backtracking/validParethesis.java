// remove Invalid Parenthesis: https://youtu.be/Cbbf5qe5stw?si=RcfEPPRUHfgMqVfr : Leetcode 301
// Input: A string containing only opening and closing parenthesis
// output: Print all the valid parenthesis
import java.util.*;
public class validParethesis {

    // mra: minimum no of removal
    public static void validParethesis(String str, int mra, HashSet<String> ans){
        // BC
        if(mra == 0){
            // check if the string created is valid?
            int mr_now = getMin(str); 
            if(mr_now == 0 && !ans.contains(str)){      //ans.contains(str): check if str is not already added
                ans.add(str);
            }
            return;
        }

        for(int i=0; i<str.length(); i++){
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            validParethesis(str, mra-1, ans);
        }

    }

    // return min no of invalid arenthesis should be removed
    public static int getMin(String str){
        Stack<Character> st = new Stack<>();

        for(char ch: str.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                if(st.size() == 0){
                    st.push(ch);
                }else if(st.peek() == ')'){
                    st.push(ch);
                }else if(ch == '('){
                    st.pop();
                }
            }
        }

        return st.size();
    }
    
}
