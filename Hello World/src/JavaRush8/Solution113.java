package JavaRush8;
import java.util.HashMap;
import java.util.Map;
/* ��������� HashMap �� �����
���� ����� Cat � ����� ��� (name, String).
������� ��������� HashMap<String, Cat>.
�������� � ��������� 10 �����, � �������� ����� ������������ ��� ����.
������� ��������� �� �����, ������ ������� � ����� ������.
*/
public class Solution113{
    public static void main(String[] args) throws Exception{
        String[] cats = new String[] {"������", "�����", "�����", "�����", "�����", "������", "����", "�����", "����", "�����"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()){
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    public static HashMap<String, Cat> addCatsToMap(String[] cats){
    	HashMap<String, Cat> c = new HashMap<String, Cat>(); 
    	for(String s : cats){
    		c.put(s, new Cat(s));  
    	}
    	return c;
        //�������� ��� ��� ���
    }
    public static class Cat{
        String name;

        public Cat(String name){
            this.name = name;
        }
        @Override
        public String toString(){
            return name != null ? name.toUpperCase() : null;
        }
    }
}
