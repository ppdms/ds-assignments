public interface TaxEvasionInterface {
    abstract void insert(LargeDepositor item);

    abstract void load(String filename);

    abstract void updateSavings(int AFM, double savings);

    abstract LargeDepositor searchByAFM(int AFM);

    abstract List searchByLastName(String last_name);

    abstract void remove(int AFM);

    abstract double getMeanSavings();

    abstract void printΤopLargeDepositors(int k);

    abstract void printByAFM();
}