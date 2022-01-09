import java.util.ArrayList;

public class BTree<E> {

    private Node<E> root;
    private int size;
    //Constructor
    public BTree (){
        this.root = null;
        this.size = 0;
    }
    //Add new path to the tree as data
    public void addByPath(E data, String path) throws InvalidPathException {
        if (path == "") {
            if (root == null) {
                size += 1;
                root = new Node(data, null, null);
                return;
            } else {
                throw new InvalidPathException("InvalidPath");
            }
        }

        if (root == null) {
            throw new InvalidPathException("InvalidPath");
        }

        Node<E> current = root;
        Node<E> previous = null;
        boolean isNull = false;

        for (int i = 0; i < path.length(); i++) {
            if (isNull){
                throw new InvalidPathException("InvalidPath");
            }
            previous = current;

            if (path.charAt(i) == 'L') {
                current = current.getLeftSon();
            } else if (path.charAt(i) == 'R') {
                current = current.getRightSon();
            } else {
                throw new InvalidPathException("InvalidPath");
            }
        }

        if (current != null) {
            throw new InvalidPathException("InvalidPath");
        } else {
            if (path.charAt(path.length()-1) == 'R'){
                previous.setRightSon(new Node(data, null, null));
                size += 1;
            } else {
                previous.setLeftSon(new Node(data, null, null));
                size += 1;
            }
        }
    }
    //String with pre order (NLR)
    public String pre() {
        String strToReturn = "";

        ArrayList<E> list = new ArrayList<>();
        preRecursion(root, list);
        for (int i=0; i < list.size(); i++) {
            strToReturn += list.get(i);
            if (i<list.size() - 1) {
                strToReturn += ",";
            }
        }

        return strToReturn;
    }
    //helper
    private void preRecursion(Node<E> node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        list.add(node.getData());
        preRecursion(node.getLeftSon(), list);
        preRecursion(node.getRightSon(), list);
    }
    //returns the amount of elements in the tree
    public int getSize() {
        return size;
    }
    //get a string and return the path
    public E findByPath(String path) throws InvalidPathException {
        if (path.equals("")) {
            return root.getData();
        }

        Node<E> current = root;
        boolean isNull = false;
        for (int i = 0; i < path.length(); i++) {
            if (isNull) {
                throw new InvalidPathException("InvalidPath");
            }
            if (path.charAt(i) == 'L') {
                 current = current.getLeftSon();
            } else if (path.charAt(i) == 'R') {
                current = current.getRightSon();
            } else {
                throw new InvalidPathException("InvalidPath");
            }
            if (current == null) {
                isNull=true;
            }
        }

        if (current == null) {
            throw new InvalidPathException("InvalidPath");
        }

        return current.getData();
    }

}
