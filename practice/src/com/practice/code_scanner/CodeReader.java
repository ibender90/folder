package com.practice.code_scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
         а вот диск у нее большой, он может хранить сотни тысяч товаров, и товары там будут искать быстро и много во время инвентуры.
        Направления изыскания: побайтовое считывание, внутренний указатель позиции в файле, бинарный поиск.*/

public class CodeReader {
    private RandomAccessFile file;

    public CodeReader(String path) throws FileNotFoundException {
        file = new RandomAccessFile(path, "r");
    }

    private String readLine(int lineNumber) throws IOException {
        int position = (lineNumber - 1) * 20;
        file.seek(position);
        return file.readLine();
    }

    private int getCode(int fromLineNr) throws IOException {
        return getInteger(readLine(fromLineNr));
    }

    private int getInteger(String inputLine) {
        String code = inputLine.substring(0, 8).trim();
        return Integer.parseInt(code);
    }

    private String getProductName(int fromLineNr) throws IOException {
        return readLine(fromLineNr).substring(8, 18);
    }

    public String findProduct(int codeFromScanner) throws IOException {
        int upperBoarder = 0;
        int lowerBoarder = howManyLines();
        int currentLine = 0;
        try {
            while ((upperBoarder <= lowerBoarder)) {
                currentLine = (lowerBoarder + upperBoarder) / 2;
                int foundCode = getCode(currentLine);
                if (foundCode < codeFromScanner) {
                    lowerBoarder = currentLine - 1;
                } else if (foundCode > codeFromScanner) {
                    upperBoarder = currentLine + 1;
                } else if (foundCode == codeFromScanner) {
                    break;
                }
            }
            if (getCode(currentLine) == codeFromScanner) {
                return getProductName(currentLine);
            } else return "Code not found";
        } finally {
            file.close();
        }
    }

    private int howManyLines() throws IOException {
        return (int) (file.length() / 20);
    }
}
