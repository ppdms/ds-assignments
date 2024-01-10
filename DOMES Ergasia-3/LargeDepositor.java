public class LargeDepositor {
    private int AFM; // ΑΦΜ (ελληνικός)
    private String firstName; // Όνομα
    private String lastName; // Επώνυμο
    private double savings; // Συνολικό ύψος γνωστών καταθέσεων σε άλλες
    private double taxedIncome; //Συνολικό δηλωμένο εισόδημα στην Ελλάδα την τελευταία 3ετία

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

    public void setTaxedIncome(double taxedIncome) {
        this.taxedIncome = taxedIncome;
    }

    int key() {return AFM;} //μέθοδος για πρόσβαση στο κλειδί

    public String toString(){
        return "First name: "+firstName+"\n Last name: "+lastName+"\n AFM: "+AFM+"\n Savings: "+savings+"\n Taxed income: "+taxedIncome+"\n";
    }
}
