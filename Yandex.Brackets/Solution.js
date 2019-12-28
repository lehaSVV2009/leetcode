function check(text) {
  const stack = [];

  for (let index in text) {
    const bracket = text.charAt(index);

    if (isStartBracket(bracket)) {
      stack.push(bracket);
      continue;
    }

    if (stack.length === 0) {
      return false;
    }

    if (stack.pop() !== reverseBracket(bracket)) {
      return false;
    }
  }

  return stack.length === 0;
}

function isStartBracket(bracket) {
  return ["{", "[", "("].includes(bracket);
}

function reverseBracket(bracket) {
  switch (bracket) {
    case "{":
      return "}";
    case "}":
      return "{";
    case "[":
      return "]";
    case "]":
      return "[";
    case "(":
      return ")";
    case ")":
      return "(";
    default:
      throw new Error("Unknown bracket character!" + bracket);
  }
}
