## Binary Decimal Conversions

### From 2 to 10 base

```java
10010101

// Starting from last digit
2^0 * 1 + 2^1 * 0 + 2^2 * 1 + 2^3 * 0 + 2^4 * 1 + 2^5 * 0 + 2^6 * 0 + 2^7 * 1
= 1 + 0 + 4 + 0 + 16 + 0 + 0 + 128
= 149
```

### From 10 to 2 base

```java
149

// Find quotient and remainder recursively until quotient is 0
47 % 2 = 1
(int) (47 / 2) = 23
23 % 2 = 1
(int) (23 / 2) = 11
11 % 2 = 1
(int) (11 / 2) = 5
5 % 2 = 1
(int) (5 / 2) = 2
2 % 2 = 0
(int) 2 / 2 = 1
1 % 2 = 1
(int) 1 / 2 = 0

// Write all remainders one by one starting from last remainder
101111
```
