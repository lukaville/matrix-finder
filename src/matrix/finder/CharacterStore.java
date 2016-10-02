package matrix.finder;

import java.util.*;

/**
 * Хранит координаты символов строки, указанной в конструкторе
 * Остальные символы игнорируются
 */
public class CharacterStore {
    private String substring;
    private Map<Character, LinkedList<CharacterPosition>> map = new HashMap<>();
    private short characterCount;

    /**
     * @param substring подстрока, содержащая символы для хранения их координат
     */
    public CharacterStore(String substring) {
        this.substring = substring;
        this.characterCount = (short) substring.length();

        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);

            LinkedList<CharacterPosition> positions = map.get(c);

            if (positions == null) {
                positions = new LinkedList<>();
                positions.add(new CharacterPosition(c));
                this.map.put(c, positions);
            } else {
                positions.add(new CharacterPosition(c));
            }
        }
    }

    /**
     * Добавляет новый символ в хранилище. Символы, не содержащиеся в substring игнорируются.
     *
     * @param c      символ
     * @param row    строка
     * @param column столбец
     * @return заполненность хранилища (true — все символы найдены, false — существуют символы без координат)
     */
    public boolean add(char c, short row, short column) {
        List<CharacterPosition> list = map.get(c);

        if (list != null) {
            for (CharacterPosition position : list) {
                if (!position.hasPosition()) {
                    position.setPosition(row, column);
                    characterCount--;
                    break;
                }
            }
        }

        return isFilled();
    }


    /**
     * @return список координат символов в том порядке, которые указаны в строке substring
     */
    public List<CharacterPosition> getPositions() {
        if (!isFilled()) {
            return null;
        }

        List<CharacterPosition> result = new ArrayList<>(substring.length());

        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            LinkedList<CharacterPosition> positions = map.get(c);
            result.add(positions.pop());
        }

        return result;
    }

    /**
     * @return заполненность хранилища (true — все символы найдены, false — существуют символы без координат)
     */
    public boolean isFilled() {
        return characterCount == 0;
    }
}
