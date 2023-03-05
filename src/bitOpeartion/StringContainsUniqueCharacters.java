package bitOpeartion;

class StringContainsUniqueCharacters {
    public boolean containsUniqueMethod1(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        // Set<Character> set = new HashSet<>();
        boolean[] visited = new boolean[256];
        for(int i = 0; i < s.length(); i++){
            if(visited[s.charAt(i)]){
                return false;
            }
            visited[s.charAt(i)] = true;
        }

        return true;
    }
    public boolean Method2(String s){
        //assume that there are only 'a' -- 'z'
        if(s == null || s.length() == 0){
            return true;
        }
        int x = 0;
        for(int i = 0; i < s.length(); i++){
            int tmp = s.charAt(i) - 'a';
            if(((x >> tmp) & 1) == 1){
                return false;
            }
            else{
                x = (1 << tmp) | x;
            }
        }
        return true;
    }
    public boolean method3(String s){
        //assume that there are no more than 256 kinds of characters
        if(s == null || s.length() == 0){
            return true;
        }

        int[] visited = new int[8];
        for(int i = 0; i < s.length(); i++){
            int row = (int) s.charAt(i) / 32;
            int col = (int) s.charAt(i) % 32;
            int tmp = visited[row];

            if(((tmp >> col) & 1) == 1){
                return false;
            }
            else{
                tmp |= (1 << col);
            }
        }
        return true;
    }
}
