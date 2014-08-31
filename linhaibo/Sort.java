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
	//×ó±ÕÓÒ¿ª
	public static void merge_sort(int A[], int temp[], final int start, final int end)
	{
		if(A == null) return;
		if(start < end-1)
		{
			int mid = start + (end - start)/2;
			merge_sort(A, temp, start, mid);
			merge_sort(A, temp, mid, end);
			merge(A, temp, start, mid, end);
		}
	}
	private static void merge(int A[], int temp[], final int start, final int mid, final int end)
	{
		int i,j,k;
		for(i = 0; i < end; ++i) temp[i] = A[i];
		i = start; j = mid; k = start;
		while(i < mid && j < end)
		{
			if(temp[i] < temp[j])
			{
				A[k++] = temp[i++];
			}
			else
			{
				A[k++] = temp[j++];
			}
		}
		while(i < mid) A[k++] = temp[i++];
		while(j < end) A[k++] = temp[j++];
	}
	public static void selection_sort(int A[], int start, int end)
	{
		if(A == null) return;
		for(int i = start; i < end-1; ++i)
		{
			int temp = i;
			for(int j = i+1; j < end; ++j)
			{
				if(A[temp] > A[j]) temp = j;
			}
			if(temp != i)
			{
				int swap = A[temp];
				A[temp] = A[i];
				A[i] = swap;
			}
		}
	}
	//×ó±ÕÓÒ¿ª
	public static void insert_sort(int A[], int start, int end)
	{
		if(A == null)return;
		int i,j;
		for(i = start+1; i < end; ++i)
		{
			int temp = A[i];
			for(j = i-1; j >= start && temp < A[j]; --j)
				A[j+1] = A[j];
			A[j+1] = temp;
		}
	}
	public static void shell_sort(int A[], int start, int end)
	{
		if(A == null) return;
		int gap = end - start;
		while(gap > 1)
		{
			gap = gap / 3 + 1;
			shell_insert(A, start, end, gap);
		}
	}
	//×ó±ÕÓÒ¿ª
	private static void shell_insert(int A[], int start, int end, int gap)
	{
		int i,j;
		for( i = start + gap; i < end; ++i)
		{
			int temp = A[i];
			for( j = i - gap; j >= start && temp < A[j]; j -= gap)
				A[j+gap] = A[j];
			A[j+gap] = temp;
		}
	}
	public static void main(String[] args)
	{
		int A[] = {1,3,4,2,8,3,4};
		int temp[] = new int[7];
		Sort.shell_sort(A, 0, A.length);
		for(int i = 0; i < A.length; ++i)
			System.out.println(A[i]);
	}

}
