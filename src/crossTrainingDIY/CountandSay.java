package crossTrainingDIY;

public class CountandSay {
    // Given a sequence of number: 1, 11, 21, 1211, 111221, …
    //
    //The rule of generating the number in the sequence is as follow:
    //
    //1 is "one 1" so 11.
    //
    //11 is "two 1s" so 21.
    //
    //21 is "one 2 followed by one 1" so 1211.
    //
    //Find the nth number in this sequence.

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        String s = "21";
        while(n > 3){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i < s.length()){
                if(i == s.length() - 1){
                    if(s.charAt(i) != s.charAt(i - 1)){
                        sb.append('1');
                        sb.append(s.charAt(i));
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(i + 1)){
                        int count = 1;
                        char tmp = s.charAt(i);
                        while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                            i++;
                            count++;
                        }
                        sb.append((char)(count + '0'));
                        sb.append(tmp);
                    }
                    else{
                        sb.append('1');
                        sb.append(s.charAt(i));

                    }
                }
                i++;
            }
            s = sb.toString();
            n--;
        }
        return s;
    }
}
