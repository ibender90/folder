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
    private static final byte[] TESTCODE = {54, 52, 49, 49, 51, 55, 50, 0}; //code from line 4810

    public GoodsReader(String path) {
        this.path = path;
    }

//    public static int bytesToInt(byte[] received) {
//        ByteBuffer wrapped = ByteBuffer.wrap(received);
//        return wrapped.getInt();
//    }
/*    public void compareByBytes(byte[]input) throws IOException {
    input = new byte[]{49, 50, 51, 52, 53, 54, 55, 56};
    readBytes(binarySearchSameLength(getCodeLength(input), 0, howManyLines()));
    }*/


/*    public long goTo(int num) throws IOException {
        file = new RandomAccessFile(path, "r");
        // переходим на num символ
        file.seek(num);
        // получаем текущее состояние курсора в файле
        long pointer = file.getFilePointer();
        file.close();

        return pointer;
    }*/

/*    // читаем файл с определенного символа
    public String readFrom(int numberSymbol) throws IOException {
        // открываем файл для чтения
        file = new RandomAccessFile(path, "r");
        String res = "";
        // ставим указатель на нужный вам символ
        file.seek(numberSymbol);
        int b = file.read();
        // побитово читаем и добавляем символы в строку
        while (b != -1) {
            res = res + (char) b;

            b = file.read();
        }
        file.close();
        return res;
    }*/

    public String readLine(int lineNumber) throws IOException {
        file = new RandomAccessFile(path, "r");
        String res = "";
        int position = (lineNumber - 1) * lineLength; //перехожу на начало строки
        file.seek(position);
        int b = file.read();       // file.read(byte array) в скобках отступ
        int counter = 0;
        while (counter != 8) {
            res = res + (char) b;
            b = file.read();
            counter++;
        }
        file.close();
        return res;
    }


    public byte[] readBytes(int lineNumber) throws IOException {
        file = new RandomAccessFile(path, "r");
        int position = (lineNumber - 1) * lineLength;
        file.seek(position);
        byte[] number = new byte[8];
        byte a = file.readByte();
        int counter = 0;
        while (counter < 8) {
            if (a != 32) {
                number[counter] = a;
                a = file.readByte();
                counter++;
            } else {
                file.close();
                break;
            }
        }
        file.close();
        return number;
    }

    public int getCodeLength(byte[] code) {
        int codeLength = 0;
        for (byte everyByte : code) {
            if (everyByte != 0) {
                codeLength++;
            }
        }
        return codeLength;
    }

    public int howManyLines() throws IOException {
        file = new RandomAccessFile(path, "r");
        return (int) (file.length() / 20); // каждая строка вмещает 20 байт
    }

    public int smallestCodeLength() throws IOException {
        file = new RandomAccessFile(path, "r");
        return getCodeLength(readBytes((int) (file.length() / 20))); // каждая строка вмещает 20 байт
    }

/*    public void printLineNumber(int recievedCodeLength) throws IOException {
        System.out.println(binarySearchSameLength(recievedCodeLength, 0, 10000));
    }*/

    // получаю код в байтах, например [54, 52, 49, 49, 51, 55, 50, 0] он хранится в строке 4810
// бинарный поиск будет переходить по массиву строк, и искать строку нужной длины
//                                              code length  0       how many lines
    public int searchSameLength(int key) throws IOException {
        int high = howManyLines();
        int low = 0;
        int lineNumber = 1;
        while (low <= smallestCodeLength()) {
            int mid = (low + high) / 2;
            if (getCodeLength(readBytes(mid)) < key) {
                low = mid + 1;
            } else if (getCodeLength(readBytes(mid)) > key) {
                high = mid - 1;
            } else if (getCodeLength(readBytes(mid)) == key) {
                lineNumber = mid;
                break;
            }
        }
        return lineNumber;
    }

/*    public int higherOrLower(int lineNumber) throws IOException {
        if (Arrays.equals(readBytes(lineNumber), TESTCODE)) {
            return 0;
        } else if (Arrays.compare(readBytes(lineNumber), TESTCODE) < 0) {
            return -1;
        }
        return 1; //current code is located above entered
    }*/

/*    public void nioReadWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        //Charset charset = Charset.forName("UTF-8"); // пример того, как дать понять джаве, если формат записей в файле отличается от стандарта
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String c;
            while ((c = reader.readLine()) != null) {
                System.out.println(c);
            }
        }
    }*/


}
