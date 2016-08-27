import java.util.Scanner;

public class Problem1 {

	private int[][] arr;
	private int[][] lookUp;
	private int size;
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args)
	{	
		Problem1 p=new Problem1();
		p.getArray();
		System.out.println("Max"+p.check(0, 0));
		System.out.println("Max"+p.check(1, 0));
		p.showlookUp();
	}
	
	public void showlookUp()
	{
	     	for(int i=0;i<size;i++)
	     	{
	     		for(int j=0;j<size;j++)
	     		{
	     			System.out.print(lookUp[i][j]+" ");
	     		}
	     		System.out.println();
	     	}
	}
	
	
	
	public void getArray()
	{
		size=sc.nextInt();
		arr=new int[size][size];
		lookUp=new int[size][size];
		System.out.println("S");
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				arr[i][j]=sc.nextInt();
				lookUp[i][j]=-1;
			}
		}
	}
	
	public int check(int a,int b)
	{
		int max=0;
		 int temp=up(a,b);
		 //System.out.println(temp);
		 if(temp>max)
		 {
			 max=temp;
		 } 
		 temp=down(a,b);
		// System.out.println(temp);
		 if(temp>max)
		 {
			 max=temp;
		 } 
		 temp=left(a,b);
		// System.out.println(temp);
		 if(temp>max)
		 {
			 max=temp;
		 }
		 temp=right(a,b);
		 //System.out.println(temp);
		 if(temp>max)
		 {
			 max=temp;
		 }
		 
		 lookUp[a][b]=max;
		 
		 return max;
	}
	
	
	public int up(int i,int j)
	{
		System.out.println("UP");
		if(lookUp[i][j]!=-1)
		{	
			return lookUp[i][j];
		}
		
		if(i==0)
		{
			return 0;
		}
		if(arr[i][j]+1==arr[i-1][j])
		{
			System.out.println("up ["+(i-1)+"]["+j+"]");
			return 1+check(i-1,j);
		}
		
		return 0;
		
	}
	
	public int down(int i,int j)
	{
		System.out.println("dOWN");
		if(lookUp[i][j]!=-1)
		{
			return lookUp[i][j];
		}
		
		if(i==size-1)
		{
			return 0;
		}
		if(arr[i][j]+1==arr[i+1][j])
		{
			//System.out.println("Eql Inc");
			System.out.println("down ["+(i+1)+"]["+j+"]");
			return 1+check(i+1,j);
		}
		
		return 0;
	}
	
	public int right(int i,int j)
	{
		System.out.println("RIGHT");
		if(lookUp[i][j]!=-1)
		{
			return lookUp[i][j];
		}
		
		if(j==size-1)
		{
			return 0;
		}
		if(arr[i][j]+1==arr[i][j+1])
		{
			//System.out.println("Eql Inc");
			System.out.println("right ["+i+"]["+(j+1)+"]");
			return 1+check(i,j+1);
		}
		
		return 0;
	}
	
	public int left(int i,int j)
	{
		System.out.println("LEFT");
		if(lookUp[i][j]!=-1)
		{
			return lookUp[i][j];
		}
		
		if(j==0)
		{
			return 0;
		}
		if(arr[i][j]+1==arr[i][j-1])
		{
			//System.out.println("Eql Inc");
			System.out.println("left ["+i+"]["+(j-1)+"]");
			return 1+check(i,j-1);
		}
		
		return 0;
	}
}