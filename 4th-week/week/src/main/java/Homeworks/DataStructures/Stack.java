package Homeworks.DataStructures;

public class Stack {
    final private int LENGTH_INTERVAL = 1;
    private int[] nums;
    private int top;

    public Stack() {
        this.nums = new int[0];
        this.top = -1;
    }

    public void push(int data) {
        this.top += 1;
        if (nums.length == this.top) {
            int[] temp = new int[nums.length + LENGTH_INTERVAL];
            for (int i=0; i<nums.length; i++) {
                temp[i] = nums[i];
            }
            temp[this.top] = data;
            this.nums = temp;
        } else {
            this.nums[this.top] = data;
        }
    }

    public int pop() throws Exception {
        if (this.top == -1) {
            System.out.println("No more stack");
            throw new Exception("No more stack");
        } else {
            int ret = this.nums[this.top];
            this.top -= 1;
            return ret;
        }
    }
}
