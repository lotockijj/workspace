package JavaRush8;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* ������� ���� �����, ���������� �����
������� ������� (Map<String, Date>) � ������� � ���� ������ ������� �� ��������: ��������� - ����� ���������.
������� �� ������� ���� �����, ���������� �����.
*/
public class Solution125{
    public static void main (String[] args) {
        HashMap<String, Date> map = createMap();
        for (Map.Entry<String, Date> pair : map.entrySet())
            System.out.print(pair.getKey() + " ");
        System.out.println("");
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
            System.out.print(pair.getKey()+" ");
    }
    public static HashMap<String, Date> createMap(){
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("��������", new Date("JUNE 1 1980"));
        map.put("������", new Date("APRIL 1 1970"));
        map.put("���������", new Date("SEPTEMBER 1 1980"));
        map.put("����������", new Date("AUGUST 1 1960"));
        map.put("������", new Date("JULY 1 1986"));
        map.put("���������", new Date("OCTOBER 1 1955"));
        map.put("�������", new Date("DECEMBER 1 1967"));
        map.put("����������", new Date("MAY 1 1954"));
        map.put("������������", new Date("NOVEMBER 1 1967"));
        map.put("�����������", new Date("DECEMBER 2 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map){
        ArrayList<String> keys = new ArrayList<String>();
        for (Map.Entry<String, Date> pair : map.entrySet()){
            if (pair.getValue().getMonth()==5 || pair.getValue().getMonth()==6 || pair.getValue().getMonth()==7)
                keys.add(pair.getKey());
        }
        for (String key : keys) map.remove(key);
    }

}