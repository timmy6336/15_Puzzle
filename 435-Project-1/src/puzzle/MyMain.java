package puzzle;

/**
 * 
 * @author Timmy
 * main class for running the search, gets input from the command line
 * checks for invalid and unsolvable input.
 */
public class MyMain 
{
	public static void main(String[] args)
	{		
		if(args.length < 2 || args.length > 3 || args[0].length() != 16)
		{
			System.out.println("Invalid Input.");
			return;
		}
		SearchTree search;
		GameBoard start;
		if(args.length < 3)
		{
			start = new GameBoard(args[0],null);
			search = new SearchTree(start,args[1],null);
		}
		else
		{
			start = new GameBoard(args[0],args[2]);
			search = new SearchTree(start,args[1],args[2]);
		}
		//checking for unsolvable input.
		int count = 0;
		for(int i = 0; i< 16 ;i++)
		{
			for(int j = i + 1 ; j < 16; j++)
			{
				if(args[0].charAt(i) == ' ' || args[0].charAt(j) ==' ')
				{
					
				}
				else if((int)args[0].charAt(i) > (int)args[0].charAt(j))
				{
					count++;
				}
			}
		}
		if((start.getSpace() >= 0 && start.getSpace() <= 3 ) || (start.getSpace() >= 8 && start.getSpace() <= 11 ) )
		{
			if(count % 2 > 0)
			{
			}
			else
			{
				System.out.println("Unsolvable input!!!");
				return;
			}
		}
		if((start.getSpace() >= 4 && start.getSpace() <= 7 ) || (start.getSpace() >= 12 && start.getSpace() <= 15 ))
		{
			if(count % 2 == 0)
			{
			}
			else
			{
				System.out.println("Unsolvable input!!!");
				return;
			}
		}
		if(args[1].equals("BFS") || args[1].equals("GBFS") || args[1].equals("AStar"))
		{
			search.findPathQueue();
		}
		else
		{
			search.findPathStack();
		}
		
	}
}
