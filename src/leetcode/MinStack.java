package leetcode;

import java.util.Stack;

/**
 * A stack that supports getMin()
 */
public class MinStack
{

//    private List<Integer> list = new ArrayList<Integer>();
//    
//    private void adjust()
//    {
//        int n = list.size();
//        int parent = 0;
//        while(parent < n/2)
//        {
//            // find the smaller one of the two children
//            int child = parent * 2 + 1;
//            if(child + 1 <= n-1 && list.get(child+1) < list.get(child))
//                child ++;
//            
//            // swap parent and child if child is smaller than parent
//            if(list.get(child) < list.get(parent))
//            {
//                int temp = list.get(parent);
//                list.set(parent, list.get(child));
//                list.set(child, temp);
//            }
//            
//            parent = child;
//        }
//    }
//    
//    public void push(int x)
//    {
//        if(list.size() > 0)
//        {
//            // move root to the bottom
//            list.add(list.get(0));
//            
//            // put x to the root
//            list.set(0, x);
//            
//            // re-adjust the root
//            adjust();
//        }
//        else
//            list.add(x);
//    }
//
//    public void pop()
//    {
//        if(list.size() > 0)
//            list.remove(list.size() - 1);
//    }
//
//    public int top()
//    {
//        return list.size() > 0 ? list.get(list.size() - 1) : 0;
//    }
//
//    public int getMin()
//    {
//        return list.size() > 0 ? list.get(0) : 0;
//    }
    
    
    /**
     * Another way is to use another stack to save the min for each position in the original stack
     * Time: O(1), space: O(n)
     * e.g.:
     * 1 1
     * 6 3
     * 3 3
     * 5 5
     */
    
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min   = new Stack<Integer>();

    public void push(int x)
    {
        stack.push(x);
        if(min.isEmpty())
            min.push(x);
        else
            min.push(Math.min(x, min.peek()));
    }

    public void pop()
    {
        stack.pop();
        min.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return min.peek();
    }
    
    public static void main(String[] args)
    {
        MinStack s = new MinStack();
        s.push(1);
        s.push(2);
        int r = s.top();
        r = s.getMin();
        s.pop();
        r = s.getMin();
        r = s.top();
    }

}
