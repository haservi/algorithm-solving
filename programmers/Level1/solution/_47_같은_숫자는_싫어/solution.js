/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
function solution(arr) {
  var answer = [];
  var temp = -1;
  for (var i = 0; i < arr.length; i++) {
    if (temp != arr[i]) {
        answer.push(arr[i]);
    }
    temp = arr[i];
  }
  return answer;
}

var arr = [1, 1, 3, 3, 0, 1, 1];
let result = solution(arr);
console.log('result: ' + result);
