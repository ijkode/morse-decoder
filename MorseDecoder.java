public class MorseDecoder {

    private BTree<String> morseTree;

    public MorseDecoder() {
        morseTree = new BTree<>();
        try {
            morseTree.addByPath("start", "");
            morseTree.addByPath("T", "R");
            morseTree.addByPath("M", "RR");
            morseTree.addByPath("O", "RRR");
            morseTree.addByPath("", "RRRR");
            morseTree.addByPath("", "RRRL");
            morseTree.addByPath("G", "RRL");
            morseTree.addByPath("Q", "RRLR");
            morseTree.addByPath("Z", "RRLL");
            morseTree.addByPath("N", "RL");
            morseTree.addByPath("K", "RLR");
            morseTree.addByPath("Y", "RLRR");
            morseTree.addByPath("C", "RLRL");
            morseTree.addByPath("D", "RLL");
            morseTree.addByPath("X", "RLLR");
            morseTree.addByPath("B", "RLLL");
            morseTree.addByPath("E", "L");
            morseTree.addByPath("A", "LR");
            morseTree.addByPath("W", "LRR");
            morseTree.addByPath("J", "LRRR");
            morseTree.addByPath("P", "LRRL");
            morseTree.addByPath("R", "LRL");
            morseTree.addByPath("", "LRLR");
            morseTree.addByPath("L", "LRLL");
            morseTree.addByPath("I", "LL");
            morseTree.addByPath("U", "LLR");
            morseTree.addByPath("", "LLRR");
            morseTree.addByPath("F", "LLRL");
            morseTree.addByPath("S", "LLL");
            morseTree.addByPath("V", "LLLR");
            morseTree.addByPath("H", "LLLL");
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
    }
    //return string (pre-order NLR)
    public String toString() {
        return morseTree.pre();
    }
    //the function get string of "." , "-", and return decoded string with morse code
    public String decode(String morseStr) throws InvalidMorseCodeException {
        if (morseStr.equals("")) {
            throw new InvalidMorseCodeException("InvalidMorseCode");
        }

        String path="";
        for (int i = 0; i < morseStr.length(); i++) {
            if (morseStr.charAt(i) == '.') {
                path += "L";
            } else if (morseStr.charAt(i) == '-') {
                path += "R";
            } else {
                throw new InvalidMorseCodeException("InvalidMorseCode");
            }
        }

        String ret = "";

        try {
            ret = morseTree.findByPath(path);
            if (ret.equals("")) {
                throw new InvalidMorseCodeException("InvalidMorseCode");
            }
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
