import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageViewerApp extends JFrame {
    private JLabel imageLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JFileChooser fileChooser;
    private File[] imageFiles;
    private int currentImageIndex;

    public ImageViewerApp() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        pack();
        setLocationRelativeTo(null);
        loadImages();
    }

    private void loadImages() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            imageFiles = fileChooser.getSelectedFiles();
            currentImageIndex = 0;
            displayImage(currentImageIndex);
        }
    }

    private void showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--;
            displayImage(currentImageIndex);
        }
    }

    private void showNextImage() {
        if (currentImageIndex < imageFiles.length - 1) {
            currentImageIndex++;
            displayImage(currentImageIndex);
        }
    }

    private void displayImage(int index) {
        if (index >= 0 && index < imageFiles.length) {
            try {
                File imageFile = imageFiles[index];
                Image image = ImageIO.read(imageFile);
                imageLabel.setIcon(new ImageIcon(image));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageViewerApp app = new ImageViewerApp();
            app.setVisible(true);
        });
    }
}
