/*
===============================================================================
                         DESIGN CIRCULAR QUEUE
===============================================================================

Platform  : LeetCode (622)
Approach  : Circular Array
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Design a Queue using a fixed-size array.

When rear reaches the end of the array,
it should wrap around to the beginning.

===============================================================================
CORE IDEA
===============================================================================

Maintain:

front
rear
size

Use modulo operator to make the queue circular.

(index + 1) % capacity

===============================================================================
WHY MODULO?
===============================================================================

capacity = 3

Indices:

0 1 2

rear = 2

Next insertion:

(2 + 1) % 3

= 0

Wraps around to beginning.

===============================================================================
TIME COMPLEXITY
===============================================================================

enQueue() : O(1)

deQueue() : O(1)

Front()   : O(1)

Rear()    : O(1)

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(k)

===============================================================================
DRY RUN
===============================================================================

capacity = 3

----------------------------------

enQueue(10)

[10,_,_]

front = 0
rear  = 0

----------------------------------

enQueue(20)

[10,20,_]

front = 0
rear  = 1

----------------------------------

enQueue(30)

[10,20,30]

front = 0
rear  = 2

Queue Full

----------------------------------

deQueue()

front = (0 + 1) % 3

front = 1

Logical Queue:

20 -> 30

----------------------------------

enQueue(40)

rear = (2 + 1) % 3

rear = 0

Array:

[40,20,30]

Logical Queue:

20 -> 30 -> 40

===============================================================================
PATTERN LEARNED
===============================================================================

Circular Buffer

Queue Implementation

Modulo Arithmetic

===============================================================================
*/

class MyCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {

        queue = new int[k];
        capacity = k;

        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;

        queue[rear] = value;

        size++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;

        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size == capacity;
    }
}
