package com.practice.sea_battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String playersName;
    private List<Ship> fleet = new ArrayList<>();

    public String getPlayersName() {
        return playersName;
    }

    public List<Ship> getFleet() {
        return fleet;
    }

    public void addToFleet(Ship ship) {
        fleet.add(ship);
    }

    public boolean fleetCreated() {
        return this.fleet.size() == 10;
    }

    public Ship.ShipSize checkFleet(Ship ship) {
        if (!this.fleet.isEmpty()) {
            int tinyCounter = 0;
            int smallCounter = 0;
            int averageCounter = 0;
            int bigCounter = 0;
            for (int i = 0; i < this.fleet.size(); i++) {
                if (this.fleet.get(i).getShipSize().equals(Ship.ShipSize.TINY)) {
                    tinyCounter++;
                }
                if (this.fleet.get(i).getShipSize().equals(Ship.ShipSize.SMALL)) {
                    smallCounter++;
                }
                if (this.fleet.get(i).getShipSize().equals(Ship.ShipSize.AVERAGE)) {
                    averageCounter++;
                }
                if (this.fleet.get(i).getShipSize().equals(Ship.ShipSize.BIG)) {
                    bigCounter++;
                }
            }
            switch (ship.getShipSize()) {
                case TINY:
                    if (tinyCounter == 4)
                        return Ship.ShipSize.TINY;
                case SMALL:
                    if (smallCounter == 3)
                        return Ship.ShipSize.SMALL;
                case AVERAGE:
                    if (averageCounter == 2)
                        return Ship.ShipSize.AVERAGE;
                case BIG:
                    if (bigCounter == 1)
                        return Ship.ShipSize.BIG;
            }
        }
        return null;
    }

    public void shoot(Player player, Field field, Field fogOfWar) {
        fogOfWar.printField();
        boolean shootAgain = true;
        do {
            System.out.println(this.playersName + ", set coordinates to shoot: ");
            Scanner scanner = new Scanner(System.in);
            int x = 0;
            int y = 0;
            boolean incorrectInput;
            do {
                incorrectInput = false;
                try {
                    String[] line = scanner.nextLine().split(",");
                    if (!line[0].startsWith("x")) {
                        System.out.println("wrong coordinate name, check x");
                        incorrectInput = true;
                    }
                    if (!line[1].startsWith("y")) {
                        System.out.println("wrong coordinate name, check y");
                        incorrectInput = true;
                    }
                    if (incorrectInput) continue;
                    line[0] = line[0].substring(1);
                    line[1] = line[1].substring(1);
                    x = Integer.parseInt(line[0]);
                    y = Integer.parseInt(line[1]);
                    if (x > 10 || y > 10) {
                        System.out.println("coordinates out of the limit");
                        incorrectInput = true;
                    } else incorrectInput = false;
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    System.out.println("Please try again");
                    incorrectInput = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("cant apply this coordinates");
                    incorrectInput = true;
                }
            } while (incorrectInput);
            int[] target = {x, y};;
            if (field.getBattleField()[y][x].equals("⚓")) {
                System.out.println("HIT!");
                fogOfWar.getBattleField()[y][x] = "❌";
                fogOfWar.printField();
                for (int i = 0; i < player.getFleet().size(); i++)
                    switch (player.getFleet().get(i).getShipSize()) {
                        case TINY:
                            if (Arrays.equals(player.getFleet().get(i).getCoordinates(), target)) {
                                player.getFleet().remove(i);
                                System.out.println("Boat was destroyed");
                            }
                            break;
                        case SMALL:
                            for (int j = 0; j < 4; j += 2) {
                                if (Arrays.equals(Arrays.copyOfRange(player.getFleet().get(i).getCoordinates(), j, (j + 2)), target)) {
                                    player.getFleet().get(i).getShipSize().reduceLives();
                                }
                            }
                            if (player.getFleet().get(i).getShipSize().getLives() == 0) {
                                System.out.println("Destroyer was crushed!");
                                player.getFleet().remove(i);
                            }
                            break;
                        case AVERAGE:
                            for (int j = 0; j < 6; j += 2) {
                                if (Arrays.equals(Arrays.copyOfRange(player.getFleet().get(i).getCoordinates(), j, (j + 2)), target)) {
                                    player.getFleet().get(i).getShipSize().reduceLives();
                                }
                            }
                            if (player.getFleet().get(i).getShipSize().getLives() == 0) {
                                System.out.println("Cruiser is in history!");
                                player.getFleet().remove(i);
                            }
                            break;
                        case BIG:
                            for (int j = 0; j < 8; j += 2) {
                                if (Arrays.equals(Arrays.copyOfRange(player.getFleet().get(i).getCoordinates(), j, (j + 2)), target)) {
                                    player.getFleet().get(i).getShipSize().reduceLives();
                                }
                            }
                            if (player.getFleet().get(i).getShipSize().getLives() == 0) {
                                System.out.println("Airplane carrier is under water");
                                player.getFleet().remove(i);
                            }
                            break;
                    }
            } else {
                fogOfWar.getBattleField()[y][x] = "∅";
                fogOfWar.printField();
                System.out.println("Miss!");
                System.out.println("\n\n\n\n");
                shootAgain = false;
            }
        } while (shootAgain && player.getFleet().size() != 0);
    }

    public Player(String playersName) {
        this.playersName = playersName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playersName='" + playersName + '\'' +
                ", fleet=" + fleet +
                '}';
    }
}
