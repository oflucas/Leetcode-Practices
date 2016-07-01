// 225_Implement_Stack_using_Queues.java
// 131ms 7% Total Accepted: 43449 Total Submissions: 141453 Difficulty: Easy
// Note: However you can optimize by maintaining newcomer-to-older in queue's front-to-tail, at cost of O(n) push
class MyStack {
    boolean tailAtHead = false;
    Queue<Integer> q = new LinkedList();
    
    // Push element x onto stack.
    public void push(int x) {
        if (tailAtHead) q.offer(q.poll());
        q.offer(x);
        tailAtHead = false;
    }

    // Removes the element on top of the stack.
    public void pop() {
        top();
        q.poll();
        tailAtHead = false;
    }

    // Get the top element.
    public int top() {
        if (tailAtHead) return q.peek();
        tailAtHead = true;
        for (int i = 0; i < q.size() - 1; i++)
            q.offer(q.poll());
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
