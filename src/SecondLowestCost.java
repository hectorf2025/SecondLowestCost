/**
 * @author Hector Fierro
 * @version 1.00, 05/25/2020
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SecondLowestCost {
    public static void main(String[] args) {
        FileSource fs = new FileSource();
        String csvPlans = fs.getPath() + fs.getPlans();
        String csvZips = fs.getPath() + fs.getZips();
        String csvSlcsp = fs.getPath() + fs.getSlcsp();

        BufferedReader br1 = null, br2 = null, br3 = null;

        String line = "";
        final String COMMA_DEL = ",";

        try {
            br1 = new BufferedReader(new FileReader(csvSlcsp));
            br2 = new BufferedReader(new FileReader(csvZips));
            br3 = new BufferedReader(new FileReader(csvPlans));
            ArrayList<ZipCodeValues> zcvArray = new ArrayList<ZipCodeValues>(); //ArrayList of Objects for ZipCodes, Values, and rateArea
            // Add ZipCodes from slcsp file to ArrayList
            while ((line = br1.readLine()) != null) {
                ZipCodeValues zcv = new ZipCodeValues();
                String[] zipcodes = line.split(COMMA_DEL); //Array with line from CSV into an array
                if (! zipcodes[0].equals("zipcode")){
                    zcv.setZipCode(zipcodes[0]); // Store ZipCOde value in the Objects field ZipCode
                    zcvArray.add(zcv); //adds the object with zip code to the array list
                }
            }

            ArrayList<Zips> zipArray = new ArrayList<Zips>(); //ArrayList of Objects for ZipCodes, Values, and rateArea
            // Add ZipCodes, State and Rate Area from zips file  to ArrayList
            while ((line = br2.readLine()) != null) {
                Zips zcv = new Zips();
                String[] zips = line.split(COMMA_DEL); //Array with line gathered from CSV splited into an array
                zcv.setZipCode(zips[0]);
                zcv.setState(zips[1]);
                zcv.setRate_area(zips[4]);
                zipArray.add(zcv); //adds the object with zip code to the array list
            }

            ArrayList<Plans> plnArray = new ArrayList<Plans>(); //ArrayList of Objects for ZipCodes, Values, and rateArea
            // Add State, Rate, Rate Area if it's SILVER plan from plans file  to ArrayList
            while ((line = br3.readLine()) != null) {
                Plans zcv = new Plans();
                String[] plans = line.split(COMMA_DEL); //Array with line gathered from CSV splited into an array
                if (plans[2].equals("Silver")){
                    zcv.setState(plans[1]); // Store State
                    zcv.setRate(plans[3]);
                    zcv.setRate_area(plans[4]);
                    plnArray.add(zcv); //adds the object with zip code to the array list
                }

            }

            /*Search for Zip code in the Zip arrayList, if found the first time set values of State and Rate Area
            in the existing zcvArray object. If it's found a second instance check if the Rate are is the same,
            else skip it from the seach of second lowest as the answer is ambiguous and should be left blank.
            */
            for (int row=0; row < zcvArray.size(); row++){
                Boolean zipFound = false;
                ZipCodeValues tmp = new ZipCodeValues();
                for (int r2=0; r2 < zipArray.size(); r2++) {
                    if(zipArray.get(r2).getZipcode().equals(zcvArray.get(row).getZipCode())){
                        if (!zipFound) {
                            zipFound = true;
                            tmp.setZipCode(zipArray.get(r2).getZipcode());
                            tmp.setState(zipArray.get(r2).getState() );
                            tmp.setRatearea(zipArray.get(r2).getRate_area());
                        }
                        else if (! zipArray.get(r2).getRate_area().equals(tmp.getRatearea())){
                            tmp.setZipCode(zipArray.get(r2).getZipcode());
                            tmp.setState("");
                            tmp.setRatearea("");
                            zcvArray.set(row,tmp); //Duplicate on different rate Area
                            break;
                        }
                        zcvArray.set(row,tmp);
                    }
                }
            }

            //Search for State and rate_area in the Plans arrayList. If found store each Rate for that State and
            // Rate Area in the tmp Array to find the second lowest value.
            for (int row=0; row < zcvArray.size(); row++){
                ZipCodeValues tmp = new ZipCodeValues();
                ArrayList<Double> plansSilver = new ArrayList<Double>();
                for (int r2=0; r2 < plnArray.size(); r2++) {
                    if(plnArray.get(r2).getState().equals(zcvArray.get(row).getState())
                            && plnArray.get(r2).getRate_area().equals(zcvArray.get(row).getRatearea())){
                        plansSilver.add(Double.parseDouble(plnArray.get(r2).getRate()));
                    }
                }
                if (plansSilver.size()>1){
                    Double sgv;
                    sgv = secondGreatestValue(plansSilver);
                    tmp.setZipCode(zcvArray.get(row).getZipCode());
                    tmp.setState(zcvArray.get(row).getState());
                    tmp.setRatearea(zcvArray.get(row).getRatearea());
                    tmp.setValue(Double.toString(sgv));
                    zcvArray.set(row,tmp);
                }
            }

            //Write CSV file
            CsvFileWriter.writeCsvFile(csvSlcsp, zcvArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br1 != null) {
                try {
                    br1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br3 != null) {
                try {
                    br3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Finds the seconds smallest value from the Array with Silver plans for specific State and Rate Area
    static Double secondGreatestValue(ArrayList<Double> plansSilver){
        if(plansSilver.size() >1) {
            double smallest = Double.MAX_VALUE;
            double secondSmallest = Double.MAX_VALUE;
            //System.out.println(smallest);
            for (int i = 0; i < plansSilver.size(); i++) {
                if (plansSilver.get(i) < smallest) {
                    secondSmallest = smallest;
                    smallest = plansSilver.get(i);
                } else if (plansSilver.get(i) < secondSmallest) {
                    secondSmallest = plansSilver.get(i);
                }
            }
            return secondSmallest;
        }
        return 0.00;
    }
}