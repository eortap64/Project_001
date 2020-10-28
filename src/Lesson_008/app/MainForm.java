package Lesson_008.app;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    public MainForm() {
        setTitle("XO game GUI");
        setBounds(300, 300, 455, 525);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainGameField gameField = MainGameField.getInstance();
        // Создаём панель для кнопок
        JPanel buttonPanel = new JPanel(new GridLayout());
        add(gameField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnEnd = new JButton("Закончить игру");
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);
        btnEnd.addActionListener(e -> System.exit(0));
        btnStart.addActionListener(e -> {
            System.out.println(btnStart.getText());
            new GameSettingsForm();
        });
        setVisible(true);
    }
}
