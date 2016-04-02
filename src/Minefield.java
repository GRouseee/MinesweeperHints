public class Minefield
{
	private int rows = 0;
	private int cols = 0;
	private char[][] minefield;
	
	public Minefield(int rows, int cols)
	{
		setRows(rows);
		setCols(cols);
		initializeMinefield();
	}
	
	public int getRows()
	{
		return rows;
	}
	
	public int getCols()
	{
		return cols;
	}
	
	public char[][] getMinefield()
	{
		return minefield;
	}
	
	public void setRows(int rows)
	{
		if (rows > 0 && rows <= 100)
			this.rows = rows;
		
		else
			throw new IllegalArgumentException("Number of rows must be greater than 0 and less than or equal to 100.");
	}
	
	public void setCols(int cols)
	{
		if (cols > 0 && cols <= 100)
			this.cols = cols;
		
		else
			throw new IllegalArgumentException("Number of columns must be greater than 0 and less than or equal to 100.");
	}
	
	public void initializeMinefield()
	{
		minefield = new char[rows + 2][cols + 2];
	}
	
	public void setMinefieldValue(int row, int col, char value)
	{
		if (value == '.' || value == '*')
			minefield[row][col] = value;
	}
	
	@Override
	public String toString()
	{
		String result = rows + " " + cols + "\n";
		
		for (int i = 0; i < this.rows + 2; i++)
		{
			for (int j = 0; j < this.cols + 2; j++)
			{
				result += minefield[i][j];
			}
			
			result += "\n";
		}
		
		return result;
	}
}
