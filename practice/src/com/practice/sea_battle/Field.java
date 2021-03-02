package com.practice.sea_battle;

public class Field {
    private String[][] battleField;

    public Field() {
        this.battleField = createNewBattlefield();
    }

    public boolean addToField(Ship ship) {
        for (int i = 0; i < ship.getCoordinates().length - 1; i += 2) {
            if (!battleField[ship.getCoordinates()[i + 1]][ship.getCoordinates()[i]].equals(Icon.EMPTY.icon))
                return false;
        }
        for (int i = 0; i < ship.getCoordinates().length - 1; i += 2) {
            battleField[ship.getCoordinates()[i + 1]][ship.getCoordinates()[i]] = Icon.SHIP.icon;
        }
        return true;
    }

    public void addRemainingFleet(Field field){
        for (int i = 0; i < this.battleField.length; i++) {
            for (int j = 0; j < this.battleField[i].length; j++) {
                if (field.battleField[i][j].equals(Icon.SHIP.icon) && this.battleField[i][j].equals(Icon.EMPTY.icon))
                    this.battleField[i][j] = Icon.SHIP.icon;
            }
        }
    }

    public void generateBlockedArea(Ship ship) {
        int electricityWasted = 0;
        for (int i = 0; i <= ship.getCoordinates().length - 1; i += 2) {
            int x = ship.getCoordinates()[i];
            int y = ship.getCoordinates()[i + 1];
            try {
                if (this.getBattleField()[y][x - 1].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y][x - 1] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {
                if (this.getBattleField()[y][x + 1].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y][x + 1] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {
                if (this.getBattleField()[y - 1][x - 1].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y - 1][x - 1] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {
                if (this.getBattleField()[y + 1][x - 1].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y + 1][x - 1] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {
                if (this.getBattleField()[y - 1][x + 1].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y - 1][x + 1] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {

                if (this.getBattleField()[y + 1][x + 1].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y + 1][x + 1] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {
                if (this.getBattleField()[y + 1][x].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y + 1][x] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
            try {
                if (this.getBattleField()[y - 1][x].equals(Icon.EMPTY.icon))
                    this.getBattleField()[y - 1][x] = Icon.BLOCKED_AREA.icon;
            } catch (ArrayIndexOutOfBoundsException e) {
                electricityWasted++;
            }
        }
    }

    private enum Icon {
        EMPTY("🟥"), SHIP("⚓"), BLOCKED_AREA("⛝");

        private String icon;

        Icon(String icon) {
            this.icon = icon;
        }

    }

    private String[][] createNewBattlefield() {
        String[][] field = new String[11][11];
        field[0][0] = " ";
        for (int i = 1; i < field.length; i++) {
            field[0][i] = "x" + i;
        }
        for (int i = 1; i < field.length; i++) {
            field[i][0] = "y" + i;
        }
        for (int i = 1; i < field.length; i++) {
            for (int j = 1; j < field.length; j++) {
                field[i][j] = Icon.EMPTY.icon;
            }
        }
        return field;
    }

    public void printField() {
        for (int i = 0; i < this.battleField.length; i++) {
            for (int j = 0; j < this.battleField[i].length; j++) {
                System.out.print(this.battleField[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public String[][] getBattleField() {
        return battleField;
    }
}