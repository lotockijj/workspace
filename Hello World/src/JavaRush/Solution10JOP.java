package JavaRush;
import javax.swing.JOptionPane;

public class Solution10JOP {
	int i1, i2, i3;
	public int i;
	
	public void Scan(){
		i1 = Integer.parseInt(JOptionPane.showInputDialog("������ ����� �����"));
		i2 = Integer.parseInt(JOptionPane.showInputDialog("������ ����� �����"));
		i3 = Integer.parseInt(JOptionPane.showInputDialog("������ ����� �����"));
		
	}
	public void Scan(int a, int b, int c){
			JOptionPane.showMessageDialog(null, "ʳ������ ���������� ����� " + c);
			if (c == 3){
			JOptionPane.showMessageDialog(null, "ʳ������ ���������� ����� " + 0);
			}
			if (c == 2){
				JOptionPane.showMessageDialog(null, "ʳ������ ���������� ����� " + 1);
				}
			if (c == 1){
				JOptionPane.showMessageDialog(null, "ʳ������ ���������� ����� " + 2);
				}
			if (c == 0){
				JOptionPane.showMessageDialog(null, "ʳ������ ���������� ����� " + 3);
				}
			
	}
}
