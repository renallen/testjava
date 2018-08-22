

public class ali {
public static int m;
public static int n;

ali(int nn,int mm){
	m=mm;
	n=nn;
}
public static void result(int[][] ab) {
	boolean flag=true;
	int []s1= new int[n];
	for (int i=1;i<=2*n;i++) {
		int[] s= new int[n];
		for (int l=0;l<m;l++) {
				int a=ab[l][0];
				int b=ab[l][1];
				System.out.println(a+" "+b);
				if (a==i) {
					
					s[(int)((b-1)/2)]+= 1;
					System.out.println(i+":"+"s["+ (int)((b-1)/2)+"]"+s[(int)((b-1)/2)]);
				}
				if (b==i) {
					s[(int)((a-1)/2)]+=1;
					System.out.println(i+":"+"s["+ (int)((a-1)/2)+"]"+s[(int)((a-1)/2)]);
				}
		}
		if(i%2==1)
			s1=s;
		else if(i%2==0) {
			
				 for (int k=0;k<n;k++) {
					 System.out.println(k+" :"+s[k]+" "+s1[k]);
					 if(s1[k]==s[k] &&s[k]==2)
					 {
						 System.out.println("no");
						 System.exit(0);
					 }
					}
			 }
		
	}
	System.out.println("yes");
}
public static void main(String []arg) {
	ali arr=new ali(4,7);
	ali.result(new int[][] {{1,3},{1,4},{2,4},{2,8},{2,7},{3,7},{3,8}});
}
}
