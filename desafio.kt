// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}
enum class Tipo {ESTUDANTE, PROFESSOR}

data class Usuarios(val Nome: String, val tipo: Tipo, val email: String)
data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val name: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuarios>()
    
    // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    fun matricular(usuario: Usuarios) {
        inscritos.add(usuario)
    }

    fun matriculados(){
        for(usuario in inscritos){
            println("Nome: ${usuario.Nome} - ${usuario.tipo} - email: ${usuario.email}")
        }
    }   

    fun printConteudoEducacional(){
        for (cont in conteudos){
            println("${cont.nome} - ${cont.duracao} horas - (${cont.nivel})")
        }
    }
}

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
   
    val Kotlin = ConteudoEducacional("Linguagem Kotlin", 40, Nivel.BASICO)
    val Python = ConteudoEducacional("Linguagem Python", 60, Nivel.INTERMEDIARIO)
    val JavaScript = ConteudoEducacional("Linguagem JavaScript", 80, Nivel.AVANCADO)
    val HTML = ConteudoEducacional("HTML & CSS", 30, Nivel.BASICO)
    val SQL = ConteudoEducacional("SQL/NoSQL", 20, Nivel.BASICO)

    val listaConteudos = mutableListOf<ConteudoEducacional>()
        listaConteudos.add(Kotlin)
        listaConteudos.add(Python)
        listaConteudos.add(JavaScript)
        listaConteudos.add(HTML)
        listaConteudos.add(SQL)
    
    val carlos = Usuarios("Carlos Henrique", Tipo.ESTUDANTE, "carlos@illab.com.br")
    val salles = Usuarios("Abimael Sales", Tipo.ESTUDANTE, "sales@illab.com.br")
    val cesar = Usuarios("Cesar Roberto", Tipo.ESTUDANTE, "cesar@4upkeep.com.br")
    val venilton = Usuarios("Venilton Falvo", Tipo.PROFESSOR, "veniltonfalvo@gmail.com")

    val programador = Formacao("Especialista em Programação", listaConteudos)

    programador.matricular(carlos)
    programador.matricular(salles)
    programador.matricular(cesar)
    programador.matricular(venilton)

    println("*****************************")
    println("<${programador.name}>")
    println("*****************************")

    println("Grade do Curso:")
    println(programador.printConteudoEducacional())
    println("---------------------------------------------")

    println("Usuários Cadastrados no Curso")
    println(programador.matriculados())
}