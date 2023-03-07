package leetCode;

import java.util.*;

public class ConcatenatedWords {
    // leetcode 472
    // Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
    //
    //A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

    public List<String> findAllConcatenatedWordsInADict(String[] words) {  // 超时
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0){
            return result;
        }

        TrieNode head = new TrieNode();
        for(String s : words){
            buildTrie(s, head);
        }

        for(String s : words){
            if(s.length() == 0){
                continue;
            }
            findAll(s, head, result);
        }

        return result;
    }

    private void findAll(String s, TrieNode head, List<String> result){
        TrieNode cur = head;
        for(int i = 0; i < s.length(); i++){
            cur = cur.children.get(s.charAt(i));
            if(cur.isWord && i < s.length() - 1){
                if(valid(s, head, i + 1)){
                    result.add(s);
                    break;
                }
            }
        }
    }

    private boolean valid(String s, TrieNode head, int start){
        if(start == s.length()){
            return true;
        }
        TrieNode cur = head;
        for(int i = start; i < s.length(); i++){
            if(! cur.children.containsKey(s.charAt(i))){
                return false;
            }
            cur = cur.children.get(s.charAt(i));
            if(cur.isWord){
                if(valid(s, head, i + 1)){
                    return true;
                }
            }
        }

        return false;
    }


    private void buildTrie(String word, TrieNode head){
        TrieNode cur = head;
        for(int i = 0; i < word.length(); i++){
            if(! cur.children.containsKey(word.charAt(i))){
                cur.children.put(word.charAt(i), new TrieNode());
            }
            cur = cur.children.get(word.charAt(i));
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


    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) { // offical answer
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            boolean[] visited = new boolean[word.length()];
            if (dfs(word, 0, visited)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    public boolean dfs(String word, int start, boolean[] visited) {
        if (word.length() == start) {
            return true;
        }
        if (visited[start]) {
            return false;
        }
        visited[start] = true;
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
            if (node.isEnd) {
                if (dfs(word, i + 1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}
//        判断一个单词是不是连接词，需要判断这个单词是否完全由至少两个给定数组中的更短的非空单词（可以重复）组成。判断更短的单词是否在给定数组中，可以使用字典树实现。
//        为了方便处理，首先将数组 words 按照字符串的长度递增的顺序排序，排序后可以确保当遍历到任意单词时，比该单词短的单词一定都已经遍历过，因此可以根据已经遍历过的全部单词判断当前单词是不是连接词。
//
//        在将数组 words 排序之后，遍历数组，跳过空字符串，对于每个非空单词，判断该单词是不是连接词，如果是连接词则将该单词加入结果数组，如果不是连接词则将该单词加入字典树。
//
//        判断一个单词是不是连接词的做法是在字典树中搜索。从该单词的第一个字符（即下标 0 处的字符）开始，在字典树中依次搜索每个字符对应的结点，可能有以下几种情况：
//
//        如果一个字符对应的结点是单词的结尾，则找到了一个更短的单词，从该字符的后一个字符开始搜索下一个更短的单词；
//
//        如果一个字符对应的结点在字典树中不存在，则当前的搜索结果失败，回到上一个单词的结尾继续搜索。
//
//        如果找到一个更短的单词且这个更短的单词的最后一个字符是当前单词的最后一个字符，则当前单词是连接词。由于数组 words 中没有重复的单词，因此在判断一个单词是不是连接词时，该单词一定没有加入字典树，由此可以确保判断连接词的条件成立。
//
//        由于一个连接词由多个更短的非空单词组成，如果存在一个较长的连接词的组成部分之一是一个较短的连接词，则一定可以将这个较短的连接词换成多个更短的非空单词，因此不需要将连接词加入字典树。
//
//        为了降低时间复杂度，需要使用记忆化搜索。对于每个单词，创建与单词相同长度的数组记录该单词的每一个下标是否被访问过，然后进行记忆化搜索。搜索过程中，如果一个下标已经被访问过，则从该下标到末尾的部分一定不是由给定数组中的一个或多个非空单词组成（否则上次访问时已经可以知道当前单词是连接词），只有尚未访问过的下标才需要进行搜索。


