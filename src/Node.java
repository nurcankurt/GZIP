public class Node {
    private Character letter;
    private int freq;
    private Node next;
    private Node left ;
    private Node right;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String  code) {
        this.code = code;
    }

    public Node(Character letter, int freq) {
        this.letter = letter;
        this.freq = freq;
    }

    public Node() {

    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Character getLetter() {
        return letter;
    }
    public void setLetter(Character letter) {
        this.letter = letter;
    }
    public int getFreq() {
        return freq;
    }
    public void setFreq(int freq) {
        this.freq = freq;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Character l) {
        this.letter =l;
        freq=1;
    }


    @Override
    public String toString() {
        return letter + " " + freq;
    }
}


