/**
 * @author Hector Fierro
 * @version 1.00, 05/25/2020
 *
 */
public class Zips {
    private String zipcode;
    private String state;
    private String rate_area;
    public Zips(String zipcode, String state, String rate_area){
        this.zipcode = zipcode;
        this.state = state;
        this.rate_area = rate_area;
    }

    public Zips(){
        this.zipcode = "";
        this.state = "";
        this.rate_area = "";
    }

    public String getZipcode(){
        return this.zipcode;
    }

    public String getState(){
        return this.state;
    }

    public String getRate_area(){
        return this.rate_area;
    }

    public void setZipCode(String zipcode){
        this.zipcode = zipcode;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setRate_area(String rate_area){
        this.rate_area = rate_area;
    }
}