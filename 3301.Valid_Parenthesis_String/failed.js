const stacks = [[]];

for (const letter of s) {
    if (letter === '(') {
        for (const stack of stacks) {
            if (stack === false) {
                continue;
            }
            stack.push('(');
        }
    } else if (letter === ')') {
        for (let i = 0; i < stacks.length; ++i) {
            const stack = stacks[i];
            if (stack === false) {
                continue;
            }
            if (stack.length === 0) {
                stacks[i] = false;
                continue;
            }
            stack.pop();
        }
    } else if (letter === '*') {
        const currentLength = stacks.length;
        for (let i = 0; i < currentLength; ++i) {
            const stack = stacks[i];
            if (stack === false) {
                continue;
            }
            stacks.push([...stack, '(']);

            if (stack.length !== 0) {
                const stackSlashEnd = [...stack];
                stackSlashEnd.pop();
                stacks.push(stackSlashEnd);
            }
        }
    } else if (letter === ' ') {
        continue;
    } else {
        return false;
    }
}

return stacks.some(stack => stack !== false && stack.length === 0);
