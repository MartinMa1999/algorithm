package DisjointSet;

public class LexicographicallySmallestEquivalentString {
    // You are given two strings of the same length s1 and s2 and a string baseStr.
    //
    //We say s1[i] and s2[i] are equivalent characters.
    //
    //For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
    //Equivalent characters follow the usual rules of any equivalence relation:
    //
    //Reflexivity: 'a' == 'a'.
    //Symmetry: 'a' == 'b' implies 'b' == 'a'.
    //Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
    //For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
    //
    //Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        if(s1 == null ||s2 == null || baseStr == null || baseStr.length() == 0){
            return null;
        }
        if (s1.length() != s2. length()){
            return null;
        }

        DisjointSet disjointSet = new DisjointSet();
        for(int i = 0; i < s1.length(); i++){
            disjointSet.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char tmp = baseStr.charAt(i);
            int num = disjointSet.findParent(tmp - 'a');
            sb.append((char)(num + 'a'));
        }

        return sb.toString();


    }
}
