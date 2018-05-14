public class AvlTree extends SimpleTree{
    //constants
    /**This represents a situation in which we want to add*/
    private static final String ADD = "add";

    /**This represents a case in which we want to subtract*/
    private static final String SUB = "sub";

    //data members
    /**This is the root of the AVL tree*/
    private Node root;


    //constructors
    /**This is the default constructor*/
    public AvlTree(){
    root = new Node();
    }

    /**This adds the height for the whole sub tree
     * @param node the root of the subtree
     */
    private void addHeightToSub (Node node){
        node.setHieght(node.getHeight()+1);
        Node rightGirl = node.getRightDaughter();
        if (rightGirl!= null){
            addHeightToSub(rightGirl);
        }
        Node leftSon = node.getLeftSon();
        if (leftSon != null){
            addHeightToSub(leftSon);
        }
    }


    /**This adds the height for the whole sub tree
     * @param node the root of the subtree
     */
    private void subHeightToSub (Node node){
        node.setHieght( node.getHeight()-1);
        Node rightGirl = node.getRightDaughter();
        if (rightGirl!= null){
            subHeightToSub(rightGirl);
        }
        Node leftSon = node.getLeftSon();
        if (leftSon != null){
            subHeightToSub(leftSon);
        }
    }

    /**This is responssible for the right rotation when needed*/
    private Node rightRotation(Node node) {
        //change locations
        Node leftSon = node.getLeftSon();
        Node leftRightGrand = leftSon.getRightDaughter();
        leftSon.setRightDaughter(node);
        node.setLeftSon(leftRightGrand);

        //update heights
        int leftSonHeight = leftSon.getHeight();
        leftSon.setHieght(node.getHeight());
        node.setHieght(leftSonHeight);
        addHeightToSub(leftSon.getLeftSon()); // adds 1 height to all the left sub of the original left son

        //update size
        leftSon.setSize(node.getSize());
        node.setSize(node.getRightDaughter().getSize()+node.getLeftSon().getSize());
        return leftSon;
    }

    private Node leftRotation(Node node) {
        Node rightGirl = node.getRightDaughter();
        Node rightLeftGrand = rightGirl.getLeftSon();
        rightGirl.setLeftSon(node);
        node.setLeftSon(rightLeftGrand);
        return rightGirl;
    }

        /**Goes upward from given leaf until recognizes interference.*/
        private Node getInterference (Node leaf){
            if (Math.abs(leaf.getBalance()) > 1) {
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
