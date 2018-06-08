package org.mvpigs;

public class DBMonster {
    public int id;
    public String monsterName;
    public String monsterCr;
    public String monsterType;
    public String monsterAlignment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterCr() {
        return monsterCr;
    }

    public void setMonsterCr(String monsterCr) {
        this.monsterCr = monsterCr;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getMonsterAlignment() {
        return monsterAlignment;
    }

    public void setMonsterAlignment(String monsterAlignment) {
        this.monsterAlignment = monsterAlignment;
    }

    @Override
    public String toString() {
        return monsterName + ", " + monsterCr + ", " + monsterType + ", " + monsterAlignment;
    }
}
