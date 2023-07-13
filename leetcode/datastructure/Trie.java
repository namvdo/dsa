package leetcode.datastructure;

public class Trie {
    Node root;

    public Trie() {
        root = new Node(false, new Node[26]);
    }
    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for(char c : chars) {
            Node[] children = cur.children;
            Node child = children[c - 'a'];
            if (child != null) {
                cur = child;
            } else {
                children[c - 'a'] = new Node(false, new Node[26]);
                cur = children[c - 'a'];
            }
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        char[] chars = word.toCharArray(); 
        Node cur = root;
        for(int i = 0; i < chars.length; i++) {
            if (cur.children[chars[i] - 'a'] != null) {
                cur = cur.children[chars[i] - 'a'];
            } else {
                return false;
            }
            if (i == chars.length - 1 && cur.isWord) return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = root;
        for(char c : chars) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        } 
        return true;
    }
}


class Node {
    boolean isWord;
    Node[] children;

    Node (boolean isWord, Node[] children) {
        this.isWord = isWord;
        this.children = children;
    }
}
