class MyHashSet {
    private static final int SIZE = 769; // prime number for fewer collisions
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int idx = hash(key);
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = hash(key);
        buckets[idx].remove((Integer) key); // cast to Integer, not index!
    }

    public boolean contains(int key) {
        int idx = hash(key);
        return buckets[idx].contains(key);
    }
}
