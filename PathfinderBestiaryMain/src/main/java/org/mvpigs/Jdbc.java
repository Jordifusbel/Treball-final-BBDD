package org.mvpigs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class FormMonsters {
    public JPanel panelMain;
    public JList mList;
    public JButton updateButton;
    public JTextField aligField;
    public JTextField nameField;
    public JTextField crField;
    public JTextField typeField;
    public JButton insertButton;
    public JButton deleteButton;

    public FormMonsters() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jdbc jdbc = new Jdbc();
                Connection connection = jdbc.connectDB();

                jdbc.insertMonster(connection, nameField.getText(), crField.getText(), typeField.getText(), aligField.getText());
                App.loadJList(mList);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jdbc jdbc = new Jdbc();
                Connection connection = jdbc.connectDB();

                DBMonster selected = (DBMonster) mList.getModel().getElementAt(mList.getSelectedIndex());

                jdbc.deleteMonster(connection, selected.id);

                jdbc.insertMonster(connection, nameField.getText(), crField.getText(), typeField.getText(), aligField.getText());

//                jdbc.updateMonster(connection, selected.id, selected.monsterName, selected.monsterCr, selected.monsterType, selected.monsterAlignment);

                App.loadJList(mList);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jdbc jdbc = new Jdbc();
                Connection connection = jdbc.connectDB();

                DBMonster selected = (DBMonster) mList.getModel().getElementAt(mList.getSelectedIndex());

                jdbc.deleteMonster(connection, selected.id);
                App.loadJList(mList);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
