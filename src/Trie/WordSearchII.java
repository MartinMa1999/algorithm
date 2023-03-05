package Trie;

import java.util.*;

public class WordSearchII {
    //Given a 2D board and a list of words from the dictionary, find all words in the board.
    //Each word must be constructed from letters of sequentially adjacent cell,
    // where "adjacent" cells are those horizontally or vertically neighboring.
    // The same letter cell may not be used more than once in a word.

    public List<String> wordSearch(char[][] board, String[] words){
        Set<String> set = new HashSet<>();
        TrieNode root = buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                findAll(board, root, set, new StringBuilder(), i, j, visited);
            }
        }
        return new ArrayList<>(set);
    }
    private void findAll(char[][] board, TrieNode root, Set<String> set, StringBuilder sb, int i, int j, boolean[][] visited){
        if(i < 0 || i > board.length || j < 0 || j > board[0].length || visited[i][j]){
            return;
        }

        if(! root.children.containsKey(board[i][j])){
            return;
        }
        visited[i][j] = true;
        sb.append(board[i][j]);
        root = root.children.get(board[i][j]);
        if(root.isWord){
            set.add(sb.toString());
        }

        findAll(board, root, set, sb, i + 1, j, visited);
        findAll(board, root, set, sb, i - 1, j ,visited);
        findAll(board, root, set, sb, i, j + 1, visited);
        findAll(board, root ,set, sb, i ,j - 1, visited);

        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s : words){
            insert(s, root);
        }
        return root;
    }
    private void insert(String s, TrieNode root){
        TrieNode cur = root;
        for(int i = 0; i < s.length(); i++){
            TrieNode next = null;
            if(! cur.children.containsKey(s.charAt(i))){
                next = new TrieNode();
                cur.children.put(s.charAt(i), next);
            }
            cur = cur.children.get(s.charAt(i));
        }
        cur.isWord = true;
    }
}
class TrieNode{
     boolean isWord;
    Map<Character, TrieNode> children;
    TrieNode(){
        children = new HashMap<>();
    }
}