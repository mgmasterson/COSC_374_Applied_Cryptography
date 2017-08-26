package PlayFair;

public class BruteForce 
{
	private static char SwitchDemo(int n) 
	{
		char AlphaString;
		switch (n) 
		{
		case 0:  AlphaString = 'A';
		break;
		case 1:  AlphaString = 'B';
		break;
		case 2:  AlphaString = 'C';
		break;
		case 3:  AlphaString = 'D';
		break;
		case 4:  AlphaString = 'E';
		break;
		case 5:  AlphaString = 'F';
		break;
		case 6:  AlphaString = 'G';
		break;
		case 7:  AlphaString = 'H';
		break;
		case 8:  AlphaString = 'I';
		break;
		case 9: AlphaString = 'J';
		break;
		case 10: AlphaString = 'K';
		break;
		case 11: AlphaString = 'L';
		break;
		case 12: AlphaString = 'M';
		break;
		case 13: AlphaString = 'N';
		break;
		case 14: AlphaString = 'O';
		break;
		case 15: AlphaString = 'P';
		break;
		case 16: AlphaString = 'Q';
		break;
		case 17: AlphaString = 'R';
		break;
		case 18: AlphaString = 'S';
		break;
		case 19: AlphaString = 'T';
		break;
		case 20: AlphaString = 'U';
		break;
		case 21: AlphaString = 'V';
		break;
		case 22: AlphaString = 'W';
		break;
		case 23: AlphaString = 'X';
		break;
		case 24: AlphaString = 'Y';
		break;
		case 25: AlphaString = 'Z';
		break;
		default: AlphaString = 'Z';
		break;
		}
		return AlphaString;
	}

	private static void fiveKey(String cipher, String message)
	{
		long startTime = System.currentTimeMillis();
		for (int i =0; i<25; i++)
			for (int j =0; j<25; j++)
				for (int k =0; k<25; k++)
					for (int l =0; l<25; l++)
						for (int m =0; m<25; m++)
						{
							String s = 	Character.toString(SwitchDemo(i)) +
									Character.toString(SwitchDemo(j)) +
									Character.toString(SwitchDemo(k)) +
									Character.toString(SwitchDemo(l)) +
									Character.toString(SwitchDemo(m));
							
							String test = PlayfairCipher.decode(cipher, PlayfairCipher.createtab(PlayfairCipher.encrypt(s)));
							if(test.equalsIgnoreCase(message))
							{
								break;
							}
						}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Run time: " + totalTime);	
	}
	
	private static void fourKey(String cipher, String message)
	{
		long startTime = System.currentTimeMillis();
		for (int i =0; i<25; i++)
			for (int j =0; j<25; j++)
				for (int k =0; k<25; k++)
					for (int l =0; l<25; l++)
					{
						String s = 	Character.toString(SwitchDemo(i)) +
								Character.toString(SwitchDemo(j)) +
								Character.toString(SwitchDemo(k)) +
								Character.toString(SwitchDemo(l));
						
						String test = PlayfairCipher.decode(cipher, PlayfairCipher.createtab(PlayfairCipher.encrypt(s)));
						if(test.equalsIgnoreCase(message))
						{
							System.out.println("Key has been found");
							break;
						}
					}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Run time: " + totalTime);	
	}
	
	private static void threeKey(String cipher, String message)
	{
		long startTime = System.currentTimeMillis();
		for (int i =0; i<25; i++)
			for (int j =0; j<25; j++)
				for (int k =0; k<25; k++)
				{
					String s = 	Character.toString(SwitchDemo(i)) +
							Character.toString(SwitchDemo(j)) +
							Character.toString(SwitchDemo(k));
					
					String test = PlayfairCipher.decode(cipher, PlayfairCipher.createtab(PlayfairCipher.encrypt(s)));
					if(test.equalsIgnoreCase(message))
					{
						System.out.println("Key has been found");
						break;
					}
				}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Run time: " + totalTime);	
	}
	
	public static void main(String[] args)
	{
		String key = "class";
		String message = "thisclassx";
		String cipher = PlayfairCipher.code(message, PlayfairCipher.createtab(PlayfairCipher.encrypt(key)));
		fourKey(cipher, message);
	}
	
}
