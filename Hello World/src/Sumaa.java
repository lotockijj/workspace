import java.util.Scanner;

public class Sumaa {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int x=0, y;
		System.out.println("������ ���������� ��� ���������� �����");
		x=input.nextInt();
		input.close();
        y = x % 100;
        System.out.println("���� ���� ����� = " + (x / 100 + y / 10 + y % 10));
	}
}
