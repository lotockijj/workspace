package JavaRush7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* ������������ ����� ������� �� 20 �����
1. � ������ initializeArray():
1.1. �������� ������ �� 20 �����
1.2. �������� � ������� 20 ����� � ��������� ��� ������
2. ����� max(int[] array) ������ �������� ������������ ����� �� ��������� �������
*/
public class Solution{
    public static void main(String[] args) throws Exception{
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
    	int [] array = new int[20]; 
    	for(int i = 0; i < array.length; i++){
    		BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
        	String s1 = reader.readLine();
        	array[i] = Integer.parseInt(s1);
    	}
        //��������������� (�������� � ���������) ������ ���
        return array;
    }
    public static int max(int[] array) {
    	int maxx = array[0]; 
    	for(int i = 0; i < array.length; i++){
    		if(array[i]>maxx){
    			maxx = array[i]; 
    		}
    	}
        //������� ������������ �������� � ���� ������
        return maxx;
    }
}
/*
public static void main(String[] args) throws Exception {
    int[] array = initializeArray();
    int max = max(array);
    System.out.println(max);
}
public static int[] initializeArray() throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
int massiv[] = new int[20]; // ������� ������ �� 20 �����
for(int j = 0; j < 20; j++ ){ // ���� for
int i = Integer.parseInt(reader.readLine()); // ���������� i - ���� � ����������
massiv[j] = i; // � ������ ������ ������� � ������ i
              }
        return massiv; // ���������� ������ ����???? 
}
     public static int max(int[] array) { // ����� �������� ��� ������ ������� int max, ������ ��������, ������ ����� ����� �������� �� ���???
      int max = array[0]; // ��������, ��� ���������� max ��������� �������� array[0] 
         for (int i = 0; i < array.length; i++){ // �������� ����� �������
        if (array[i] > max ) //���� ����� ���� �� ������� ������ ��� max 
            max = array[i]; // �� max ����������� ���� �������� �������
    }
     return max; // ���������� max - ���� ��� ���������� �� ������� , ����� � sout 
}
}
*/