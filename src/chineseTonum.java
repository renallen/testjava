
public class chineseTonum {
	public final static  char[] CN_num= {'零','一','二','三','四','五','六','七','八','九'};
	public final static  char[] CN_u={'十','百','千','万','亿'};
	public final static  int[] CN_v={10,100,1000,10000,1000000000};
	public final static boolean[] CN_f={false,false,false,true,true};
	static int chinese2num(String CNstr) {
		int result=0;
		int section=0;
		int number=0;
		int i=0;

		int l=CNstr.length();
		while(i<l) {
			int num = getnum(CNstr.charAt(i));
			if(num>=0) {
				number=num;
			}else {
				int unit=getu(CNstr.charAt(i));
				if(CN_f[unit]) {
					section=(section+number)*CN_v[unit];
					result+=section;
					section=0;
				}else {
					section+=(number*CN_v[unit]);
				}
				number=0;

			}
			i++;
		    if(i>=l) {
		    	section+=number;
		    	result+=section;
		    	break;
		    }
		}
		return result;
	}
	static int getnum(char c) {
		for(int i=0;i<CN_num.length;i++) {
			if (c==CN_num[i])
				return i;
		}
		return -1;
	}
	static int getu(char c) {
		for(int i=0;i<CN_u.length;i++) {
			if (c==CN_u[i])
				return i;
		}
		return -1;
	}
	
	
	public static void main(String []arg) {
		int test;
		String CNstr="一亿一百零一万零九百一十";
		test= chinese2num(CNstr);
		System.out.println(test);
//		for(int i =0;i<result.length();i++) {
//			System.out.println(result.charAt(i));
//		}
//		
	}
}

