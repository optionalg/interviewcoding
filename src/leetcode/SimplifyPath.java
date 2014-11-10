package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimplifyPath
{

    public static String simplifyPath(String path)
    {
        // a stack to save dir structure
        List<String> stack = new LinkedList<String>();
        stack.add("/");
        
        String[] dirs = path.split("/");
        
        // for each dir
        for(String dir: dirs)
        {
            if(dir.equals(".") || dir.isEmpty())
                continue;
            
            if(dir.equals(".."))
            {
                if(stack.size() > 1)
                    stack.remove(stack.size() - 1);
            }
            else
            {
                stack.add(dir);
            }
        }
        
        if(stack.size() == 1)
            return "/";
        
        String result = "";
        Iterator<String> it = stack.iterator();
        while(it.hasNext())
        {
            String dir = it.next();
            if(!dir.equals("/"))
                result += "/" + dir;
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(simplifyPath("/"));
        System.out.println(simplifyPath("/../../"));
        System.out.println(simplifyPath("/./"));
        System.out.println(simplifyPath("/a/./b/"));
        System.out.println(simplifyPath("/./a/b/../c/"));
        System.out.println(simplifyPath("/a/b/"));
        System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }

}
