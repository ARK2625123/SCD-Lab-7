import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingApp extends JFrame {
    private JPanel canvas;
    private int startX, startY, endX, endY;
    private int selectedShape = 0; // 0: Line, 1: Rectangle, 2: Ellipse

    public DrawingApp() {
        setTitle("Drawing Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawShape(g);
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                canvas.repaint();
            }
        });

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                canvas.repaint();
            }
        });

        add(canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton lineButton = new JButton("Line");
        JButton rectangleButton = new JButton("Rectangle");
        JButton ellipseButton = new JButton("Ellipse");

        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);

        add(buttonPanel, BorderLayout.SOUTH);

        lineButton.addActionListener(e -> selectedShape = 0);
        rectangleButton.addActionListener(e -> selectedShape = 1);
        ellipseButton.addActionListener(e -> selectedShape = 2);

        pack();
        setLocationRelativeTo(null);
    }

    private void drawShape(Graphics g) {
        if (selectedShape == 0) {
            g.drawLine(startX, startY, endX, endY);
        } else if (selectedShape == 1) {
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);
            g.drawRect(Math.min(startX, endX), Math.min(startY, endY), width, height);
        } else if (selectedShape == 2) {
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);
            g.drawOval(Math.min(startX, endX), Math.min(startY, endY), width, height);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingApp app = new DrawingApp();
            app.setVisible(true);
        });
    }
}
