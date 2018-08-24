import java.util.ArrayList;
import java.util.List;

public class river {
     
      static final int monk_num=3;
      static final int monster_num=3;
      static int total=0;		//最后的方法总数
      static final int[] end= {0,0,3,3};	//结束状态
      static final move_boat[] method= {new move_boat(0,-1,true),new move_boat(0,-2,true),new move_boat(-1,0,true)
    		  ,new move_boat(-2,0,true),new move_boat(-1,-1,true),new move_boat(0,1,false),new move_boat(0,2,false),new move_boat(1,0,false)
    		  ,new move_boat(2,0,false),new move_boat(1,1,false)};
	  //移动船的方式  左向右 还是右向左  其中船上的负数是为了计算方便
      
      static List <step> process;
      static boolean Canmove(num_state state,move_boat boat) {
    	  //判断当前状态下是否能够以这种方式移动船  满足两边人数限定  以及规则限定 妖怪不大于和尚 且都大于0
    	  if(state.isleft != boat.toright)
    		  return false;
    	  if(state.isleft) {
    		  if(state.num[0]+boat.monk<0  || state.num[1]+boat.monster<0 )
    			  return false;
    	  	  if((0< state.num[0]+boat.monk && state.num[0]+boat.monk < state.num[1]+boat.monster) || (0< state.num[2]-boat.monk && state.num[2]-boat.monk<state.num[3]-boat.monster  ))
    	  		  return false;
    	  	  }
    	  else {
    		  if(state.num[2]-boat.monk<0  || state.num[3]-boat.monster<0 )
    			  return false;
    	  	  if((0<state.num[0]+boat.monk && state.num[0]+boat.monk < state.num[1]+boat.monster) || (0<state.num[2]-boat.monk && state.num[2]-boat.monk < state.num[3]-boat.monster))
    	  		  return false;
    	  }
    	  return true;
      }
      static boolean isend(int[] state) {
    	  //判断是否结束转移
    	  for (int i=0;i<end.length;i++) {
    		  if(state[i]!=end[i])
    			  return false;
    	  }
    	  return true;
      }
	  static boolean isExist(num_state state) {
		  //判断是否以前出现过这种状态  出现过则这个状态的搜索无意义 循环
		  	if(process==null ||process.size()==0)
		  	{
		  		process=new ArrayList<step>();
		  		return false;
		  		}
			int l=process.size();
			for(int i=0;i<l;i++) {
				if(process.get(i).state.num[0]==state.num[0]&&process.get(i).state.num[1]==state.num[1]&&process.get(i).state.isleft==state.isleft)
						return true;
//				if(process.get(i).boat.monk!=boat.monk || process.get(i).boat.monster!=boat.monster)
//					return false;
			}

			return false;
		}
      
      static num_state moveon(num_state state,move_boat boat) {
    	  //船移动后的状态更新
    	  num_state new_state = new num_state();
    	  
    	  new_state.num[0]=state.num[0]+boat.monk;
    	  new_state.num[1]=state.num[1]+boat.monster;
    	  new_state.num[2]=state.num[2]-boat.monk;
    	  new_state.num[3]=state.num[3]-boat.monster;
    	  new_state.isleft=!state.isleft;
    	  
    	  return new_state;
      }
      
      static void searchstate(num_state state,move_boat boat) {
    	  //获取新的状态并将这一步的状态和移动方式存入步骤 从新的状态重新开始搜索
       	  num_state  new_state=moveon(state,boat);
    	  if(!isExist(new_state)) {
	       	  process.add(new step(state,boat));
	    	  search(new_state);
	    	  process.remove(process.size()-1);
    	  }
    	  
  	  	}
      static void search(num_state state) {

			
    	  	if(isend(state.num)) {
    	  		//获得最终结果 打印
    			total++;
    			System.out.println("第"+(total)+"种方法：");
    			int i;
    	  		for(i=0;i<process.size();i++) {
    	  			
    	  			System.out.print((process.get(i).state.isleft?"船在左边":"船在右边 ") +"[ "+process.get(i).state.num[0]+" "+process.get(i).state.num[1] +" | ");
    	  			System.out.print(process.get(i).state.num[2]+" "+process.get(i).state.num[3]+" ]\n");
    	  			System.out.println((process.get(i).boat.toright?">> ":"<< ")+"[ "+Math.abs(process.get(i).boat.monk)+" "+ Math.abs(process.get(i).boat.monster)+" ]");
    	  		}
    	  		System.out.print("左边："  +" 和尚:"+end[0]+" 妖怪："+end[1] +" ");
	  			System.out.print("右边: " +" 和尚:"+end[2]+" 妖怪："+end[3]+" \n");
	  			System.out.println("共"+(i-1)+"步");
    	  		System.out.println("结束该方法");
    	  		System.out.println();
    	  		return;
    	  	}else {
    	  		//为达到结果  继续再该状态下搜索新的移动方式
	    	  	for(int i=0; i<method.length;i++) {

	    	  		if(Canmove(state,method[i])) {
	    	  			searchstate(state,method[i]);
	    	  		}
	    	  	}
	    	  	}
		
	}
		public static void main(String []arg) {
			process=null; 
			step new_step=new step(new num_state(new int[] {3,3,0,0},true),new move_boat(0,0,true));

			search(new_step.state);
			System.out.println("总共"+total+"种方法");
		}
      
      
}
class step{
	num_state state;
	move_boat boat;

	step(num_state mystate,move_boat myboat){
			state=mystate;
			boat=myboat;
	}
}
class num_state{
	 int[] num;
	 boolean isleft;
	 num_state(){
		 num=new int[4];
		 isleft=true;
	 }
	 num_state(int[] n,boolean T){
		 num=n.clone();
		 isleft=T;
	 }
}
class move_boat{
	int monk;
	int monster;
	boolean toright;
	move_boat(){
		 monk=0;
		 monster=0;
		 toright=true;
	 }
	move_boat(int m,int n, boolean move){
		monk=m;
		monster=n;
		toright=move;
	}
}