import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Drow_style{
    public static void main(String[] args) throws NumberFormatException, IOException {

    	BufferedReader buf;  
    	
        buf = new BufferedReader(new InputStreamReader(System. in ));  
        System.out.print("你要打印什么形状：1,菱形，2,三角形，3,平行四边形，4,exit\n");
        int style= Integer.parseInt(buf.readLine());
        if(style==1) {
        	System.out.print("菱形行数：");
        	int n= Integer.parseInt(buf.readLine());
        	Diamond D = new Diamond(n);
        	D.output();
        }
        else if(style==2) {
        	System.out.print("打印等腰三角形？y/n");
        	Boolean right= buf.readLine().equals("y") ? true: false;
        	System.out.print("三角形行数：");
        	int n= Integer.parseInt(buf.readLine());
        	System.out.print("是否倒立：y/n");
        	Boolean inv=  buf.readLine().equals("y") ? true : false;
        	right_tri Tri = new right_tri(n,inv) ;
        	if (right)
        		Tri.output();
        	else
        		Tri.output_right();
        	
        }else if(style==3) {
        	
        	System.out.print("平行四边形行数：");
        	int n= Integer.parseInt(buf.readLine());
        	Parallelogram par = new Parallelogram(n);
        	par.output();
        }else {
        	System.exit(0);
        }

    }


}
class Style {
	int num;
	Style(int n){
		num =n;
	}
	void output() {
		System.out.println("你可以确定那种形状。");
	}

}
class Diamond extends  Style{

	Diamond(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	void output(){
		int size=num;
		if (num%2==0) {
			size=num+1;
		}
		for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" "); // 输出左上角位置的空白
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*"); // 输出菱形上半部边缘
            }
            System.out.println(); // 换行
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" "); // 输出菱形左下角空白
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                System.out.print("*"); // 输出菱形下半部边缘
            }
            System.out.println(); // 换行
        }
	}
}
class Triangle extends Style{
	Boolean  Inverted ;
	Triangle(int n, Boolean T) {
		super(n);
		 Inverted =T;
		// TODO Auto-generated constructor stub
	}
	void output(){
		char s1=' ';
		char s2='*';
		if (Inverted) {
			s1=' ';
			s2='*';
			}
        for (int m = 1; m <= num; m++) {
            //打印空格

            for (int n = 0; (n <= m && Inverted )||(n <= num-m && !Inverted); n++) {
                System.out.print(s1);
            }
            //打印*
            for (int x = 1; (x <= 2*num-1 -2 * (m - 1)&& Inverted )||(x<= 2 * m - 1 && !Inverted); x++) {
                System.out.print(s2);
            }
            System.out.println();
        }        
    
	}
}
class right_tri extends Triangle{

	right_tri(int n, Boolean T) {
		super(n, T);
		// TODO Auto-generated constructor stub
	}
	void output_right(){

        for (int m = 1; m <= num; m++) {
            //打印空格
        	System.out.print(" ");
        	for (int k=1;(k<=num-m && Inverted)||(k<=m && !Inverted);k++)
        		System.out.print("*");
    
            System.out.println();
        }        
    
	}
}
class Parallelogram extends Style{

	Parallelogram(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	void output(){
		 for (int i = 1; i <=num; i++) {
	            //填充空格
	            for (int j = 1; j <= num - i; j++) {
	                System.out.print(" ");
	            }
	            //内层循环 每次打印一个*
	            for (int k = 1; k <= num*4; k++) {
	            	if (k%4==1)
	            		System.out.print("*");
	            	else System.out.print(" ");
	            } 
	            System.out.println();
	        }
	}
}