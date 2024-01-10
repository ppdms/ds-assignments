import java.util.List;

import org.w3c.dom.Node;

class RandomizedBST implements TaxEvasionInterface {
    private class TreeNode {
        LargeDepositor item;
        TreeNode left; // pointer to left subtree
        TreeNode right; // pointer to right subtree
        int N; //number of nodes in the subtree rooted at this TreeNode
    }

    private TreeNode root; //ρίζα στο δέντρο
    //Υλοποίηση μεθόδων από εδώ και κάτω
    @Override
    public void insert(LargeDepositor item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }
    @Override
    public void load(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public void updateSavings(int AFM, double savings) {
        // Traverse the tree --> 1) if you find the given AFM, then add the savings to that account
        //                       2) otherwise print a message saying you couldn't find it
        TreeNode curr = foundByAFM(AFM);
        if (curr != null){
            curr.item.setSavings(curr.item.getSavings() + savings);
        }
        else{
            System.out.println("Requested AFM not found.");
        }
    }

    @Override
    public LargeDepositor searchByAFM(int AFM) {
        // Traverse the tree --> 1) if you find the given AFM, then print the holders information
        //                       2) otherwise print a message saying you couldn't find it
        TreeNode curr = foundByAFM(AFM);
        if (curr != null){
            System.out.println(curr.item);
            return curr.item;
        }
        else{
            System.out.println("Requested AFM not found.");
            return null;
        }
    }
    @Override
    public List searchByLastName(String last_name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByLastName'");
    }

    @Override
    public void remove(int AFM) {
        root = removeNode(root, AFM);
    }

    @Override
    public double getMeanSavings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMeanSavings'");
    }
    @Override
    public void printΤopLargeDepositors(int k) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printΤopLargeDepositors'");
    }
    @Override
    public void printByAFM() {
        if (root == null){
            return;
        }
        // We will traverse the tree *INORDER* and print the nodes as such
        TreeNode curr = root;
        TreeNode[] nodes = new TreeNode[root.N+1];
        int ind = 0;

        while (curr != null){

            while (curr != null || nodes.length > 0){
                nodes[ind] = curr;
                curr = curr.left;
                ++ind;
            }

            // Curr is null so we pop
            curr = nodes[ind - 1];
            --ind;
            System.out.println(curr);

            curr = curr.right;
        }
    }

    /*
     *  Helpers
     */
    public TreeNode foundByAFM(int AFM){
        TreeNode curr = root;
        while (curr != null){
            // Found it
            if (curr.item.key() == AFM){
                return curr;
            }
            // Didn't
            else{
                // If it's less then go to the right sub-tree
                if (curr.item.key() < AFM){
                    curr = curr.right;
                }
                // If it's greater then go to the left sub-tree
                else{
                    curr = curr.left;
                }
            }
        }
        // If you haven't returned that means that you didn't find the AFM
        return null;
    }

    public TreeNode joinNode(TreeNode a, TreeNode b) {
        //κλειδιά στο a ≤ κλειδιά στο b
        int N = a.N + b.N;
        if (a == null){
            return b;
        } 
        if (b == null) {
            return a;
        }
        if (Math.random()*N < 1.0*a.N) {
            a.right = joinNode(a.right, b);
            return a; 
        } //βάζουμε το b κάτω από το a
        else { 
            b.left = joinNode(a, b.left); return b; 
        } 
    } 

    public TreeNode removeNode(TreeNode h, int AFM) {
        if (h == null) return null;
        int w = h.item.key();
        if (AFM < w){
            h.left = removeNode(h.left, AFM);
        } 
        else if (w < AFM){
            h.right = removeNode(h.right, AFM);
        } 
        else{
            h = joinNode(h.left, h.right);
        }       
        return h; 
    }


}
