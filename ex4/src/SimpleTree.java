public class SimpleTree implements BinaryTree{

    /**Returns minimum number of nodes in depth h*/
    public static int findMinNodes(int h){
        return 2^h-1;
    }

    /**Returns maximum number of nodes in depth h*/
    public static int findMaxNodes(int h) {
        return 2^(h+1)-1;
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
}
