import java.util.Scanner;
import java.lang.Math;
class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    double pi = Math.PI; //Variável com o valor do pi
    float h; //Variável com o valor da altura
    float r; //Variável com o valor do raio
    double v; //Variável com o valor do volume
    byte n; //Variável com o valor da quantia de tanques
    byte barril = 100;
    byte resp; //Variável com o valor da resposta
    System.out.print("Altura do tanque (em metros): ");
    h = s.nextFloat();
    System.out.print("Raio do tanque (em metros): ");
    r = s.nextFloat();
    System.out.print("Quantia de tanques: ");
    n = s.nextByte();
    v = pi * r * r * h * n;
    System.out.println("Volume (em litros): "+v);
    resp = (byte) Math.round(v/barril); //Arredondar o número de barris
    System.out.print("Número de barris necessários: "+resp);
  }
}