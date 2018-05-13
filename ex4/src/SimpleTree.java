public abstract class SimpleTree implements BinaryTree{

    /**Returns minimum number of nodes in depth h*/
    public static int findMinNodes(int h){
        return 2^h-1;
    }

    /**Returns maximum number of nodes in depth h*/
    public static int findMaxNodes(int h) {
        return 2^(h+1)-1;
    }
}
