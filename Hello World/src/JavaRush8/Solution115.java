package JavaRush8;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/* ������� �� ����� ������ ��������
���� ��������� HashMap<String, String>, ���� ������� 10 ��������� �����.
������� �� ����� ������ ��������, ������ ������� � ����� ������.
*/
public class Solution115{
    public static void main(String[] args) throws Exception{
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    public static void printValues(Map<String, String> map){
    	for(Entry<String, String> pair : map.entrySet()){
    		System.out.println(pair.getValue());
    	}
        //�������� ��� ��� ���
    }

}
