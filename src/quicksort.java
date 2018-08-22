
public class quicksort {

	    private int[] data;  
	    quicksort(int[] data) {  
	        this.data = data;  
	    }  
	    public void quickSort() {  
	        recQuickSort1(data, 0, data.length - 1);  
	    }  
	    private void recQuickSort(int[] data, int low, int high) {  
	        // 设置两个滑标  
	        int lowCursor = low + 1;  
	        int highCursor = high;  
	        // 交换时的临时变量  
	        int temp = 0;  
	        // 比较枢值,设为数组的第一个值  
	        int medi = data[low];  
	        while (true) {  
	            // 从低端开始查找，确定大于数 data[low] 所在的位置  
	            while (lowCursor < high && data[lowCursor] < medi) {  
	                lowCursor++;  
	            }  
	            // 从高端开始查找，确定小于数 data[low] 所在的位置。这里要使用 >= 判断确定小于值  
	            while (highCursor > low && data[highCursor] >= medi) {  
	                highCursor--;  
	            }  
	            // 两游标位置出现越界，退出循环  
	            if (lowCursor >= highCursor) {  
	                break;  
	            }  
	            // 交换 data[highCursor] 和 data[lowCursor] 位置数据  
	            temp = data[highCursor];  
	            data[highCursor] = data[lowCursor];  
	            data[lowCursor] = temp;  
	        }  

	        // 由 while 循环退出条件可知：lowCursor > highCursor  
	        // 当前 lowCursor 指向右侧大于 data[low]的第一个位置;  
	        // 而 highCursor 指向左侧小于 data[low]的第一个位置，所以需要交换 data[low] 和  
	        // data[highCursor]的值  
	        data[low] = data[highCursor];  
	        data[highCursor] = medi;  
	        // 递归运算左半部分  
	        if (low < highCursor) {  
	            recQuickSort(data, low, highCursor);  
	        }  
	        // 递归运算右半部分  
	        if (lowCursor < high) {  
	            recQuickSort(data, lowCursor, high);  
	        }  
	    }  
	    private void recQuickSort1(int[] data, int low, int high) {  
	        // 设置两个滑标  
	        if(low<high){
	        int lowCursor = low -1;  
	        int highCursor = high+1;  
	        // 交换时的临时变量  
	        int temp = 0;  
	        // 比较枢值,设为数组的第一个值  
	        int medi = data[(low+high)/2];  
	        while (true) {  
	            // 从低端开始查找，确定大于数 data[low] 所在的位置  
	            while ( data[++lowCursor] < medi) {  
//	                lowCursor++;  
	            }  
	            // 从高端开始查找，确定小于数 data[low] 所在的位置。这里要使用 >= 判断确定小于值  
	            while ( data[--highCursor] >= medi) {  
//	                highCursor--;  
	            }  
	            // 两游标位置出现越界，退出循环  
	            if (lowCursor >= highCursor) {  
	                break;  
	            }  
	            // 交换 data[highCursor] 和 data[lowCursor] 位置数据  
	            temp = data[highCursor];  
	            data[highCursor] = data[lowCursor];  
	            data[lowCursor] = temp;  
	        }  

	        // 由 while 循环退出条件可知：lowCursor > highCursor  
	        // 当前 lowCursor 指向右侧大于 data[low]的第一个位置;  
	        // 而 highCursor 指向左侧小于 data[low]的第一个位置，所以需要交换 data[low] 和  
	        // data[highCursor]的值  

	        // 递归运算左半部分  

	            recQuickSort1(data, low, highCursor-1);  

	        // 递归运算右半部分  
	         
	            recQuickSort1(data, lowCursor+1, high); 
	           }
 
	    }  
	    public void display() {  
	        for (int i = 0; i < data.length; i++) {  
	            System.out.print(data[i] + " ");  
	        }  
	        System.out.println();  
	    }  
	    public static void main(String[] args) {  
	        int[] data = new int[] {  
	            43, 12, 32, 55, 33, 67, 54, 65, 43, 22, 66,  
	            98, 74  
	        };  
	        quicksort sort = new quicksort(data);  
	        sort.display();  
	        sort.quickSort();  
	        sort.display();  
	    }  
	 
}
