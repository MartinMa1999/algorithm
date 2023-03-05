package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    // 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。

    // 对于「空字符串」以及「一个点」，我们实际上无需对它们进行处理，因为「空字符串」没有任何含义，而「一个点」表示当前目录本身，我们无需切换目录。
    //对于「两个点」或者「目录名」，我们则可以用一个栈来维护路径中的每一个目录名。当我们遇到「两个点」时，
    // 需要将目录切换到上一级，因此只要栈不为空，我们就弹出栈顶的目录。当我们遇到「目录名」时，就把它放入栈。

    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return path;
        }

        String[] array = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(String s : array){
            if(s.equals("..")){
                if(! deque.isEmpty()){
                    deque.pollFirst();
                }
            }
            else if(! s.equals(".") && s.length() > 0){
                deque.offerFirst(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(deque.isEmpty()){
            sb.append('/');
        }
        else{
            while(! deque.isEmpty()){
                sb.append('/');
                sb.append(deque.pollLast());
            }
        }
        return sb.toString();
    }
}
