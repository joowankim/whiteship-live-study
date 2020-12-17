# 과제 (Optional)

테스트를 위해 이진 트리에 노드 추가시에는 value의 오름차순으로 정렬하며 같은 값은 허용하지 않는다.

## int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요

1. `int value`, `Node left`, `Node right`를 가진다.
   - `value`: 노드가 가지고 있는 값을 나타낸다.
   - `left`: 노드의 왼쪽 자식 노드를 나타낸다.
     - 본 과제에서는 부모 노드의 `value` 값보다 작은 `value` 값을 가지는 노드이다.
   - `right`: 노드의 오른쪽 자식 노드를 나타낸다.
     - 본 과제에서는 부모 노드 `value` 값보다 큰 `value` 값을 가지는 노드이다.

2. 각 노드에 접근할 수 있는 `getter`와 `setter`를 정의한다.

## BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요

BinaryTree

1. 트리의 시작점인 `Node root`를 변수로 가진다.
2. 노드의 `value` 값을 기준으로 오름차순으로 정렬되어 노드가 추가된다.
3. 노드의 `value` 값의 중복을 허용하지 않는다.

DFS와 BFS 메소드는 값을 출력하는 대신 배열을 반환하도록 하여 테스트에 용이하게 하였다.

### DFS

DFS는 왼쪽, 루트, 오른쪽 순으로 순회한다. 본 과제에서는 노드의 `value` 값을 기준으로 오름차순으로 정렬된 `int` 배열을 반환한다.

DFS는 `iterable`과 `recursive` 방식, 두 가지로 구현해보았다.

#### iterable DFS

1. 결과를 담을 `List<Intger> result`를 초기화 한다.
2. 방문하는 다음 노드를 얻기 위해 `Stack<Node> stack`을 초기화 한다.
3. 각 노드에 방문했는 지를 판단하기 위한 `Map<Integer, boolean> visited` 맵을 선언한다.
4. `stack`이 empty 상태가 될 때까지 아래 4 ~ 5 단계들을 반복한다.
5. `Node current`에 `stack.pop()` 된 노드를 저장한다.
6. `current`가 이전에 방문했던 부모 노드인지를 판단한다.
   - 방문했던 노드라면 `value`를 `result` 배열에 저장하고 `continue`를 통해 다음 노드로 진행한다.
   - 방문했던 노드가 아니라면 해당 노드에 방문하여 그 자식 노드들을 right, current, left 순으로 `stack`에 `push()`한다. 그리고 방문한 노드를 `visited`에 표시한다.
7. `stack`의 상태가 empty가 되면 `result`를 반환한다.

#### recursive DFS

1. 메소드의 파라미터로 탐색을 시작할 노드(`Node node`)와 결과를 담을 리스트(`List<Integer> result`)를 파라미터로 받는다.
2. inorder traversal을 구현한다.
3. traversal이 끝나면 `result`를 반환한다.

### BFS

일반적인 그래프에 대해 BFS 알고리즘을 적용할 때는 각 노드에 방문을 했는지에 대해 `visited` 배열이나 맵을 사용하여 체크하지만 순환하지 않는 이진 트리이기에 체크할 필요가 없었다.

1. 결과를 담을 `List<Intger> result`를 초기화 한다.
2. 방문하는 다음 노드를 얻기 위해 `Queue<Node> queue`를 초기화 한다.
3. `queue`의 상태가 empty가 될 때까지 4 ~ 5단계를 반복한다.
4. `queue`의 `remove()` 메소드를 이용해 `current`의 `value`를 `result`에 저장한다.
5. `current`에 방문하여 그 자식 노드들을 `queue`에 담는다.
6. `queue` 상태가 emtpy가 되면 `result`를 반환한다.
