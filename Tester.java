public class Tester {

    public static void main(String[] args) {
        MorseDecoder md = new MorseDecoder();
        try {
            System.out.println(md.decode(".-.."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
