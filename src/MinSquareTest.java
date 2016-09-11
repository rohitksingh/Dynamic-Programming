/*
 * 
  Find min num of squares to make a num
 
  eg 5={1,1,1,1,1}
       {1,2}
       Ans={1,2}
  
 */


public class MinSquareTest {

	public static void main(String[] args)
	{
		Abc a=new Abc();
		a.get(1000);
	}
}

class Abc{
  
	String lookUp[];
	int countHit=0;
	int countMiss=0;
	
	public void get(int n)
	{
		lookUp=new String[n+1];
		System.out.println("-----------"+squareFor(n));
		
	
		for(int i=0;i<lookUp.length;i++)
		{
			System.out.println(i+") "+lookUp[i]);
		}
		
		System.out.println(countHit+" "+countMiss);
	}
	
	public String squareFor(int n)
	{
		if(n==0)
			return "";
		if(lookUp[n]!=null)
		{
			countHit++;
			return lookUp[n];
		}	
		else
		{
			countMiss++;
			String tempResult=null;
			String Result=null;
			int length=100000;
			for(int i=1;i*i<=n;i++)
			{
				tempResult=i+" "+squareFor(n-(i*i));
				if(tempResult.length()<length)
				{
					Result=tempResult;
					length=tempResult.length();
				}
			}
			return lookUp[n]=Result;
		}
	}
	
	
}