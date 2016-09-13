
package Function;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {


	public static void main(String[] args)throws java.lang.Exception 
	{
		try{
		//Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=true;
		
		//int n=sc.nextInt();
		int n=Integer.parseInt(br.readLine());
		int[] arr;
		if(n>=1&& n<= 100000)
		{
			arr=new int[n];
		for(int i=0;i<n;i++)
		{   
			//int k=sc.nextInt();
			int k=Integer.parseInt(br.readLine());
			if(k>=1&&k<=1000000)
			{
				arr[i]=k;
			}
			else
			{
				flag=false;
				break;
			}
		}
		if(flag==true)
		{
		Sum s=new Sum();
		for(int i=0;i<n;i++)
		{
		System.out.println(s.get(arr[i]));
		}
		}
		}
		}
		catch(Exception e)
		{
			System.out.println("?");
		}
	}

}

class Sum{
	
	int[] lookUp;
	
	public int get(int n)
	{
		int sum=0;
		lookUp=new int[n+1];
		lookUp[0]=-1;
		lookUp[1]=1;
		for(int i=1;i<=n;i++)
		{
			sum=sum+compute(i);
		}
		return sum;
	}
	
	public int compute(int n)
	{
		if(n==1)
			return 1;
		else if(lookUp[n]!=0)
			return lookUp[n];
		else
		{
			return lookUp[n]=(n*n)*n+compute(n-1);
		}
	}
}