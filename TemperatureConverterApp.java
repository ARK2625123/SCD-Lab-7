import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp extends JFrame {
    private JTextField temperatureField;
    private JComboBox<String> sourceUnitComboBox;
    private JComboBox<String> targetUnitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public TemperatureConverterApp() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Fields
        JPanel inputPanel = new JPanel();
        temperatureField = new JTextField(10);
        inputPanel.add(temperatureField);

        // Combo Boxes
        String[] units = {"Celsius to Fahrenheit", "Fahrenheit to Celsius"};
        sourceUnitComboBox = new JComboBox<>(units);
        targetUnitComboBox = new JComboBox<>(units);
        inputPanel.add(sourceUnitComboBox);
        add(inputPanel, BorderLayout.NORTH);

        // Conversion Button
        convertButton = new JButton("Convert");
        add(convertButton, BorderLayout.CENTER);

        // Result Label
        resultLabel = new JLabel("Result: ");
        add(resultLabel, BorderLayout.SOUTH);

        // Conversion Button Action
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double inputValue = Double.parseDouble(temperatureField.getText());

                if (sourceUnitComboBox.getSelectedIndex() == 0) {
                    // Celsius to Fahrenheit
                    double result = (inputValue * 9 / 5) + 32;
                    resultLabel.setText("Result: " + result + "°F");
                } else {
                    // Fahrenheit to Celsius
                    double result = (inputValue - 32) * 5 / 9;
                    resultLabel.setText("Result: " + result + "°C");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverterApp app = new TemperatureConverterApp();
            app.setVisible(true);
        });
    }
}
