class Carro{
  private int ano;
  private String marca;
  private String modelo;
  private String categoria;
    
  public Carro(int ano, String marca, String modelo, String categoria){
      this.ano = ano;
      this.marca = marca;
      this.modelo = modelo;
      this.categoria = categoria;
  }
  public int getAno(){
      return ano;
  }
  public String getMarca(){
      return marca;
  }
  public String getModelo(){
      return modelo;
  }
  public String getCategoria(){
      return categoria;
  }
  public void setAno(int ano){
      this.ano = ano;
  }
  public void setMarca(String marca){
      this.marca = marca;
  }
  public void setModelo(String modelo){
      this.modelo = modelo;
  }
  public void setCategoria(String categoria){
      this.categoria = categoria;
  }
  public void mostra(){
      System.out.print(ano+", ");
      System.out.print(marca+", "); 
      System.out.print(modelo+", "); 
      System.out.println(categoria);
  }
}

public class Main
{
	public static void main(String[] args) {
		Carro car1 = new Carro(2022, "Fiat", "Strada", "Picape");
		Carro car2 = new Carro(2022, "Hyundai", "Creta", "Sedan");
		car1.mostra();
		car2.mostra();
	}
}
