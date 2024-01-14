public class LargeDepositor {
    private int AFM; // ΑΦΜ (ελληνικός)
    private String firstName; // Όνομα
    private String lastName; // Επώνυμο
    private double savings; // Συνολικό ύψος γνωστών καταθέσεων σε άλλες
    private double taxedIncome; //Συνολικό δηλωμένο εισόδημα στην Ελλάδα την τελευταία 3ετία



    public LargeDepositor(int afm, String first, String last, double sav, double tax) {
        AFM = afm;
        firstName = first;
        lastName = last;
        savings = sav;
        taxedIncome = tax;
	}

    public LargeDepositor() {}

	public void setAFM(int AFM) {
        this.AFM = AFM;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSavings() {
        return this.savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getTaxedIncome() {
        return this.taxedIncome;
    }

    public int getAFM() {
        return this.AFM;
    }

    public void setTaxedIncome(double taxedIncome) {
        this.taxedIncome = taxedIncome;
    }

    int key() {return AFM;} //μέθοδος για πρόσβαση στο κλειδί

    public String toString(){
        return " AFM: "+AFM+" | First name: "+firstName+" | Last name: "+lastName+" | Savings: "+savings+" | Taxed income: "+taxedIncome + "\n----\nScore: " + (taxedIncome > 8000 ? savings - taxedIncome : Double.MAX_VALUE) + "\n----\n";
    }

    public int compareTo(LargeDepositor other) {
        Double score1 = taxedIncome > 8000 ? savings - taxedIncome : Double.MAX_VALUE;
        Double score2 = other.getTaxedIncome() > 8000 ? other.getSavings() - other.getTaxedIncome() : Double.MAX_VALUE;

        return score1.compareTo(score2);

    }
}
