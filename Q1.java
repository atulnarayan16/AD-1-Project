Q1:-How to implement ternary heap in Java programming ?
Ans:-
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;


class TernaryHeap    
{
    private int d;
    private int heapSize;
    private int[] heap;

     
    public TernaryHeap  (int capacity, int numChild)
    {
        heapSize = 0;
        d = numChild;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }

    
    public void clear( )
    {
        heapSize = 0;
    }

    
    private int parent(int i) 
    {
        return (i - 1)/d;
    }

    
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }

    
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[0];
    }

    
    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);        
        return keyItem;
    }

    
    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];    
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }

    
    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    
    private int minChild(int ind) 
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize)) 
        {
            if (heap[pos] < heap[bestChild]) 
                bestChild = pos;
            pos = kthChild(ind, k++);
        }    
        return bestChild;
    }

    
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }     
}


public class TernaryHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ternary Heap Test\n\n");
        System.out.println("Enter size and no of nodes each child has");
        /** Make object of TernaryHeapHeap **/
        TernaryHeap th = new TernaryHeap(scan.nextInt(), scan.nextInt() );

        char ch;
        
/**  Perform Ternary Heap operations **/
        do    
        {
            System.out.println("\nTernary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. check full");            
            System.out.println("4. check empty");
            System.out.println("5. clear");

            boolean chk;       
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    System.out.println("Enter integer element to insert");
                    th.insert( scan.nextInt() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }    
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Enter delete position");
                    th.delete(scan.nextInt() - 1); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }                 
                break;                         
            case 3 : 
                System.out.println("Full status = "+ th.isFull());
                break;                                   
            case 4 : 
                System.out.println("Empty status = "+ th.isEmpty());
                break; 
            case 5 : 
                th.clear(); 
                System.out.println("Heap Cleared\n");
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            } 
            /** Display heap **/
            th.printHeap();  

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
}
