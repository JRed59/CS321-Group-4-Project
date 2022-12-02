import java.io.File;
import java.io.IOException;
import java.util.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

import com.jayway.jsonpath.*;
import com.jayway.jsonpath.internal.JsonContext;

import static java.util.stream.Collectors.toMap;


//Class which carries out the process of determining what restaurants are both open and the closest
public class restaurantFinder {
    public DocumentContext jsonContext;
    public ArrayList<String> nearbyRestaurants = new ArrayList<String>();
    public ArrayList<String> nearbyDists = new ArrayList<String>();
    public  ArrayList<String> openRestaurants = new ArrayList<String>();
    public ArrayList<String> openRestaurantAcronyms = new ArrayList<String>();

    public String getAcr(String location) {
        if (location.equalsIgnoreCase("Bevill Center")) {
            return "BEV";

        } else if (location.equalsIgnoreCase("Business Administration Building")) {
            return "BAB";

        } else if (location.equalsIgnoreCase("Business Services Building")) {
            return "BSB";

        } else if (location.equalsIgnoreCase("Central Receiving & Shipping")) {
            return "REC";

        } else if (location.equalsIgnoreCase("Charger Union")) {
            return "CGU";

        } else if (location.equalsIgnoreCase("Conference Training Center")) {
            return "CTC";

        } else if (location.equalsIgnoreCase("Cramer Research Hall")) {
            return "CRH";

        } else if (location.equalsIgnoreCase("Early Learning Center")) {
            return "ELC";

        } else if (location.equalsIgnoreCase("Engineering Building")) {
            return "ENG";

        } else if (location.equalsIgnoreCase("Intermodal Parking Facility")) {
            return "IMF";

        } else if (location.equalsIgnoreCase("Invention to Innovation Center")) {
            return "I2C";

        } else if (location.equalsIgnoreCase("Johnson Research Center")) {
            return "JRC";

        } else if (location.equalsIgnoreCase("Materials Science Building")) {
            return "MSB";

        } else if (location.equalsIgnoreCase("Morton Hall")) {
            return "MOR";
        } else if (location.equalsIgnoreCase("Nursing Building")) {
            return "NUR";
        } else if (location.equalsIgnoreCase("Olin B. King Technology Hall")) {
            return "OKT";
        } else if (location.equalsIgnoreCase("Optics Building")) {
            return "OPB";
        } else if (location.equalsIgnoreCase("Physical Plant Building")) {
            return "SPR";
        } else if (location.equalsIgnoreCase("Roberts Hall")) {
            return "PPB";
        } else if (location.equalsIgnoreCase("Salmon Library")) {
            return "ROB";
        } else if (location.equalsIgnoreCase("Shelbie King Hall")) {
            return "LIB";
        } else if (location.equalsIgnoreCase("Shelby Center for Sci. & Tech.")) {
            return "SKH";
        } else if (location.equalsIgnoreCase("Spragins Hall")) {
            return "SST";
        } else if (location.equalsIgnoreCase("Student Services Building")) {
            return "SSB";
        } else if (location.equalsIgnoreCase("SWIRLL")) {
            return "SWI";
        } else if (location.equalsIgnoreCase("University Fitness Center")) {
            return "UFC";
        } else if (location.equalsIgnoreCase("Union Grove Gallery")) {
            return "UGG";
        } else if (location.equalsIgnoreCase("von Braun Research Hall")) {
            return "VBH";
        } else if (location.equalsIgnoreCase("Wilson Hall")) {
            return "WIL";
        } else if (location.equalsIgnoreCase("WLRH Radio Station")) {
            return "LBH";
        }
        else
            return"location";
    }
    //public void initAcro()

    /**
         * Determines what restaurants are open and adds them to the Arraylist of open restaurants
         * @param currentClassEnd Current time if not checking schedule, or end of class selected in schedule
         * @param day Current day or day of selected class
         */
    public void findOpenRestaurants(LocalTime currentClassEnd, String day) {
        try {
            this.openRestaurants = new ArrayList<String>();

            File dataSource = new File("src/restaurants.json").getAbsoluteFile();
            this.jsonContext = JsonPath.parse(dataSource);


                //region Get Hours for Restaurants

            LocalTime CBHMopen = LocalTime.parse(jsonContext.read("$.CBH.MTHOpen"));
            LocalTime CBHMClose = LocalTime.parse(jsonContext.read("$.CBH.MTHClose"));
            LocalTime CBHFOpen = LocalTime.parse(jsonContext.read("$.CBH.FOpen"));
            LocalTime CBHFClose = LocalTime.parse(jsonContext.read("$.CBH.FClose"));

            LocalTime BBMopen = LocalTime.parse(jsonContext.read("$.BBowl.MTHOpen"));
            LocalTime BBMClose = LocalTime.parse(jsonContext.read("$.BBowl.MTHClose"));
            LocalTime BBFOpen = LocalTime.parse(jsonContext.read("$.BBowl.FOpen"));
            LocalTime BBFClose = LocalTime.parse(jsonContext.read("$.BBowl.FClose"));

            LocalTime CFAMopen = LocalTime.parse(jsonContext.read("$.CFA.MTHOpen"));
            LocalTime CFAMClose = LocalTime.parse(jsonContext.read("$.CFA.MTHClose"));
            LocalTime CFAFOpen = LocalTime.parse(jsonContext.read("$.CFA.FOpen"));
            LocalTime CFAFClose = LocalTime.parse(jsonContext.read("$.CFA.FClose"));

            LocalTime PJMopen = LocalTime.parse(jsonContext.read("$.PJs.MTHOpen"));
            LocalTime PJHMClose = LocalTime.parse(jsonContext.read("$.PJs.MTHClose"));

            LocalTime CBrewMopen = LocalTime.parse(jsonContext.read("$.CBrew.MTHOpen"));
            LocalTime CBrewClose = LocalTime.parse(jsonContext.read("$.CBrew.MTHClose"));
            LocalTime CBrewFOpen = LocalTime.parse(jsonContext.read("$.CBrew.FOpen"));
            LocalTime CBrewFClose = LocalTime.parse(jsonContext.read("$.CBrew.FClose"));

            LocalTime DDMopen = LocalTime.parse(jsonContext.read("$.DD.MTHOpen"));
            LocalTime DDMClose = LocalTime.parse(jsonContext.read("$.DD.MTHClose"));
            LocalTime DDFSSOpen = LocalTime.parse(jsonContext.read("$.DD.FSSOpen"));
            LocalTime DDFSSClose = LocalTime.parse(jsonContext.read("$.DD.FSSClose"));

            LocalTime MBMTSuopen = LocalTime.parse(jsonContext.read("$.MB.MTHSuOpen"));
            LocalTime MBMTSuClose = LocalTime.parse(jsonContext.read("$.MB.MTHSuClose"));
            LocalTime MBFOpen = LocalTime.parse(jsonContext.read("$.MB.FOpen"));
            LocalTime MBFClose = LocalTime.parse(jsonContext.read("$.MB.FClose"));

            LocalTime TDMopen = LocalTime.parse(jsonContext.read("$.TD.MTHOpen"));
            LocalTime TDMClose = LocalTime.parse(jsonContext.read("$.TD.MTHClose"));
            LocalTime TDFOpen = LocalTime.parse(jsonContext.read("$.TD.FOpen"));
            LocalTime TDFClose = LocalTime.parse(jsonContext.read("$.TD.FClose"));
            LocalTime TDSSOpen = LocalTime.parse(jsonContext.read("$.TD.SSOpen"));
            LocalTime TDSSClose = LocalTime.parse(jsonContext.read("$.TD.SSClose"));

            LocalTime CCBMOpen = LocalTime.parse(jsonContext.read("$.CC.MTHBOpen"));
            LocalTime CCBMClose = LocalTime.parse(jsonContext.read("$.CC.MTHBClose"));
            LocalTime CCBFOpen = LocalTime.parse(jsonContext.read("$.CC.FBOpen"));
            LocalTime CCBFClose = LocalTime.parse(jsonContext.read("$.CC.FBClose"));
            LocalTime CCBSSOpen = LocalTime.parse(jsonContext.read("$.CC.SSBOpen"));
            LocalTime CCBSSClose = LocalTime.parse(jsonContext.read("$.CC.SSBClose"));
            LocalTime CCLMOpen = LocalTime.parse(jsonContext.read("$.CC.MTHLOpen"));
            LocalTime CCLMClose = LocalTime.parse(jsonContext.read("$.CC.MTHLClose"));
            LocalTime CCLFOpen = LocalTime.parse(jsonContext.read("$.CC.FLOpen"));
            LocalTime CCLFClose = LocalTime.parse(jsonContext.read("$.CC.FLClose"));
            LocalTime CCLSSOpen = LocalTime.parse(jsonContext.read("$.CC.SSLOpen"));
            LocalTime CCLSSClose = LocalTime.parse(jsonContext.read("$.CC.SSLClose"));
            LocalTime CCDMOpen = LocalTime.parse(jsonContext.read("$.CC.MTHDOpen"));
            LocalTime CCDMClose = LocalTime.parse(jsonContext.read("$.CC.MTHDClose"));
            LocalTime CCDFOpen = LocalTime.parse(jsonContext.read("$.CC.FDOpen"));
            LocalTime CCDFClose = LocalTime.parse(jsonContext.read("$.CC.FDClose"));
            LocalTime CCDSSOpen = LocalTime.parse(jsonContext.read("$.CC.SSDOpen"));
            LocalTime CCDSSClose = LocalTime.parse(jsonContext.read("$.CC.SSDClose"));
                //endregion

            //Determines what restaurants are open at the provided class end time and day of week

            if (DayOfWeek.valueOf(day).getValue() < 5) {
                if (currentClassEnd.compareTo(CBHMopen) >= 0) {
                    if (currentClassEnd.compareTo(CBHMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CBH.Name"));
                    }
                }
                if (currentClassEnd.compareTo(BBMopen) >= 0) {
                    if (currentClassEnd.compareTo(BBMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.BBowl.Name"));
                    }
                }
                if (currentClassEnd.compareTo(CFAMopen) >= 0) {
                    if (currentClassEnd.compareTo(CFAMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CFA.Name"));
                    }
                }
                if (currentClassEnd.compareTo(PJMopen) >= 0) {
                    if (currentClassEnd.compareTo(PJHMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.PJs.Name"));
                    }
                }
                if (currentClassEnd.compareTo(CBrewMopen) >= 0) {
                    if (currentClassEnd.compareTo(CBrewClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CBrew.Name"));
                    }
                }
                if (currentClassEnd.compareTo(DDMopen) >= 0) {
                    if (currentClassEnd.compareTo(DDMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.DD.Name"));
                    }
                }
                if (currentClassEnd.compareTo(MBMTSuopen) >= 0) {
                    if (currentClassEnd.compareTo(MBMTSuClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.MB.Name"));
                    }
                }
                if (currentClassEnd.compareTo(TDMopen) >= 0) {
                    if (currentClassEnd.compareTo(TDMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.TD.Name"));
                    }
                }
                if (currentClassEnd.compareTo(CCBMOpen) >= 0) {
                    if (currentClassEnd.compareTo(CCBMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                    }
                } else if (currentClassEnd.compareTo(CCLMOpen) >= 0) {
                    if (currentClassEnd.compareTo(CCLMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                    }
                } else if (currentClassEnd.compareTo(CCDMOpen) >= 0) {
                    if (currentClassEnd.compareTo(CCDMClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                    }
                }

            }
            else if (DayOfWeek.valueOf(day).getValue() == 5) {
                if (currentClassEnd.compareTo(CBHFOpen) >= 0) {
                    if (currentClassEnd.compareTo(CBHFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CBH.Name"));
                    }
                }
                if (currentClassEnd.compareTo(BBFOpen) >= 0) {
                    if (currentClassEnd.compareTo(BBFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.BBowl.Name"));
                    }
                }
                if (currentClassEnd.compareTo(CFAFOpen) >= 0) {
                    if (currentClassEnd.compareTo(CFAFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CFA.Name"));
                    }
                }
                if (currentClassEnd.compareTo(CBrewFOpen) >= 0) {
                    if (currentClassEnd.compareTo(CBrewFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CBrew.Name"));
                    }
                }
                if (currentClassEnd.compareTo(DDFSSOpen) >= 0) {
                    if (currentClassEnd.compareTo(DDFSSClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.DD.Name"));
                    }
                }
                if (currentClassEnd.compareTo(MBFOpen) >= 0) {
                    if (currentClassEnd.compareTo(MBFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.MB.Name"));
                    }
                }
                if (currentClassEnd.compareTo(TDFOpen) >= 0) {
                    if (currentClassEnd.compareTo(TDFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.TD.Name"));
                    }
                }
                if (currentClassEnd.compareTo(CCBFOpen) >= 0) {
                    if (currentClassEnd.compareTo(CCBFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                    }
                } else if (currentClassEnd.compareTo(CCLFOpen) >= 0) {
                    if (currentClassEnd.compareTo(CCLFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                    }
                } else if (currentClassEnd.compareTo(CCDFOpen) >= 0) {
                    if (currentClassEnd.compareTo(CCDFClose) < 0) {
                        this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                    }
                }


            }
            else if (DayOfWeek.valueOf(day).getValue() > 5) {

                    if (currentClassEnd.compareTo(DDFSSOpen) >= 0) {
                            if (currentClassEnd.compareTo(DDFSSClose) < 0) {
                                    this.openRestaurants.add(jsonContext.read("$.DD.Name"));
                            }
                    }
                    if (DayOfWeek.valueOf(day).getValue() == 7){
                        if (currentClassEnd.compareTo(MBMTSuopen) >= 0) {
                            if (currentClassEnd.compareTo(MBMTSuClose) < 0) {
                                    this.openRestaurants.add(jsonContext.read("$.MB.Name"));
                            }
                    }
                    }
                    if (currentClassEnd.compareTo(TDSSOpen) >= 0) {
                            if (currentClassEnd.compareTo(TDSSClose) < 0) {
                                    this.openRestaurants.add(jsonContext.read("$.TD.Name"));
                            }
                    }
                    if (currentClassEnd.compareTo(CCBSSOpen) >= 0) {
                            if (currentClassEnd.compareTo(CCBSSClose) < 0) {
                                    this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                            }
                    } else if (currentClassEnd.compareTo(CCLSSOpen) >= 0) {
                            if (currentClassEnd.compareTo(CCLSSClose) < 0) {
                                    this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                            }
                    } else if (currentClassEnd.compareTo(CCDSSOpen) >= 0) {
                            if (currentClassEnd.compareTo(CCDSSClose) < 0) {
                                    this.openRestaurants.add(jsonContext.read("$.CC.Name"));
                            }
                    }


            }
            for(int i = 0; i< openRestaurants.size();i++){
            if(String.valueOf(openRestaurants.get(i)) .equalsIgnoreCase("CStore and Boar's Head")){
                this.openRestaurantAcronyms.add("CBH");
            }
            else if(String.valueOf(openRestaurants.get(i)).equalsIgnoreCase("Burrito Bowl")){
                this.openRestaurantAcronyms.add("BBowl");
            }
            else if(String.valueOf(openRestaurants.get(i)).equalsIgnoreCase("Chick-Fil-A")){
                this.openRestaurantAcronyms.add("CFA");
            }
            else if(String.valueOf(openRestaurants.get(i)).equalsIgnoreCase("Papa John's")){
                this.openRestaurantAcronyms.add("PJs");
            }
            else if(String.valueOf(openRestaurants.get(i)).equalsIgnoreCase("Charger Brew")){
                this.openRestaurantAcronyms.add("CBrew");
            }
            else if(String.valueOf(openRestaurants.get(i)).equalsIgnoreCase( "Charger Cafe")){
                this.openRestaurantAcronyms.add("CC");
            }
            else if(String.valueOf(openRestaurants.get(i)).equalsIgnoreCase("Dunkin Donuts")){
                this.openRestaurantAcronyms.add("DD");
            }
            else if(openRestaurants.get(i).equalsIgnoreCase( "Mein Bowl")){
                this.openRestaurantAcronyms.add("MB");
            }
            else if(openRestaurants.get(i).equalsIgnoreCase( "The Den")){
                this.openRestaurantAcronyms.add("TD");
            }
        }
    } catch (IOException except) {
        System.out.println("IO error");

    }
    }

    public String closestRestaurants(ArrayList<String> openRestaurantsAcronyms, ArrayList<String> openRestaurants, String currentBuilding, LocalTime currentClassEnd, LocalTime nextClassStart, int transport, String nextClassLocation){

                this.nearbyDists = new ArrayList<String>();
                this.nearbyRestaurants = new ArrayList<String>();

        String transportMethod = "walk";
        Integer tempTime = 0;
        LocalTime tT;
        Boolean drive = false;
        if (transport == 0){
            transportMethod= "driv";
            for(int i = 0; i< openRestaurantsAcronyms.size(); i++){
                tempTime = 0;
                tempTime += Integer.parseInt(jsonContext.read("$." + openRestaurantsAcronyms.get(i) + "." + currentBuilding).toString());

                if(nextClassStart != null);{
                    tempTime+=Integer.parseInt(jsonContext.read("$." + openRestaurantsAcronyms.get(i) + "." + nextClassLocation).toString());
                        this.nearbyRestaurants.add(openRestaurants.get(i));
                        this.nearbyDists.add(String.valueOf(tempTime));

                }
            }
        }
        else{
            transportMethod = "walk";
            for(int i = 0; i< openRestaurantsAcronyms.size(); i++){
                tempTime = 0;
                tempTime = Integer.parseInt(jsonContext.read("$." + openRestaurantsAcronyms.get(i) + "." + currentBuilding + "walk").toString());
                if(nextClassStart != null);{
                    tempTime = tempTime + Integer.parseInt(jsonContext.read("$." + openRestaurantsAcronyms.get(i) + "." + nextClassLocation + "walk").toString());
                    if ((currentClassEnd.plusMinutes(tempTime)).compareTo(nextClassStart) == -1){
                        this.nearbyRestaurants.add(openRestaurants.get(i));
                        this.nearbyDists.add(tempTime.toString());
                    }}
                }
            }


        if (nearbyRestaurants != null) {

            String resString = "";
                  resString = resString.join(resString,  "The closest restaurants are " + this.nearbyRestaurants + " with total " + transportMethod+ "ing distances of " +this.nearbyDists + " respectively");
                return resString;
            }


        else {
            return "There are no open restaurants you can reach within your time frame";
        }
    }
    public String viewRestaurants(){
        String oRString = "Open restaurants\n";
        for (String a:openRestaurants
        ) {
            oRString+= a +'\n';
        }
        return oRString;
    }
}



