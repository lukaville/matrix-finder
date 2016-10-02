package matrix.finder;

/**
 * Хранит символ и его координаты в матрице
 */
public class CharacterPosition {
    private short row = -1;
    private short column = -1;
    private char character;

    public CharacterPosition(char c) {
        this.character = c;
    }

    public CharacterPosition(char character, short row, short column) {
        this.character = character;
        this.column = column;
        this.row = row;
    }

    public void setPosition(short row, short column) {
        this.row = row;
        this.column = column;
    }

    public boolean hasPosition() {
        return row != -1;
    }

    public short getRow() {
        return row;
    }

    public short getColumn() {
        return column;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterPosition that = (CharacterPosition) o;

        if (row != that.row) return false;
        if (column != that.column) return false;
        return character == that.character;

    }

    @Override
    public int hashCode() {
        int result = (int) row;
        result = 31 * result + (int) column;
        result = 31 * result + (int) character;
        return result;
    }
}
