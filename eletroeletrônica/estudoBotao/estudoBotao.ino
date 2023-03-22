/**
   Estudo do botão (interruptor de pressão)
   @author Professor José de Assis
*/

void setup() {
  pinMode(13, OUTPUT);
  // a linha abaixo habilita a comunicação serial em 9600bps
  Serial.begin(9600);
  // a linha abaixo configura a chave como entrada
  pinMode(2, INPUT_PULLUP);
  // a linha abaixo escreve um texto no terminal do computador
  Serial.println("Estudo do botão");
}

void loop() {
  // a linha abaixo cria uma variável que irá armazenar o valor do botão
  // digitalRead(2) Lê o valor do pino 2
  int botao = digitalRead(2);
  // a linha abaixo escreve no terminal o valor do botão
  Serial.println(botao);
  if (botao == 0) {
    digitalWrite(13, HIGH);
  } else {
    digitalWrite(13, LOW);
  }
}
