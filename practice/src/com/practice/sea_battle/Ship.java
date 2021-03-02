package com.practice.sea_battle;

import java.util.Arrays;
import java.util.Scanner;

public class Ship {
    private int[] coordinates;
    private ShipSize shipSize;

    public Ship(ShipSize size) {
        this.shipSize = size;
    }

    public ShipSize getShipSize() {
        return shipSize;
    }

    public int[] getCoordinates() {
        return coordinates;
    }


    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public enum ShipSize {
        BIG(4), AVERAGE(3), SMALL(2), TINY(1);
        private int lives; //cells = life of the ship

        ShipSize(int cells) {
            this.lives = cells;
        }

        public int getLives() {
            return lives;
        }

        public void reduceLives() {
            this.lives -= 1;
        }
    }

    public void getInstruction() {
        switch (this.shipSize) {
            case TINY:
                System.out.println("please enter coordinates of a boat, for example x1,y1: ");
                break;
            case SMALL:
                System.out.println("please enter coordinates of a destroyer, for example  (x1,y1,x1,y2): ");
                break;
            case AVERAGE:
                System.out.println("please enter coordinates of a cruiser, for example  (x1,y1,x2,y1,x3,y1): ");
                break;
            case BIG:
                System.out.println("please enter coordinates of a battleship , for example  (x1,y1,x2,y1,x3,y1,x4,y1): ");
                break;
        }
    }

    public static Ship createShip(int usersInput) {
        switch (usersInput) {
            case 1:
                Ship ship1 = new Ship(ShipSize.TINY);
                return ship1;
            case 2:
                Ship ship2 = new Ship(ShipSize.SMALL);
                return ship2;
            case 3:
                Ship ship3 = new Ship(ShipSize.AVERAGE);
                return ship3;
            case 4:
                Ship ship4 = new Ship(ShipSize.BIG);
                return ship4;
        }
        return null;
    }

    public boolean correctShape() {
        boolean correct = false;
        switch (shipSize) {
            case TINY:
                return true;
            case SMALL:
                for (int i = 0; i < shipSize.lives; i += 2) {
                    if ((coordinates[i] != coordinates[i + 2]) && (coordinates[i + 1] != coordinates[i + 3]) ||
                            ((Math.abs(coordinates[i + 1] - coordinates[i + 3]) != 1) && (Math.abs(coordinates[i] - coordinates[i + 2])) != 1))
                        return false;
                    else correct = true;
                }
                return correct;
            case AVERAGE:
                for (int i = 0; i <= shipSize.lives - 1; i += 2) {
                    if ((coordinates[i] != coordinates[i + 2]) && (coordinates[i + 1] != coordinates[i + 3]) ||
                            ((Math.abs(coordinates[i + 1] - coordinates[i + 3]) != 1) && (Math.abs(coordinates[i] - coordinates[i + 2])) != 1))
                        return false;
                    else correct = true;
                }
                return correct;
            case BIG:
                for (int i = 0; i <= shipSize.lives; i += 2) {
                    if ((coordinates[i] != coordinates[i + 2]) && (coordinates[i + 1] != coordinates[i + 3]) ||
                            ((Math.abs(coordinates[i + 1] - coordinates[i + 3]) != 1) && (Math.abs(coordinates[i] - coordinates[i + 2])) != 1))
                        return false;
                    else correct = true;
                }
                return correct;
        }
        return true;
    }

    public int[] defineCoordinates() {
        Scanner scanner = new Scanner(System.in);
        int[] position = new int[this.shipSize.getLives() * 2];
        boolean incorrectInput;
        do {
            incorrectInput = false;
            try {
                String[] line = scanner.nextLine().split(",");
                for (int i = 0; i < this.shipSize.getLives() * 2; i += 2) {
                    if (!line[i].startsWith("x")) {
                        System.out.println("wrong coordinate name, check x");
                        incorrectInput = true;
                    }
                }
                for (int i = 1; i < this.shipSize.getLives() * 2; i += 2) {
                    if (!line[i].startsWith("y")) {
                        System.out.println("wrong coordinate name, check y");
                        incorrectInput = true;
                    }
                }
                if (incorrectInput) continue;
                for (int i = 0; i < this.shipSize.getLives() * 2; i++) {
                    line[i] = line[i].substring(1);
                    position[i] = Integer.parseInt(line[i]);
                    if (position[i] > 10) {
                        System.out.println("coordinates out of the limit");
                        incorrectInput = true;
                        break;
                    } else incorrectInput = false;
                }
            } catch (NumberFormatException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please try again");
                incorrectInput = true;
            }
        } while (incorrectInput);
        return position;
    }

    @Override
    public String toString() {
        return "Ship " +
                "coordinates=" + Arrays.toString(coordinates) +
                ", ship size = " + shipSize;
    }
}

