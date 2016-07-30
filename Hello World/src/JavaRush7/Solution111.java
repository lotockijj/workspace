package JavaRush7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* “ри массива
1. ¬веди с клавиатуры 20 чисел, сохрани их в список и рассортируй по трЄм другим спискам:
„исло делитс€ на 3 (x%3==0), делитс€ на 2 (x%2==0) и все остальные.
„исла, которые дел€тс€ на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. ћетод printList должен выводить на экран все элементы списка с новой строки.
3. »спользу€ метод printList выведи эти три списка на экран. —начала тот, который дл€ x%3, потом тот, который дл€ x%2, потом последний.
 */
public class Solution111{
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int i = 0; i < 20; i++){
			String s = reader.readLine();
			int s1 = Integer.parseInt(s);
			a.add(i, s1);
		}
		for(int i = 0; i <a.size(); i++){
			if( a.get(i)%3 ==0){
				a3.add(a.get(i));
			} else if(a.get(i)%2 ==0){
				a2.add(a.get(i));
			}else if( a.get(i)%6 == 0){
				a3.add(a.get(i));
				a2.add(a.get(i));
			} 
			else if( (a.get(i)%3 != 0) & (a.get(i)%2 != 0) ){
				ar.add(a.get(i));
			}
		}
		printList(a3); 
		printList(a2);
		printList(ar); 
	}

	public static void printList(List<Integer> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
