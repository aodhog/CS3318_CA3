package ie.ucc.csgate.cs3318.ca3;

public class Main {
    public static void main(String[] args) throws Exception {
        Colour colour1 = new Colour(1f, 1f, 1f);
        Colour colour2 = new Colour("12345F");

        System.out.println(colour1);
        System.out.println(colour2);
        System.out.println(colour1.getHex());
        System.out.println(colour2.getRGB());

    }
}