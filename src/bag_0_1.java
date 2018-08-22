import java.util.ArrayList;
import java.util.List;

public class bag_0_1 {
	static List<tagobj> arr;   //背包最终的结果
	static int totalC;			//能包含的总重量
	static int s_type;			//按照哪种方式来装 0-价格最高  1-重量最轻 2-性价比最高
	
	public static int maxselect(List<tagobj> sources) {
		
		/* 选取按照某种方式的剩下物品的最优解下标，输入剩下的物品以及何种选择方式*/
		int index=-1;
		float mp;
		int l=sources.size();
		if( s_type==0) {
				mp=0;
					for (int i=0;i<l ;i++) {
						if (sources.get(i).price>mp) {  //价格最高
							 mp = sources.get(i).price;
					         index = i;
						}
				}
		}
		else if ( s_type==1) {
			mp=totalC;
			for (int i=0;i< l;i++) {
				if (sources.get(i).weight<mp) {			//重量最轻
					 mp = sources.get(i).weight;
			         index = i;
				}}
			}
		else if ( s_type==2) {
			mp =0;
			for (int i=0;i< l;i++) {			//性价比最高
				if ((float)sources.get(i).price/sources.get(i).weight>mp) {
					 mp = (float)sources.get(i).price/sources.get(i).weight;
			         index = i;
				}
			}
		}
		return index;
	}
	
	public static void greedy(List<tagobj> sources) {
		int dx=0 ;
		int all_c=0;
		
		while(true){
			dx=maxselect(sources);
			if (dx==-1) {
				break;
			}
			if (all_c + sources.get(dx).weight <= totalC) {
				arr.add(sources.get(dx));
				all_c+=sources.get(dx).weight;
			}
			sources.remove(dx);
		}
		
	}
	public static List<tagobj> init(int[] w, int[] p ,int C,int type) {
		//初始化背包问题的相关量 ，物品的重量，价格，背包的容量，装包的方式
		List<tagobj> sources= new ArrayList<tagobj>();
		for (int i =0; i<w.length;i++) {
			tagobj obj= new tagobj();
			obj.price=p[i];
			obj.weight=w[i];
			sources.add(obj);
		}
		arr=new ArrayList<tagobj>();
		totalC= C;
		s_type=type;
		return sources;
	}
	public static void main(String []arg) {

		int [] w= {35,30,60,50,40,10,25};
		int [] p= {10,40,30,50,35,40,30};
		List<tagobj> sources= new ArrayList<tagobj>();
		sources=init(w,p,150,1);
		greedy(sources);
		int sum_w=0,sum_p=0;
		for (int i=0;i<arr.size();i++) {
			System.out.println("price:"+arr.get(i).price+" weight:" +arr.get(i).weight);
			sum_p+=arr.get(i).price;
			sum_w+=arr.get(i).weight;
		}
		System.out.println("total_price:"+sum_p + " total_weight:"+sum_w);
	}
}


//物品
class tagobj{
	int weight;
	int price;
}
