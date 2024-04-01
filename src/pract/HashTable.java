package pract;

class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
public class HashTable {

    public final int size = 1000000;
    public final int hashNumber = 1234567;
    ListNode[] data;
    public HashTable() {
        this.data = new ListNode[size];
    }
    public int hash(int key) {//df
        return (key * hashNumber % size);
    }
    public void put(int key, int val) {
        delete(key); // удаляем если есть такой ключ что бы не было ошибок
        int hash = hash(key);
        ListNode listNode = new ListNode(key, val, data[hash]);// если кто то уже есть с колизией мы делаем на него ссылку next
        data[hash] = listNode; // назначаем ноду
    }

    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }

        return -1000000;
    }

    public void delete(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        if (node == null) {
            return;
        }

        if (node.key == key) {
            data[hash] = node.next;
        } else {
            while (node.next != null) {
                if (node.next.key == key) {
                    //просто меняем ссылку
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }
}
