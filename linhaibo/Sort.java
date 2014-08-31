package exercise;

public class Sort {
	//×ó±ÕÓÒ¿ª
	public static void bubble_sort(int A[], int start, int end)
	{
		if(A == null)return;
		boolean exchange;
        for(int i = start; i < end - 1; ++i)
        {
        	exchange = false;
        	for(int j = end-1; j > i; --j)
        	{
        		if(A[j] < A[j-1])
        		{
        			int temp = A[j];
        			A[j] = A[j-1];
        			A[j-1] = temp;
        			exchange = true;
        		}
        	}
        	if(!exchange) return;
        }
	}
	private static int partition(int A[], final int start, final int end)
	{
		int l = start, r = end-1;
		final int val = A[l];
		while(l < r)
		{
			while(l < r && A[r] >= val) --r;
			A[l] = A[r];
			while(l < r && A[l] <= val) ++l;
			A[r] = A[l];
		}
		A[l] = val;
		return l;
	}
	//×ó±ÕÓÒ¿ª
	public static void quick_sort(int A[],final int start,final int end)
	{
		if(A == null)return;
		if(start < end-1)
		{
			final int pos = partition(A, start, end);
			quick_sort(A, start, pos);
			quick_sort(A, pos+1, end);
		}
	}
	public static void main(String[] args)
	{
		int A[] = {1,3,4,2,8,3,4};
		Sort.quick_sort(A, 0, A.length);
		for(int i = 0; i < A.length; ++i)
			System.out.println(A[i]);
	}

}
