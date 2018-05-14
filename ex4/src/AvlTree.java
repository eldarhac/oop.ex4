public class AvlTree extends SimpleTree{

    private Node root;

    /**This is the root of the AVL tree*/
    public AvlTree() {
    }

    /**Goes upward from given leaf until recognizes interference.*/
    private Node getInterference(Node leaf){
        if (Math.abs(leaf.getBalance()) > 1){
            return leaf;
        }
        return getInterference(leaf.getFather());
    }

    /**
     *
     */
//    private void fixInterference(Node leaf){
//       Node badNode = getInterference(leaf);
//       int balance = badNode.getBalance();
//       if(badNode.getBalance() > 0){
//           if(badNode.getLeftSon().getBalance() > 0) {
//               rotateRight(badNode);
//           }
//           else {
//               rightLeftRotation(badNode);
//           }
//       }
//
//        }
//       else if(badNode.getBalance() < 0 && badNode.getRightDaughter().getBalance() < 0){
//           rotateLeft(badNode);
//       }
//       else if(badNode.getBalance())
//    }

    /**Helper function for add.
     * Runs recursively on nodes of the tree, until reached the right place
     * for assertion, Than asserts value. Returns a pointer to Node where
     * checking continues from.
     * */
    private Node addHelper(Node root, int val){
        if(val > root.getData()){
//            root.heightUp();
            root.sizeUp();
            if (root.getRightDaughter()!=null){
                return addHelper(root.getRightDaughter(), val);
            }
            root.setRightDaughter(new Node(root, val));
            return root.getRightDaughter();
        }
        else if(val < root.getData()){
//            root.heightUp();
            root.sizeUp();
            if (root.getLeftSon()!=null){
                return addHelper(root.getLeftSon(), val);
            }
            root.setLeftSon(new Node(root, val));
            return root.getLeftSon();
        }
        return null;
    }

    /***/
    @Override
    public boolean add(int newValue) {
        Node newNode = addHelper(root, newValue);
        boolean added = newNode!=null;
        if(added){
            if(Math.abs(root.getBalance()) > 1){
//                fixInterference(newNode);
            }
            return true;
        }
        return false;
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

    public String toString (){
        return "";
    }
}
