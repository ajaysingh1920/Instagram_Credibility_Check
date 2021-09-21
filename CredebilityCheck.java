
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.*;
import java.util.StringTokenizer;
import java.util.Scanner;

//	 input-->

//	 1
//	 A
//	 5
//	 a 10 6
//	 b 12 5
//	 c 2 42
//	 d 9 18
//	 e 1 100
//	 A
	 
 class Pair{
	int followers;
	int following;
	
	Pair(int followers,int following){
		this.followers=followers;
		this.following=following;
	}
}

 public class credebilityCheck {
	public static void main (String [ ] args) {
		Scanner sc=new Scanner(System.in);
		Map<String,Map<String,Pair>> map=new HashMap<>();
		
		int numberOfUsername=sc.nextInt();
		for(int i=1;i<=numberOfUsername;i++) {
			String username=sc.next();
			int numberOfFollowers=sc.nextInt();
			map.put(username,new HashMap<>());
			for(int j=1;j<=numberOfFollowers;j++) {
				String name=sc.next();
				int followers=sc.nextInt();
				int following=sc.nextInt();
				Map<String,Pair> innerMap=map.get(username);
				innerMap.put(name,new Pair(followers,following));
				map.put(username,innerMap);
			}
		}
		
//		for(String s:map.keySet()) {
//			Map<String,Pair> m=map.get(s);
//			System.out.println(s);
//			for(String ss:m.keySet()) {
//				System.out.println(ss+" "+m.get(ss).followers+" "+m.get(ss).following);
//			}
//			System.out.println("------");
//		}
		
		String find=sc.next();
		if(!map.containsKey(find)) {
			System.out.println("Please enter the correct username");
			return ;
		}
		
	    Map<String,Pair> m=map.get(find);
	    int valid=0;
	    int unvalid=0;
	    
	    for(String s:m.keySet()) {
	    	float val=(float)(m.get(s).followers)/(m.get(s).following);
	    	if(val>0.3) {
	    		valid++;
	    	}
	    	else {
	    		unvalid++;
	    	}
	    }
		
	    System.out.println(valid+" "+unvalid);
	    float percentage=(float)((valid*100/(valid+unvalid)));
	    System.out.println(percentage+"% is the credebility score");
	    
	}	 
	
}