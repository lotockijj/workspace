package JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* —ортировка трех чисел
¬вести с клавиатуры три числа, и вывести их в пор€дке убывани€.
*/
public class Three{
    public static void main(String[] args) throws Exception{
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        int n1 = Integer.parseInt(reader.readLine());
        arr[0] = n1;
        int n2 = Integer.parseInt(reader.readLine());
        arr [1] = n2;
        int n3 = Integer.parseInt(reader.readLine());
        arr [2] = n3;
        sort(arr);
        for (int i = arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
        }
     }
    public static void sort (int []arr){
        for (int i =0; i < arr.length;i++){
            int min = arr [i];
            int i_min = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<min){
                    min = arr [j];
                    i_min = j;
                }
            }
            if (i!=i_min){
                int tmp = arr [i];
                arr [i]= arr [i_min];
                arr [i_min]=tmp;
            }
        }
    }
}