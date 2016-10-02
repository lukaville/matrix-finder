package matrix.writer;

import matrix.finder.CharacterPosition;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileCharacterPositionsWriter {
    public static final String OUTPUT_FILE_CHARSET = "UTF-8";

    private String fileName;

    public FileCharacterPositionsWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(List<CharacterPosition> positions) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName, OUTPUT_FILE_CHARSET)) {
            if (positions == null) {
                writer.println("Impossible");
            } else {
                for (CharacterPosition position : positions) {
                    writer.printf("%s - (%s, %s);%n", position.getCharacter(), position.getRow(), position.getColumn());
                }
            }
        }
    }
}
