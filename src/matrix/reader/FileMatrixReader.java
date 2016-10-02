package matrix.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Читает матрицу из файла. В первой строке должны быть указаны высота и ширина матрицы
 * через пробел. Следующие строки должны содержать символы матрицы.
 * <p>
 * Пример содержимого файла:
 * 3 4
 * 1234
 * 4567
 * 9754
 */
public class FileMatrixReader implements MatrixReader {
    public static final String INPUT_FILE_CHARSET = "UTF-8";

    private String fileName;

    public FileMatrixReader(String fileName) {
        this.fileName = fileName;
    }

    public void readMatrix(CharCallback callback) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName),
                        Charset.forName(INPUT_FILE_CHARSET)
                )
        )) {
            String[] size = reader.readLine().split(" ");
            short height = (short) Integer.parseInt(size[0]);
            short width = (short) Integer.parseInt(size[1]);

            int c, currentIndex = 0;
            while ((c = reader.read()) != -1) {
                if (c == '\r' || c == '\n') {
                    continue;
                }

                char character = (char) c;
                short column = (short) (currentIndex % width);
                short row = (short) ((currentIndex - column) / height);

                boolean stop = callback.onNextChar(
                        row,
                        column,
                        Character.toLowerCase(character)
                );

                if (stop) {
                    break;
                }

                currentIndex++;
            }
        }
    }
}
