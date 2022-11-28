package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

public class ToDoListApp extends JFrame {
    AddNewTaskButton addNewTaskButton = new AddNewTaskButton();
    Headline title = new Headline();
    TasksList list = new TasksList();
    JButton addNewTask = addNewTaskButton.getButton();

    ToDoListApp() {
        add(title, BorderLayout.NORTH);
        add(list, BorderLayout.WEST);
        add(addNewTaskButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(450, 600);
        setVisible(true);

        addNewTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String newTask = JOptionPane.showInputDialog(null,
                        "Add new task", "New Task");
                if (newTask != null && !("").equals(newTask)) {
                    Task task = new Task();
                    task.newTask.setText(newTask);
                    Component[] components = list.getComponents();
                    if (components.length >= 5) {
                        JOptionPane.showMessageDialog(null, "You can't add more than 10 items");
                    } else {
                        list.add(task);
                        revalidate();
                    }
                    task.newTask.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if (task.newTask.isSelected()) {
                                Map attributes = task.myFont.getAttributes();
                                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                                task.newTask.setFont(new Font(attributes));
                            } else {
                                task.newTask.setFont(task.myFont);
                            }
                        }

                    });
                    JButton removeItem = task.getRemoveItem();
                    removeItem.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            list.remove(task);
                            revalidate();
                            repaint();
                        }
                    });
                }
            }

            ;
        });
    }
}