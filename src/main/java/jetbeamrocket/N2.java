package jetbeamrocket;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N2 {

    public List<String> opcodesAsString = new ArrayList<>();
    public List<Integer> opcodesAsInt = new ArrayList<>();
    public List<Integer> opcodesAsIntRes = new ArrayList<>();

    public N2(String fileNam){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileNam));
            opcodesAsString = Arrays.stream(reader.readLine().split(",")).collect(Collectors.toList());
            for(int i = 1; i < opcodesAsString.size(); i++){ opcodesAsInt.add(Integer.parseInt(opcodesAsString.get(i)));}
            for(int i = 1; i < opcodesAsString.size(); i++){ opcodesAsIntRes.add(Integer.parseInt(opcodesAsString.get(i)));}
        }catch(Exception ie){
            ie.printStackTrace();
        }
    }
    public boolean opVerbNoun(){
        try{
        for(int noun = 0; noun <= 99; ++noun){
            for(int verb = 0; verb <= 99; ++verb){
                opcodesAsInt.clear();
                opcodesAsInt.addAll(opcodesAsIntRes);
                opcodesAsInt.set(1, noun);
                opcodesAsInt.set(2, verb);
                if(opCodeCalc() == 19690720){
                    System.out.println("answer " + ((100 * noun) + verb));
                    return true;
                }
            }
        }}catch(Exception ie){
            ie.printStackTrace();
        }
        return false;
    }

    public int opCodeCalc(){
        try{
        for (int i = 0; i < opcodesAsInt.size(); ++i) {
            switch (opcodesAsInt.get(i)) {
                case 1:
                    opcodesAsInt.set(opcodesAsInt.get(i + 3), opcodesAsInt.get(opcodesAsInt.get(i + 1)) + opcodesAsInt.get(opcodesAsInt.get(i + 2)));
                    i += 3;
                    break;
                case 2:
                    opcodesAsInt.set(opcodesAsInt.get(i + 3), opcodesAsInt.get(opcodesAsInt.get(i + 1)) * opcodesAsInt.get(opcodesAsInt.get(i + 2)));
                    i += 3;
                    break;
                case 99:
                    return opcodesAsInt.get(0);
            }
        }

        return opcodesAsInt.get(0);
        }catch(IndexOutOfBoundsException ie){
            return opcodesAsInt.get(0);
        }
    }
}
