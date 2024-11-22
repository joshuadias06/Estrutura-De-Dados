package TorreHanoi;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		static TadPilha pilha1, pilha2, pilha3;
		int tam, qtd;
		
		System.out.println("==========================================");
		System.out.println("==============TORRE DE HANOI==============");
		System.out.println("==========================================");
		System.out.println("Qual será o tamanho das pilhas?");
		
		while(true){
			System.out.println("Qual será o tamanho das pilhas?");
			tam = sc.nextInt();
				if(tam < 5 || tam > 100) {
					System.out.println("Tamanho da pilha inválido! O tamanho tem que ser entre 5 e 100");
					continue;
					}
				System.out.println("Informe a quantidade inicial de numeros nas pilhas 1 e 2 (min 3. e max. " + tam + "): ");
				qtd = sc.nextInt();
				if(qtd < 3 || qtd > tam) {
					System.out.println("Insira uma quantidade valida.");
					continue;
				}
				break;
			}
		
		pilha1 = new TadPilha(tam);
		pilha2 = new TadPilha(tam);
		pilha3 = new TadPilha(tam);
		
		Random seed = new Random();
		for(int i = 0; i < qtd; i++) {
			pilha1.push(seed.nextInt(5 * qtd));
			pilha2.push(seed.nextInt(5 * qtd));
		}
		
		while(true) {
			System.out.println("\n\n===================================");
			
			imprirPilha();
			
			System.out.println("\n\n===================================");
			System.out.println("");
			System.out.println("0 - encerrar");
			System.out.println("1 - mover");
			System.out.println("");
			System.out.println("Opção: ");
			int opc = sc.nextByte();
			
			if(opc == 0) {
				
				
			}else if(opc == 1) {
				
			}
			
		}
		
	}

}
