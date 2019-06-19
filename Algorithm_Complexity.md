## Recursions

### Simple recursion

```js
function sum(n) {
  if (n == 1) {
    return 1; // T(1) = 1
  }
  return n + sum(n - 1); // T(n) = 1 + T(n-1)
}
```

```
// T - number of elementary operations
T(1) = 1
T(n) = 1 + T(n-1)
T(n-1) = 1 + T(n-2)
T(n-2) = 1 + T(n-3)

// Substition 
T(n) = 1 + (1 + T(n-2)) = 2 + T(n-2)
T(n) = 2 + T(n-2) = 2 + (1 + T(n-3)) = 3 + T(n - 3)

// Find the logic of k
T(n) = k + T(n-k)

// Replace k and T(1) with appropriate values
n-k = 1
=>
k = n-1 and T(n-k) = T(1)

T(n) = k + T(n-k) = n-1 + T(1) = n-1+1 = n => O(n)
```

### Binary search

```js
function binarySearch(array, value, leftBound, rightBound) {
  if (leftBound > rightBound) {
    return -1;
  }
  const mid = Math.floor((leftBound + rightBound) / 2);
  if (value === array[mid]) {
    return mid;
  }
  if (value < array[mid]) {
    return binarySearch(array, value, leftBound, mid - 1);
  }
  return binarySearch(array, value, mid + 1, rightBound);
}

binarySearch([1, 2, 3, 4], 3, 0, 4);
```

```
// T - number of elementary operations
T(1) = 1
T(n) = 1 + T(n/2)
T(n/2) = 1 + T(n/4)
T(n/4) = 1 + T(n/8)

// Substition 
T(n) = 2 + T(n/4) = 3 + T(n/8) = 4 + T(n/16)

// Find the logic of k
T(n) = k + T(n/2^k)

// Replace k and T(1) with appropriate values
n/2^k = 1;
2^k = n;
k = log(n);

T(n) = log(n) + 1 => O(log(n))
```

### Double recursion

```js
function recursiveFun4(n, m, o)
{
  if (n <= 0) {
    console.log(n, m, o);
  } else {
    recursiveFun4(n-1, m+1, o);
    recursiveFun4(n-1, m, o+1);
  }
}
```

```
// T - number of elementary operations
T(1) = 1
T(n) = 1 + 2*T(n-1)
T(n-1) = 1 + 2*T(n-2)
T(n-2) = 1 + 2*T(n-3)

// Substition 
T(n) = 1 + 2*(1 + 2*T(n-2)) = 3 + 4T(n-2)
T(n) = 1 + 2*(3 + 4T(n-3)) = 7 + 8T(n-3)
T(n) = 1 + 2*(7 + 8T(n-4)) = 15 + 16T(n-4)

// Find the logic of k
T(n) = 2^k - 1 + 2^k*T(n-k)

// Replace k and T(1) with appropriate values
n-k=1, T(n-k) = T(1), k = n-1
=>

T(n) = 2^(n-1) - 1 + 2^(n-1) * T(1) = 2^n => O(2^n)

```