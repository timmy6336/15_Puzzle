package puzzle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


/**
 *  
 * @author Timmy
 * A class for running a search on the 15 puzzle.
 * made to work for Breadth first search, depth first search, greedy best first search
 * A* search and depth limited search. 
 */
public class SearchTree 
{
	/*save file name*/
	private static String MY_FILE = "./resources/ReadMe2.txt";
	/* the type of search used*/
	private String type;
	/* max size the fringe reached*/
	private int maxFringe;
	/*max depth of DLS*/
	private String option;
	/* the initial Gameboard*/
	private GameBoard start;
	/*root of the search tree*/
	private TreeNode root;
	/*fringe for queue based search*/
	private PriorityQueue<TreeNode> fringe1;
	/*fringe for stack based search*/
	private Stack<TreeNode> fringe2;
	/*expanded set*/
	private Set<String> expanded; 
	/*boolean if goal is found*/
	private boolean found;
	
	/**
	 * 
	 * @param theStart start state of the game board
	 * @param newType the type of search
	 * @param newOption special option for choice of heuristic or the max depth
	 * Constructor for the search tree creates the root of the tree.
	 */
	public SearchTree(GameBoard theStart, String newType, String newOption)
	{
		maxFringe = 0;
		option = newOption;
		type = newType;
		expanded = new HashSet<>();
		found = false;
		start = theStart;
		root = new TreeNode(null,start,type);
	}
	
	/**
	 *  Method for finding the path using a priority queue.
	 *  this method is used for the Breadth first search, greedy Breadth first search and A* search 
	 */
	public void findPathQueue()
	{
		fringe1 = new PriorityQueue<>();
		fringe1.add(root);
		int check2 = 0;
		while(!found)
		{
			TreeNode currentNode = fringe1.remove();
			GameBoard currentBoard = currentNode.getBoard();
			int check = expanded.size();
			expanded.add(currentBoard.toString());
			if(check != expanded.size())
			{
				if(currentBoard.getHeuristic() == 0)
				{
					try(BufferedWriter out = new BufferedWriter(new FileWriter(MY_FILE, true))) 
					{
						out.write("Start Board: " + start.toString() + "\n");
						out.write("End Board: " + currentBoard.toString() + "\n");
						out.write("Nodes Created: " + check2 + "\n");
						out.write("Nodes Expanded: " + expanded.size() + "\n");
						out.write("Depth: " + currentNode.getLevel() + "\n");
						out.write("Max Fringe: " + maxFringe + "\n");
						out.write("Search Used: " + type + "\n");
						if(type.equals("AStar") ||type.equals("GBFS"))
						{
							out.write("Heuristic Used: " + option + "\n");
						}
						out.newLine();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					System.out.println(currentBoard);
					System.out.println("Nodes Created: " + check2);
					System.out.println("Nodes Expanded: " + expanded.size());
					System.out.println("Depth: " + currentNode.getLevel());
					System.out.println("Max Fringe: " + maxFringe);
					System.out.println("Search Used: " + type);
					found = true;
					break;
				}
				if(currentBoard.getRight())
				{
					fringe1.add(new TreeNode(currentNode,currentBoard.moveRight(),type));
					check2++;
				}
				if(currentBoard.getDown())
				{
					fringe1.add(new TreeNode(currentNode,currentBoard.moveDown(),type));
					check2++;
				}
				if(currentBoard.getLeft())
				{
					fringe1.add(new TreeNode(currentNode,currentBoard.moveLeft(),type));
					check2++;
				}
				if(currentBoard.getUp())
				{
					fringe1.add(new TreeNode(currentNode,currentBoard.moveUp(),type));
					check2++;
				}
				if(fringe1.size() > maxFringe)
				{
					maxFringe = fringe1.size();
				}
			}
		}
	}
	/**
	 * 	Method for finding the path using a Stack.
	 *  this method is used for the depth first search and depth Limited search
	 */
	public void findPathStack()
	{
		int maxDepth = 0;
		boolean isLimited = true;
		try
		{
			if(option != null)
			{
				maxDepth = Integer.valueOf(option);
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid Option for depth");
			found = true;
		}
		if(maxDepth == 0)
		{
			isLimited = false;
		}
		fringe2 = new Stack<>();
		fringe2.add(root);
		int check2 = 0;
		while(!found)
		{
			TreeNode currentNode = fringe2.pop();
			GameBoard currentBoard = currentNode.getBoard();
			int check = expanded.size();
			expanded.add(currentBoard.toString());
			if(check != expanded.size() && (currentNode.getLevel() < maxDepth || !isLimited))
			{
				if(currentBoard.getHeuristic() == 0)
				{
					try(BufferedWriter out = new BufferedWriter(new FileWriter(MY_FILE, true))) 
					{
						out.write("Start Board: " + start.toString() + "\n");
						out.write("End Board: " + currentBoard.toString() + "\n");
						out.write("Nodes Created: " + check2 + "\n");
						out.write("Nodes Expanded: " + expanded.size() + "\n");
						out.write("Depth: " + currentNode.getLevel() + "\n");
						out.write("Max Fringe: " + maxFringe + "\n");
						out.write("Search Used: " + type + "\n");
						if(type.equals("DLS"))
						{
							out.write("Max Depth: " + option + "\n");
						}
						out.newLine();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					System.out.println(currentBoard);
					System.out.println("Nodes Created: " + check2);
					System.out.println("Nodes Expanded: " + expanded.size());
					System.out.println("Depth: " + currentNode.getLevel());
					System.out.println("Max Fringe: " + maxFringe);
					System.out.println("Search Used: " + type);
					found = true;
					break;
				}
				if(currentBoard.getUp())
				{
					fringe2.add(new TreeNode(currentNode,currentBoard.moveUp(),type));
					check2++;
				}
				if(currentBoard.getLeft())
				{
					fringe2.add(new TreeNode(currentNode,currentBoard.moveLeft(),type));
					check2++;
				}
				if(currentBoard.getDown())
				{
					fringe2.add(new TreeNode(currentNode,currentBoard.moveDown(),type));
					check2++;
				}
				if(currentBoard.getRight())
				{
					fringe2.add(new TreeNode(currentNode,currentBoard.moveRight(),type));
					check2++;
				}
				if(fringe2.size() > maxFringe)
				{
					maxFringe = fringe2.size();
				}
			}
		}
	}
}
