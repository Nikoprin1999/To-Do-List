package App;

import javax.swing.*;
import java.awt.*;

public class Headline extends JPanel {
    JLabel headline = new JLabel("To Do App");

    Headline() {
        headline.setFont(new Font("Arial", Font.BOLD, 30));
        add(headline);
    }
}
