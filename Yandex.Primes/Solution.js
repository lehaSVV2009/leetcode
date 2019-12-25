const getPrimes = n => {
  if (!n || n < 0) return [];
  if (n === 1) return [1];
  if (n === 2) return [1, 2];

  let primes = [2];

  for (let num = 3; num <= n; ++num) {
    if (num > 10 && (num % 2 === 0 || num % 5 === 0)) {
      continue;
    }

    let isPrime = true;

    for (let j = 0; j < primes.length; j++) {
      const prime = primes[j];
      if (prime > Math.sqrt(num)) {
        break;
      }
      if (num % prime === 0) {
        isPrime = false;
        break;
      }
    }

    if (isPrime) {
      primes.push(num);
    }
  }

  return [1, ...primes];
};
