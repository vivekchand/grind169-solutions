class TrieNode {
    public char ch;
    public boolean isWord = false;
    public String word;
    public Map<Character, TrieNode> children = new HashMap<>();
}

class Trie {
    private int R = 26;
    private TrieNode trieNode; 
    
    public Trie() {
        trieNode = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = trieNode;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                TrieNode newNode = new TrieNode();
                newNode.ch = ch;
                node.children.put(ch, newNode);
                node = newNode;
            }
            if(i == word.length() -1) {
                node.isWord = true;
                node.word = word;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode node = trieNode;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return false;
            }
        }
        return node.isWord && node.word.equals(word);
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = trieNode;
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node != null && node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                node = null;
            }
        }
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */