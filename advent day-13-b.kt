import java.io.File

var file = arrayListOf<String>()
var IDs:ArrayList<Long> = arrayListOf()

fun readFileLineByLineUsingForEachLine(fileName: String) {
    File(fileName).forEachLine { file.add(it) }
    file.removeFirst()
    file[0] = file[0].replace(",x",",0")
    val newFile = file[0].split(",")
    newFile.forEach{IDs.add(it.toLong())}
    println(IDs)
}

fun main(args: Array<String>) {
    readFileLineByLineUsingForEachLine("src/input.txt")

    var curTime: Long = 100001054194390
    loop@ while (true) {
        curTime+=IDs[0]
        var it = 0
        for(l in 1 until IDs.size)
        {
            it++
            if(IDs[l] == 0.toLong())
            {
                continue
            }
            if(!((curTime + it) % IDs[l] == 0.toLong())) {
                continue@loop
            }
        }
        println("answer: ${(curTime)}")
        break@loop
    }
}

// 100001054194390 is too low
