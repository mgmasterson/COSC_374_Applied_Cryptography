package PlayFair;
import java.awt.Point;
import java.util.Scanner;

public class PlayfairCipher
{	
	private static Point [] pos;
	private static char [][] chartable;
	
	public static char[][] createtab(char[] s)
	{
		chartable = new char [5][5];
		pos = new Point[26];
		
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','K','L',
							'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		int current = 0;
		for(int i = 0; i < s.length; i++)
		{
			if(s[i] != '1')
			{
				chartable[0][current] = s[i];
				current++;
			}
		}
		for(int i = 0; i < s.length; i++)
		{
			for(int j = 0; j < 25; j++)
			{
				if(s[i] == alphabet[j])
				{
					alphabet[j] = '1';
				}
			}
		}
		
		for(int i = 0; i < 25 ; i++)
		{
			if(alphabet[i] != '1')
			{
				if(current < 5)
					chartable[0][current % 5] = alphabet[i];
				else if(current < 10 && current >= 5)
					chartable[1][current % 5] = alphabet[i];
				else if(current < 15 && current >= 10)
					chartable[2][current % 5] = alphabet[i];
				else if(current < 20 && current >= 15)
					chartable[3][current % 5] = alphabet[i];
				else 
					chartable[4][current % 5] = alphabet[i];
				current++;
			}
		}
		
		
		
		return chartable;
	}

	//space for prompt
	public static String prompt(String promptxt, Scanner keyboard, int minlen)
	{
		String s;
		do
		{
			System.out.print(promptxt);
			s = keyboard.nextLine().trim();
		}
		while(s.length()<minlen);
		return s;
	}

	//space to encrypt
	public static char[] encrypt(String s) 
	{
		String tmp = s.toUpperCase();
		char[] h = new char[tmp.length()];
		
		for(int i=0;i<tmp.length();i++)
		{
			if(tmp.charAt(i) == 'J')
				h[i] = 'I';
			else
				h[i] = tmp.charAt(i);
		}
		
		for(int i=0; i<h.length; i++)
		{
			for(int j = i +1; j <h.length;j++)
			{
				if (h[i] == h[j])
					h[j] = '1';
					
			}
		}
		
		return h;
	}

	//space for code
	public static String code( String phrase, char[][] input) 
	{
		String s = phrase.toUpperCase();
		String output = "";
		int len = s.length();
		for(int i=0; i <len; i+=2)
		{
			char a = s.charAt(i);
			char m = s.charAt(i+1);
			
			
			int col1 = 0;
			int col2 = 0;
			int row1 = 0;
			int row2 = 0; 
		
			
			for(int row  = 0; row < 5; row++)
			{
				for(int col  = 0; col < 5; col++)
				{
					if(input[row][col] == a)
					{
						row1 = row;
						col1 = col;
					}
					else if(input[row][col] == m)
					{
						row2 = row;
						col2 = col;
					}
				}
			}
			if(row1 == row2 && col1 == col2)
			{
				col1 = (col1 + 1) %5;
				col2 = (col2 + 1) %5;
			}
			else if(row1 == row2)
			{
				col1 = (col1 + 1) %5;
				col2 = (col2 + 1) %5;
			}
			else if(col1 == col2)
			{
				row1 = (row1 + 1) %5;
				row2 = (row2 + 1) %5;
			}
			else
			{
				int tmp = col1;
				col1 =col2;
				col2 = tmp;
			}
			output = output +  Character.toString(input[row1][col1]) + Character.toString(input[row2][col2]);
		}
		return output;
	}
	
	public static String decode( String phrase, char[][] input) 
	{
		String s = phrase.toUpperCase();
		String output = "";
		int len = s.length();
		for(int i=0; i <len; i+=2)
		{
			char a = s.charAt(i);
			char m = s.charAt(i+1);
			
			
			int col1 = 0;
			int col2 = 0;
			int row1 = 0;
			int row2 = 0; 
		
			
			for(int row  = 0; row < 5; row++)
			{
				for(int col  = 0; col < 5; col++)
				{
					if(input[row][col] == a)
					{
						row1 = row;
						col1 = col;
					}
					if(input[row][col] == m)
					{
						row2 = row;
						col2 = col;
					}
				}
			}
			if(row1 == row2 && col1 == col2)
			{
				col1 = (col1 - 1);
				col2 = (col2 - 1);
				if(col1 < 0)
					col1 = 4;
				if(col2 < 0)
					col2 = 4;
			}
			else if(row1 == row2)
			{
				col1 = (col1 - 1);
				col2 = (col2 - 1);
				if(col1 < 0)
					col1 = 4;
				if(col2 < 0)
					col2 = 4;
			}
			else if(col1 == col2)
			{
				row1 = (row1 - 1);
				row2 = (row2 - 1);
				if(row1 < 0)
					row1 = 4;
				if(row2 < 0)
					row2 = 4;
			}
			else
			{
				int tmp = col1;
				col1 =col2;
				col2 = tmp;
			}
			output = output +  Character.toString(input[row1][col1]) + Character.toString(input[row2][col2]);
		}
		return output;
	}

}