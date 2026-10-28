# Sixth Sorting Algorithm: Heap Sort

> Write every section below in your own words (assignment requirement).
> Delete the prompts in *italics* as you fill each section in.

## 1. Description
*heap sort uses a heap, which is a binary tree stored inside the array. In a min Heap, every parent is smaller than or euqal to its children. the smallest value is theofre always at index 0. I use min heap becuase the sort has to go from large to small. 

the algorithm has 2 pahse;
Build- starts form the last parent and goes back to index 0, sift all elements down until min heap rule hold
Extract- swap the smallest value & last element of the heap. Then shrink the heap and sift the new smallest value down to repair it, repeat until empty.

## 2. Why it is different from the other five
*Compare with bubble/insertion/selection (O(n^2), compare neighbours/scan),
merge (extra array, divide and conquer) and quick (partitioning around a
pivot). Heap sort uses a tree structure inside the array, sorts in place and
keeps O(n log n) in the worst case.*

## 3. Pseudocode
*Pseudocode for heapSort(arr), buildHeap and heapify (siftDown).
Number or label each line so section 4 can refer to it.*

```
heapSort(arr):
    ...
```

## 4. Operation counting
*For each line of the pseudocode, state how many times it runs:
- buildHeap: about n/2 calls to heapify; heapify cost depends on the height
- extraction phase: n - 1 swaps + n - 1 calls to heapify, each at most log2(n)
Add the counts up and show how they reduce to a Big-O.*

| Step | Operation | Times executed |
|------|-----------|----------------|
|      |           |                |

## 5. Best / average / worst case
*State each and justify. Mention space complexity and stability.*

## 6. Test results
*Paste the PASS/FAIL and timing table from SortTester for products1, 2, 3
(compareTo, original price, updated price).*
