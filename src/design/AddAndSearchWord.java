package design;

// In order to process the '.' situations, Trie tree is modified.
class RegexTrie {
    private TrieNode root;

    public RegexTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode r = root;
        int n = word.length();
        for (int i = 0; i < n; ++i) {
        	char c = word.charAt(i); 
        	if (r.children[c - 'a'] == null)
        		r.children[c - 'a'] = new TrieNode();        	
        	r = r.children[c - 'a'];        	
        }
        
        r.isEow = true;
    }

    public boolean search(String word) {
    	return search(word, root);
    }
    
    // Returns if the word is in the trie.
    private boolean search(String word, TrieNode r) {
        int i = 0;
        while (i < word.length()) {
        	if (word.charAt(i) == '.') {
        		for (int j = 0; j < 26; ++j) {
        			if (r.children[j] == null) continue;
        			if (search(word.substring(i + 1, word.length()), r.children[j]))
        				return true;
        		}
        		
        		return false;
        	} 
        	
        	r = r.children[word.charAt(i) - 'a'];
        	if (r == null)
        		return false;
        	
        	++i;
        }
        
        return i == word.length() && r.isEow;
    }
}

public class AddAndSearchWord {

	private RegexTrie trie = new RegexTrie();
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddAndSearchWord a = new AddAndSearchWord();
		a.addWord("bad");
		a.addWord("dad");
		a.addWord("mad");
		System.out.println(a.search("pad"));
		System.out.println(a.search("bad"));
		System.out.println(a.search(".ad"));
		System.out.println(a.search("b.."));
		System.out.println(a.search("..e"));
	}

}
