package portella.douglas.quiz.model

import android.content.Context
import android.widget.Toast
import portella.douglas.quiz.R

class Quiz {
    companion object {
        var context: Context? = null
        var questionArray = ArrayList<Question>()

        init {

            genarateQuestions()
            questionsShuffle()
        }





        /*   fun genarateQuestions() {
         questionArray.add(
              Question(
                  context!!.getString(R.string.questao1),
                  context!!.getString(R.string.casteloOpcao1),
                  context!!.getString(R.string.casteloOpcao2),
                  context!!.getString(R.string.casteloOpcao3),
                  context!!.getString(R.string.casteloOpcao4),
                  context!!.getString(R.string.casteloOpcao3)




              )
          )
            questionArray.add(
                Question(
                    context!!.getString(R.string.animaisarcaQuestão),
                    context!!.getString(R.string.animaisarcaOpcao1),
                    context!!.getString(R.string.animaisarcaOpcao2),
                    context!!.getString(R.string.animaisarcaOpcao3),
                    context!!.getString(R.string.animaisarcaOpcao4),
                    context!!.getString(R.string.animaisarcaOpcao4)
                )
            )

            questionArray.add(
                Question(
                    context!!.getString(R.string.mesesQuestão),
                    context!!.getString(R.string.mesesOpcao1),
                    context!!.getString(R.string.mesesOpcao2),
                    context!!.getString(R.string.mesesOpcao3),
                    context!!.getString(R.string.mesesOpcao3),
                    context!!.getString(R.string.mesesOpcao2)
                )
            )

            questionArray.add(
                Question(
                    context!!.getString(R.string.horasQuestao),
                    context!!.getString(R.string.horasOpcao1),
                    context!!.getString(R.string.mesesOpcao2),
                    context!!.getString(R.string.horaspcao3),
                    context!!.getString(R.string.horasOpcao4),
                    context!!.getString(R.string.horasOpcao1)
                )
            )


        }*/

       fun genarateQuestions()
        {

            questionArray.add(
                Question(
                    "Você entra em um castelo escuro com uma caixa de fósforos que contém apenas um palito. Não há eletricidade, porém há uma vela, um lampião a gás e uma lamparina a querosene. O que você acende primeiro?",
                    "A) A vela",
                    "B) Um lampião",
                    "c) O fosforo",
                    "e) O seu aquecedor",
                    "c) O fosforo"
                )
            )
            questionArray.add(
                Question(
                    "Quantos animais de cada espécie, Moisés colocou em sua arca?",
                    "a) 1",
                    "b) 2",
                    "C) 0",
                    "d) 3",
                    "C) 0"
                )
            )
            questionArray.add(
                Question(
                    "Quantos meses tem 28 dias durante um período de 6 anos?",
                    "a) 1",
                    "B) 12",
                    "C) 2",
                    "D) nenhum ",
                    "c"
                )
            )
            questionArray.add(
                Question(
                    "Você levantou às 8h para ir trabalhar; foi dormir às 7h. Quantas horas você dormiu?",
                    "A) 1 Hora",
                    "12 Horas",
                    "E) 8 Horas",
                    "D) 13 Horas",
                    "A) 1 Hora"
                )
            )
            questionArray.add(
                Question(
                    "Sem calculadora, divida 60 por meio e some 20. Qual é o resultado?",
                    "A) 140",
                    "B) 20",
                    "C) 90",
                    "D) 120",
                    "C) nenhuma das opções"
                )
            )
            questionArray.add(
                Question(
                    "Havia cinco pessoas na sala, cheguei e matei quatro. Quantas pessoas ficaram na sala?",
                    "A) 6",
                    "B) 1",
                    "C) 5",
                    "D) 4",
                    "A) 6"
                )
            )
            questionArray.add(
                Question(
                    "Você mora sozinho e está dormindo em seu quarto. Seus pais tocam a campainha da casa. Eles vieram tomar café da manhã. Você tem pão, leite, mel, geleia e cereais em casa. O que você abre primeiro?",
                    "A) pão",
                    "B) leite",
                    "C) geladeira",
                    "D) nehum",
                    "D) nehum"
                )
            )
            questionArray.add(
                Question(
                    "Um pato bota um ovo na fronteira entre Brasil e Chile. A quem pertence o ovo?",
                    "A) Brasil",
                    "B) Chile",
                    "C) Minha mãe",
                    "D) nehum",
                    "D) nehum"
                )
            )

        }
        fun markAsrepeatedAnser() {
            questionArray.get(0).repeatedQuestion = true
        }

        fun questionsShuffle() {
            while (questionArray.get(0).repeatedQuestion) {
                questionArray.shuffle()
            }
            markAsrepeatedAnser()


        }

        fun score(): Int {
            var score = 0
            for (question in questionArray) {
                if (question.correctAnswer) {
                    score++
                }
            }
            return score

        }


        fun checkAverageOfCorrectAnswers(): Double {
            return (score() / 3.0) * 100
        }

        fun finalMessage(): String {
            if (checkAverageOfCorrectAnswers() > 80) {
                return "${context?.getString(R.string.great)}"
            } else if (checkAverageOfCorrectAnswers() > 50) {
                return "${context?.getString(R.string.maisoumeno)}"
            } else {
                return "${context?.getString(R.string.verygood)}"
            }
        }

        fun verifuTheCorrectanser(answer: String): Boolean {

            if (answer.equals(questionArray.get(0).correctOptionAnswer)) {
                questionArray.get(0).correctAnswer = true
                return true
            } else {
                return false
            }
        }

        fun clearALL() {
            questionArray.clear()
            genarateQuestions()
        }
        private fun requireContext(): Context{
            return requireContext()
        }

    }
}

