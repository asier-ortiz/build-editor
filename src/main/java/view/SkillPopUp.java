package view;

import javax.swing.*;
import java.awt.*;

public class SkillPopUp extends JFrame {
    private JPanel popWindow;
    private JPanel headerPanel;
    private JLabel skillNameLabel;
    private JTextArea descriptionTextArea;

    public SkillPopUp() {
        popWindow.setPreferredSize(new Dimension(500, 100));
        popWindow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        popWindow.setBackground(Color.BLACK);
        headerPanel.setBackground(Color.BLACK);
        skillNameLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        skillNameLabel.setForeground(Color.WHITE);
        skillNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        descriptionTextArea.setFont(new Font("Verdana", Font.PLAIN, 12));
        descriptionTextArea.setForeground(Color.WHITE);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setOpaque(false);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setFocusable(false);
    }

    public JPanel getPopWindow() {
        return popWindow;
    }

    public JLabel getSkillNameLabel() {
        return skillNameLabel;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }
}