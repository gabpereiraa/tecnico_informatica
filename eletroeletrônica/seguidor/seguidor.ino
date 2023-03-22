/**
   Robô seguidor de linha
   @author Professor José de Assis
*/

void setup() {
  pinMode(5, OUTPUT); //motor 1
  pinMode(6, OUTPUT); //motor 1
  pinMode(10, OUTPUT); //motor 2
  pinMode(11, OUTPUT); //motor 2
}

void loop() {
  frente();
}

void frente() {
  digitalWrite(5, HIGH); //motor 1
  digitalWrite(6, LOW); //motor 1
  digitalWrite(10, HIGH); //motor 2
  digitalWrite(11, LOW); //motor 2
}
