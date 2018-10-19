package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/19
 * description：
 * ****************************************
 */
fun main(args: Array<String>) {
    uniqueMorseRepresentations(arrayOf("words"))
}
fun uniqueMorseRepresentations(words: Array<String>): Int {
    val arrayOfString: Array<String> = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
    val results = ArrayList<String>(words.size)
    for (word in words) {
        var temp=""
        for (c in word) {
            temp+=arrayOfString[c-'a']
        }
        if(!results.contains(temp)){
            results.add(temp)
        }

    }
    return results.size
}