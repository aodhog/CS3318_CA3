package ie.ucc.csgate.cs3318.ca3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColourTest {
    @Fast
    @Test
    void testConstructorFloats() throws Exception{
        final Colour colourFloat = new Colour(0.1f, 0.3f, 1.0f);
        assertEquals("#194CFF", colourFloat.getHex());
    }
    @Fast
    @Test
    void testConstructorHex() throws Exception {
        final Colour colourHex = new Colour("01CC3F");
        assertEquals("1, 204, 63", colourHex.getRGB());
    }
}