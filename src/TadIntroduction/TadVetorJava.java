package TadIntroduction;

import java.util.Scanner;
import java.util.Random;

public class TadVetorJava {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int tamanho, minimo, maximo, vaga, repete;
		
		while(true) {
		
		System.out.println("------------------------------------------------");
		System.out.println("       Configuracoes iniciais do vetor");
		System.out.println("------------------------------------------------");
		
		System.out.println("Tamanho do vetor: ");
		tamanho = sc.nextInt();
		
		if(tamanho <= 0) {
			System.out.println("O tamanho do vetor tem que ser maior que 0!");
			continue;
		}
		
		System.out.println("Valor minimo do vetor: ");
		minimo = sc.nextInt();
		System.out.println("Valor maximo do vetor: ");
		maximo = sc.nextInt();
		
		if (minimo > maximo) {
			System.out.println("O minimo tem que ser menor que o maximo!");
			continue;
		}
		
		System.out.println("Valor indicativo de posicao vaga: ");
		vaga = sc.nextInt();
		
		if(vaga >= minimo && vaga <= maximo) {
			System.out.println("ERROR: Valor indicativo de posicao vaga nao pode estar no indice");
			continue;
		}
		
		System.out.println("Pode haver repeticao de valores (1) ou nao (2)");
		repete =sc.nextInt();
		
		if(repete < 1 || repete > 2) {
			System.out.println("Valor invalido informe 1 ou 2.");
			continue;
		}
		
		break;
	}
		
		TadVetor vetor = new TadVetor(tamanho, minimo, maximo, vaga, repete);
		
		while(true) {
			
			System.out.println("===================================================");
            System.out.println("            Estudo do TAD Vetor");
            System.out.println("===================================================");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Atribuir um valor a determinada posição.");
            System.out.println("2 - Alterar o valor de determinada posição.");
            System.out.println("3 - Remover o valor de determinada posição (atribui o valor indicativo de posição vaga).");
            System.out.println("4 - Ler o conteúdo de uma posicao.");
            System.out.println("5 - Localizar um valor e retornar sua posição (se permitir repetição tem que retornar todos).");
            System.out.println("6 - Inserir na primeira posição vaga (busca no sentido 0 → N).");
            System.out.println("7 - Remover da última posição ocupada (busca no sentido 0 → N).");
            System.out.println("8 - Imprimir o conteúdo do vetor.");
			
			
            System.out.println("Escolha um opcao: ");
            int opc =sc.nextInt();
            
            if(opc == 0) {
            	break;            	
            }else if(opc == 1) {
            	
            	System.out.println("======ATRIBUICAO======");
            	System.out.println("Valor: ");
            	int valor = sc.nextInt();
            	System.out.println("Posicao: ");
            	int posicao = sc.nextInt();
            	Utils.printRet(vetor.armazenar(valor, posicao));
            	
            }else if (opc == 2) {
            	
            	System.out.println("======ALTERACAO======");
            	System.out.println("Valor: ");
            	int valor = sc.nextInt();
            	System.out.println("Posicao: ");
            	int posicao = sc.nextInt();
            	Utils.printRet(vetor.alterar(valor, posicao));
            	
            }else if (opc == 3) {
            	
            	System.out.println("======EXCLUSAO======");
            	System.out.println("Posicao: ");
            	int posicao = sc.nextInt();
            	Utils.printRet(vetor.excluir(posicao));
            	
            }else if(opc == 4) {
            	System.out.println("======LEITURA======");
            	System.out.println("Posicao a ler: ");
            	int posicao = sc.nextInt();
            	System.out.println("Posicao " + posicao + "contem " + vetor.ler(posicao));
            }else if(opc == 5) {
            	
            	System.out.println("======LOCALIZAR======");
            	System.out.println("Valor a localizar: ");
            	int valor = sc.nextInt();
            	int[] valores = vetor.localizar(valor, 0);
            	
            	if(valores [0] == 0) {
            		System.out.println("\nValor nao localizado. \n\n");
            	}else {
            		System.out.println("\n\n==VALORES ENCONTRADOS NOS INDICES ABAIXO==");
            		for(int i = 1; i < valores.length; i++) {
            			if(valores[i] == 0) {
            				break;
            			}
            			System.out.println(valores[i] + " ");
            		}
            		System.out.println("\n" + valores[0] + " ");
            	}
            	
            	
            }else if(opc == 6) {
            	
            	System.out.println("===INSERINDO NA PRIMEIRA POSICAO VAGA===");
            	System.out.println("Valor a inserir: ");
            	int valor = sc.nextInt();
            	Utils.printRet(vetor.armazenar1Vaga(valor));
            	
            }else if(opc == 7) {
            	
            	System.out.println("===REMOVENDO DA ULTIMA POSICAO OCUPADA===");
            	Utils.printRet(vetor.removerUltima());
            	
            }else if (opc == 8){
            	
            	for(int i = 0; i < tamanho; i++) {
            		System.out.println(i + "= " + vetor.ler(i));
            	}
            }else if(opc == 99) {
            	
            	vetor.limparVetor();
            	Random seed = new Random();
            	for(int i = 0; i < tamanho; i++) {
            		vetor.armazenar(minimo + seed.nextInt(maximo + 1 - minimo), i);
            	}
            	
            }
		
		}
		sc.close();
	}
}
