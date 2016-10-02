import matrix.finder.CharacterPosition;
import matrix.finder.CharacterStore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class CharacterStoreTest {

    @Test
    public void testAddOneCharacter() throws Exception {
        CharacterStore store = new CharacterStore("a");
        store.add('a', (short) 1, (short) 2);

        assertEquals(
                store.getPositions().get(0),
                new CharacterPosition('a', (short) 1, (short) 2)
        );
    }

    @Test
    public void testAddSameCharacters() throws Exception {
        CharacterStore store = new CharacterStore("aaa");
        store.add('a', (short) 1, (short) 2);
        store.add('a', (short) 2, (short) 3);
        store.add('a', (short) 5, (short) 6);

        List<CharacterPosition> positions = Arrays.asList(
                new CharacterPosition('a', (short) 1, (short) 2),
                new CharacterPosition('a', (short) 2, (short) 3),
                new CharacterPosition('a', (short) 5, (short) 6)
        );

        assertEquals(store.getPositions(), positions);
    }

    @Test
    public void testCharacterOrder() throws Exception {
        CharacterStore store = new CharacterStore("abc");
        store.add('b', (short) 1, (short) 2);
        store.add('a', (short) 5, (short) 3);
        store.add('c', (short) 2, (short) 3);

        List<CharacterPosition> positions = Arrays.asList(
                new CharacterPosition('a', (short) 5, (short) 3),
                new CharacterPosition('b', (short) 1, (short) 2),
                new CharacterPosition('c', (short) 2, (short) 3)
        );

        assertEquals(store.getPositions(), positions);
    }

    @Test
    public void testNotFilled() throws Exception {
        CharacterStore store = new CharacterStore("aaa");
        store.add('a', (short) 1, (short) 2);
        assertFalse(store.isFilled());
    }

    @Test
    public void testFilled() throws Exception {
        CharacterStore store = new CharacterStore("ab");
        store.add('a', (short) 1, (short) 2);
        store.add('b', (short) 4, (short) 6);
        assertTrue(store.isFilled());
    }
}