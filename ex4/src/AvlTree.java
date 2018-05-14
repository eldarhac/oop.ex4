public class AvlTree extends SimpleTree{
    /**This is the root of the AVL tree*/
    private Node root;

    /**This is the default constructor*/
    public AvlTree(){
    root = new Node();
    }

    /**This is responssible for the right rotation when needed*/
    private Node rightRotation(Node node) {
        Node leftSon = node.getLeftSon();
        Node leftRightGrand = leftSon.getRightDaughter();
        leftSon.setRightDaughter(node);
        node.setLeftSon(leftRightGrand);
        return leftSon;
    }

    private Node leftRotation(Node node){
        Node rightGirl = node.getRightDaughter();
        Node rightLeftGrand = rightGirl.getLeftSon();
        rightGirl.setLeftSon(node);
        node.setLeftSon(rightLeftGrand);
        return  rightGirl;
    }

    @Override
    public boolean add(int value) {

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
