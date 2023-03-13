import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);;
    static Integer tries = 0;
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein!");
    static JTextField textField = new JTextField();
    public static void main(String[] args) {
       openUI();

    }

    public static void openUI() {
        JFrame frame = new JFrame("Zahlenraten");
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(50, 50, 350, 30);
        textField.setBounds(50, 100, 200, 30);

        JButton button = new JButton("Raten!");
        button.setBounds(50, 150, 200, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textFromTextfield = textField.getText();
                    Integer number = Integer.parseInt(textFromTextfield);
                    guess(number);
                } catch (Exception error) {
                    text.setText("Bitte gebe eine Zahl ein!");
                }
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void guess(Integer number) {
        if(number == myNumber) {
            text.setText("Hey, das war richtig! ");
            text.setText("<<<< Du hast " + tries + " Versuche gebraucht! >>>>");
        } else {
            tries++;
            if(number < myNumber) {
                text.setText("Die gesuchte Zahl ist größer!");
            } else {
                text.setText("Die gesuchte Zahl ist kleiner!");
            }
            textField.setText("");
        }
    }
}