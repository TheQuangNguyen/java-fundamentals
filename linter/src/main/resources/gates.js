function not(a) {
  if (a === "0")
    return 1
  else
    return 0
}

function nand(a,b) {
  return not(and(a, b))
}

function nor(a,b) {
  return not(or(a,b))
}

function add1(a,b) {
  overflow = and(a,b)
  sum = xor(a,b)
  return {sum, overflow}
}

function zadd1(a,b,z) {
  var ones, zf;
  zf = or(or(and(a,b), and(b,z)), and(a,z));

  j = or(a, nor(b,z));
  k = or(b, nor(a,z))
  l = or(z, nor(a,b))

  console.log("jkl", j, k, l);

  ones = xor(j, xor(k, l));
  return {ones, zf};
}

// add1(0, 1)
// add2(00, 01)
// add4(0000, 1001)
// add8(10100000, 11001001)
function add2(a,b) {
  twos = add1(a[0], b[0])
  ones = add1(a[1], b[1]);

}

console.log("add1 00", add1(0,0))
console.log("add1 01", add1(0,1))
console.log("add1 10", add1(1,0))
console.log("add1 11", add1(1,1))
console.log()

