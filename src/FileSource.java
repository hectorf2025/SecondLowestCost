/**
 * @author Hector Fierro
 * @version 1.00, 05/25/2020
 *
 */
public class FileSource {
    private String plans;
    private String zips;
    private String slcsp;

    private String path;
    public FileSource(){
        plans = "plans.csv";
        zips = "zips.csv";
        slcsp = "slcsp.csv";
        path = System.getProperty("user.home")+"/slcsp/";
    }

    public String getPlans(){
        return plans;
    }

    public String getZips(){
        return zips;
    }

    public String getSlcsp(){
        return slcsp;
    }

    public String getPath(){
        return path;
    }
}
