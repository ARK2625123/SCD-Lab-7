import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPaletteApp extends JFrame {
    private JPanel colorPanel;
    private JButton colorButton;
    private JColorChooser colorChooser;

    public ColorPaletteApp() {
        setTitle("Color Palette");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Color Panel
        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(400, 200));
        colorPanel.setBackground(Color.WHITE);
        add(colorPanel, BorderLayout.CENTER);

        // Color Button
        colorButton = new JButton("Select Color");
        add(colorButton, BorderLayout.SOUTH);

        // Color Chooser
        colorChooser = new JColorChooser();

        // Color Button Action
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", colorPanel.getBackground());
                if (selectedColor != null) {
                    colorPanel.setBackground(selectedColor);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorPaletteApp app = new ColorPaletteApp();
            app.setVisible(true);
        });
    }
}
