import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalendarApp {
    private JFrame frame;
    private JPanel calendarPanel;
    private JPanel eventPanel;
    private JComboBox<String> monthSelector;
    private JButton prevMonthButton;
    private JButton nextMonthButton;
    private JButton addEventButton;
    private JButton viewEventsButton;
    private JTextArea eventTextArea;

    private List<String> events = new ArrayList<>();

    public CalendarApp() {
        frame = new JFrame("Monthly Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        calendarPanel = new JPanel(new BorderLayout());
        eventPanel = new JPanel(new BorderLayout());

        monthSelector = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        prevMonthButton = new JButton("Previous Month");
        nextMonthButton = new JButton("Next Month");

        calendarPanel.add(monthSelector, BorderLayout.NORTH);
        calendarPanel.add(prevMonthButton, BorderLayout.WEST);
        calendarPanel.add(nextMonthButton, BorderLayout.EAST);

        eventTextArea = new JTextArea(10, 20);
        eventTextArea.setEditable(false);

        addEventButton = new JButton("Add Event");
        viewEventsButton = new JButton("View Events");

        eventPanel.add(eventTextArea, BorderLayout.CENTER);
        eventPanel.add(addEventButton, BorderLayout.WEST);
        eventPanel.add(viewEventsButton, BorderLayout.EAST);

        frame.add(calendarPanel, BorderLayout.NORTH);
        frame.add(eventPanel, BorderLayout.SOUTH);

        prevMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to display the previous month
            }
        });

        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to display the next month
            }
        });

        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String event = JOptionPane.showInputDialog(frame, "Enter the event description:");
                if (event != null && !event.isEmpty()) {
                    events.add(event);
                }
            }
        });

        viewEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder eventList = new StringBuilder();
                for (String event : events) {
                    eventList.append(event).append("\n");
                }
                eventTextArea.setText(eventList.toString());
            }
        });

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalendarApp();
            }
        });
    }
}
