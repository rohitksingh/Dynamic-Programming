package Min_Cost_To_Reach_Destination;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args)
	{
		MinCost minCost=new MinCost();
		minCost.get();
		//minCost.display();
		int n=minCost.sourceNdestination.length;
		for(int i=0;i<n;i++)
		{
			String e=minCost.sourceNdestination[i];
			System.out.println(e);
			minCost.getSnD(e);
		}
		
	}
}

class MinCost{
	
	String source;
	String destination;
	String snD;
	int num_of_cities;
	String[] allCities;
	int[] lookUp;
	String[] sourceNdestination;
	Scanner sc=new Scanner(System.in);
	
	LinkedHashMap<Integer,String> reachableCities=new LinkedHashMap<Integer,String>();
	
	public void get()
	{
		System.out.println("Num of cities");
		num_of_cities=sc.nextInt();
		sc.nextLine();
		allCities=new String[num_of_cities+1];
		lookUp=new int[num_of_cities+1];
		for(int i=0;i<num_of_cities+1;i++)
			lookUp[i]=-1;
		
		for(int i=0;i<num_of_cities;i++)
		{
			System.out.println("Enter city "+(i+1));
			allCities[i+1]=sc.nextLine();
			System.out.println("Enter num of rec cities");
			int n=sc.nextInt();
			sc.nextLine();
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<n;j++)
			{   
				sb.append(sc.nextLine()+",");
			}
			String path=new String(sb);
			System.out.println(path);
			reachableCities.put(i+1,path);
		}
		int num_of_queries=sc.nextInt();
		sc.nextLine();
		sourceNdestination=new String[num_of_queries];
		for(int i=0;i<num_of_queries;i++)
			sourceNdestination[i]=sc.nextLine();
		//System.out.println("Enter s and d");
		//snD=sc.nextLine();
		
	}
	
	public void getSnD(String path)
	{
		StringTokenizer st=new StringTokenizer(path," ");
		source=st.nextToken();
		destination=st.nextToken();
		int cityCode=-1;
		for(int i=1;i<allCities.length;i++)
		{
			
			System.out.println(allCities.length+"< "+allCities[i]+" ? "+source);
			if(allCities[i].equalsIgnoreCase(source))
			{
				cityCode=i;
			    break;
			}   
		}
		
		int dis=getMinDis(cityCode,"");
		System.out.println("Min dis is "+dis);
	}
	
	public void display()
	{
		for(int i=0;i<num_of_cities+1;i++)
           System.out.println(lookUp[i]);
		
		for(int i=1;i<num_of_cities+1;i++)
			System.out.println(reachableCities.get(i));
	}
	
	public int getMinDis(int source,String checked)
	{
		if(allCities[source].equals(destination))
			return 0;
		else if(lookUp[source]!=-1)
		{
			return lookUp[source];
		}
		else
		{
			int min=1000;
			String cities=reachableCities.get(source);
			StringTokenizer st=new StringTokenizer(cities,",");
			while(st.hasMoreTokens())
			{
				String citydis=st.nextToken();
				StringTokenizer st1=new StringTokenizer(citydis," ");
				int cityCode=Integer.parseInt(st1.nextToken());
				if(!checked.contains(cityCode+""))
				{
					int dis=Integer.parseInt(st1.nextToken());
					checked=checked+" "+cityCode;
					int temp=dis+getMinDis(cityCode,checked);
					if(temp<min)
					{
						min=temp;
					}
				}
			}
			return lookUp[source]=min;
		}
	}
	
}