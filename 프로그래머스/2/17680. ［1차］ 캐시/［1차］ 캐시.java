import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LRUCache cache = new LRUCache(cacheSize);
        int answer = 0;

        for (String c : cities) {
            answer += cache.getOrSet(c);
        }

        return answer;
    }

    class LRUCache {
        private static final int CACHE_MISS = 5;
        private static final int CACHE_HIT = 1;

        class Node {
            Node next;
            Node prev;
            String key;
        }

        int cacheSize = 0;
        Map<String, Node> map = new HashMap<>();
        Node head = new Node();
        Node tail = new Node();

        LRUCache(int cacheSize) {
            this.cacheSize = cacheSize;
            head.next = tail;
            tail.prev = head;
        }

        public int getOrSet(String key) {
            if (cacheSize == 0) {
                return CACHE_MISS;
            }
            key = key.toLowerCase();

            // TODO 캐시 미스일 경우,
            if (!map.containsKey(key)) {
                if (map.size() == cacheSize) {
                    Node node = tail.prev;
                    map.remove(node.key);
                    removeNode(node);
                }

                Node node = new Node();
                node.key = key;
                map.put(key, node);
                addHead(node);

                return CACHE_MISS;
            } // TODO 캐시 히트일 경우,
            else {
                Node node = map.get(key);
                removeNode(node);
                addHead(node);

                return CACHE_HIT;
            }
        }

        private void addHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
