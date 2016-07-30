package JavaRush8;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* ���������� ��� � �������
������� ������� (Map<String, String>) ������� � ���� ������ ������� �� �������� ��������� - �����.
��������� ������� ����� ����� ����������� � �������� ��� ��� �������.
*/
public class Solution124{
	public static HashMap<String, String> createMap(){
        Map<String, String> map = new HashMap<String,String>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Herov", "Her");
        map.put("Dul'kin", "Dula");
        map.put("Petin", "Afanasiy");
        map.put("Sidorov", "Semen");
        map.put("Pen", "Semen");
        map.put("Nosin", "Napoleon");
        map.put("PUtin", "Semen");
        map.put("Cherezzabornogyzaderi", "Petr");
        return (HashMap<String, String>) map;
    }
    public static int getCountTheSameFirstName(HashMap<String, String> map, String name){
        int count =0;
        for (Map.Entry<String,String> pair: map.entrySet()){
            if (pair.getValue().equals(name))
                count++;
        }
        return count;
    }
    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya){
        int count =0;
        for (Map.Entry<String,String> pair: map.entrySet()){
            if (pair.getKey().equals(familiya))
                count++;
        }
        return count;
    }
}