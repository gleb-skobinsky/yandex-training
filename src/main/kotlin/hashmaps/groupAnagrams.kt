package hashmaps

import java.util.*


fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    for (word in strs) {
        val chars = word.toCharArray()
        Arrays.sort(chars)
        val sortedWord = String(chars)
        if (!map.containsKey(sortedWord)) {
            map[sortedWord] = ArrayList()
        }
        map[sortedWord]!!.add(word)
    }
    return map.values.toList()
}