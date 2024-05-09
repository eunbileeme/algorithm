# 📝 오답 노트

1. head는 input에 나타난 것처럼 list가 아닌 head 노드를 나타내는 것이었다. OMG
2. next 노드의 값을 찍을려면 sout(head.next.val);을 하면 된다.
3. while문의 조건 중, fast.next != null을 먼저 비교하게 되면 null의 다음 값은 없으므로 false가 아닌 NullPointException이 발생한다.
4. HastSet으로 풀 경우, set.add() 시도 시 이미 있는 값을 넣는다면 false를 반환하므로 그 자체로 반환이 가능하다.​
