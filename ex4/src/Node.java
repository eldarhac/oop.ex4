public class Node{
    /**This class implements the nodes that the tree is built of*/


    //data members
    /**This is the pointer to the right son of the node*/
    private Node rightDaughter;

    /**This is the pointer to the left son*/
    private Node leftSon;

    /**This is a boolean represent if the node is empty*/
    private boolean isEmpty;

    /**This is the pointer to the father */
    private Node father;

    /**This is the size of the sub setOf the tree*/
    private int Size;

    /**This represents the data of the node*/
    private int data;


    //contructor
    /**This is the defult constructor for al leaf (no sons)*/
    public Node (){
    data = 0;
    isEmpty = true;
    }

    public Node (Node fatherNode,int value){
        father = fatherNode;
        data = value;
        Size = 0;

    }



    //methods

    /**This sets the right son
     * @param newSon the new right son */
    protected void setRightDaughter(Node newSon){
        rightDaughter = newSon;
    }

    /**This returns the Right Node
     * @return the right daughter of the node*/
    public Node getRightDaughter() {
        return rightDaughter;
    }

    /**This returns the left Node
     * @return the left son of the node*/
    public Node getLeftSon() {
        return leftSon;
    }

    /**This returns the right Node
     * @param leftSon new left son*/
    public void setLeftSon(Node leftSon) {
        this.leftSon = leftSon;
    }

    /**This returns the father
     * @return the nodes father*/
    public Node getFather() {
        return father;
    }

    /**This sets the father
     * @param father the new father */
    public void setFather(Node father) {
        this.father = father;
    }

    /**This gets the size
     * @return the size*/
    public int getSize() {
        return Size;
    }

    /**
     * This sets the size
     * @param state the new size
     */
    public void isEmpty(boolean state) {
        isEmpty = state;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
