package string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {    	
    	String[] arr1 = version1.split("\\.");
    	String[] arr2 = version2.split("\\.");    	
    	int m = arr1.length;
    	int n = arr2.length;    	
    	int i = 0;
    	while (i < m && i < n) {
    		int x = Integer.parseInt(arr1[i]);
    		int y = Integer.parseInt(arr2[i]);
    		if (x > y) 
    			return 1;
    		if (x < y)
    			return -1;
    		++i;
    	}
    	
    	if (m > n) {
    		while (i < m) {
    			if (Integer.parseInt(arr1[i]) > 0) {
    				return 1;
    			}
				++i;
    		}
    	} else if (m < n) {
    		while (i < n) {
    			if (Integer.parseInt(arr2[i]) > 0) {
    				return -1;
    			}
				++i;
    		}
    	}
    	
    	return 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersionNumbers c = new CompareVersionNumbers();
		System.out.println(c.compareVersion("1", "1.1"));
	}

}
