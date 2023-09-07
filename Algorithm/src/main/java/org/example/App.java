package org.example;

import java.util.*;

public class App {
    public static void main(String[] args) {

    }

    public boolean isNumber(String s) {
        char[] ch = s.toCharArray();
        int size = ch.length;
        for (int i = 0; i < size; i++) {
            while (ch[i] == ' ') i++;
            while (ch[i] >= '0' && ch[i] <= '9')
                i++;
            boolean after = ch[i + 1] >= '0' && ch[i + 1] <= '9';
            if ((ch[i] == '-' || ch[i] == '+')) {
                if (i == size - 1) return false;
                if (!after) {
                    return false;
                }
            }

            if ((ch[i] == '.' || ch[i] == 'e' || ch[i] == 'E')) {
                if (i == 0) return false;
                boolean before = ch[i - 1] >= '0' && ch[i - 1] <= '9';
                if (ch[i] == '.') {
                    if (!before || !after) return false;
                } else {
                    if (!(before && after)) {
                        if (ch[i] != '-') {
                            return false;
                        } else {
                            if (!after)
                                return false;
                        }
                    }
                }

            }
        }
        return true;
    }

}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int t = stack.pop();
        if (minStack.peek() == t){
            minStack.pop();
        }
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}