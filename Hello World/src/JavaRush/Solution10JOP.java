package JavaRush;
import javax.swing.JOptionPane;

public class Solution10JOP {
	int i1, i2, i3;
	public int i;
	
	public void Scan(){
		i1 = Integer.parseInt(JOptionPane.showInputDialog("Введіть перше число"));
		i2 = Integer.parseInt(JOptionPane.showInputDialog("Введіть друге число"));
		i3 = Integer.parseInt(JOptionPane.showInputDialog("Введіть друге число"));
		
	}
	public void Scan(int a, int b, int c){
			JOptionPane.showMessageDialog(null, "Кількість позитивних чисел " + c);
			if (c == 3){
			JOptionPane.showMessageDialog(null, "Кількість негативних чисел " + 0);
			}
			if (c == 2){
				JOptionPane.showMessageDialog(null, "Кількість негативних чисел " + 1);
				}
			if (c == 1){
				JOptionPane.showMessageDialog(null, "Кількість негативних чисел " + 2);
				}
			if (c == 0){
				JOptionPane.showMessageDialog(null, "Кількість негативних чисел " + 3);
				}
			
	}
}
