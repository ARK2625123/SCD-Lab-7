import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoListApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoListApp() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Task Input
        taskInput = new JTextField();
        add(taskInput, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Complete Task");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskText = taskInput.getText().trim();
                if (!taskText.isEmpty()) {
                    taskListModel.addElement(taskText);
                    taskInput.setText("");
                }
            }
        });

        // Delete Button Action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    taskListModel.remove(selectedIndex);
                }
            }
        });

        // Complete Button Action
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String taskText = taskListModel.get(selectedIndex);
                    taskListModel.set(selectedIndex, "[Completed] " + taskText);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListApp app = new ToDoListApp();
            app.setVisible(true);
        });
    }
}

