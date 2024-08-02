fun main() {
    val program = """
        SET x 10
        ADD x 5
        SUB x 3
        PRINT x
        ABOUT
    """.trimIndent()

    val interpreter = PlazmaInterpreter()
    interpreter.run(program)
}

class PlazmaInterpreter {
    private val variables = mutableMapOf<String, Int>()

    fun run(program: String) {
        val lines = program.lines()
        for (line in lines) {
            execute(line)
        }
    }

    private fun execute(line: String) {
        val parts = line.split(" ")
        val command = parts[0]
        when (command) {
            "SET" -> {
                val variable = parts[1]
                val value = parts[2].toInt()
                variables[variable] = value
            }
            "ADD" -> {
                val variable = parts[1]
                val value = parts[2].toInt()
                variables[variable] = (variables[variable] ?: 0) + value
            }
            "SUB" -> {
                val variable = parts[1]
                val value = parts[2].toInt()
                variables[variable] = (variables[variable] ?: 0) - value
            }
            "PRINT" -> {
                val variable = parts[1]
                println(variables[variable] ?: 0)
            }
            "ABOUT" -> {
                println("Plazma is a revolutionary language written in Kotlin :-)")
            }
            else -> {
                println("Unknown command: $command")
            }
        }
    }
}
