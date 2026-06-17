# DSA-JAVA 🚀

[![LeetCode](https://img.shields.io/badge/LeetCode-200%2B%20Solved-orange?style=flat&logo=leetcode)](https://leetcode.com/u/Arun-G)
[![Language](https://img.shields.io/badge/Language-Java-blue?style=flat&logo=java)](https://www.java.com)
[![GitHub](https://img.shields.io/badge/GitHub-ArunDev--07-black?style=flat&logo=github)](https://github.com/ArunDev-07)
[![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat)]()

> A structured Java repository for DSA problem-solving and coding interview preparation.  
> Built by a Final-Year CS student targeting product-based company placements.

---

## 📊 Progress Snapshot

| Metric | Count |
|---|---|
| ✅ Problems Solved | 200+ |
| 🏷️ Topics Covered | 12+ |
| 💻 Language | Java |
| 🎯 Goal | Product-based company placements |

---

## 📂 Repository Structure

```
DSA-JAVA/
├── Arrays/
├── BinarySearch/
├── Sorting/
├── Recursion/
├── Backtracking/
├── LinkedList/
├── Stack/
├── SlidingWindow/
├── BitManipulation/
├── Math/
├── Greedy/
└── README.md
```

---

## 🗂️ Topics Covered

| Topic | Sample Problems |
|---|---|
| **Arrays** | Find Duplicates, Missing Number, Merge Intervals, Kadane's Algorithm |
| **Binary Search** | Classic BS, 2D Binary Search, Kth Largest/Smallest Element |
| **Sorting** | Bubble Sort, Insertion Sort, Merge Sort |
| **Sliding Window** | Best Time to Buy & Sell Stock, Container With Most Water |
| **Recursion** | Palindrome Partitioning, Permutations |
| **Backtracking** | N-Queens, N-Knights |
| **Linked List** | Reverse Linked List, Remove Duplicates |
| **Stack** | Stack-based problem patterns |
| **Greedy** | Gas Station |
| **Bit Manipulation** | Bitwise problem patterns |

---

## ⚡ Sample Solutions

### Kadane's Algorithm — Maximum Subarray Sum
```java
int maxSubarraySum(int[] arr) {
    int maxFar = arr[0], maxEnd = arr[0];
    for (int i = 1; i < arr.length; i++) {
        maxFar = Math.max(arr[i], arr[i] + maxFar);
        maxEnd = Math.max(maxEnd, maxFar);
    }
    return maxEnd;
}
```

### Binary Search
```java
int binarySearch(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1;
}
```

---

## 🎯 Goals

- [x] Build strong DSA fundamentals in Java
- [x] Solve 200+ LeetCode problems
- [ ] Complete Trees, Graphs, and Dynamic Programming sections
- [ ] Add time & space complexity to every solution
- [ ] Add brute-force vs optimal comparisons
- [ ] Reach 300+ problems before placement season

---

## 🔗 Connect

[![Portfolio](https://img.shields.io/badge/Portfolio-arun--g.vercel.app-purple?style=flat)](https://arun-g.vercel.app)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Arun%20G-blue?style=flat&logo=linkedin)](https://linkedin.com/in/arun-g-dev)
[![LeetCode](https://img.shields.io/badge/LeetCode-Arun--G-orange?style=flat&logo=leetcode)](https://leetcode.com/u/Arun-G)

---

> *"Consistency beats intensity. One problem a day compounds."*
