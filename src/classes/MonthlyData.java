package classes ;


public class MonthlyData extends Meter {
    private int d_month;
    private int d_year;

    public MonthlyData(int d_month, int d_year, boolean check, int consumption, float billing) {
        super(check, consumption, billing);
        this.d_month = d_month;
        this.d_year = d_year;
    }

    public void setD_month(int d_month) {
        this.d_month = d_month;
    }

    public void setD_year(int d_year) {
        this.d_year = d_year;
    }


    public int getD_month() {
        return d_month;
    }

    public int getD_year() {
        return d_year;
    }


    public boolean isCheck() {
        return check;
    }
    
    
    
}
