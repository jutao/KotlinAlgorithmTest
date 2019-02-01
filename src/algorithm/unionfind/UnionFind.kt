package sort.algorithm.unionfind

/**
 * 并查集
 */
class UnionFind(n: Int) {
    private val id: IntArray = IntArray(n)
    private var count: Int = n

    init {
        for (i in 0 until n) {
            id[i] = i
        }
    }

    fun find(p: Int): Int {
        assert(p in 0..(count - 1))
        return id[p]
    }

    fun isConnected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun unionElements(p: Int, q: Int) {
        var pId = find(p)
        var qId = find(q)
        if (pId == qId) {
            return
        }
        for (i in 0 until count) {
            if (pId == id[i]) {
                id[i] = qId
            }
        }
    }
}