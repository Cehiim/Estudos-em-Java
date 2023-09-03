import java.util.Scanner;

class Circulo{
  private float raio;

  public Circulo(float raio){
    this.raio = raio;
  }

  public float getRaio(){
    return raio;
  }
  public void setRaio(float raio){
    this.raio = raio;
  }
  public float calculaDiametro(){
    return raio*2;
  }
  public double calculaArea(){
    return raio*raio*Math.PI;
  }
  public void mostraDados(){
    System.out.print("Raio: ");
    System.out.println(raio);
    System.out.print("Diâmetro: ");
    System.out.println(calculaDiametro());
    System.out.print("Área: ");
    System.out.println(calculaArea());
  }
}

class Main {
  public static void main(String[] args) {
    float erro = 1;
    while(erro == 1){
      Scanner s = new Scanner(System.in);
      float raio;
      System.out.print("Digite o tamanho do raio do círculo: ");
      raio = s.nextFloat();
      if(raio>0){
        erro = 0;
        Circulo a = new Circulo(raio);
        a.mostraDados();
      }
      else{
        System.out.println("Valor inválido, digite novamente");
      }
    }
  }
}