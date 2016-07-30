import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdPanel extends JPanel {

    private JTextField idField;
    private JLabel idLabel;

    public IdPanel() {

        setLayout(new GridBagLayout());

        setPreferredSize(new Dimension(500, 70));

        idField = new JTextField(20);
       // idField.setCaret(new Font("Serif", Font.PLAIN, 20));

        idLabel = new JLabel("Enter ID:");
        idLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(9, 9, 9, 9);
        gc.anchor = GridBagConstraints.CENTER;
        add(idLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(idField, gc);
    }

    public void putText(String number) {
        idField.setText(idField.getText()+number);
    }
}
