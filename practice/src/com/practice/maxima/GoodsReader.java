package com.practice.maxima;

/*дан файл, типа список товаров в магазине. Он fixed line length:
        ########xxxxxxxxxx
        ########xxxxxxxxxx
        ########xxxxxxxxxx
        ....
        максимум 8 цифр код товара, максимум 10 символов (пусть будут только буквы и пробелы) название.
        Если код/имя меньше 8/10 символов, то там дополняется справа пробелами, типа "#####  xxxxxxxx   " то есть длина строки всегда та же самая.
        Важно: файл отсортирован уже по коду товара от большего к меньшему.
        На вход подается код товара (типа сканер штрихкода считал)
        Надо найти товар и вывести его имя.
        И сделать это эффктивно. Почему? Потому что бегает это все в древнем девайсе для инвентуры с 40 Кб памяти и обрезанным MS DOS на борту,
         а вот диск у нее большой, туда может зайти база максимы три икса на дохериллион товаров, и товары там будут искать быстро и много во время инвентуры.
        Направления изыскания: побайтовое считывание, внутренний указатель позиции в файле, бинарный поиск.*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class GoodsReader {
    private String path;
    private static final int lineLength = 20;
    private RandomAccessFile file;
    private static final int[] TESTCODE = {49, 50, 51, 52, 48, 48, 56, 32};//{49, 50, 50, 57, 56, 56, 0, 0}; //122988 line 5005
    private int startLine;

    public GoodsReader(String path) {
        this.path = path;
    }

    public int aboveOrBeyound() throws IOException {
        int[] codeRecievedFromSearch = readInt(searchSameLength(getCodeLength(TESTCODE)));
        for (int i = 0; i < 8; i++) {
            if (codeRecievedFromSearch[i] == TESTCODE[i]) {
                continue;
            }
            if (codeRecievedFromSearch[i] < TESTCODE[i]) {
                return -1; //look above
            } else return 1; //look beyond
        }
        return 0; //same code!
    }

    public String readFromPosition(long position) throws IOException { //temporary
        file = new RandomAccessFile(path, "r");
        String res = "";
        file.seek(position);
        int b = file.read();
        int counter = 0;
        while (counter != 10) {
            res = res + (char) b;
            b = file.read();
            counter++;
        }
        file.close();
        return res;
    }

    public String findCode() throws IOException {
        int direction = 20 * aboveOrBeyound();
        int[] codeFromFile = readInt(startLine);
        file = new RandomAccessFile(path, "r");
        long position = (long) (startLine - 1) * lineLength;
        for (int i = 0; i < 7; i++) {
            if (codeFromFile[i] == TESTCODE[i]) {
                position += 1;
                file.seek(position);
                codeFromFile[i + 1] = file.read();
                continue;
            }
            if (codeFromFile[i] == 48) {
                codeFromFile[i] = 0;
            }
            while (codeFromFile[i] != TESTCODE[i]) {
                file.seek((position += direction));
                codeFromFile[i] = file.read();
            }
            position += 1;
            file.seek(position);
            codeFromFile[i + 1] = file.read();
        }
        return "" + readFromPosition(position+1);
    }

    public int[] readInt(int lineNumber) throws IOException {
        file = new RandomAccessFile(path, "r");
        int position = (lineNumber - 1) * lineLength;
        file.seek(position);
        int[] codeArray = new int[8];
        int nextInt = file.read();
        for (int i = 0; i < 8; i++) {
            codeArray[i] = nextInt;
            nextInt = file.read();
        }
        file.close();
        return codeArray;
    }

    public int getCodeLength(int[] code) {
        int codeLength = 0;
        for (int everyByte : code) {
            if (everyByte != 32) {
                codeLength++;
            }
        }
        return codeLength;
    }

    public int howManyLines() throws IOException {
        file = new RandomAccessFile(path, "r");
        return (int) (file.length() / 20); // каждая строка вмещает 20 байт
    }

    public int searchSameLength(int requiredLength) throws IOException {
        int upperBoarder = 0;
        int lowerBoarder = howManyLines();
        int lineNumber = 1;
        startLine = 1;

        while ((upperBoarder <= lowerBoarder) && (requiredLength != 8)) { // 8ми значные коды будем искать с начала файла
            int mid = (lowerBoarder + upperBoarder) / 2;
            int foundLength = getCodeLength(readInt(mid));

            if (foundLength < requiredLength) {
                lowerBoarder = mid - 1;
            } else if (foundLength > requiredLength) {
                upperBoarder = mid + 1;
            } else if (foundLength == requiredLength) {
                lineNumber = mid;
                break;
            }
        }
        startLine = lineNumber;
        return lineNumber;
    }

}
