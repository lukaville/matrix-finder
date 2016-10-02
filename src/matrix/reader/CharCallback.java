package matrix.reader;

public interface CharCallback {
    /**
     * Вызывается при чтении очередного символа матрицы
     *
     * @param row    строка символа
     * @param column столбец символа
     * @param c      символ
     * @return true, если требуется прервать чтение, иначе — false
     */
    boolean onNextChar(short row, short column, char c);
}