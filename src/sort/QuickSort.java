package sort;
import java.util.Arrays;

public class QuickSort{
    
    
    static int getMiddle(Integer[] list, int low, int high) {  
        int tmp = list[low];    //数组的第一个作为中轴  
        while (low < high) {  
            while (low < high && list[high] > tmp) {  
                high--;  
            }  
            list[low] = list[high];   //比中轴小的记录移到低端  
            
            
            while (low < high && list[low] < tmp) {  
                low++;  
            }  
            list[high] = list[low];   //比中轴大的记录移到高端  
            
        }  
        list[low] = tmp;              //中轴记录到尾  
        System.out.println(Arrays.toString(list));
        return low;                  //返回中轴的位置  

        
    }
    
     static void _quickSort(Integer[] list, int low, int high) {  
        if (low < high) {  
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二  
           
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序  
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序  
        }  
    }
    
    
    public static void main(String args[]){
    	int array [] ={49,38,65,97,76,13,27};
    	
    	//_quickSort(array,0,array.length-1);
    }
    
    
//    快速排序是对冒泡排序的一种改进。它的基本思想是：通过一躺排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一不部分的所有数据都要小，然后再按次方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。最坏情况的时间复杂度为O(n2)，最好情况时间复杂度为O(nlog2n)。
//    假设要排序的数组是A[1]……A[N]，首先任意选取一个数据（通常选用第一个数据）作为关键数据，然后将所有比它的数都放到它前面，所有比它大的数都放到它后面，这个过程称为一躺快速排序。一趟快速排序的算法是：
//   1）、设置两个变量I、J，排序开始的时候I：=1，J：=N；
//   2）以第一个数组元素作为关键数据，赋值给X，即X：=A[1]；
//   3）、从J开始向前搜索，即由后开始向前搜索（J：=J-1），找到第一个小于X的值，两者交换；
//   4）、从I开始向后搜索，即由前开始向后搜索（I：=I+1），找到第一个大于X的值，两者交换；
//   5）、重复第3、4步，直到I=J；
//   例如：待排序的数组A的值分别是：（初始关键数据X：=49）
//                   A[1]    A[2]    A[3]    A[4]    A[5]     A[6]    A[7]： 
//                     49       38      65      97      76      13       27
// 进行第一次交换后：  27       38      65      97      76      13       49
//                   ( 按照算法的第三步从后面开始找)
// 进行第二次交换后：  27       38      49      97      76      13       65
//                  ( 按照算法的第四步从前面开始找>X的值，65>49,两者交换，此时I：=3 )
// 进行第三次交换后：  27       38      13      97      76      49       65
// ( 按照算法的第五步将又一次执行算法的第三步从后开始找)
// 进行第四次交换后：  27       38      13      49      76      97       65
// ( 按照算法的第四步从前面开始找大于X的值，97>49,两者交换，此时J：=4 )
//      此时再执行第三步的时候就发现I=J，从而结束一躺快速排序，那么经过一躺快速排序之后的结果是：27       38      13      49      76      97       65，即所以大于49的数全部在49的后面，所以小于49的数全部在49的前面。
//      快速排序就是递归调用此过程——在以49为中点分割这个数据序列，分别对前面一部分和后面一部分进行类似的快速排序，从而完成全部数据序列的快速排序，最后把此数据序列变成一个有序的序列，根据这种思想对于上述数组A的快速排序的全过程如图6所示：
//  初始状态                       {49    38    65    97    76    13    27}   
// 进行一次快速排序之后划分为     {27    38    13}    49  {76    97    65}
// 分别对前后两部分进行快速排序   {13}   27   {38} 
//                                结束        结束   {49   65}   76   {97}
//                                                    49  {65}        结束
//                                                        结束
//                          图6   快速排序全过程
//  
// 1）、设有N（假设N=10）个数，存放在S数组中；
// 2）、在S[1。。N]中任取一个元素作为比较基准，例如取T=S[1]，起目的就是在定出T应在排序结果中的位置K，这个K的位置在：S[1。。K-1]<=S[K]<=S[K+1..N]，即在S[K]以前的数都小于S[K]，在S[K]以后的数都大于S[K]；
// 3）、利用分治思想（即大化小的策略）可进一步对S[1。。K-1]和S[K+1。。N]两组数据再进行快速排序直到分组对象只有一个数据为止。
// 如具体数据如下，那么第一躺快速排序的过程是：
// 数组下标： 1     2     3     4     5     6     7     8     9     10
//           45    36    18    53    72    30    48    93    15     36
//           I                                                       J
// （1）     36    36    18    53    72    30    48    93    15     45
// （2）     36    36    18    45    72    30    48    93    15     53
// （3）     36    36    18    15    72    30    48    93    45     53
// （4）     36    36    18    15    45    30    48    93    72     53
// （5）     36    36    18    15    30    45    48    93    72     53
// 通过一躺排序将45放到应该放的位置K，这里K=6，那么再对S[1。。5]和S[6。。10]分别进行快速排序。
// 
}