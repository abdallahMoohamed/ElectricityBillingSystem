
package classes;

/**
 *
 * @author HP
 */
public class Meter {
    
    private static int meter_Code = 202100;
    protected long meter_Reading;
    protected int consumption;
    protected float billing;
    protected boolean check;
    public Meter() {
        meter_Code++;
    }
    public Meter(boolean check, int consumption, float billing) {
        this.check = check;

        this.consumption = consumption;
        this.billing = billing;
    }


    public static void setMeter_Code(int meter_Code) {
        Meter.meter_Code = meter_Code;
    }

    public void setMeter_Reading(long meter_Reading) {
        this.meter_Reading = meter_Reading;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void setBilling(float billing) {
        this.billing = billing;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public static int getMeter_Code() {
        return meter_Code;
    }
     
    public long getMeter_Reading() {
        return meter_Reading;
    }

    public int getConsumption() {
        return consumption;
    }

    public float getBilling() {
        return billing;
    }

    public boolean getCheck() {
        return check;
    }



}
