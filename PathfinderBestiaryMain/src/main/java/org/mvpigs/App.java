package org.mvpigs;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        FormMonsters form = new FormMonsters();
        JFrame frame = new JFrame("Monsters");
        frame.setContentPane(form.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadJList(form.mList);

        frame.pack();
        frame.setVisible(true);
    }

    public static void loadJList(JList list){
        DefaultListModel model = new DefaultListModel();

        Jdbc jdbc = new Jdbc();
        Connection connection = jdbc.connectDB();

        ArrayList<DBMonster> monstersList = getAllMonsters(jdbc, connection);

        for (int i = 0; i < monstersList.size(); i++) {
            model.addElement(monstersList.get(i));
        }

        list.setModel(model);
    }

    private static ArrayList<DBMonster> getAllMonsters(Jdbc jdbc, Connection connection) {
        ArrayList<DBMonster> monsterList = new ArrayList<DBMonster>();

        if (jdbc.Logged && connection != null) {
            try {
                ResultSet resultSet = jdbc.getAllEntrys(connection);
                while (resultSet.next()) {
                    DBMonster monster = new DBMonster();
                    monster.id = resultSet.getInt("id");
                    monster.monsterName = resultSet.getString("name");
                    monster.monsterCr = resultSet.getString("cr");
                    monster.monsterType = resultSet.getString("type");
                    monster.monsterAlignment = resultSet.getString("alignment");
                    monsterList.add(monster);
                }
            } catch (Exception e) {
                return null;
            }
            return monsterList;
        }
        return null;
    }
}
