//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// TODO: Colocar a identificação dos(as) integrantes aqui.
//Nome: Luiz Henrique Bonilha Pasquinelli 
//Matricula: 32224419
//Nome: Cesar Hideki Imai
//Matricula: 32255659
//Nome: Arthur de Pina Balduino
//Matricula: 32207840
//Nome: João Victor Dallapé Madeira
//Matricula: 32209592
// TODO: Listar todas as referências consultadas para solucionar a atividade.

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;
import apl2.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainApl2 {
	
	public static void main(String[] args) {
    int program = 0;
    Scanner s = new Scanner(System.in);
    Data archive = new Data();
    String reader = null;
    LinkedListOriginal listantiga = new LinkedListOriginal();
    String[] listaleitora;
    DLinkedList listacerta = new DLinkedList();
    DLinkedList filtrada = new DLinkedList();
    float media = 0;
    System.out.println("Menu:\n1) Dados originais: lê arquivo dados.txt e apresenta todos os dados do Sistema de Notas Legado;\n2) Dados convertidos: gera arquivo dados.csv e apresenta todos os dados do Sistema de Notas Atualizado;\n3) Lista notas filtradas válidas: apresenta os dados somente das notas válidas filtradas;\n4) Lista notas filtradas inválidas: apresenta os dados somente das notas filtradas pela 'ausência de notas';\n5) Média de notas válidas: apresenta a média das notas válidas filtradas;\n6) Notas acima da média: apresenta os dados para as notas acima da média;\n7) Lista mapeada para uma única string: apresenta a String contendo os dados mapeados;\n8) Finalizar Sistema");
  while (program != 8){
      s = new Scanner(System.in);
      switch(program){
        case 0:
          System.out.println("Insira o próximo passo desejado");
          program = s.nextInt();
          break;
        case 1: 
          try {
       reader = archive.loadTextFileToString("dados.txt");
    } catch (FileNotFoundException ef) {
      System.out.println("Arquivo não encontrado");
    } catch (IOException ion){
      System.out.println("Erro no acesso ao arquivo");
    }
    listaleitora = reader.split("\n");
    for (int i = 0; i < listaleitora.length; i ++){
      String[] temp = listaleitora[i].split("#");
      listantiga.append(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
    }
          System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		System.out.println(listantiga);
		System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
          listacerta = Operation.map(listantiga);
          reader = Operation.mapToString(listacerta);
          filtrada = Operation.filterRemoveNonGraded(listacerta);
          media = Operation.reduce(filtrada);
          program = 0;
          break;
        case 2:
          try {
       archive.saveStringToTextFile("dados.csv", reader);
    } catch (FileNotFoundException ef) {
      System.out.println("Arquivo não encontrado");
    } catch (IOException ion){
      System.out.println("Erro no acesso ao arquivo");
    }
          System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(listacerta);
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
          program = 0;
          break;
        case 3:
		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		System.out.println(filtrada);
		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
          program = 0;
          break;
        case 4:
          DLinkedList semnota = Operation.filterRemoveGraded(listacerta);
		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		System.out.println(semnota);
		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");
          program = 0;
          break;
        case 5:
		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		System.out.println(media);
		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
          program = 0;
          break;
        case 6:
          DLinkedList acimamedia = Operation.filterRemoveBelowAverage(filtrada, media);
		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		System.out.println(acimamedia);
		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
          program = 0;
          break;
        case 7:
          System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		System.out.println(reader);
		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
          program = 0;
          break;
      }
    }
    s.close();
  }  
}
