import java.util.Comparator;

public class PositiveComparator implements Comparator<LargeDepositor> {
    @Override
    public int compare(LargeDepositor o1, LargeDepositor o2) {
        Double score1 = o1.getTaxedIncome() > 8000 ? o1.getSavings() - o1.getTaxedIncome() : Double.MAX_VALUE;
        Double score2 = o2.getTaxedIncome() > 8000 ? o2.getSavings() - o2.getTaxedIncome() : Double.MAX_VALUE;

        return score1.compareTo(score2);

    }
}
