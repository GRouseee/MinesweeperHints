import java.util.LinkedList;
import java.util.Scanner;

public class Manager
{
	private LinkedList<Minefield> minefields = new LinkedList<Minefield>();
	
	public void getInput()
	{
		Scanner input = new Scanner(System.in);
		int rows = 0;
		int cols = 0;
		
		while (input.hasNext())
		{
			rows = input.nextInt();
			cols = input.nextInt();
			
			if (input.hasNext())
				input.nextLine();
			
			if (rows == 0 || cols == 0)
			{
				return;
			}
			
			Minefield temp = new Minefield(rows, cols);
			
			for (int row = 0; row < temp.getRows() + 2; row++)
			{				
				int count = 0;
				int col = 0;
				
				while (col < temp.getCols() + 2)
				{
					if (row == 0 || row == temp.getRows() + 1 || col == 0 || col == temp.getCols() + 1)
					{
						temp.setMinefieldValue(row, col, '.');
						col++;
					}
					
					else
					{
						String values = input.nextLine();
						
						while (count < values.length())
						{
							temp.setMinefieldValue(row, col, values.charAt(count));
							col++;
							count++;
						}
					}
				}
			}
			
			minefields.add(temp);
		}
	}
	
	public void getOutput()
	{	
		int minefieldCount = 1;
		
		for (Minefield m : minefields)
		{
			String result = "Field #" + minefieldCount + ":\r\n";
			minefieldCount++;
			
			for (int row = 1; row < m.getRows() + 1; row++)
			{
				for (int col = 1; col < m.getCols() + 1; col++)
				{
					int count = 0;
					
					if (m.getMinefield()[row][col] == '*')
						result += '*';
						
					else
					{
						if (m.getMinefield()[row - 1][col] == '*')
							count++;
						
						if (m.getMinefield()[row - 1][col - 1] == '*')
							count++;
						
						if (m.getMinefield()[row][col - 1] == '*')
							count++;
						
						if (m.getMinefield()[row + 1][col - 1] == '*')
							count++;
						
						if (m.getMinefield()[row + 1][col] == '*')
							count++;
						
						if (m.getMinefield()[row + 1][col + 1] == '*')
							count++;
						
						if (m.getMinefield()[row][col + 1] == '*')
							count++;
						
						if (m.getMinefield()[row - 1][col + 1] == '*')
							count++;
						
						result += count;
					}
				}
				
				result += "\r\n";
			}
			
			System.out.println(result);
		}
	}
}
