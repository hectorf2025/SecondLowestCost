Hector Fierro

Completed this short programming assignment:
https://homework.adhoc.team/slcsp/

Submitting code written in the Jave language as we agreed.

Development environment:
IDE: IntelliJ IDEA 2019.1.2 (Community Edition)
Build #IC-191.7141.44
SDK: java version 1.8.0_144

Instructions on how to run your program.
1. Create a folder "slcsp" inside of your user.home (your user name) directory:
	c:\users\home\slcsp

2. Download and unzip the slcsp-aab498af8d435c61f13227d0e5702a23.zip file provided by AdHoc

3. Drop the three original CSV files provided by AdHoc inside of the slcsp folder 

4. Open the slcsp.csv file and ensure it contains only one column with zip code value. Make a backup copy of this file as it will be rewritten adding a second column of rates when the program executes.

5. Open the project SecondLowestCost.java, which includes the following files:
	SecondLowestCost.java
	ZipCodeValues.java
	Plans.java
	Zips.java
	FileSource.java
	CsvFileWriter.java
	
6. Compile and run the program

7. Open the slcsp.csv file and check the second column of rates added as required by the assignment.

8. Before runnig it again, delete the sclsp.csv file and copy the one from the back up giving it the same name: slcsp.csv


Included tests and Instructions on how to run the tests.
Test case 1:
A ZIP exist in the zips file, then state abd area rate exist in the plans file for multiple SILVER plans
zipcode,rate (slcsp)
64148, 245.2       State,AreaRate (zips)
		64148,MO,3,   metal_level,rate (plans)    
				MO,Silver,290.05,3
				MO,Silver,234.6,3
				MO,Silver,265.82,3
				MO,Silver,251.08,3
				MO,Silver,351.6,3
				MO,Silver,312.06,3
				MO,Silver,245.2,3
				MO,Silver,265.25,3
				MO,Silver,253.65,3
				MO,Silver,319.57,3
				MO,Silver,271.64,3
				MO,Silver,298.87,3
				MO,Silver,341.24,3

Test case 2:
A ZIP code can also be in more than one rate area. In that case, the answer is ambiguous and should be left blank.
zipcode,rate (slcsp)
36749, 		State,AreaRate (zips)
		36749,AL,11   metal_level,rate (plans)
				AL,Silver,268.26,11	
				AL,Silver,256.21,11
				AL,Silver,271.77,11
				AL,Silver,261.81,11
				AL,Silver,263.3,11
				AL,Silver,248.17,11
	       	36749,AL,13
				AL,Silver,273.9,13
				AL,Silver,248.03,13
				AL,Silver,263.1,13
				AL,Silver,268.82,13
				AL,Silver,267.3,13
				AL,Silver,253.37,13
Test case 3:
A ZIP code can potentially be in more than one county. If the county can not be determined definitively by the ZIP code, it may still be possible to determine the rate area for that ZIP code. (Only if all Counties have the same area)
67118,KS,20077,Harper,6
67118,KS,20095,Kingman,6
67118,KS,20173,Sedgwick,6
67118,KS,20191,Sumner,6

zipcode,rate (slcsp)
67118, 212.35	State,AreaRate (zips)
		67118,KS,6,   metal_level,rate (plans)
			      	KS,Silver,224.31,6
			      	KS,Silver,236.85,6
			      	KS,Silver,236.24,6
			      	KS,Silver,212.35,6
			      	KS,Silver,251.06,6
	       			KS,Silver,212.35,6
			      	KS,Silver,245.15,6
			      	KS,Silver,218.83,6
			      	KS,Silver,237.4,6
			      	KS,Silver,228,6
			      	KS,Silver,195.46,6
			      	KS,Silver,236.85,6

Test case 4
A ZIp code exist in one State and Area rate, however there is no silver plan for that state 
zipcode,rate (slcsp)
40813 	        State,AreaRate (zips)
		40813,KY,8    metal_level,rate (plans)

Added slcsp_full.csv with additional columns to reference the State and Area Rate for each ZipCode and rate.

Shared my code via a publicly accessible Git repository.
Github.com hectorf2025/SecondLowestCost



