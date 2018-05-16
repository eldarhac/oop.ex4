import java.util.Iterator;

public class AvlIterator implements Iterator<Integer> {
    private int value;
    private  Node origiNode;
    private Node currentNode;

    public AvlIterator (int newVal, Node newNode){
        value = newVal;
        origiNode = newNode;
        currentNode = newNode;
    }

    /**
     * If This is the first call we want to go to the right subtree, otherwise we want to go all
     * the way to the left.
     * @return if there is a next node in our way
     */
    @Override
    public boolean hasNext() {
        if (currentNode == origiNode){
            return (origiNode.getRightDaughter() != null);
        }
        else return (currentNode.getLeftSon() != null);
    }

    /**This implements the succesor method that returns the elements by order
     * @returnThe next value that is bigger than the given
     */
    @Override
    public Integer next() {
        while (hasNext()) {
            if (currentNode == origiNode)
                currentNode = (origiNode.getRightDaughter());
            else
                currentNode = currentNode.getLeftSon();

            }
        return currentNode.getData();
    }

}
