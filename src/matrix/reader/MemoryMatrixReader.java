package matrix.reader;

import java.io.IOException;

/**
 * Читает матрицу из массива, переданного в конструктор
 */
public class MemoryMatrixReader implements MatrixReader {
    private final char[][] matrix;

    public MemoryMatrixReader(char[][] matrix) {
        this.matrix = matrix;
    }

    public void readMatrix(CharCallback callback) throws IOException {
        for (short row = 0; row < matrix.length; ++row) {
            for (short column = 0; column < matrix[0].length; ++column) {
                boolean stop = callback.onNextChar(
                        row,
                        column,
                        Character.toLowerCase(matrix[row][column])
                );

                if (stop) {
                    return;
                }

            }
        }
    }
}
