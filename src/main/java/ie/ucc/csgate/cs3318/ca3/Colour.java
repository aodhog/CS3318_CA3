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
}