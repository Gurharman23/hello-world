package Lab4;
import java.io.*;

public class ProgramSearch {
	public static String keywords[];
	public static void selectionSort()
	{
		for(int i=0;i<=keywords.length-1;i++)
		{
			for(int j=i;j<=keywords.length-1;j++)
			{
				if(keywords[j].compareTo(keywords[i])<0)
					{
					String temp=keywords[i];
					keywords[i]=keywords[j];
					keywords[j]=temp;
					}
				}
			
		}
	}

	public static boolean binarySearch(String s,int l,int h)
	{
		
		if(l>h)
			return false;
		
		int mid=(l+h)/2;
		if(s.compareTo(keywords[mid])==0)
			return true;
			
		
		else if(s.compareTo(keywords[mid])<0)
			return binarySearch(s,l,mid-1);
		else
			return binarySearch(s,mid+1,h);	
	}
	
	//read keywords from file and store it in the keywords array
	public static void readKeywords()
	{
		try {
			File f=new File("C:\\Users\\gurharmanjit\\Desktop\\csx-351-hw3-Gurharman23-master\\HW3-unsorted-keywords.txt");
			 FileReader fr=new FileReader(f);
		     BufferedReader br = new BufferedReader(fr);
		     int i=0;
		     
		     while(br.readLine()!=null)
		    	 i++;
		     br.close();
		     keywords=new String[i];
		     fr=new FileReader(f);
		     br = new BufferedReader(fr);
		     
		     
		     i=0;
		  String line=br.readLine();
		  while(line!=null)
		  {
			  keywords[i++]=line;
			  line=br.readLine();
		  }
		  br.close();
			
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
		
	}
	
	public static void searchAndWrite()
	{
		try {
		
		File f=new File("C:\\Users\\gurharmanjit\\Desktop\\csx-351-hw3-Gurharman23-master\\HW3-input-code.cpp");
		BufferedReader br=new BufferedReader(new FileReader(f));
		String line=br.readLine();
		int l=1;
		FileWriter fw=new FileWriter("C:\\Users\\gurharmanjit\\Desktop\\csx-351-hw3-Gurharman23-master\\result.txt");
		int count=0;
		while(line!=null)
		{
			int p=0;
			boolean y=false;
			String s[]=line.split("[ |(|)|#|;|<|>|{|}]");
			for(int i=0;i<s.length;i++)
			{
				boolean x=binarySearch(s[i],0,keywords.length);
				if(x==true)
				{
					if(y==false)
					{
						fw.write("line "+l+":"+" ");
						System.out.print("line "+l+":"+" ");
						y=true;
					}
				System.out.print(" "+ s[i] + "(" + p + ")" );
				fw.write(" "+ s[i] + "(" + p + ")");
				count++;
				}
				p=p+s[i].length()+1;
			}
			if(y==true)
			{
				fw.write("\r\n");
			System.out.println("");
			}
			
			line=br.readLine();
			l++;
		}
	    fw.write("Number of keywords found =" + count+"\r\n");
		fw.close();
		br.close();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String args[])
	{
		
		readKeywords();
		 selectionSort();
		  
		  searchAndWrite();
		  
		  
		  

	}
}
