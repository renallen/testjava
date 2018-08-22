import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iter_fun {
    public static void main(String args[]) throws IOException {  
        int n;  
        BufferedReader buf;  
        buf = new BufferedReader(new InputStreamReader(System. in ));  
//        System.out.print("请输入盘数：");  
//        n = Integer.parseInt(buf.readLine());  
//        Hanoi hanoi = new Hanoi();  
//        hanoi.move(n, 'A', 'B', 'C');  
        
//        System.out.print("请输入fabonacci数列个数：");  
//        n = Integer.parseInt(buf.readLine());  
//        System.out.print("Fibonacci of is: ");
//        fibonacci Fib=new fibonacci();
//        for (int counter = 0; counter <= n; counter++){
//        	System.out.print( " "+Fib.fib(counter) );
//        }System.out.println( );
        
        System.out.print("阶乘个数：");  
        n = Integer.parseInt(buf.readLine());  
        Factorial Fact=new Factorial(n);
        for (int counter = 0; counter <= n; counter++){
            System.out.printf("%d! = %d\n", counter,
            Fact.fact(counter));
        }

        System.out.print("累加个数：");  
        n = Integer.parseInt(buf.readLine()); 
        sum_a suma=new sum_a(n);

        
    }  
}
class Hanoi {
    public void move(int n, char a, char b, char c) {  
        if (n == 1) System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);  
        else {  
            move(n - 1, a, c, b);  
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);  
            move(n - 1, b, a, c);  
        }  
    }  
}
class fibonacci {
	public long fib(long number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return fib(number - 1) + fib(number - 2);
        }
}
class Factorial{
	int number ;
	Factorial (int n){
		number=n;
	}
    public long fact(int number) {
        if (number <= 1)
            return 1;
        else
            return number * fact(number - 1);
    }
}
//方法的覆盖 子类
class sum_a extends Factorial{
	int number ;
	long sums;
	sum_a(int n) {
		super(n);
		// TODO Auto-generated constructor stub
        for (int counter = 0; counter <= n; counter++){
        	sums=fact(counter);
            System.out.printf("sum(%d) = %d\n", counter,
            sums);
        }

	}
	public long fact(int number) {
        if (number <= 1)
            return 1;
        else
            return number + fact(number - 1);
    }
}