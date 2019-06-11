package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/6
 * description：208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */

public class Trie {

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("word");
        trie.insert("aabcdosad");
        System.out.println(trie.search("wor"));
        System.out.println(trie.startsWith("wor"));
    }

    TrieNode root;

    private class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch -'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root =new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node= root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node=node.get(ch);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        char[] chars = word.toCharArray();
        TrieNode node= root;
        for (char ch : chars) {
            if (!node.containsKey(ch)){
                return null;
            }
            node=node.get(ch);
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = searchPrefix(word);
        return trieNode!=null&&trieNode.isEnd;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        return trieNode!=null;
    }
}
