
//阿拉伯数字转中文数字、

//重点：万作为区分片   ，注意零的含义  每个对10取余之后的数需要与对应的权值同时连接
public class num2Chinese {
	public final static  String[] CN_num= {"零","一","二","三","四","五","六","七","八","九"};
	public final static  String[] CN_T= {"","十","百","千"};
	public final static  String[] CN_S= {"","万","亿","万亿"};
	public static String numtoCN(int num) {
			int unitPos=0;
			String CNnum="";
			String substr="";
			boolean addzero=false;
			while(num>0) {
				int section = num%10000;
				if(addzero) {
					 CNnum=CN_num[0]+ CNnum;
				}
				substr=sec2CN(section);			//对分出来的片计算中文数字串
				substr+=(section!=0)?CN_S[unitPos]:CN_S[0];  //每个片段需要加的权
				CNnum=substr+CNnum;        
				addzero=(section<1000)&&(section>0);   //分片需要加0的情况
				num/=10000;
				unitPos++;
				
			}
			return CNnum;
	}
	public static String sec2CN(int num) {
		int unitPos=0;
		String CNnum="";
		String substr="";
		boolean addzero=true;
		while(num>0) {
			int b= num%10;
			if(b==0) {
				if((num== 0)||!addzero) {
					addzero=true;
					CNnum=CN_num[b]+CNnum;
				}
			}else {
				addzero=false;
				substr=CN_num[b]+CN_T[unitPos];
				CNnum=substr+CNnum;
			}
			unitPos++;
			num=num/10;	
		}
		return CNnum;
	}
	public static void main(String []arg) {
		int test=1201010910;
		String result="";
		result=numtoCN(test);
		System.out.println(result);
//		for(int i =0;i<result.length();i++) {
//			System.out.println(result.charAt(i));
//		}
//		
	}

}
