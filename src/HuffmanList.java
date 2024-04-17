import java.util.Hashtable;

public class HuffmanList {
    Node head = null;

    public void add(char w) {
        Node newNode = getNode(w);
        if (newNode != null) {
            newNode.setFreq(newNode.getFreq() + 1);
        } else {
            newNode = new Node(w);
            if (head == null)
                head = newNode;
            else {
                Node walk=head;
                while (walk.getNext()!=null){
                    walk=walk.getNext();
                }
                walk.setNext(newNode);
            }
        }
    }



    private Node getNode(char s) {
        Node walk = head;
        while (walk != null) {
            if (walk.getLetter().equals(s))
                return walk;
            walk = walk.getNext();
        }
        return null;
    }
    public void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp);
            temp = temp.getNext();
        }

    }
    public HuffmanList sortList(){
        HuffmanList sortedList = new HuffmanList();
        Node walk = this.head ;
        while (walk != null){
            Node newNode = new Node(walk.getLetter(),walk.getFreq());
            sortedList.insertByAscending(newNode);
            walk = walk.getNext();
        }
        return sortedList;
    }

    private void insertByAscending(Node newNode) {
        if (head == null)
            head = newNode;
        else if(head.getNext()==null)
            head.setNext(newNode);
        else {
            Node walk = head;
            while (walk.getNext() != null) {
                if (walk.getNext().getFreq() > newNode.getFreq() ){
                    newNode.setNext(walk.getNext());
                    walk.setNext(newNode);
                    break;
                }
                else if (walk.getNext().getNext()==null){
                    walk.getNext().setNext(newNode);
                    break;
                }
                walk = walk.getNext();
            }
        }
    }
    public void constructTree(){
        Node walk = head;
        while(walk.getNext().getNext()!=null){
            Node bNode=new Node();
            bNode.setRight(walk.getNext());
            bNode.setLeft(walk);
            bNode.setFreq(bNode.getLeft().getFreq()+bNode.getRight().getFreq());
            walk = walk.getNext().getNext();
            head=walk;
            bNode.getRight().setNext(null);
            bNode.getLeft().setNext(null);
            insertByAscending(bNode);
        }
        if(walk.getNext().getNext()==null){
            Node root = new Node();
            root.setRight(walk.getNext());
            root.setLeft(walk);
            root.setFreq(root.getLeft().getFreq()+root.getRight().getFreq());
            head=root;
            root.getLeft().setNext(null);
        }
    }

    public void inorder(){
        inorder(head);
    }
    private void inorder(Node r){
        if (r==null)
            return;
        inorder(r.getLeft());
        System.out.print(r.getLetter()+" "+r.getFreq()+" "+r.getCode()+"\n");
        inorder(r.getRight());
    }
    public void encodeTree(){
        head=encodeTree(head,"");
    }
    private Node encodeTree(Node root, String s) {
        if (root==null)
            return null;
        if (root.getLeft() == null && root.getRight() == null ) {
            root.setCode(s);
        }
        root.setLeft(encodeTree(root.getLeft(), s + "0"));
        root.setRight(encodeTree(root.getRight(), s + "1"));
        return root;
    }
    public void createCodeTable(Hashtable<Character, String> hm){
        createCodeTable(head,hm);
    }
    private void createCodeTable(Node root,Hashtable<Character, String> hm) {
        if (root==null)
            return;
        if (root.getLeft() == null && root.getRight() == null ) {
            hm.put(root.getLetter(),root.getCode());
        }
        createCodeTable(root.getLeft(),hm);
        createCodeTable(root.getRight(),hm);

    }

}