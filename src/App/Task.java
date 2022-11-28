package App;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Task extends JPanel {
    JCheckBox newTask = new JCheckBox();
    private JButton removeItem;
    Font myFont = new Font("Arial", Font.BOLD, 30);
    Task() {
        newTask.setFont(myFont);
        add(newTask);
        try {
            BufferedImage removeItemImage = ImageIO.read(new File("remove.png"));
            Image removeItemIcon = removeItemImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            removeItem = new JButton(new ImageIcon(removeItemIcon));
            removeItem.setBorder(BorderFactory.createEmptyBorder());
            removeItem.setContentAreaFilled(false);
            add(removeItem);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public JButton getRemoveItem() {
        return removeItem;
    }
}
