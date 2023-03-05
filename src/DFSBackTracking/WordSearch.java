package DFSBackTracking;

public class WordSearch {
    // Given a 2D board and a word, find if the word exists in the grid.The word can be constructed from letters of
    // sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
    // The same letter cell may not be used more than once.

    public boolean isWord(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(findIt(board, word, 0, i, j, visited)){
                    return true;
                }

            }
        }
        return false;
    }
    private boolean findIt(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }

        visited[i][j] = true;

        if(findIt(board, word, index + 1, i + 1, j, visited)){
            return true;
        }
        if(findIt(board, word, index + 1, i - 1, j, visited)){
            return true;
        }
        if(findIt(board, word, index + 1, i, j + 1, visited)){
            return true;
        }
        if(findIt(board, word, index + 1, i, j - 1, visited)){
            return true;
        }

        visited[i][j] = false;

        return false;

    }
}
