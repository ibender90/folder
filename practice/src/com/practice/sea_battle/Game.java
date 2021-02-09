package com.practice.sea_battle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Player player1 = new Player("Admiral Nelson");
        Player player2 = new Player("Captain Jack Sparrow");
        printRules();
        Field createdField = new Field();
        System.out.println(player1.getPlayersName() + ", please create your fleet and place it on the map");
        createdField.printField();
        createFleet(player1, createdField);
        System.out.println(player1.getPlayersName() + ", your fleet is created!");
        Field players1Field = createdField;
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(player2.getPlayersName() + ", please create your fleet and place it on the map");
        createdField = new Field();
        createdField.printField();
        createFleet(player2, createdField);
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(player1.getPlayersName() + ", your fleet is created!");
        Field players2Field = createdField;
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        Field hiddenFieldOfPlayer1 = new Field();
        Field hiddenFieldOfPlayer2 = new Field();

        do {
            player1.shoot(player2, players2Field, hiddenFieldOfPlayer2);
            if (player2.getFleet().size() == 0) break;
            player2.shoot(player1, players1Field, hiddenFieldOfPlayer1);
            if (player1.getFleet().size() == 0) break;
        } while (true);

        System.out.println("GAME OVER");
        if (player1.getFleet().size() == 0) {
            System.out.println(player2.getPlayersName() + " won!");
            hiddenFieldOfPlayer2.addRemainingFleet(players2Field);
            System.out.println("Now fog of war has vanished, see enemy`s fleet!");
            hiddenFieldOfPlayer2.printField();
        } else {
            System.out.println(player1.getPlayersName() + " won!");
            hiddenFieldOfPlayer1.addRemainingFleet(players1Field);
            System.out.println("Now fog of war has vanished, see enemy`s fleet!");
            hiddenFieldOfPlayer1.printField();
        }

    }

    private static void createFleet(Player player, Field field) {
        Scanner scanner = new Scanner(System.in);
        int shipType = 0;
        boolean incorrectInput;
        do {
            do {
                System.out.println("enter 1 to create a boat");
                System.out.println("enter 2 to create a destroyer");
                System.out.println("enter 3 to create a cruiser");
                System.out.println("enter 4 to create a airplane carrier");
                try {
                    int checkInput = scanner.nextInt();
                    if (checkInput > 0 && checkInput < 5) { // проверяю, что введено число от 1 до 4 включительно
                        shipType = checkInput;
                        incorrectInput = false;
                    } else incorrectInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("please enter a number from 1 to 4");
                    incorrectInput = true;
                    scanner.nextLine();
                }
            } while (incorrectInput);
            Ship testShip = Ship.createShip(shipType); // создаю корабль нужного размера без определённых координат
            if (testShip.getShipSize() == player.checkFleet(testShip)) { //если размер созданного корабля совпадает с максимальным количеством
                System.out.println("fleet can not contain more vessels of this size");  //если кораблей такого размера уже слишком много во флоте игрока, то он не добавляется
                continue;
            } else testShip.getInstruction();
            testShip.setCoordinates(testShip.defineCoordinates()); // вводим координаты для нового корабля
            if (testShip.correctShape()) { // если форма корабля соответствует правилам
                if (field.addToField(testShip)) { // если удалось уместить корабль на поле
                    player.addToFleet(testShip);   // добавляем его во флот игрока
                    field.generateBlockedArea(testShip);  // генерируем на поле зону, куда нельзя теперь добавить корабль
                    field.printField(); //
                } else System.out.println("this coordinates can not be used");
            } else System.out.println("wrong shape of the ship");
           // System.out.println(player.toString());
        } while (!player.fleetCreated());
    }

    private static void printRules() {
        System.out.println("Welcome to the SeaSlash!\n" +
                "Two players have to place their fleet on the map one by one. \n" +
                "Fleet consists of 4 type of vessels:\n" +
                "Boat - ship which requires only one cell of the map\n" +
                "Destroyer - two cells of the map\n" +
                "Cruiser - three cells of the map\n" +
                "Plane carrier - four cells\n" +
                "Every player has to place 4 boats, 3 destroyers, 2 cruisers and one plane carrier.\n" +
                "Ship has to form a straight line on the map (except for boat).\n" +
                "Map size is 10 by 10 cells.\n" +
                "Every placed ship will be separated by 1 cell from each side for safety reasons.\n" +
                "After two fleets are created shooting happens.\n" +
                "Enter coordinates to aim, if you miss, turn goes to other player.\n" +
                "One who destroys enemy fleet - wins! GOOD LUCK!\n");
    }
}
