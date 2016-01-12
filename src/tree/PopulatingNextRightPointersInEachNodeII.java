package tree;

public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
    	if (root == null || (root.left == null && root.right == null)) return;

        TreeLinkNode next = root.next;
        while (next != null) {
        	if(next.left != null) {
        		next = next.left;
        		break;
        	}
        	
        	if (next.right != null) {
        		next = next.right;
        		break;
        	}
        	
        	next = next.next;
        }
        
        if (root.right != null) 
        	root.right.next = next;
         
    	if (root.left != null)
        	root.left.next = root.right == null ? next : root.right;
            	
        connect(root.right);
        connect(root.left);
    }

}
