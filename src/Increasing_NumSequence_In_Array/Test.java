package Increasing_NumSequence_In_Array;

public class Test {

	public static void main(String[] args)
	{
		
		Problem p=new Problem();
		p.get();
		System.out.println(p.maxPathFrom(0, 2));
		p.lookUp();
		System.out.println(p.maxPathFrom(0, 3));
		//System.out.println(p.maxPath());
		System.out.println("Hit="+p.hitCount+" Miss="+p.missCount+"\n\n\n\nLookUpTable\n");
		p.lookUp();
		
	}

}


class Problem{
	
	int arr[][];
	String lookUp[][];
	int hitCount=0;
	int missCount=0;
	
	public void get()
	{
		arr=new int[][]{{1,2,3,4,5},{2,3,2,13,6},{3,4,1,12,7},{4,5,0,11,8},{5,6,8,10,9}};
		lookUp=new String[arr.length][arr.length];
		
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void lookUp()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.println(lookUp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public String maxPathFrom(int i,int j)
	{
		if(lookUp[i][j]!=null)
		{
			//System.out.println("Hit");
			hitCount++;
			return lookUp[i][j];
		}
		else{
		//System.out.println("Not Hit");
		missCount++;
		String path;
		int maxLenght=0;
		String maxPathYet=null;
		
		path=moveLeft(i,j);
		//System.out.println("LEFT("+i+","+j+")"+path);
		if(path.length()>maxLenght)
		{
			maxLenght=path.length();
			maxPathYet=path;
		}	
		path=moveRight(i,j);
		//System.out.println("RIGHT("+i+","+j+")"+path);
		if(path.length()>maxLenght)
		{
			maxLenght=path.length();
			maxPathYet=path;
		}	
		path=moveUp(i,j);
		//System.out.println("UP("+i+","+j+")"+path);
		if(path.length()>maxLenght)
		{
			maxLenght=path.length();
			maxPathYet=path;
		}
		path=moveDown(i,j);
		//System.out.println("DOWN("+i+","+j+")"+path);
		if(path.length()>maxLenght)
		{
			maxLenght=path.length();
			maxPathYet=path;
		}
		return maxPathYet;
		}
		
	}
	
	public String maxPath()
	{
		int n=arr.length;
		String longestPath="";
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				String tempPath=maxPathFrom(i,j);
				if(longestPath.length()<tempPath.length())
					longestPath=tempPath;
			}
		}
		return longestPath;
	}
	
	public String moveLeft(int i,int j)
	{
		//System.out.print("Left("+i+" ,"+j+")"+"->");
		if(j==0)
		{
			//System.out.print("Hit");
			return arr[i][j]+"";
		}	
		else if(arr[i][j]>arr[i][j-1])
		{
			//System.out.print("a[i][j] "+arr[i][j]+" a[i-1][j] "+arr[i-1][j]);
			//System.out.print("Cant move");
		    return arr[i][j]+"";
		} 
		else
			return lookUp[i][j]=arr[i][j]+"->"+maxPathFrom(i,j-1);	
	}
	
	public String moveRight(int i,int j)
	{
		//System.out.print("Right("+i+" ,"+j+")"+"->");
		if(j==arr.length-1)
			return arr[i][j]+"";
		else if(arr[i][j]>arr[i][j+1])
		    return arr[i][j]+"";
		else
			return lookUp[i][j]=arr[i][j]+"->"+maxPathFrom(i,j+1);
	}
	public String moveUp(int i,int j)
	{
		//System.out.print("Up("+i+" ,"+j+")"+"->");
		if(i==0)
			return arr[i][j]+"";
		else if(arr[i][j]>arr[i-1][j])
		    return arr[i][j]+"";
		else
			return lookUp[i][j]=arr[i][j]+"->"+maxPathFrom(i-1,j);
	}
	public String moveDown(int i,int j)
	{
		//System.out.print("Down("+i+" ,"+j+")"+"->");
		if(i==arr.length-1)
			return arr[i][j]+"";
		else if(arr[i][j]>arr[i+1][j])
		    return arr[i][j]+"";
		else
			return lookUp[i][j]=arr[i][j]+"->"+maxPathFrom(i+1,j);
	}
}