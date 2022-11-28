package ie.ucc.csgate.cs3318.ca3;

import java.util.*;

public class Colour {
    private int Red = -1;
    private int Green = -1;
    private int Blue = -1;
    private String Hex;

    public Colour(float R, float G, float B) throws Exception {
        if (R >= 0 && R <= 1 && G >= 0 && G <= 1 && B >= 0 && B <= 1) {
            this.Red = (int) (R * 255);
            this.Green = (int) (G * 255);
            this.Blue = (int) (B * 255);
        } else {
            throw new Exception("Colours must be a floating point number between 0 and 1 inclusive");
        }
        this.Hex = getHex();
    }

    public Colour(String HexString) throws Exception {
        HashMap<String, Integer> HexCodes = new HashMap<String, Integer>();
        HexCodes.put("0", 0);
        HexCodes.put("1", 1);
        HexCodes.put("2", 2);
        HexCodes.put("3", 3);
        HexCodes.put("4", 4);
        HexCodes.put("5", 5);
        HexCodes.put("6", 6);
        HexCodes.put("7", 7);
        HexCodes.put("8", 8);
        HexCodes.put("9", 9);
        HexCodes.put("A", 10);
        HexCodes.put("B", 11);
        HexCodes.put("C", 12);
        HexCodes.put("D", 13);
        HexCodes.put("E", 14);
        HexCodes.put("F", 15);

        if (HexString.length()!=6){
            throw new Exception("Incorrect Hexadecimal code, " +
                    "Hexadecimals must be 6 characters long ");
        }
        if (        HexCodes.containsKey(HexString.substring(0, 1).toUpperCase())
                && HexCodes.containsKey(HexString.substring(1, 2).toUpperCase())
                && HexCodes.containsKey(HexString.substring(2, 3).toUpperCase())
                && HexCodes.containsKey(HexString.substring(3, 4).toUpperCase())
                && HexCodes.containsKey(HexString.substring(4, 5).toUpperCase())
                && HexCodes.containsKey(HexString.substring(5, 6).toUpperCase()))
        {
            int R1 = HexCodes.get(HexString.substring(0, 1).toUpperCase());
            int R2 = HexCodes.get(HexString.substring(1, 2).toUpperCase());
            int G1 = HexCodes.get(HexString.substring(2, 3).toUpperCase());
            int G2 = HexCodes.get(HexString.substring(3, 4).toUpperCase());
            int B1 = HexCodes.get(HexString.substring(4, 5).toUpperCase());
            int B2 = HexCodes.get(HexString.substring(5, 6).toUpperCase());

            this.Red = R1 * 16 + R2;
            this.Green = G1 * 16 + G2;
            this.Blue = B1 * 16 + B2;

            this.Hex = "#" + HexString;
        } else {
            throw new Exception("Incorrect Hexadecimal code, " +
                    "Hexadecimals must feature characters ranging from 0 to 9 or A to F");
        }

    }

    public String getHex() {
        if (this.Red > 15) {
            this.Hex = "#" + Integer.toHexString(this.Red).toUpperCase();
        } else if (this.Red == -1) {
            return this.toString();
        } else {
            this.Hex = "#0" + Integer.toHexString(this.Red).toUpperCase();
        }
        if (this.Green > 15) {
            this.Hex += Integer.toHexString(this.Green).toUpperCase();
        } else if (this.Green == -1) {
            return this.toString();
        } else {
            this.Hex += "0" + Integer.toHexString(this.Green).toUpperCase();
        }
        if (this.Blue > 15) {
            this.Hex += Integer.toHexString(this.Blue).toUpperCase();
        } else if (this.Blue == -1) {
            return this.toString();
        } else {
            this.Hex += "0" + Integer.toHexString(this.Blue).toUpperCase();
        }
        return Hex;
    }
    public String getRGB() {
        return this.Red + ", " + this.Green + ", " + this.Blue;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Colour colours)) return false;
        return Hex.equals(colours.Hex);
    }
    @Override
    public String toString() {
        String str;
        if (Red == -1 || Blue == -1 || Green == -1) {
            str = "Correct values for colours not given. No colour produced.";
        } else {
            str = "Colour{" +
                    "Red=" + Red + "/255" +
                    ", Green=" + Green + "/255" +
                    ", Blue=" + Blue + "/255" +
                    ", Hexadecimal Code='" + Hex + '\'' +
                    '}';
        }
        return str;
    }
}