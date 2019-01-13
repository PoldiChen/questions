
function ispp(str) {
    return str === str.split('').reverse().join('');
}

console.log(ispp('level'));
console.log(ispp('abc'));