// Autor: Antônio Azevedo
// Desafio de Projeto Kotlin - DIO
// 29/08/2023

enum class Nivel { Basico, Intermediario, Avancado }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(
    val nome: String,
    val descricao: String,
    val conteudos: List<ConteudoEducacional>,
    val aluno: Usuario,
    val nivel: List<Nivel>,
    val inscritos: MutableList<Usuario> = mutableListOf(),
) {
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("Maria", "maria@email.com")
    val usuario2 = Usuario("Jose", "jose@email.com.br")
    val usuario3 = Usuario("Isabel", "isabel@email.com")
    val usuario4 = Usuario("Renata", "renata@email.com.br")
    val usuario5 = Usuario("Pedro", "pedro@email.com")
    val usuario6 = Usuario("Lucas", "lucas@email.com.br")

    val conteudo1 = ConteudoEducacional("Conhecendo o Kotlin e sua documentação", 60, Nivel.Basico)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados com Kotlin", 90, Nivel.Intermediario)
    val conteudo3 = ConteudoEducacional("Desenvolvendo app Android com Kotlin", 140, Nivel.Avancado)

    val formacao1 = Formacao(
        "Formação em Desenvolvimento Mobile Android com Kotlin", " ",
        listOf(conteudo1, conteudo2, conteudo3),
        usuario1,
        listOf(Nivel.Basico,Nivel.Intermediario, Nivel.Avancado)
    )
    
    val formacao2 = Formacao(
        "Formação em Desenvolvimento Mobile Android com Kotlin", " ",
        listOf(conteudo1, conteudo2, conteudo3),
        usuario2,
        listOf(Nivel.Basico,Nivel.Intermediario, Nivel.Avancado)
    )
    
    val formacao3 = Formacao(
        "Formação em Desenvolvimento Mobile Android com Kotlin", " ",
        listOf(conteudo1, conteudo2, conteudo3),
        usuario3,
        listOf(Nivel.Basico,Nivel.Intermediario, Nivel.Avancado)
    )

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario3)
    formacao2.matricular(usuario4)
    formacao3.matricular(usuario5)
    formacao3.matricular(usuario6)
    
    println("--------------------- Desafio de Projeto Kotlin - DIO ------------------------------")
    println(" ")
           
    println("Alunos matriculados na formação: Conhecendo o Kotlin e sua documentação.")
    formacao1.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, e-mail: ${aluno.email}")
    }
    println("")

    println("Alunos matriculados na formação: Estruturas de Dados com Kotlin.")
    formacao2.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, e-mail: ${aluno.email}")
    }
    println("")
    
    println("Alunos matriculados na formação: Desenvolvendo app Android com Kotlin.")
    formacao3.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, e-mail: ${aluno.email}")
    }
    println("")
    println("Sejam todo(s) Bem Vindo(s) a nossa plataforma.")
}