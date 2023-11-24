import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar {
    private JFrame frame;
    private JPanel panel;
    private JProgressBar progressBar;
    private JButton startButton;
    private JButton resetButton;
    private Timer timer;
    private int progressValue;

    public ProgressBar() {
        frame = new JFrame("Progress Bar Demo");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        startButton = new JButton("Start");
        resetButton = new JButton("Reset");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProgressBar();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetProgressBar();
            }
        });

        panel.add(progressBar);
        panel.add(startButton);
        panel.add(resetButton);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setVisible(true);

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressValue < 100) {
                    progressValue++;
                    progressBar.setValue(progressValue);
                } else {
                    timer.stop();
                }
            }
        });
    }

    private void startProgressBar() {
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    private void resetProgressBar() {
        timer.stop();
        progressValue = 0;
        progressBar.setValue(progressValue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgressBar();
            }
        });
    }
}
