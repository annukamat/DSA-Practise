public class printPermutation {

    // abc: abc, acb, bac, bca, cab, cba
    public static void printPermutations_(String ques, String asf){
        // BC
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<ques.length(); i++){
            char ch = ques.charAt(i);
            String left = ques.substring(0, i);
            String rt = ques.substring(i+1);
            String roq = left + rt;     // roq: rest of the ques

            printPermutations_(roq, asf+ch);
        }
    }

    public static void main(String[] args) {
        
    }
    
}
