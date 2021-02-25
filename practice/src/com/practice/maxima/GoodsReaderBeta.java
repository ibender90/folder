package com.practice.maxima;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GoodsReaderBeta {
    private RandomAccessFile file;

    public GoodsReaderBeta(String path) throws FileNotFoundException {
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
