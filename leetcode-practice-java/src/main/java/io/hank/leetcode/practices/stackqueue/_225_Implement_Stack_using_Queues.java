package io.hank.leetcode.practices.stackqueue;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 *
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * </pre>
 */
public class _225_Implement_Stack_using_Queues extends LeetcodeProblemSolution {

    @Override
    @Topic({TopicType.STACK, TopicType.QUEUE})
    public void execute() {
        super.execute();
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

class MyStack {

    private final Deque<Integer> deque;

    public MyStack() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        deque.push(x);
    }

    public int pop() {
        return deque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
