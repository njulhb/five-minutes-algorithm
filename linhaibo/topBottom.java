package exercise;
/*
 * 
 * 给你10分钟时间，根据上排给出十个数，在其下排填出对应的十个数  
要求下排每个数都是先前上排那十个数在下排出现的次数。  
上排的十个数如下：  
【0，1，2，3，4，5，6，7，8，9
 */
public class topBottom {
	private int[] bottom = new int[10];
	private int[] top = new int[10];
	private boolean success;
	public topBottom()
	{
		success = false;
		for(int i = 0; i < 10; ++i)
			top[i] = i;
	}
	public int[] getBottom()
	{
		while(!success)
		{
			setNextBottom();
		}
		return bottom;
	}
	public void setNextBottom()
	{
		boolean r = true;
		for(int i = 0; i < 10; ++i)
		{
			int frequence = getFrequence(i);
			if(bottom[i] != frequence)
			{
				bottom[i] = frequence;
				r = false;
			}
		}
		success = r;
	}
	public int getFrequence(int num)
	{
		int count = 0;
		for(int i = 0; i < 10; ++i)
		{
			if(bottom[i] == num)
				count++;
		}
		return count;
	}
	public static void main(String[] args)
	{
		topBottom t = new topBottom();
		int[] A = t.getBottom();
		for(int i = 0; i < 10; ++i)
			System.out.println(A[i]);
	}
}
