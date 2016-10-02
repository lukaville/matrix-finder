import matrix.finder.CharacterPosition;
import matrix.finder.MatrixFinder;
import matrix.reader.FileMatrixReader;
import matrix.writer.FileCharacterPositionsWriter;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    private static final String SUBSTRING = "onetwotrip";

    public static void main(String[] args) throws IOException {
        MatrixFinder matrixFinder = new MatrixFinder(new FileMatrixReader(INPUT_FILE_NAME));

        List<CharacterPosition> positions = matrixFinder.findSubstring(SUBSTRING);

        FileCharacterPositionsWriter writer = new FileCharacterPositionsWriter(OUTPUT_FILE_NAME);
        writer.write(positions);
    }
}
