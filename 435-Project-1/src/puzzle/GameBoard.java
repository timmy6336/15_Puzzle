package puzzle;

import java.awt.Point;

/**
 * 
 * @author Timmy
 * Class that creates the gameboard for the given state;
 */
public class GameBoard 
{

		/*An array of points that corrispond to the grid of the board*/
		private Point[] coor;
		/* the first goal state*/ 
		private String goal = "123456789ABCDEF ";
		/* the second goal state*/ 
		private String goal2 = "123456789ABCDFE ";
		/* the input string that represents the gameboard  */ 
		private String in;
		/* the string that represents heuristic to use*/
		private String option;
		/*the first heuristic showing out of place tiles*/
		private int heuristic;
		/*second heuristic showing total Manhattan distance of out of place tiles*/
		private int heuristic2;
		/* a char array representation of the board*/
		private char[] board;
		/*location of the space*/
		private int space;
		/*booleans to check which moves are possible*/
		private boolean left,right,up,down;
		
		/**
		 * Constructor for the Gameboard
		 * @param input the input string for the gameboard state.
		 * @param newOption the choice of heuristic.
		 */
		public GameBoard(String input, String newOption)
		{
			option = newOption;
			coor = new Point[16];
			int count = 0;
			for(int j = 0; j < 4; j++)
			{
				for(int k = 0;k < 4 ; k++)
				{
					coor[count] = new Point(j,k);
					count++;
				}
			}


			in = input;
			board = new char[16];
			input = input.toUpperCase();
			for(int i = 0; i < 16; i++)
			{
				if(input.charAt(i) == ' ')
				{
					space = i;
				}
				board[i] = input.charAt(i);
			}
			left = right = up = down = true;
			possibleMoves();
			if(option == null || option.equals("h1"))
			{
				CalculateHeuristics();
			}
			else
			{
				CalculateHeuristics2();
			}
		}
		/**
		 * calculates the heuristic based on number of out of place tiles
		 */
		private void CalculateHeuristics()
		{
			heuristic = 0;
			heuristic2 = 0;
			for(int i = 0; i < 16 ; i++)
			{
				if(board[i] != goal.charAt(i))
				{
					heuristic++;
				}
			}
			for(int i = 0; i < 16 ; i++)
			{
				if(board[i] != goal2.charAt(i))
				{
					heuristic2++;
				}
			}
		}
		/**
		 * calculates heuristics based on the total Manhattan distance of out of place tiles
		 */
		private void CalculateHeuristics2()
		{
			heuristic = 0;
			heuristic2 = 0;
			for(int i = 0; i < 16 ; i++)
			{
				if(board[i] != goal.charAt(i))
				{
					int right = 0;
					for(int j = 0; j < 16 ; j++)
					{
						if(board[i] == goal.charAt(j))
						{
							right = j;
						}
					}
					heuristic += (Math.abs(coor[i].getX() - coor[right].getX()) + Math.abs(coor[i].getY() - coor[right].getY()));
				}
			}
			for(int i = 0; i < 16 ; i++)
			{
				if(board[i] != goal2.charAt(i))
				{
					int right = 0;
					for(int j = 0; j < 16 ; j++)
					{
						if(board[i] == goal2.charAt(j))
						{
							right = j;
						}
					}
					heuristic2 += (Math.abs(coor[i].getX() - coor[right].getX()) + Math.abs(coor[i].getY() - coor[right].getY()));
				}
			}
		}
		/**
		 * getter for the smaller heuristic
		 * @return the smaller heuristic
		 */
		public int getHeuristic()
		{
			if(heuristic < heuristic2)
			{
				return heuristic;
			}
			else
			{
				return heuristic2;
			}
		}
		@Override
		public String toString()
		{
			StringBuilder returnString = new StringBuilder();
			for(int i = 0; i < 16 ; i++)
			{
				returnString.append(board[i]);
			}
			return returnString.toString();
		}
		/**
		 * determins which moves are possible
		 */
		private void possibleMoves()
		{
			if(space == 0 ||space == 4 ||space == 8 ||space == 12)
			{
				left = false;
			}
			if(space == 0 ||space == 1 ||space == 2 ||space == 3)
			{
				up = false;
			}
			if(space == 3 ||space == 7 ||space == 11 ||space == 15)
			{
				right = false;
			}
			if(space == 12 ||space == 13 ||space == 14 ||space == 15)
			{
				down = false;
			}
		}
		/**
		 * creates a new board after moving the blank tile to the left
		 * @return the new board after a left move
 		 */
		public GameBoard moveLeft()
		{
			char[] temp = new char[16];
			for(int i = 0; i < 16; i++)
			{
				temp[i] = in.charAt(i);
			}
			temp[space] = temp[space-1];
			temp[space - 1] = ' ';
			return new GameBoard(String.valueOf(temp),option);
			
		}
		/**
		 * creates a new board after moving the blank tile to the right
		 * @return the new board after a right move
 		 */		
		public GameBoard moveRight()
		{
			char[] temp = new char[16];
			for(int i = 0; i < 16; i++)
			{
				temp[i] = in.charAt(i);
			}
			temp[space] = temp[space+1];
			temp[space + 1] = ' ';
			return new GameBoard(String.valueOf(temp),option);
		}
		/**
		 * creates a new board after moving the blank tile to the up
		 * @return the new board after a up move
 		 */
		public GameBoard moveUp()
		{
			char[] temp = new char[16];
			for(int i = 0; i < 16; i++)
			{
				temp[i] = in.charAt(i);
			}
			temp[space] = temp[space-4];
			temp[space - 4] = ' ';
			return new GameBoard(String.valueOf(temp),option);
		}
		/**
		 * creates a new board after moving the blank tile to the down
		 * @return the new board after a down move
 		 */
		public GameBoard moveDown()
		{
			char[] temp = new char[16];
			for(int i = 0; i < 16; i++)
			{
				temp[i] = in.charAt(i);
			}
			temp[space] = temp[space + 4];
			temp[space + 4] = ' ';

			return new GameBoard(String.valueOf(temp),option);
		}
		/**
		 * getter for if a left move is possible
		 * @return possibility of a left move
		 */
		public boolean getLeft()
		{
			return left;
		}
		/**
		 * getter for if a right move is possible
		 * @return possibility of a right move
		 */
		public boolean getRight()
		{
			return right;
		}
		/**
		 * getter for if a up move is possible
		 * @return possibility of a up move
		 */
		public boolean getUp()
		{
			return up;
		}
		/**
		 * getter for if a down move is possible
		 * @return possibility of a down move
		 */
		public boolean getDown()
		{
			return down;
		}
		/**
		 * getter for the space index
		 * @return the index of the space
		 */
		public int getSpace()
		{
			return space;
		}
}
