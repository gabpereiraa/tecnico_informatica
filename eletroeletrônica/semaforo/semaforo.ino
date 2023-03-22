/**
   Semáforo de pedestres
   @author Professor José de Assis
*/

void setup() {
  pinMode(2, INPUT_PULLUP);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
}

void loop() {
  int botao = digitalRead(2);
  //se o botão for pressionado
  if (botao == 0) {
    // Passo 1
    digitalWrite(6, HIGH); // acende led amarelo carros
    digitalWrite(4, HIGH); // acende led vermelho pedestre
    digitalWrite(5, LOW); // apaga led verde carros
    delay(1000);
    // Passo 2
    digitalWrite(7, HIGH); // acende led vermelho carros
    digitalWrite(3, HIGH); // acende led verde pedestre
    digitalWrite(6, LOW); // apaga led amarelo carros
    digitalWrite(4, LOW); // apaga led vermelho pedestre
    delay(5000);
    // Passo 3
    digitalWrite(7, HIGH); // acende led vermelho carros
    digitalWrite(3, LOW); // apaga led verde pedestre
    //piscar led vermelho pedestre
    digitalWrite(4, HIGH);
    delay(500);
    digitalWrite(4, LOW);
    delay(500);
    digitalWrite(4, HIGH);
    delay(500);
    digitalWrite(4, LOW);
    delay(500);
    digitalWrite(4, HIGH);
    delay(500);
    digitalWrite(4, LOW);
    delay(500);
    digitalWrite(7, LOW); // apagar led vermelho carro
  } else {
    digitalWrite(4, HIGH);
    digitalWrite(5, HIGH);
  }
}
