public interface BinaryTree{

    /**Adds value to right place in tree*/
    boolean add(int value);

    /**Deletes value from tree (if exists)*/
    boolean delete(int value);

    /**Returns true if value contained in tree*/
    boolean contains(int value);

    /**Returns size of tree*/
    public int size();

}
