import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyApplication {
    private JFrame myframe; // instance variable of a JFrame
    private JDialog mydialog;

    public MyApplication() {
        super();
        myframe = new JFrame(); // instantiation
        myframe.setSize(new Dimension(400, 75));
        myframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNewWindow = new JButton("Open New Window");
        btnNewWindow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mydialog = new JDialog();
                mydialog.setSize(new Dimension(400,100));
                mydialog.setTitle("I got you! You can't click on your JFrame now!");
                mydialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // prevent user from doing something else
                mydialog.setVisible(true);
            }
        });
        myframe.getContentPane().add(btnNewWindow);

        JButton btnCloseProgram = new JButton("Close Program :(");
        btnCloseProgram.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myframe.dispose();
            }
        });
        myframe.getContentPane().add(btnCloseProgram);
        myframe.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MyApplication();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}