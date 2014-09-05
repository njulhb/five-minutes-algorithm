package exercise;
/*
 * 
 * ����10����ʱ�䣬�������Ÿ���ʮ�������������������Ӧ��ʮ����  
Ҫ������ÿ����������ǰ������ʮ���������ų��ֵĴ�����  
���ŵ�ʮ�������£�  
��0��1��2��3��4��5��6��7��8��9
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
