import java.util.Scanner;
import java.util.ArrayList; 
import java.util.*;

public class oopsp1{  
    public static void getMedian(ArrayList<Double> nums){
        Collections.sort(nums);
        double median;
        if (nums.size()%2 == 0){
            median = (nums.get(nums.size()/2) + nums.get((nums.size() - 1)/2))/2;
        }
        else{
            median = (nums.get(nums.size()/2));
        }
        System.out.println("Median " + median);
    }

    public static double getMean(ArrayList<Double> nums){
        double sum = 0;
        for (int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
        }
        return (sum/nums.size());
    }

    public static void getMode(ArrayList<Double> nums){
        ArrayList<Double> mode = new ArrayList<Double>();
        double maxCount = 0;

        for(int i = 0; i < nums.size(); ++i){
            int count = 0;
            for(int j = 0; j < nums.size(); ++j){
                if(Double.compare(nums.get(i), nums.get(j)) == 0){
                    count++;
                }
            }
   
            if(count > maxCount){
               maxCount = count;
               mode.clear();
               mode.add(nums.get(i));
            }
            else if(count == maxCount){
                boolean dif = true;
                for(int j = 0; j < mode.size(); j++){
                    if(Double.compare(mode.get(j), nums.get(i)) == 0){
                        dif = false;
                    }
                }
                if(dif){
                    mode.add(nums.get(i));
                }
            }
        }
        System.out.println("Mode: " + mode);
    }  

    public static void getVariance(ArrayList<Double> nums){
        double mean = getMean(nums);
        double temp = 0;
        for(int i = 0; i < nums.size(); i++){
            temp += (nums.get(i) - mean) * (nums.get(i) - mean);
        }
        System.out.println("Variance: " + (temp/(nums.size()-1)));
    }

    public static double getSqrt(double num){
        double temp;
        double hold = num/2;
        do{
            temp = hold;
            hold = (temp + (num/temp))/2;
        }
        while((temp - hold) != 0);

        return hold;
    }

    public static void getSD(ArrayList<Double> nums){
        double mean = getMean(nums);
        double temp = 0;
        for(int i = 0; i < nums.size(); i++){
            temp += (nums.get(i) - mean) * (nums.get(i) - mean);
        }
        System.out.println("Standard Deviation: " + getSqrt((temp/(nums.size()))));
    }

    public static void getMinVal(ArrayList<Double> nums){
        System.out.println("Minimum Value: " + nums.get(0));
    }

    public static void getMaxVal(ArrayList<Double> nums){
        System.out.println("Maximmum Value: " + nums.get(nums.size()-1));
    }

    public static boolean isNum(String strNum) {
        if(strNum == null){
            return false;
        }
        try{
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);

        ArrayList<Double> nums = new ArrayList<Double>();
        boolean ans = false;

        String nl = s.nextLine();

        while(nl != null || nl == "-1"){
            if(nl.isEmpty()){
                break;
            }
            else if(!isNum(nl)){
                System.out.println("Number not entered");
                nl = s.nextLine();
            }
            else if(s.hasNextLine()){
                nums.add(Double.valueOf(nl));
                nl = s.nextLine();
                ans = true;
            }
            else{
                nl = null;
            }
        }

        if(ans){
            getMedian(nums);
            System.out.println("Mean: " + getMean(nums));
            getMode(nums);
            getVariance(nums);
            getSD(nums);
            getMinVal(nums);
            getMaxVal(nums);
        }
    }
}