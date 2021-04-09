import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    Pattern p1 = Pattern.compile("Horatio");
    Pattern p2 = Pattern.compile("Hamlet");

    public HamletParser(){
        this.hamletData = loadFile();
    }

    public Boolean find(Pattern p){
        return p.matcher(hamletData).find();
    }

    public String change(Pattern p, String s1, String s2){
        return p.matcher(s1).replaceAll(s2);
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public Pattern getP1(){
        return p1;
    }

    public Pattern getP2(){
        return p2;
    }



}
