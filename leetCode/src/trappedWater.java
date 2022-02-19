// { Driver Code Starts
import java.io.*;

class Array {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            //calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    long trappingWater(int arr[], int n) {
        int menor = 0;
        if (arr[n-1] > arr[0]) {
            menor = arr[0];
        } else {
            menor = arr[n-1];
        }

        int alturaDagua = menor;
        long agua = 0;

        long nivelDagua = 0;
        for (int i = 1; i <= (n - 2); i++) {
            if(arr[i] == 0) {
                agua += alturaDagua;
            } else {
                nivelDagua = alturaDagua - arr[i];
                agua += nivelDagua;
            }

        }
        return agua;
    }

}


