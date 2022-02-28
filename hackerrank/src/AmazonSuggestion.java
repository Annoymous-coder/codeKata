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



class Resultado {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {

        List<List<String>> suggestions = new ArrayList<>();

        for (int i = 0; i < customerQuery.length()-1; i++) {
            List<String> sugestoes = new ArrayList<>();
            for (int j = 0 ; j < repository.size(); j++) {
                if (repository.get(j).contains(customerQuery.substring(0, Math.min(i+2, customerQuery.length())))) {
                    sugestoes.add(repository.get(j));
                }
            }

            //[1,2,3,4,5,6]
            sugestoes.sort((a,b) -> a.compareTo(b));
            if (sugestoes.size() > 3) {
                for (int l = 3; l < sugestoes.size() - 1; l++) {
                    sugestoes.remove(l);
                    sugestoes.remove(l-1);
                }
            }
            suggestions.add(sugestoes);


        }
        return suggestions;
    }
}

public class AmazonSuggestion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int repositoryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> repository = IntStream.range(0, repositoryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String customerQuery = bufferedReader.readLine();

        List<List<String>> result = Resultado.searchSuggestions(repository, customerQuery);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
