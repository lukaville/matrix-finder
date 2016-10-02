package matrix.reader;

import java.io.IOException;

/**
 * Интерфейс чтения матрицы
 */
public interface MatrixReader {
    /**
     * Начать чтение матрицы
     *
     * @param callback обратный вызов, в который передается каждый следующий элемент матрицы в нижнем регистре
     * @throws IOException
     */
    void readMatrix(CharCallback callback) throws IOException;
}
