import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;

public class RandomizedBST implements TaxEvasionInterface {
    private class TreeNode {
        LargeDepositor item;
        TreeNode left; // pointer to left subtree
        TreeNode right; // pointer to right subtree
        int N; // number of nodes in the subtree rooted at this TreeNode

        TreeNode(LargeDepositor x) {
            item = x;
        }
    }

    private TreeNode root; // ρίζα στο δέντρο

    private TreeNode rotR(TreeNode h) {
        TreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private TreeNode rotL(TreeNode h) {
        TreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    private TreeNode insertT(TreeNode h, LargeDepositor x) {
        if (h == null)
            return new TreeNode(x);
        if (x.key() < h.item.key()) {
            h.left = insertT(h.left, x);
            h = rotR(h);
        } else {
            h.right = insertT(h.right, x);
            h = rotL(h);
        }
        return h;
    }

    private TreeNode insertR(TreeNode h, LargeDepositor x) {
        if (h == null) {
            return new TreeNode(x);
        }
        if (Math.random() * (h.N + 1) < 1.0) {
            return insertT(h, x);
        }
        if (x.key() < h.item.key()) {
            h.left = insertR(h.left, x);
        } else {
            h.right = insertR(h.right, x);
        }
        h.N++;
        return h;
    }

    @Override
    public void insert(LargeDepositor item) {
        root = insertR(root, item);
    }

    @Override
    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitted = line.split("\\s+");
                insert(new LargeDepositor(Integer.parseInt(splitted[0]), splitted[1], splitted[2],
                        Double.parseDouble(splitted[3]), Double.parseDouble(splitted[4])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSavings(int AFM, double savings) {
        // Traverse the tree --> 1) if you find the given AFM, then add the savings to
        // that account
        // 2) otherwise print a message saying you couldn't find it
        TreeNode curr = foundByAFM(AFM);
        if (curr != null) {
            curr.item.setSavings(curr.item.getSavings() + savings);
        } else {
            System.out.println("Requested AFM not found.");
        }
    }

    @Override
    public LargeDepositor searchByAFM(int AFM) {
        // Traverse the tree --> 1) if you find the given AFM, then print the holders
        // information
        // 2) otherwise print a message saying you couldn't find it
        TreeNode curr = foundByAFM(AFM);
        if (curr != null) {
            System.out.println(curr.item);
            return curr.item;
        } else {
            System.out.println("Requested AFM not found.");
            return null;
        }
    }

    @Override
    public List<LargeDepositor> searchByLastName(String last_name) {
        List<LargeDepositor> res = new List<LargeDepositor>();
        int counter = 0;


        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        TreeNode[] nodes = new TreeNode[root.N + 1];
        int ind = 0;

        while (curr != null || ind != 0){
            if (curr != null){
                nodes[ind] = curr;
                ind++;
                curr = curr.left;
            }
            else{
                curr = nodes[ind-1];
                ind--;

                if (curr.item.getLastName().equals(last_name)) {
                res.insertAtBack(curr.item);
                ++counter;
                }

                curr = curr.right;
            }
        }

        if (0 < counter && counter <= 5) {
            System.out.println(res);
        }

        return res;

    }

    @Override
    public void remove(int AFM) {
        root = removeNode(root, AFM);
    }

    @Override
    public double getMeanSavings() {
        int sum = 0;

        if (root == null) {
            return 0;
        }
        TreeNode curr = root;
        TreeNode[] nodes = new TreeNode[root.N + 1];
        int ind = 0;

        while (curr != null) {

            while (curr != null || nodes.length > 0) {
                nodes[ind] = curr;
                curr = curr.left;
                ++ind;
            }

            // Curr is null so we pop
            curr = nodes[ind - 1];
            --ind;
            sum += curr.item.getSavings();
            curr = curr.right;
        }

        return sum / root.N;

    }

    @Override
    public void printΤopLargeDepositors(int k) {
        PQ pq = new PQ(500); // TODO: might need more?

        if (root == null) {
            return;
        }
        TreeNode curr = root;
        TreeNode[] nodes = new TreeNode[root.N + 1];
        int ind = 0;

        while (curr != null) {

            while (curr != null || nodes.length > 0) {
                nodes[ind] = curr;
                curr = curr.left;
                ++ind;
            }

            curr = nodes[ind - 1];
            --ind;
            {
                if (pq.size() < k) {
                    pq.insert(curr.item);
                }
                else if (pq.min().compareTo(curr.item) < 1) {
                    pq.getmin();
                    pq.insert(curr.item);
                }


            }

            curr = curr.right;
        }

    }

    @Override
    public void printByAFM() {
        System.out.println("all fine 1");
        if (root == null) {
            return;
        }
        // We will traverse the tree *INORDER* and print the nodes as such
        TreeNode curr = root;
        System.out.println("all fine 2");
        TreeNode[] nodes = new TreeNode[root.N + 1];
        System.out.println("size: "+nodes.length);
        System.out.println("all fine 3");
        int ind = 0;

        while (curr != null || ind != 0){
            System.out.println("all fine 4");
            if (curr != null){
                System.out.println("all fine 5");
                System.out.println("ind: "+ind);
                nodes[ind] = curr;
                ind++;
                curr = curr.left;
                System.out.println("all fine 6");
            }
            else{
                System.out.println("all fine 7");
                curr = nodes[ind-1];
                ind--;
                System.out.println(curr.item);

                curr = curr.right;
                System.out.println("all fine 8");
            }
        }
        /* 
        while (curr != null) {

            while (curr != null || ind>0) {
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
        */
    }

    /*
     * Helpers
     */
    public TreeNode foundByAFM(int AFM) {
        TreeNode curr = root;
        while (curr != null) {
            // Found it
            if (curr.item.key() == AFM) {
                return curr;
            }
            // Didn't
            else {
                // If it's less then go to the right sub-tree
                if (curr.item.key() < AFM) {
                    curr = curr.right;
                }
                // If it's greater then go to the left sub-tree
                else {
                    curr = curr.left;
                }
            }
        }
        // If you haven't returned that means that you didn't find the AFM
        return null;
    }

    public TreeNode joinNode(TreeNode a, TreeNode b) {
        // κλειδιά στο a ≤ κλειδιά στο b
        int N = a.N + b.N;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (Math.random() * N < 1.0 * a.N) {
            a.right = joinNode(a.right, b);
            return a;
        } // βάζουμε το b κάτω από το a
        else {
            b.left = joinNode(a, b.left);
            return b;
        }
    }

    public TreeNode removeNode(TreeNode h, int AFM) {
        if (h == null)
            return null;
        int w = h.item.key();
        if (AFM < w) {
            h.left = removeNode(h.left, AFM);
        } else if (w < AFM) {
            h.right = removeNode(h.right, AFM);
        } else {
            h = joinNode(h.left, h.right);
        }
        return h;
    }

    public static void main(String[] args) {
        RandomizedBST bst = new RandomizedBST();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Options:\n1. Insert suspect\n2. Remove suspect\n3. Load data from file\n4. Update suspect's savings\n5. Find suspect by AFM\n6. Find suspect by last name\n7. Calculate mean savings\n8. Print top k depositors\n9. Print all data\nYour choice: ");

            switch (sc.nextInt()) {
                case 1:
                    LargeDepositor sus = new LargeDepositor();
                    System.out.print("Enter AFM: ");
                    sus.setAFM(sc.nextInt());
                    System.out.println();
                    System.out.print("Enter first name: ");
                    sus.setFirstName(sc.next());
                    System.out.println();
                    System.out.print("Enter last name: ");
                    sus.setLastName(sc.next());
                    System.out.println();
                    System.out.print("Enter savings: ");
                    sus.setSavings(sc.nextInt());
                    System.out.println();
                    System.out.print("Enter taxed income: ");
                    sus.setTaxedIncome(sc.nextInt());
                    System.out.println();
                    bst.insert(sus);
                    break;
                case 2:
                    System.out.print("Enter AFM: ");
                    bst.remove(sc.nextInt());
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter filename: ");
                    bst.load(sc.next());
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter AFM: ");
                    int AFM = sc.nextInt();
                    System.out.println();
                    System.out.print("Enter savings: ");
                    System.out.println();
                    int savings = sc.nextInt();
                    bst.updateSavings(AFM, savings);
                    break;
                case 5:
                    System.out.print("Enter AFM: ");
                    bst.searchByAFM(sc.nextInt());
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter last name: ");
                    bst.searchByLastName(sc.next());
                    System.out.println();
                    break;
                case 7:
                    System.out.println(bst.getMeanSavings());
                    break;
                case 8:
                    System.out.print("Enter k: ");                    
                    bst.printΤopLargeDepositors(sc.nextInt());
                    System.out.println();
                    break;
                case 9:
                    bst.printByAFM();
                    break;
                default:
                    break;
            }
        
        }
    }


}