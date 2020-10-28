package Lesson_008.app;

import javax.swing.*;
import java.awt.*;

public class GameSettingsForm extends JFrame {
    GameSettingsForm gameSettingsForm = this;
    public GameSettingsForm() {
        setTitle("Настройки игры");
        setBounds(450, 450, 240, 190);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelMode = new JLabel("Выберете режим игры:");
        add(jLabelMode);
        JRadioButton radioButtonModeTwoPlayers = new JRadioButton("Игрок против игрока");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        JRadioButton radioButtonModeAgainstAI = new JRadioButton("Игрок против компьютера");
        add(radioButtonModeAgainstAI);
        JLabel jLabelAILevel = new JLabel("Выберете уровень AI:");
        add(jLabelAILevel);
        JSlider jSlider = new JSlider(0,2,0);
        add(jSlider);
        jSlider.setAlignmentX(LEFT_ALIGNMENT);
        jSlider.setVisible(false);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);
        JLabel jLabelLinesCount = new JLabel("Размер поля (по умолчанию 3 на 3): ");
        add(jLabelLinesCount);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);
        JButton jButtonSetSettings = new JButton("Начать игру!");
        add(jButtonSetSettings);
        setVisible(true);

        radioButtonModeTwoPlayers.addActionListener(e -> {
            if (radioButtonModeTwoPlayers.isSelected()) {
                jSlider.setVisible(false);
            }
        });

        radioButtonModeAgainstAI.addActionListener(e -> {
            if (radioButtonModeAgainstAI.isSelected()) {
                jSlider.setVisible(true);
            }
        });

        jButtonSetSettings.addActionListener(e -> {
            MainGameField gameField = MainGameField.getInstance();
            if (jTextFieldLinesCount.getText().isEmpty()) {
                MainGameField.linesCount = 3;
            }
            else {
                try {
                    MainGameField.linesCount = Integer.parseInt(jTextFieldLinesCount.getText());
                }
                catch (NumberFormatException ex) {
                    System.out.println("Необходимо ввести целое число!");
                }
            }
            gameField.startNewGame();
            if (radioButtonModeAgainstAI.isSelected()) {
                gameField.gameMode = 2;
            }
            else {
                gameField.gameMode = 1;
            }
            gameField.aiLevel = jSlider.getValue();
            gameSettingsForm.setVisible(false);
        });
    }
}
