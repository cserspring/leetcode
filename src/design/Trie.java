package design;

class TrieNode {
    public boolean isEow = false;
    public char value;
    private int size = 26;
    public TrieNode[] children = new TrieNode[size];
    
    // Initialize your data structure here.
    public TrieNode() {
        
    }
    
    public TrieNode(char value) {
    	this.value = value;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode r = root;
        int n = word.length();
        for (int i = 0; i < n; ++i) {
        	char c = word.charAt(i); 
        	if (r.children[c - 'a'] == null)
        		r.children[c - 'a'] = new TrieNode(c);        	
        	r = r.children[c - 'a'];        	
        }
        
        r.isEow = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode r = root;
        int i = 0;
        while (i < word.length() && r.children[word.charAt(i) - 'a'] != null) {
        	r = r.children[word.charAt(i) - 'a'];
        	if (r.value != word.charAt(i)) {
        		return false;
        	}

        	++i;
        }
        
        return i == word.length() && r.isEow;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode r = root;
        int i = 0;
        while (i < prefix.length() && r.children[prefix.charAt(i) - 'a'] != null) {
        	r = r.children[prefix.charAt(i) - 'a'];
        	if (r.value != prefix.charAt(i)) {
        		return false;
        	}
        	
        	++i;
        }
        
        return i == prefix.length();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		
		t.insert("abc");
		System.out.println(t.search("abc"));
		System.out.println(t.search("ab"));
		t.insert("ab");
		System.out.println(t.search("ab"));
		t.insert("ab");
		System.out.println(t.search("ab"));		
		
		t.insert("abc");
		t.insert("abcd");
		System.out.println(t.search("abc"));
		System.out.println(t.search("abcde"));
		System.out.println(t.startsWith("abcd"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
