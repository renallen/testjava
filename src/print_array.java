
public class print_array {
	public static <A> void printArray(A[] inputArray) {
        for (A element : inputArray){
            System.out.print( element+" ");       
        } 
        System.out.println();
    }
   
    public static void main(String args[]) {
        Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };
        System.out.println("输出整型数组:");
        printArray(integerArray);
        System.out.println("\n输出双精度型数组:");
        printArray(doubleArray);
        System.out.println("\n输出字符型数组:");
        printArray(characterArray);
    }
}
