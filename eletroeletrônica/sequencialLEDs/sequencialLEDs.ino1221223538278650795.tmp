/**
   Sequencial da LEDs
   @author Professor José de Assis
*/

// A linha abaixo cria uma variável global do tipo numérico inteiro
int efeito = 100;

void setup() {
  pinMode (2, OUTPUT);
  pinMode (3, OUTPUT);
  pinMode (4, OUTPUT);
  pinMode (5, OUTPUT);
  pinMode (6, OUTPUT);
  pinMode (7, OUTPUT);

  // estudo do laço for
  Serial.begin(9600);
  for (int i = 1; i < 10; i++) {
    Serial.println(i);
  }
}

void loop() {
  for (int i = 2; i <= 7; i++){
    digitalWrite(i, HIGH);
    delay(efeito);
    digitalWrite(i, LOW);
  }
  for (int j = 6; j > 2; j--) {
    digitalWrite(j, HIGH);
    delay(efeito);
    digitalWrite(j, LOW);
  }
}
