import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RandomizedBST implements TaxEvasionInterface {
    private class TreeNode {
    };

    private TreeNode root;

    private TreeNode insertR(TreeNode h, LargeDepositor x) {
        if (h == null) {
            return new Node(x);
        }
        if (Math.random() * (h.N + 1) < 1.0) {
            return insertT(h, x);
        }
        if (less(x.key(), h.item.key())) {
            h.l = insertR(h.l, x);
        } else {
            h.r = insertR(h.r, x);
        }
        h.N++;
        return h;
    }

    public void insert(LargeDepositor item) {
        root = insertR(root, item);
    }

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

    public List<LargeDepositor> searchByLastName(String last_name) {

    }

    public double getMeanSavings() {

    }

    public void printΤopLargeDepositors(int k) {

    }

}