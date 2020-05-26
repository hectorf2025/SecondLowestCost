/**
 * @author Hector Fierro
 * @version 1.00, 05/25/2020
 *
 */
public class Plans {
    private String state;
    private String rate;
    private String rate_area;

    public Plans(String state, String rate, String rate_area){
        this.state = state;
        this.rate = rate;
        this.rate_area = rate_area;
    }

    public Plans(){
        this.state = "";
        this.rate = "";
        this.rate_area = "";
    }

    public String getState(){
        return this.state;
    }

    public String getRate(){
        return this.rate;
    }

    public String getRate_area(){
        return this.rate_area;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setRate(String rate){
        this.rate = String.format ("%.2f", Double.parseDouble(rate));
    }

    public void setRate_area(String rate_area){
        this.rate_area = rate_area;
    }
}
