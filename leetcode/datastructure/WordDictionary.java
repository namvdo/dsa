package leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    class Trie {
        TrieNode root;

        void add(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < chars.length; i++) {
                if (!cur.children.containsKey(chars[i])) {
                    TrieNode node = new TrieNode();
                    cur.children.put(chars[i], node);
                    cur = node;
                } else {
                    cur = cur.children.get(chars[i]);
                }
            }
            cur.isWord = true;
        }

        boolean search(String word) {
            return helper(root, word, 0);
        }

        boolean helper(TrieNode node, String word, int pos) {
            if (node == null)
                return false;
            if (pos == word.length())
                return node.isWord;
            if (pos >= word.length()) {
                return false;
            }
            char c = word.charAt(pos);
            if (c == '.') {
                boolean bool = false;
                for (char x = 'a'; x <= 'z'; x++) {
                    TrieNode child = node.children.get(x);
                    bool = helper(child, word, pos + 1);
                    if (bool) {
                        return true;
                    }
                }
                return false;
            } else {
                node = node.children.get(c);
                return helper(node, word, pos + 1);
            }
        }
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
        
    }

    Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
        trie.root = new TrieNode();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
