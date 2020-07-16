package puzzle;

/**
 * class for the nodes used in the tree search.
 * @author Timmy
 *
 */
public class TreeNode implements Comparable<TreeNode>
{
	/* global value to know what the next order added to the queue*/
	private static int nextorder = 0;
	/*order the node was added to the queue*/
	private int order;
	/*the parent of the node*/
	private TreeNode parent;
	/*current gameboard for this node*/
	private GameBoard theBoard;
	/* search type being used*/
	private String type;
	/*depth of this node*/
	private int level;
	
	/**
	 * constructor of the tree nodes
	 * @param theParent parent of the node
	 * @param newBoard the board for this node
	 * @param newType the type of search used
	 */
	public TreeNode(TreeNode theParent,GameBoard newBoard, String newType)
	{
		type = newType;
		parent = theParent;
		theBoard = newBoard;
		if(parent == null)
		{
			level = 0;
		}
		else
		{
			level = parent.getLevel() + 1;
		}
	      this.order = nextorder;
	      TreeNode.nextorder++;
	}
	/**
	 * getter for the depth
	 * @return depth of this node on the tree
	 */
	public int getLevel()
	{
		return level;
	}
	/**
	 * getter for the gameboard
	 * @return the gameboard in this node
	 */
	public GameBoard getBoard()
	{
		return theBoard;
	}
	/**
	 * getter for the order added to the queue
	 * @return the order added to the queue
	 */
	public int getOrder()
	{
		return order;
	}
	@Override
	public int compareTo(TreeNode check)
	{
	      int result;
	      if(type.equals("AStar"))
	      {
	    	  result = (this.theBoard.getHeuristic() + this.getLevel()) - (check.getBoard().getHeuristic() + check.getLevel());
	      }
	      else if(type.equals("GBFS"))
	      {
	    	  result = (this.theBoard.getHeuristic()) - (check.getBoard().getHeuristic());
	      }
	      else
	      {
	    	  result = 0;
	      }
	      if (result == 0)
	      {
	         result = this.getOrder() - check.getOrder();
	      }
	      return result;
	   }
}
