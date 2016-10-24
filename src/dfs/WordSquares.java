package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquares {
	private List<List<String>> allSquares;
	private List<String> square;
	private Map<String, List<String>> map;
	private int n;
	public List<List<String>> wordSquares(String[] words) {
		allSquares = new ArrayList<List<String>>();
		square = new ArrayList<String>();
		map = new HashMap<String, List<String>>();
		int m = words.length;
		n = words[0].length();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j <= n; ++j) {
				String prefix = words[i].substring(0, j);
				if (map.containsKey(prefix)) {
					map.get(prefix).add(words[i]);
				} else {
					List<String> allWords = new ArrayList<String>();
					allWords.add(words[i]);
					map.put(prefix, allWords);
				}
			}
		}
		
		build(0);
		return allSquares;
	}
	
	private void build(int i) {
		if (i == n) {
			allSquares.add(new ArrayList<String>(square));
			return;
		}
		
		String prefix = "";
		for (int k = 0; k < i; ++k) {
			prefix += square.get(k).charAt(i);
		}
		
		List<String> words = map.get(prefix);
		if (words != null) {
			for (int j = 0; j < words.size(); ++j) {
				square.add(words.get(j));
				build(i + 1);
				square.remove(square.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "area","lead","wall","lady","ball" };
		//String[] words = {"wall", "area", "lead", "lady"};
		WordSquares w = new WordSquares();
		List<List<String>> squares = w.wordSquares(words);
		for (int i = 0; i < squares.size(); ++i) {
			for (int j = 0; j < squares.get(i).size(); ++j) {
				System.out.println(squares.get(i).get(j));
			}			
			System.out.println();
		}
	}

}
