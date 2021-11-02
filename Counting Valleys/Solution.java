package justTests;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int countingValleys(int steps, String path) {
        String[] stepsSplited = path.split("");
        int currentAltitude = 0;
        int enteredValley = 0;
        
        for (int i = 0; i < steps; i++) {
            if(stepsSplited[i] == "U") {
                currentAltitude++;
            } else if (stepsSplited[i] == "D") {
                currentAltitude--;
            }
            
            if (currentAltitude <= -1) {
                enteredValley++;
            }
        }
        /*
        quando o nivel do mar for pra -1 -> entrou num vale
        quando o nível do mar voltar pra 0 -> saiu do vale
        */
        return enteredValley; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
