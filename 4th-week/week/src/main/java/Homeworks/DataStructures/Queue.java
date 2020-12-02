package Homeworks.DataStructures;

public class Queue {
    final private int LENGTH_INTERVAL = 1;
    private int[] nums;
    private int last;

    public Queue() {
        this.nums = new int[0];
        this.last = -1;
    }

    public void add(int data) {
        this.last += 1;
        if (nums.length == this.last) {
            int[] temp = new int[nums.length + LENGTH_INTERVAL];
            for (int i=0; i<nums.length; i++) {
                temp[i] = nums[i];
            }
            temp[this.last] = data;
            this.nums = temp;
        } else {
            this.nums[this.last] = data;
        }
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("No more queue");
        }
        int ret = this.nums[0];
        for (int i=1; i<=this.last; i++) {
            this.nums[i-1] = this.nums[i];
        }
        this.last -= 1;
        return ret;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("No more queue");
        }
        return this.nums[0];
    }

    public boolean isEmpty() {
        if (this.last == -1) {
            return true;
        } else {
            return false;
        }
    }

}
