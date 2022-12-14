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

    @Fast
    @Test
    void testConstructorBadFloatOver1(){
        boolean caught = false;
        try {
            final Colour colourFloat = new Colour(0.1f, 0.3f, 1.1f);

        } catch (Exception e){
            caught = true;
        }
        assertTrue(caught);
    }

    @Fast
    @Test
    void testConstructorBadFloatUnder0(){
        boolean caught = false;
        try {
            final Colour colourFloat = new Colour(-0.1f, 0.3f, 1.0f);

        } catch (Exception e){
            caught = true;
        }
        assertTrue(caught);
    }

    @Fast
    @Test
    void testConstructorBadHexDigit(){
        boolean caught = false;
        try {
            final Colour colourHex = new Colour("12345Z");

        } catch (Exception e){
            caught = true;
        }
        assertTrue(caught);
    }

    @Fast
    @Test
    void testConstructorBadHexLengthLong(){
        boolean caught = false;
        try {
            final Colour colourFloat = new Colour("1234567");

        } catch (Exception e){
            caught = true;
        }
        assertTrue(caught);
    }

    @Fast
    @Test
    void testConstructorBadHexLengthShort(){
        boolean caught = false;
        try {
            final Colour colourFloat = new Colour("12345");

        } catch (Exception e){
            caught = true;
        }
        assertTrue(caught);
    }

    @Fast
    @Test
    void getHex() throws Exception {
        final Colour colourFloat = new Colour(0.1f, 0.3f, 1.0f);
        final Colour colourHex = new Colour("01CC3F");

        assertEquals("#194CFF", colourFloat.getHex());
        assertEquals("#01CC3F", colourHex.getHex());

    }

    @Fast
    @Test
    void getRGB() throws Exception {
        final Colour colourFloat = new Colour(0.1f, 0.3f, 1.0f);
        final Colour colourHex = new Colour("01CC3F");

        assertEquals("25, 76, 255", colourFloat.getRGB() );
        assertEquals("1, 204, 63", colourHex.getRGB());

    }
    @Fast
    @Test
    void testEquals() throws Exception {
        final Colour colourFloat = new Colour(0.1f, 0.3f, 1.0f);
        final Colour colourHex = new Colour("194CFF");

        assertEquals(colourFloat, colourHex);
    }

    @Test
    void testToString() throws Exception {
        final Colour colourFloat = new Colour(0.1f, 0.3f, 1.0f);
        final Colour colourHex = new Colour("194CFF");

        assertEquals("Colour{" +
                "Red=" + 25 + "/255" +
                ", Green=" + 76 + "/255" +
                ", Blue=" + 255 + "/255" +
                ", Hexadecimal Code='" + "#194CFF" + '\'' +
                '}', colourFloat.toString());
        assertEquals("Colour{" +
                "Red=" + 25 + "/255" +
                ", Green=" + 76 + "/255" +
                ", Blue=" + 255 + "/255" +
                ", Hexadecimal Code='" + "#194CFF" + '\'' +
                '}', colourHex.toString());
    }
}