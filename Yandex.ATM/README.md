# Description

## Iteration 1

Calculate banknotes to withdraw from given amount, preferrably with large banknotes.

```
var moneyTypes = [5000, 1000, 500, 100, 50];
function getMoney(amount) {
   // format to return:
   // {
   //   5000: 1,
   //   1000: 2,
   //   ....
   //   50: 5
   // }
   // throw exception if withdrawal is impossible
}
```

## Iteration 2

Same, but ATM has limits

```
var limits = {
  5000: 4,
  1000: 5,
  500: 2,
  100: 5,
  50: 100
};

function getMoney(amount, limits) {
   // new format to return:
   // {
   //   res: {
   //     5000: 1,
   //     1000: 2,
   //     ....
   //     50: 5
   //   } || "warn" (if withdrawal is impossible)
   //  limits: // new ATM limits after withdrawal
   // }
}
```

## Iteration 3

Same, but limits are different:

```
var limits = {
  5000: 4,
  1000: 5,
  500: 2,
  100: 5,
  50: 100,
  30: 23
};
```
