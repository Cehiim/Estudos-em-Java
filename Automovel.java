import java.util.Scanner;


class Automovel{
  private String placa;
  private String marca;
  private int ano;
  private float preco;
  
  public Automovel(){
    this.placa = "----";
    this.marca = "----";
    this.ano = 0;
    this.preco = 0;
  }

  public Automovel(String placa, String marca, int ano, float preco){
    this.placa = placa;
    this.marca = marca;
    this.ano = ano;
    this.preco = preco;
  }

  public String getPlaca(){
    return placa;
  }
  
  public String getMarca(){
    return marca;
  }

  public int getAno(){
    return ano;
  }

  public float getPreco(){
    return preco;
  }

  public void setPlaca(String placa){
    this.placa = placa;
  }

  public void setMarca(String marca){
    this.marca = marca;
  }

  public void setAno(int ano){
    this.ano = ano;
  }

  public void setPreco(float preco){
    this.preco = preco;
  }

  public String toString(){
    return "Placa: "+placa+
    ", Marca: "+marca+
    ", Ano: "+ano+
    ", Preço: "+preco;
  }
}


class Principal{ // Item A
  private Automovel vetor[];
  private static int MAX_CARROS = 100;
  private int num_carros;
  private int index;

  public Principal(){
    this.num_carros = MAX_CARROS;
    this.vetor = new Automovel[num_carros];
    this.index = 0;
  }
  
  public Principal(int n){
    if(n < MAX_CARROS && n > 0){
      this.num_carros = n;
    }
    else{
      System.out.println("Número inválido, tamanho padrão da lista igual a 100");
      this.num_carros = MAX_CARROS;
    }
    this.vetor = new Automovel[num_carros];
    this.index = 0;
  }

  public void inserir(Automovel c){
    if(index < num_carros){
      this.vetor[index] = c;
      index++;
    }
    else{
      System.out.println("Vetor cheio");
    }
  } // Item B

  public void mostrar(){
    for(int x = 0; x < index; x++){
      System.out.println(vetor[x].toString());
    }
    System.out.println();
  } // Item C

  public void filtrarMarca(){
    System.out.print("Forneça uma marca para listar os carros: ");
    Scanner s = new Scanner(System.in);
    String m = s.next();
    for(int x = 0; x < index; x++){
      if(m.equals(vetor[x].getMarca())){
        System.out.println(vetor[x].toString());
      }
    }
    System.out.println();
  } // Item D

  public void mediaPreco(){
    float media = 0;
    for(int x = 0; x < index; x++){
      media += vetor[x].getPreco();
    }
    media /= index;
    System.out.println("Média de preço dos carros registrados: "+media);
    System.out.println();
  } // Item E

  public void contagemAno(){
    System.out.print("Forneça um ano para contar os carros fabricados após: ");
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int count = 0;
    for(int x = 0; x < index; x++){
      if(a < vetor[x].getAno()){
        count++;
      }
    }
    System.out.println("Carros fabricados depois de "+a+": "+count);
    System.out.println();
  } // Item F

  public void mediaPeriodo(){
    System.out.print("Digite um ano inicial: ");
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    System.out.print("Digite um ano final: ");
    int b = s.nextInt();
    float media = 0;
    int count = 0;
    for(int x = 0; x < index; x++){
      if(a < vetor[x].getAno() && b > vetor[x].getAno()){
        media += vetor[x].getPreco();
        count++;
      }
    }
    media /= count;
    System.out.println("Média dos preços dos carros fabricados entre "+a+" e "+b+": "+media);
    System.out.println();
  } // Item G
}

class Main {
  public static void main(String[] args) {
    Automovel a1 = new Automovel("1111", "Honda", 2020, 140000);
    Automovel a2 = new Automovel("2222", "Mercedes", 2022, 300000);
    Automovel a3 = new Automovel("3333", "Volkswagen", 2016, 90000);
    Automovel a4 = new Automovel("4444", "Honda", 2018, 120000);
    Automovel a5 = new Automovel();
    
    Principal p = new Principal(5);
    p.inserir(a1);
    p.inserir(a2);
    p.inserir(a3);
    p.inserir(a4);
    p.inserir(a5);
    p.mostrar();
    p.filtrarMarca();
    p.mediaPreco();
    p.contagemAno();
    p.mediaPeriodo();
  }
}