/**
   Desafio
   Controle remoto luminoso
   @author Professor José de Assis
*/

void setup() {
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int ldr1 = analogRead(A0);
  Serial.print("LDR 1: ");
  Serial.println(ldr1);
  Serial.println("");
  int ldr2 = analogRead(A1);
  Serial.print("LDR 2: ");
  Serial.println(ldr2);
  Serial.println("");
  if (ldr1 > 700) {
    digitalWrite(13, HIGH);
  } else {
    digitalWrite(13, LOW);
  }
  if (ldr2 > 700) {
    digitalWrite(12, HIGH);
  } else {
    digitalWrite(12, LOW);
  }
}
