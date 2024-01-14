import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RandomizedBST implements TaxEvasionInterface {
    private int N;
    private class TreeNode {
        LargeDepositor item;
        TreeNode left; // pointer to left subtree
        TreeNode right; // pointer to right subtree
        int N;

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
        return h;
    }

    @Override
    public void insert(LargeDepositor item) {
        root = insertR(root, item);
        ++N;
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
            curr.item.setSavings(savings);
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

    private void traverseAndBuild(TreeNode node, List<LargeDepositor> ls) {
        if (node == null)
            return;

        if (node.item.getLastName().equals(ls.lastname))
            ls.insertAtFront(node.item);

        traverseAndBuild(node.left, ls);
        traverseAndBuild(node.right, ls);
    }

    @Override
    public List<LargeDepositor> searchByLastName(String last_name) {
        List<LargeDepositor> res = new List<LargeDepositor>();
        res.lastname = last_name;

        traverseAndBuild(root, res);

        if (0 < res.N && res.N <= 5) {
            System.out.println(res);
        }

        return res;

    }

    @Override
    public void remove(int AFM) {
        root = removeNode(root, AFM);
    }

    private double traverseAndSum(TreeNode node) {
        if (node == null)
            return 0;

        return node.item.getSavings() + traverseAndSum(node.left) + traverseAndSum(node.right);
    }

    @Override
    public double getMeanSavings() {
        return traverseAndSum(root) / N;

    }

    private void traverseAndRank(TreeNode node, PQ pq) {
        if (node == null)
            return;

        if (pq.size() < pq.capacity) {
            pq.insert(node.item);
        } else if (pq.min().compareTo(node.item) == 1) {
            pq.getmin();
            pq.insert(node.item);
        }

        traverseAndRank(node.left,pq);
        traverseAndRank(node.right, pq);
    }

    @Override
    public void printΤopLargeDepositors(int k) {
        PQ pq = new PQ(k);
        List<LargeDepositor> ls = new List<LargeDepositor>();

        traverseAndRank(root, pq);
        while (pq.size() > 0)
            ls.insertAtFront(pq.getmin());
        while (ls.N > 0)
            System.out.println(ls.removeFromFront());

    }

    private void printInorder(TreeNode node) {
        if (node == null)
            return;

        printInorder(node.left);

        System.out.print(node.item + " ");

        printInorder(node.right);
    }

    @Override
    public void printByAFM() {
        printInorder(root);
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
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int N = a.N + b.N;
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
            System.out.print(
                    "Options:\n1. Insert suspect\n2. Remove suspect\n3. Load data from file\n4. Update suspect's savings\n5. Find suspect by AFM\n6. Find suspect by last name\n7. Calculate mean savings\n8. Print top k depositors\n9. Print all data\nYour choice: ");

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
                    System.out.println(bst.getMeanSavings() + " EUR");
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