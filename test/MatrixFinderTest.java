import matrix.finder.CharacterPosition;
import matrix.finder.MatrixFinder;
import matrix.reader.MatrixReader;
import matrix.reader.MemoryMatrixReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class MatrixFinderTest {
    private static void assertCorrectSubstring(char[][] matrix, String substring, List<CharacterPosition> positions) {
        for (int i = 0; i < positions.size(); i++) {
            CharacterPosition position = positions.get(i);

            char matrixCharacter = matrix[position.getRow()][position.getColumn()];
            char substringCharacter = substring.charAt(i);

            assertEquals(
                    Character.toLowerCase(matrixCharacter),
                    Character.toLowerCase(substringCharacter)
            );

            // Удостоверимся, что каждый символ используется один раз
            matrix[position.getRow()][position.getColumn()] = '\0';
        }
    }

    @Test
    public void testFindSubstring() throws IOException {
        char[][] matrix = new char[][]{
                {'n', 'O', 'e', '1'},
                {'T', 'w', 'o', '2'},
                {'T', 'r', 'i', 'p'}
        };
        String substr = "onetwotrip";

        MatrixReader reader = new MemoryMatrixReader(matrix);
        MatrixFinder finder = new MatrixFinder(reader);

        List<CharacterPosition> positions = finder.findSubstring(substr);
        assertCorrectSubstring(matrix, substr, positions);
    }

    @Test
    public void testFindSubstringImpossible() throws IOException {
        char[][] matrix = new char[][]{
                {'w', '1'},
                {'T', 'w'},
                {'Q', 'r'}
        };
        String substr = "qwerty";

        MatrixReader reader = new MemoryMatrixReader(matrix);
        MatrixFinder finder = new MatrixFinder(reader);

        List<CharacterPosition> positions = finder.findSubstring(substr);
        assertNull(positions);
    }
}
