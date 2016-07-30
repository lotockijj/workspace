package JavaRush9;
/* �������������� ����������
1. ���� ��� ���������� ��������������� �������������� �� Exception:
2. class Exception1 extends  Exception
3. class Exception2 extends  Exception1
4. class Exception3 extends  Exception2
5. ���� �����, ������� ������ ���:
5.1. public static void method1() throws Exception1, Exception2, Exception3
6. ������ catch, ������� ���������� ��� ��� Exception1, Exception2 � Exception3
*/
public class Solution12{
    public static void main(String[] args) throws Exception{
      //�������� ��� ��� ���
    	try{
            method1();
    	} catch (Exception3 e){
    		System.out.println(e);
    	}
    	catch (Exception2 e){
    		System.out.println(e);
    	}
    	catch (Exception1 e){
    		System.out.println(e);
    	}
      //�������� ��� ��� ���
    }
    public static void method1() throws Exception1, Exception2, Exception3{
        int i = (int) (Math.random() * 3);
        if (i == 0)
            throw new Exception1();
        if (i == 1)
            throw new Exception2();
        if (i == 2)
            throw new Exception3();
    }
}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception2 {
}