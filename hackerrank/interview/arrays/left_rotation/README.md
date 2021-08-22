# [Left Rotation](https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)

## Problem
A left rotation operation on an array shifts each of the array's elements **1** unit to the left.  
For example, if **2** left rotations are performed on array **[1, 2, 3, 4, 5]**, then the array would become **[3, 4, 5, 1, 2]**.  
Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array $a$ of $n$ integers and a number, $d$, perform $d$ left rotations on the array.  
Return the updated array to be printed as a single line of space-separated integers.

**Function Description**

Complete the function rotLeft in the editor below.  
rotLeft has the following parameter(s):
- int a[n]: the array to rotate
- int d: the number of rotations

**Returns**

int a[n]: the rotated array

**Input Format**

The first line contains two space-separated integers $n$ and $d$, the size of $a$ and the number of left rotations.  
The second line contains $ n $ space-separated integers, each an $a[i]$.

**Constraints**
- $ 1 \leq n \leq 10^5 $
- $ 1 \leq d \leq n $
- $ 1 \leq a[i] \leq 10^6 $

**Sample Input**
```
5 4  
1 2 3 4 5
```

**Sample Output**
```
5 1 2 3 4
```

**Explanation**
When we perform **$d$ = 4** left rotations, the array undergoes the following sequence of changes:  
**$ [1, 2, 3, 4, 5] \rightarrow [2, 3, 4, 5, 1] \rightarrow [3, 4, 5, 1, 2] \rightarrow [4, 5, 1, 2, 3] \rightarrow [5, 1, 2, 3, 4] $**


## Problem Solving Review
1. 해당 문제의 경우 배열의 시작과 종료 카운트 다시 시작하면 되도록 코드를 작성했다.  
2. Explanation에서는 뭔가 단계별로 처리해 보이는데 해당 인덱스로 넣도록 구현했다.