package recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	class Node {
		public String word;
		public int distance;
		public Node(String word, int distance) {
			this.word = word;
			this.distance = distance;
		}
		
	}
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(new Node(beginWord, 1));
    	wordList.add(endWord);
    	
    	while (!queue.isEmpty()) {
    		Node node = queue.poll();
    		if (node.word.equals(endWord)) return node.distance;
    		addNeighbors(node, wordList, queue);
    	}
    	
    	return 0;
    }
    
    private void addNeighbors(Node node, Set<String> wordList, Queue<Node> queue) {
    	int n = node.word.length();
    	for (int i = 0; i < n; ++i) {
    		for (char j = 'a'; j <= 'z'; ++j) {
    			if (j != node.word.charAt(i)) {
    				String intermediate = replaceChar(node.word, i, j);
    				if (wordList.contains(intermediate)) {
    					queue.add(new Node(intermediate, node.distance + 1));
    					wordList.remove(intermediate);
    				}
    			}
    		}
    	}
    }
    
    private String replaceChar(String s, int index, char c) {
    	char[] charArr = s.toCharArray();
    	charArr[index] = c;
    	return new String(charArr);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		WordLadder w = new WordLadder();
		System.out.println(w.ladderLength(beginWord, endWord, wordList));
	}

}
