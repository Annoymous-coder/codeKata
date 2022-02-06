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

    public static int hourglassSum(List<List<Integer>> arr) {

        int qtdLinhas = arr.size();
        int qtdColunas = arr.get(0).size();
        int total = 0;
        int max = Integer.MIN_VALUE;

        for (int linha = 0; linha < qtdLinhas; linha++) {
            for (int coluna = 0; coluna < qtdColunas; coluna++) {
                total = arr.get(linha).get(coluna) + arr.get(linha).get(coluna+1) + arr.get(linha).get(coluna+2);
                total += arr.get(linha+1).get(coluna+1);
                total += arr.get(linha+2).get(coluna) + arr.get(linha+2).get(coluna+1) + arr.get(linha+2).get(coluna+2);
                max = Math.max(total, max);
            }
        }
        return max;
    }

}

public class ArrayDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
