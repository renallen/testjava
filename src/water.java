import java.util.ArrayList;
import java.util.List;
public class water {
		static final int num=3;				//水桶个数
		static final int[] bucket= {8,5,3};   //三个水桶的容量
		static final int[] end_state= {4,4,0};		//最终结果
		static int m=0;						
		static int min_step=0;					

		static List <trans_state> process;
		static boolean isValidtrans(trans_state next,int f, int t) { 
			//判断由f水桶到入t是否可行
			if(f!=t && next.water_state[f]!=0 && next.water_state[t]<bucket[t])
				return true;
			return false;
		}
		static boolean isExist(trans_state next) {
			//判断是否以前出现过这种水量的情况  
			int l=process.size();
			for(int i=0;i<l;i++) {
				if(next.water_state[0]==process.get(i).water_state[0] && next.water_state[1]==process.get(i).water_state[1])
				{
					//System.out.println("yes");
					return true;
				}
			}
			return false;
		}
		static void searchstate(trans_state next,int f,int t) {
			
			//可以倒水的话进行倒水操作
			if(isValidtrans(next,f,t)) {
				trans_state new_next=trans( next,f,t);
				//获得倒完水之后的新状态
				if(!isExist(new_next)) {
					//如果之前这种水量状态没有出现过，那就把它加入列表
					process.add(new_next);
					search(new_next);
					//搜索完新状态后遍历得到最终结果的反馈之后  回退一个节点 进行前一个状态的新的遍历
					process.remove(process.size()-1);
				}
			}
		}
		static trans_state trans(trans_state next,int f,int t) {
			//可以倒水的情况下 进行倒水操作，并获得新的倒水过程及状态
			trans_state new_next=new trans_state(next);
			int trans_water=(bucket[t]-next.water_state[t]);
			if(new_next.water_state[f]>=trans_water) {
				new_next.water_state[t]+=trans_water;
				new_next.water_state[f]-=trans_water;
			}else {
				new_next.water_state[t]+=new_next.water_state[f];
				trans_water=new_next.water_state[f];
				new_next.water_state[f]=0;
			}
			new_next.trans_state[0]= f;
			new_next.trans_state[1]= t;
			new_next.trans_state[2]= trans_water;
			return  new_next;
		}
		static void search(trans_state next) {
					//搜索当前水量下后续倒水操作
			if(next.water_state[0]==end_state[0] && next.water_state[1]==end_state[1] ) {
				
				//终止状态，达到结果后打印出结果
				System.out.println("method "+m+": " +"转换 f t v"+" "+"水桶 8 5 3：" );
				int k;
				for(k=1;k<process.size();k++)
					{
						System.out.print("step   "+(k)+": "+"转换 "+bucket[process.get(k).trans_state[0]]+" "+bucket[process.get(k).trans_state[1]]+" "+process.get(k).trans_state[2]);
						System.out.println(" 水量 "+process.get(k).water_state[0]+" "+process.get(k).water_state[1]+" "+process.get(k).water_state[2]);
						
					}
				System.out.println("结束，总共"+(k-1)+"步");
				System.out.println();
				if(min_step==0)
					min_step=k-1;
				else if(min_step>k-1) {
					min_step=k-1;
				}
		
				m++;
				return;
				
			}
			//没达到结果就继续遍历当前水量下的倒水过程
			for(int j=0;j<num;j++) {
				for(int i=0;i<num;i++) {
					searchstate(next,i,j);
				}
			}
		}
		static void init() {
			
			process=new ArrayList<trans_state>();  //初始化过程列表
			process.add(new trans_state());   //增加初始水量状态
		}
		public static void main(String []arg) {
			init();
			
			System.out.println("初始水量 8 0 0");
			search(process.get(0));
			System.out.println("结束，总共"+m+"种方法");
			System.out.println("最少需要"+min_step+"步");
			
		}
		
		
}
class trans_state{   
	//倒水过程 
	//l
	int[]   water_state;		//当前水量
	int[]   trans_state;		//到达当前水量的过程
	trans_state() {
		water_state= new int[]{8,0,0};
		trans_state= new int[]{-1,0,8};
	}
	trans_state(trans_state obj) {
		water_state= obj.water_state.clone();
		trans_state= obj.trans_state.clone();
	}
}