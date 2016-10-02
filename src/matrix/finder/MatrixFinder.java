package matrix.finder;

import matrix.reader.MatrixReader;

import java.io.IOException;
import java.util.List;

/**
 * Позволяет производить поиск по матрице
 */
public class MatrixFinder {
    private MatrixReader matrixReader;

    public MatrixFinder(MatrixReader matrixReader) {
        this.matrixReader = matrixReader;
    }

    /**
     * Ищет координаты символов в матрице, образующих строку substring.
     * Поиск производится без учета регистра, сложность — O(MxN).
     *
     * @param substring подстрока для поиска
     * @return список координат символов, если подстрока найдена, иначе — null
     */
    public List<CharacterPosition> findSubstring(String substring) throws IOException {
        CharacterStore characters = new CharacterStore(substring.toLowerCase());
        this.matrixReader.readMatrix((row, column, character) -> characters.add(character, row, column));
        return characters.getPositions();
    }
}
