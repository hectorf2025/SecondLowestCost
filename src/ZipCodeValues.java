/**
 * @author Hector Fierro
 * @version 1.00, 05/25/2020
 *
 */
public class ZipCodeValues {
    private String zipCode;
    private String value;
    private String state;
    private String ratearea;

    public ZipCodeValues(String zipCode, String value, String state, String ratearea){
        this.zipCode = zipCode;
        this.value  = value;
        this.state = state;
        this.ratearea = ratearea;
    }

    public ZipCodeValues(String zipCode){
        this.zipCode = zipCode;
        this.value  = "";
        this.state = "";
        this.ratearea = "";
    }

    public ZipCodeValues(){
        this.zipCode = "";
        this.value  = "";
        this.state = "";
        this.ratearea = "";
    }

    public String getZipCode(){
        return this.zipCode;
    }

    public String getValue(){
        return this.value;
    }

    public String getState(){
        return this.state;
    }

    public String getRatearea(){
        return this.ratearea;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public void setValue(String value){

        this.value = String.format ("%.2f", Double.parseDouble(value));
    }

    public void setState(String state){
        this.state = state ;
    }
    public void setRatearea(String ratearea){
        this.ratearea = ratearea;
    }
}
