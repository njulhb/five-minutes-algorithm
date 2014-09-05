package exercise;

public class search {
	//×ó±ÕÓÒ¿ª
	public static int binary_search(int A[], int target, int start, int end)
	{
		if(A == null) return -1;
		int l = start, r = end-1;
		while(l <= r)
		{
			int mid = l + (r-l)/2;
			if(A[mid] > target)
				r = mid - 1;
			else if(A[mid] < target)
				l = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int A[] = {0, 1, 2, 3, 4, 5, 6, 8};
		System.out.println(binary_search(A, 9, 0, A.length));
	}
}
