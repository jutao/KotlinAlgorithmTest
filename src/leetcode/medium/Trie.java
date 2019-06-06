package leetcode.medium;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * author：jutao
 * time：2019/6/6
 * description：208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class Trie {
    HashMap<String, Boolean> tree;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        tree = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        tree.put(word, true);
        StringBuilder sb = new StringBuilder(word);
        sb.deleteCharAt(sb.toString().length() - 1);
        while (sb.toString().length() != 0) {
            if (!tree.getOrDefault(sb.toString(), false)) {
                tree.put(sb.toString(), false);
            }
            sb.deleteCharAt(sb.toString().length() - 1);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        return tree.getOrDefault(word, false);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return tree.get(prefix) != null;
    }
}
