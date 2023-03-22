/**
 * Cálculo da média de 2 notas
 */

//importar os pacotes
const read = require('readline-sync')
const colors = require('colors')

//variáveis
console.log("===== Cálculo da média =====")
let nome = read.question("Digite o seu nome: ")
console.log(`Aluno: ${nome}`)
let nota1 = Number(read.question("Digite a nota1: ").replace(",","."))
let nota2 = Number(read.question("Digite a nota2: ").replace(",","."))
//processamento
let media = (nota1 + nota2) / 2
//saída
console.log(`Média: ${media.toFixed(1)}`)
//status
if(media < 5) {
    console.log("REPROVADO".red)
} else {
    console.log("APROVADO".blue)
}

