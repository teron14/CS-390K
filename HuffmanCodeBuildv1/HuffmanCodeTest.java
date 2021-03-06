import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.HashMap;

/**
 * Tests for HuffmanCode.
 *
 * @author Bennett Alex Myers
 * @version 14 October 2016
 */
public class HuffmanCodeTest {

    /** Frequency table corresponding to "roadrunner" */
    private static final HashMap<Character, Double> TABLE;

    /** Initialization for TABLE. */
    static {
        TABLE = new HashMap<>();
        TABLE.put('r', 0.3);
        TABLE.put('o', 0.1);
        TABLE.put('a', 0.1);
        TABLE.put('d', 0.1);
        TABLE.put('u', 0.1);
        TABLE.put('n', 0.2);
        TABLE.put('e', 0.1);
    }

    /** Symbol-to-code map for "roadrunner". */
    private static final Map<Character, StringOfBits> MAP;

    /** Initialization for MAP. */
    static {
        MAP = new HashMap<>();
        MAP.put('r', new StringOfBits("11"));
        MAP.put('o', new StringOfBits("100"));
        MAP.put('a', new StringOfBits("001"));
        MAP.put('d', new StringOfBits("1011"));
        MAP.put('u', new StringOfBits("1010"));
        MAP.put('n', new StringOfBits("01"));
        MAP.put('e', new StringOfBits("000"));
    }

    /**
     * Tests for Huffman code generated by frequency table.
     */
    @Test
    public void tableDecodeEncodeTest() {
        HuffmanCode hc = new HuffmanCode(TABLE);
        String input;
        StringOfBits encoded;
        String decoded;
        String[] words = {"",
                "unordered",
                "rodeo",
                "neuron",
                "under",
                "round"};
        for (String word : words) {
            input = word;
            encoded = hc.encode(input);
            decoded = hc.decode(encoded);
            assertEquals(decoded, input);
        }
    }

    /**
     * Tests for Huffman code generated by symbol-code mapping.
     */
    @Test
    public void mapDecodeEncodeTest() {
        HuffmanCode hc = new HuffmanCode(MAP);
        String input;
        StringOfBits encoded;
        String decoded;
        String[] words = {"",
                "unordered",
                "rodeo",
                "neuron",
                "under",
                "round"};
        for (String word : words) {
            input = word;
            encoded = hc.encode(input);
            decoded = hc.decode(encoded);
            assertEquals(decoded, input);
        }
    }

    /**
     * Tests for Huffman code generated by string seed.
     */
    @Test
    public void seededDecodeEncodeTest() {
        HuffmanCode hc = new HuffmanCode("roadrunner");
        String input;
        StringOfBits encoded;
        String decoded;
        String[] words = {"",
                "unordered",
                "rodeo",
                "neuron",
                "under",
                "round"};
        for (String word : words) {
            input = word;
            encoded = hc.encode(input);
            decoded = hc.decode(encoded);
            assertEquals(decoded, input);
        }
    }
}

