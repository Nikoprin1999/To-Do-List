package App;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddNewTaskButton extends JPanel {
    private JButton button;
    AddNewTaskButton() {
        try {
            BufferedImage buttonIcon = ImageIO.read(new File("plus.png"));
            Image imageIcon = buttonIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            button = new JButton(new ImageIcon(imageIcon));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            add(button);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JButton getButton() {
        return button;
    }
}