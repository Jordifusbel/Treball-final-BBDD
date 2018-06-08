package org.mvpigs;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
//    @Before
//    public void initDb{
//    }

    @Test
    public void testDB()
    {
        Jdbc jdbc = new Jdbc();
        Connection connection = jdbc.connectDB();

        ArrayList<DBMonster> monsterList = new ArrayList<DBMonster>();

        try{
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("Select * from monsters");

            while (resultSet.next()){
                DBMonster monster = new DBMonster();
                monster.id = resultSet.getInt("id");
                monster.monsterName = resultSet.getString("monster_name");
                monsterList.add(monster);
            }

        } catch (Exception e){

        }
        assertEquals(true, false);
    }
}
