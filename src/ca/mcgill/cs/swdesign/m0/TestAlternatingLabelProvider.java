package ca.mcgill.cs.swdesign.m0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the AlternatingLabelProvider.
 */
public class TestAlternatingLabelProvider
{
    private static final String LABEL_1 = "AAA";
    private static final String LABEL_2 = "BBB";

    private AlternatingLabelProvider aFixture;

    /**
     * Initializes the test fixture.
     */
    @BeforeEach
    public void setup()
    {
        aFixture = new AlternatingLabelProvider(LABEL_1, LABEL_2);
    }

    /**
     * Tests the entire class.
     */
    @Test
    public void testAll()
    {
        assertEquals(LABEL_1, aFixture.getLabel(true));
        assertEquals(LABEL_2, aFixture.getLabel(false));
        assertEquals(LABEL_1 + " " + LABEL_2, aFixture.getBoth());
    }
}