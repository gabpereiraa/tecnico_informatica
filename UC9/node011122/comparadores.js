/**
 * Comparadores
 */
//comparadores se referem as variáveis
console.log("Comparadores")
console.log(">   | maior que")
console.log(">=  | maior ou igual a")
console.log("<   | menor que")
console.log("<=  | menor ou igual a")
console.log("==  | comparador de igualdade (BUG)")
console.log("=== | comparador de igualdade")
console.log("!=  | diferente de (BUG)")
console.log("!== | diferente de")

//exemplo de uso dos comparadores == === != !==
let x = 2
let y = "2"
console.log(typeof(x))
console.log(typeof(y))

//demonstração do bug == 
if (x === y) {
    console.log("x é igual a y")
} else {
    console.log("x é diferente de y")
}

//demonstração do bug !=
if (x !== y) {
    console.log("x é diferente de y")
} else {    
    console.log("x é igual a y")
}
