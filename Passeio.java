import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t1[] = {0,0,0}; //Vetor com o valor do horário de partida
    int t2[] = {0,0,0}; //Vetor com o valor do horário de chegada
    int tt[] = {0,0,0}; //Vetor com o valor do tempo de viagem
    float valor; //Variável com o valor de custo
    float hr = 15.00f; //Custo por hora
    float min = 0.50f; //Custo por minuto
    float seg = 0.05f; //Custo por segundo
    
    for(byte x = 0; x < 3; x++){
      if(x == 0){
        System.out.print("Digite a hora de partida: ");
      }
      else{
        if(x == 1){
          System.out.print("Digite o minuto de partida: ");
        }
        else{
          System.out.print("Digite o segundo de partida: ");
        }
      }
      t1[x] = s.nextInt();
      if(t1[0] > 23 || t1[1] > 59 || t1[2] > 59){ //Filtrar valores inválidos
        System.out.println("Valor inválido, digite novamente.");
        x--; //Voltar para a ação anterior
      }
    }
    for(byte x = 0; x < 3; x++){
      if(x == 0){
        System.out.print("Digite a hora de chegada: ");
      }
      else{
        if(x == 1){
          System.out.print("Digite o minuto de chegada: ");
        }
        else{
          System.out.print("Digite o segundo de chegada: ");
        }
      }
      t2[x] = s.nextInt();
      if(t2[0] > 23 || t2[1] > 59 || t2[2] > 59){
        System.out.println("Valor inválido, digite novamente.");
        x--;
      }
    }
    for(byte x = 0; x < 3; x++){
      tt[x] = t2[x] - t1[x];
      if(tt[x] < 0){ //Se a subtração gerar um número negativo, subtrair do elemento anterior
        tt[x-1] -= 1;
        tt[x] = 60 + tt[x];
      }
    }
    valor = tt[0]*hr + tt[1]*min + tt[2]*seg; //Calcular o custo
    System.out.println("Valor do passeio: R$"+valor);
  }
}