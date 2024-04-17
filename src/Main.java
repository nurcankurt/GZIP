import java.util.*;

public class Main {

    public static void main(String[] args) {
        String input = "CABRACADABRAR";
        
        // Step 1: Compress with LZ77
        List<Tuple> lz77Output = LZ77.compress(input);
        
        // Step 2: Compress with Huffman
        Hashtable<Character, String> huffmanCodes = compressWithHuffman(lz77Output);

        // Print Huffman codes
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Hashtable<Character, String> compressWithHuffman(List<Tuple> lz77Output) {
        HuffmanList freqList = new HuffmanList();
        Hashtable<Character, String> hm = new Hashtable<>();

        // Convert LZ77 output to frequency list
        for (Tuple tuple : lz77Output) {
            freqList.add(tuple.getCharacter());
        }

        HuffmanList sortedByIncreasing = freqList.sortList();
        sortedByIncreasing.constructTree();
        sortedByIncreasing.encodeTree();
        sortedByIncreasing.createCodeTable(hm);

        return hm;
    }
}
