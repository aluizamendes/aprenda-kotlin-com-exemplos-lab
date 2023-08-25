// [Template no Kotlin Playground](https://pl.kotl.in/BSeBCPGgk)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)


data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    
    // lista de inscritos    
    private val inscritos: MutableList<Usuario> = mutableListOf()
    
    // matricula usuarios, add na lista de inscritos
    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach { usuario ->
            inscritos.add(usuario)
        }
    }
    
    // retorna lista de inscritos
    fun getInscritos(): List<Usuario> {
        return inscritos
    }
}

fun main() {
    // TO-DO: Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.
    // TO-DO: Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.
    
    
    // criando listas de conteudos
    val conteudosUX = listOf<ConteudoEducacional>(
        ConteudoEducacional("Fundamentos de UX/UI", 8),
        ConteudoEducacional("Design Mobile e Prototipagem", 10),
        ConteudoEducacional("Documentação de Design Systems", 6)
    )
    
    val conteudosAndroid = listOf<ConteudoEducacional>(
    	ConteudoEducacional("Introdução ao Kotlin", 8),
        ConteudoEducacional("Fundamentos de desenvolvimento Mobile", 10),
        ConteudoEducacional("Noções básicas do Android com Kotlin", 16),
        ConteudoEducacional("Android Jetpack", 20),
    )
    
    val conteudosJava = listOf<ConteudoEducacional>(
    	ConteudoEducacional("Introdução ao Java", 8),
        ConteudoEducacional("Programação Orientada a Objetos em Java", 24),
        ConteudoEducacional("Estruturas de Dados e API", 16),
        ConteudoEducacional("Qualidade de Código e Boas Práticas", 16),
    )
    
    val conteudosNet = listOf<ConteudoEducacional>(
    	ConteudoEducacional("Fundamentos .NET", 8),
        ConteudoEducacional("Programação Orientada a Objetos em C#", 16),
        ConteudoEducacional("Bancos de Dados não Relacionais", 10),
        ConteudoEducacional("Testes Unitários com C#", 16),
    )
    
    
    // lista de formações
    val formacoes: List<Formacao> = listOf(
    	Formacao("Formação UX", Nivel.INTERMEDIARIO, conteudosUX),
        Formacao("Formação Android Developer", Nivel.INTERMEDIARIO, conteudosAndroid),
        Formacao("Formação Java Developer", Nivel.DIFICIL, conteudosJava),
        Formacao("Formação .NET Developer", Nivel.INTERMEDIARIO, conteudosNet)
    )
    
    formacoes[0].matricular(
        Usuario("Roberta"), 
        Usuario("Felipe"), 
        Usuario("Amanda"), 
        Usuario("Roberta"), 
        Usuario("Luiza")
    )
    
    formacoes[1].matricular(
        Usuario("Julia"), 
        Usuario("Henrique"), 
        Usuario("Sabrina")
    )
    
    formacoes[3].matricular(
        Usuario("Julia"), 
        Usuario("Henrique"), 
        Usuario("Sabrina"), 
        Usuario("Roberta"),
        Usuario("Felipe"), 
        Usuario("Amanda"), 
        Usuario("Roberta"), 
        Usuario("Luiza")
    )
    
    formacoes.forEach {
        val nomeConteudos = it.conteudos.map { conteudo -> conteudo.nome }.joinToString()
        val inscritosFormacao = if (it.getInscritos().isEmpty()) {
            "Não há alunos matriculados."
        } else { 
            it.getInscritos().map { aluno -> aluno.nome }.joinToString() 
        }
        
        println("A ${it.nome} de nível ${it.nivel} possui os conteúdos: ${nomeConteudos}")
        println("Inscritos na formação: ${inscritosFormacao}")
        println("")
    }
}
