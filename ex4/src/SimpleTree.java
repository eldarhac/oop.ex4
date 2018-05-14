public class SimpleTree implements BinaryTree {

    private Node root;

    public SimpleTree(){
    }

    @Override
    public boolean add(int newValue) {
        return addHelper(root, newValue)!=null;
    }

    @Override
    public boolean delete(int value) {
        return false;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**Helper function for add.
     * Runs recursively on nodes of the tree, until reached the right place
     * for assertion, Than asserts value. Returns a pointer to Node where
     * checking continues from.
     * */
    private Node addHelper(Node root, int val){
        if(val > root.getData()){
            if (root.getRightDaughter()!=null){
                return addHelper(root.getRightDaughter(), val);
            }
            root.setRightDaughter(new Node(root, val));
            return root.getRightDaughter();
        }
        else if(val < root.getData()){
            if (root.getLeftSon()!=null){
                return addHelper(root.getLeftSon(), val);
            }
            root.setLeftSon(new Node(root, val));
            return root.getLeftSon();
        }
        return null;
    }

    /**Returns minimum number of nodes in depth h*/
    public static int findMinNodes(int h){
        return 2^h-1;
    }

    /**Returns maximum number of nodes in depth h*/
    public static int findMaxNodes(int h) {
        return 2^(h+1)-1;
    }
}
