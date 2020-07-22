package multiplayer_game;
import java.util.*;

public class Players extends Thread {
int count=0;
ArrayList<Integer> tokens=new ArrayList<Integer>();
HashMap<Integer, Integer>map=new HashMap<>(); 
String name;
int number;
Generator generate;
public Players(int number,String name)
{ this.name=name;
  this.number=number;	
  generate=Generator.getInstance();
  Random r=new Random();
	for(int i=0;i<10;++i)
	{	int a=r.nextInt(51);
	   tokens.add(a);  
	if(map.containsKey(a))
	{
		int x=map.get(a);
		map.put(a,x+1);
	}
	else
		map.put(a, 1);
	}
}
public void run()
{
	int value=0;
    for (int i=0;i<10;i++) 
    {
       if(generate.arr[number-1]==1)
       {
    	   try {
	            sleep(100);
	          } catch (InterruptedException e) { } 
       
       }
    	value = generate.read();
    	
    	generate.arr[number-1]=1;    
    	

			if(map.containsKey(value)&&map.get(value)>0)
			{ 
				count=count+1;
			  
				if(count==3)
				{	
				  System.out.println(name+" won the game");
				  System.exit(0);
				}
			int x=map.get(value);
			map.put(value,x-1);
			}
  }

}

}

