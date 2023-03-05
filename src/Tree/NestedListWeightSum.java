package Tree;

public class NestedListWeightSum {
    // Given a nested list of integers represented by a string without blank, parse the string and
    // return the sum of all integers in the list weighted by their depth.
    //
    //Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    // Given the list "[[1,1],2,[1,1]]", return 10. (four 1's at depth 2, one 2 at depth 1)

    public int depthSum(String nestlists) {
        if(nestlists == null || nestlists.length() == 0){
            return 0;
        }

        int count = 1;
        int sum = 0;
        int i = 1;
        while(i < nestlists.length()){
            if(nestlists.charAt(i) == '['){
                count++;
                i++;
            }
            else if(nestlists.charAt(i) == ']'){
                count--;
                i++;
            }
            else if(nestlists.charAt(i) == '-'){
                i++;
                int tmp = 0;
                while(i < nestlists.length() && Character.isDigit(nestlists.charAt(i))){
                    tmp = tmp * 10 + (nestlists.charAt(i) - '0');
                    i++;
                }

                sum += tmp * count * -1;
            }
            else if(Character.isDigit(nestlists.charAt(i))){
                int tmp = 0;
                while(i < nestlists.length() && Character.isDigit(nestlists.charAt(i))){
                    tmp = tmp * 10 + (nestlists.charAt(i) - '0');
                    i++;
                }

                sum += tmp * count;
            }
            else{
                i++;
            }

        }

        return sum;
    }
}
