

public class dancer_partner {
	
	static int Count;
	static partner[] boys;
	static partner[] girls;
	static void match_partner(partner[] boys,partner[] girls,int Count) {
		int bid=getalone(boys,Count);//找到一个没有舞伴的男孩id
		while(bid>=0) {
			int gid=boys[bid].Plist[boys[bid].next];  //下一个女孩的id
			if(girls[gid].current==-1) {
				girls[gid].current=bid;
				boys[bid].current=gid;
			}else {
				int gcid=girls[gid].current;
				if(Isperfect(girls[gid],gcid,bid) ) {
					boys[gcid].current=-1;
					boys[bid].current=gid;
					girls[gid].current=bid;
				}
			}
			boys[bid].next++;
			bid=getalone(boys,Count);
		}
		

	}

	static int getalone(partner[] boys,int Count) {
		//找到没有匹配的男孩
		for(int i=0;i<Count;i++) {
			if(boys[i].current==-1) {
				return i;
			}
		}
		return -1;
	}
	static boolean Isperfect(partner p,int gcid,int bid) {
		//判断更喜欢哪个
		for(int i=0;i<p.Count;i++) {
			if(p.Plist[i]==gcid){
				return false;
			}
			if(p.Plist[i]==bid){
				return true;
			}
		}
		
		return false;
	}

	public static void main(String []arg) {
			Count=3;
			boys= new  partner[] {new partner(-1,0,3,new int[]{0,1,2}),new partner(-1,0,3,new int[]{0,1,2}),new partner(-1,0,3,new int[]{1,0,2})};
			girls= new  partner[] {new partner(-1,0,3,new int[]{0,2,1}),new partner(-1,0,3,new int[]{2,0,1}),new partner(-1,0,3,new int[]{0,2,1})};
			match_partner(boys,girls,Count);
			for(int i=0;i<Count;i++) {
				System.out.println("第"+i +"个匹配："+boys[i].current+" "+girls[boys[i].current].current);
			}
			
	}

}
class partner{
	//舞伴的基本数据
	
	int current;
	int next;
	int Count;
	int []Plist;
	partner(int c,int n,int C, int [] l){
		current=c;
		next=n;
		Count=C;
		Plist=l;
	}
}