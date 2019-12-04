package jetbeamrocket;
import java.lang.*;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class N1 {

    public ArrayList<String> numbers = new ArrayList<>();
    public double finalResult;


    public N1(String file) {
        try {
            Scanner s = new Scanner(new File(file));
            s.useLocale(Locale.US);
            while(s.hasNext()){
                numbers.add(s.nextLine());
            }
            s.close();
        } catch(IOException ie){
            System.out.println("FAIL");
        }
    }

    public void parseAndCalc(){
        for(int i = 1; i < numbers.size(); i++ ){
            double asd = convertStringToDouble(numbers.get(i));
            calculateN2(asd);
        }
        System.out.println(finalResult);
    }

    public void calculateN2(double d){
        while(d >= 0){
            if(d > 8){ finalResult = finalResult + Math.floor(d/3) - 2; }
            d = Math.floor(d/3) - 2;
        }
    }

    public void calculateN1(double d){
        finalResult = finalResult + Math.floor(d/3) - 2;
        System.out.println(finalResult);
    }

    public double convertStringToDouble(String a) {
        try{
        NumberFormat nf = NumberFormat.getInstance();
        double number = nf.parse(a).doubleValue();
        return number;} catch(ParseException ie){
            System.out.println("fail");
        }
        return 0;
    }
}
