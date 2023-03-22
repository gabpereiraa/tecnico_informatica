/**
 * Strings
 */

const professor = "José de Assis"
//índice           0123456789...
console.log(typeof(professor))
console.log(professor)
//Obtendo o valor de um caractere da string
console.log(professor.charAt(8))
//Para obter o valor do índice de uma string
console.log(professor.indexOf("é"))
//Obter uma sequência à partir do índice
console.log(professor.substring(8))
//É possível alterar o conteúdo da string
console.log(professor.replace("José","Zé"))//(original,novo)
//Dica: replace(",",".")

/**** Concatenação ****/
const x = 2
const y = Number("3") //converter uma string em um número
console.log(typeof(x))
console.log(typeof(y))
console.log("Valor de x: " + x) 
console.log("2" + x) //concatena
console.log("3" - x) //subtrai (o mesmo para * /)
console.log("Professor: " + professor)
//evitar o uso do + na concatenação
//Para concatenar usar crases ``
console.log(`Professor: ${professor}`)
