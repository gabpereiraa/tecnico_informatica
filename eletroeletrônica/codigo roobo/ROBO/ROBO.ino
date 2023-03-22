
/**
   Robô seguidor de linha
   @author Eric Silva Rodrigues , Isaac Cauã Mourão da Silva, Vinicios Barbosa , Kauan Oliveira Cardozo
*/
void setup()
{
  pinMode(13, OUTPUT);  // led
  digitalWrite(13, HIGH);
  pinMode(5, OUTPUT);// motor 1
  pinMode(6, OUTPUT);// motor 1
  pinMode(10, OUTPUT);// motor 2
  pinMode(11, OUTPUT); //motor 2
  Serial.begin(9600);
}

void loop()
{
  int ldr1 = analogRead(A0);
  int ldr2 = analogRead(A1);
  Serial.println(ldr1);

  if (ldr1 < 800 && ldr2 >= 800 ) {
    dir();
  } else if (ldr1 >= 800 && ldr2 < 800) {
    esq();
  } else {
    frente();
  }

}
void frente()
{
  //liga os motores
  analogWrite(5, 90);//roda direita
  digitalWrite(6, LOW);
  analogWrite(10, 130);// roda esquerda
  digitalWrite(11, LOW);
}

void tras()
{
  //liga os motores
  analogWrite(5, LOW);//roda direita
  digitalWrite(6, 170);
  analogWrite(10, LOW);// roda esquerda
  digitalWrite(11, 170);
}

void parar()
{
  //liga os motores
  analogWrite(5, LOW);//roda direita
  digitalWrite(6, LOW);
  analogWrite(10, LOW);// roda esquerda
  digitalWrite(11, LOW);
}

void dir()
{
  //liga os motores
  analogWrite(5, LOW);//roda direita
  digitalWrite(6, 215);
  analogWrite(10, 255);// roda esquerda
  digitalWrite(11, LOW);
}

void esq()
{
  //liga os motores
  analogWrite(5, 215);//roda direita
  digitalWrite(6, LOW);
  analogWrite(10, LOW);// roda esquerda
  digitalWrite(11, 255);
}
