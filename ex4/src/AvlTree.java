public class AvlTree implements BinaryTree{
    /**This is the root of the AVL tree*/
    private Node root;

    /**This is the default constructor*/
    public AvlTree(){
    root = new Node();
    }

    private static void heightUpIfNeeded(Node root, boolean isRight){
        if (isRight){
            if((root.getLeftSon()==null)||(root.getRightDaughter()!=null&&
                    root.getLeftSon().getHeight()<=root.getRightDaughter().getHeight())){
                root.heightUp();
            }
        }
        else {
            if((root.getRightDaughter()==null)||(root.getLeftSon()!=null&&
                    root.getRightDaughter().getHeight()<=root.getLeftSon().getHeight())){
                root.heightUp();
            }
        }

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
        //TODO: Father pointer and if (null)
        Node leftSon = node.getLeftSon();
        Node leftRightGrand = leftSon.getRightDaughter();
        leftSon.setRightDaughter(node);
        node.setLeftSon(leftRightGrand);
        return leftSon;
    }

    /**This is responssible for the left rotation when needed*/
    private Node leftRotation(Node node) {
        //TODO: Father pointer and if (null)
        Node rightGirl = node.getRightDaughter();
        Node rightLeftGrand = rightGirl.getLeftSon();
        rightGirl.setLeftSon(node);
        node.setLeftSon(rightLeftGrand);
        return rightGirl;
    }

    /**Goes upward from given leaf until recognizes interference.*/
    private Node getInterference(Node leaf){
        if (Math.abs(leaf.getBalance()) > 1){
            return leaf;
        }
        return getInterference(leaf.getFather());
    }

    /**
     * fixes the interference detected by using left and right rotations
     */
    private void fixInterference(Node leaf) {
        Node badNode = getInterference(leaf);
        Node rightGirl = badNode.getRightDaughter();
        Node leftSon = badNode.getLeftSon();
        int balance = badNode.getBalance();
        if (badNode.getBalance() > 1) {
            if(rightGirl.getBalance() < 0){
                rightRotation(rightGirl);
            }
            leftRotation(badNode);
        }
        else{
            if(leftSon.getBalance() > 0){
                leftRotation(leftSon);
            }
            rightRotation(badNode);
        }
    }

    /**Helper function for add.
     * Runs recursively on nodes of the tree, until reached the right place
     * for assertion, Than asserts value. Returns a pointer to Node where
     * checking continues from.
     * */
    private Node helper(Node root, int val, boolean isAdd){
        Node wanted;
        if(val > root.getData()){
            if (root.getRightDaughter()==null) {
                if(isAdd){
                    root.setRightDaughter(new Node(root, val));
                    root.sizeUp();
                    heightUpIfNeeded(root, true);
                }
                return root.getRightDaughter();
            }
            else {
                wanted = helper(root.getRightDaughter(), val, isAdd);
                if(wanted!=null){
                    if(isAdd) {
                        root.sizeUp();
                        heightUpIfNeeded(root, true);
                    }
                    return(wanted);
                }
            }
        }
        else if(val < root.getData()){
            if (root.getLeftSon()==null) {
                if(isAdd) {
                    root.setLeftSon(new Node(root, val));
                    root.sizeUp();
                    heightUpIfNeeded(root, false);
                }
                return root.getLeftSon();
            }
            else {
                wanted = helper(root.getLeftSon(), val, isAdd);
                if(wanted!=null){
                    if(isAdd) {
                        root.sizeUp();
                        heightUpIfNeeded(root, false);
                    }
                    return wanted;
                }
            }
        }
        return null;
    }

    /***/
    private Node deleteHelper(Node root, int val){
        Node wanted;
        if(val > root.getData()){
            if (root.getRightDaughter()==null) {
                return null;
            }
            else {
                wanted = deleteHelper(root.getRightDaughter(), val);
                if(wanted!=null){
//                        root.sizeUp();
//                        heightUpIfNeeded(root, true);
                        return(wanted);
                }
            }
        }
        else if(val < root.getData()){
            if (root.getLeftSon()==null) {
                return null;
            }
            else {
                wanted = deleteHelper(root.getLeftSon(), val);
                if(wanted!=null){
//                        root.sizeUp();
//                        heightUpIfNeeded(root, false);
                        return wanted;
                }
            }
        }
        else{
            //TODO reattaching remaining elements
            wanted = root;
            return wanted;
        }
        return null;
    }

    /***/
    @Override
    public boolean add(int newValue) {
        Node newNode = helper(root, newValue, true);
        boolean added = newNode!=null;
        if(added){
            if(Math.abs(root.getBalance()) > 1){
                fixInterference(newNode);
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
        return helper(root,value,false) == null;
    }

    @Override
    public int size() {
        return root.getSize();
    }

    public String toString (){
        return "";
    }
}
