package recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	Queue<String> queue = new LinkedList<String>();
    	queue.add(beginWord);
    	wordList.add(endWord);
    	int distance = 0;
    	while (!queue.isEmpty()) {
    		++distance;
    		int n = queue.size();
    		for (int i = 0; i < n; ++i) {
        		String word = queue.poll();
        		if (word.equals(endWord)) return distance;
        		addNeighbors(word, wordList, queue);        		
    		}
    	}
    	
    	return 0;
    }
    
    private void addNeighbors(String word, Set<String> wordList, Queue<String> queue) {
    	int n = word.length();
    	for (int i = 0; i < n; ++i) {
    		for (char j = 'a'; j <= 'z'; ++j) {
    			if (j != word.charAt(i)) {
    				String intermediate = replaceChar(word, i, j);
    				if (wordList.contains(intermediate)) {
    					queue.add(intermediate);
    					wordList.remove(intermediate);
    				}
    			}
    		}
    	}
    }
    
    private String replaceChar(String s, int index, char c) {
    	char[] charArr = s.toCharArray();
    	charArr[index] = c;
    	return String.valueOf(charArr);
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
