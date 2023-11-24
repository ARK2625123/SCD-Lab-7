import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task1 {
    private JButton CLICKMEButton;
    private JPanel panel1;
    private JLabel label;
    int count;
    private JFrame f1;


    task1()
    {
        count=0;
        f1=new JFrame();
        panel1=new JPanel();
        panel1.setSize(300,300);
        f1.setSize(300,300);
        panel1.setVisible(true);
        panel1.add(label);
        panel1.add(CLICKMEButton);
        f1.add(panel1);
        f1.setVisible(true);
        CLICKMEButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText(Integer.toString(count));
            }
        });
    }
    public static void main(String args[])
    {
        task1 t=new task1();
    }
}
