/**
 *  Consider this string representation for binary trees. Each node is of the
    form (lr), where l represents the left child and r represents the right
    child. If l is the character 0, then there is no left child. Similarly, if r
    is the character 0, then there is no right child. Otherwise, the child can
    be a node of the form (lr), and the representation continues recursively.
    For example: (00) is a tree that consists of one node. ((00)0) is a two-node
    tree in which the root has a left child, and the left child is a leaf. And
    ((00)(00)) is a three-node tree, with a root, a left and a right child.

    Write a function that takes as input such a string, and returns -1 if the
    string is malformed, and the depth of the tree if the string is well-formed.

    For instance:

    find_depth('(00)') -> 0
    find_depth('((00)0)') -> 1
    find_depth('((00)(00))') -> 1
    find_depth('((00)(0(00)))') -> 2
    find_depth('((00)(0(0(00))))') -> 3
    find_depth('x') -> -1
    find_depth('0') -> -1
    find_depth('()') -> -1
    find_depth('(0)') -> -1
    find_depth('(00)x') -> -1
    find_depth('(0p)') -> -1
 */

public class BinaryTreeSerialization
{
    static int maxDepth = 0;
    public static int getDepth(String str)
    {
        if(str == null || str.isEmpty())
            return -1;
        
        maxDepth = 0;
        getDepth(str, 0, str.length() - 1, 0);
        return maxDepth;
    }
    
    private static void getDepth(String str, int start, int end, int depth)
    {
        if(maxDepth == -1)
            return;
        
        if(str.charAt(start) != '(' || str.charAt(end) != ')')
        {
            maxDepth = -1;
            return;
        }
        
        if(end - start < 3)
        {
            maxDepth = -1;
            return;
        }
        
        if(end - start == 3)
        {
            if(str.substring(start, end+1).equals("(00)"))
            {
                maxDepth = Math.max(depth, maxDepth);
                return;
            }
            else
            {
                maxDepth = -1;
                return;
            }
        }
        
        if(str.charAt(start + 1) == '0')
        {
            getDepth(str, start + 2, end - 1, depth + 1);
        }
        else if(str.charAt(end - 1) == '0')
        {
            getDepth(str, start + 1, end - 2, depth + 1);
        }
        else
        {
            int rightParenthesis = str.indexOf(")");
            getDepth(str, start + 1, rightParenthesis, depth + 1);
            getDepth(str, rightParenthesis + 1, end - 1, depth + 1);
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(getDepth("(00)"));
        System.out.println(getDepth("((00)0)"));
        System.out.println(getDepth("(0(00))"));
        System.out.println(getDepth("((00)(00))"));
        System.out.println(getDepth("((00)(0(00)))"));
        System.out.println(getDepth("((00)(0(0(00))))"));
        System.out.println(getDepth("x"));
        System.out.println(getDepth("0"));
        System.out.println(getDepth("()"));
        System.out.println(getDepth("(0)"));
        System.out.println(getDepth("(00)x"));
        System.out.println(getDepth("(0p)"));
    }

}
