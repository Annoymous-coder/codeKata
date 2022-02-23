// { Driver Code Starts
import java.util.*;
    
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int t = sc.nextInt();
    
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
    
            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
                
            SubarrayWithGivenSum obj = new SubarrayWithGivenSum();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }
}
    
    
class SubarrayWithGivenSum
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int i = 0, j = 0;
        ArrayList<Integer> auxList = new ArrayList<>();
           
        while (i < n) 
        {
            int soma = arr[i];
            
            if (soma == s) { //deu certo
                auxList.add(i+1); //retorna a 1 pos
                auxList.add(j+1); //retorna a ultima pos
                return auxList;
            }
            j = i + 1;
            while (j < n) {
                soma += arr[j];
                if (soma == s) {
                    auxList.add(i+1);
                    auxList.add(j+1);
                    return auxList;
                }   
                if (soma > s) {
                    break;
                }
                j++;
            }
            i++;
        }
        auxList.add(-1);
        return auxList;
    }
}