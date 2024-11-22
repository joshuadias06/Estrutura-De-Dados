package ArrayTarget;

import java.util.*;

class Program {
    public static int[] Solution(int[] array, int targetSum) {
        for(int i = 0; i < array.length; i++){
          for(int j = i + 1; j < array.length; j++){

            if(array[i] + array[j] == targetSum){
              return new int[] { array[i], array[j]};
            }
          }
        }
        return new int[] {};
    }

  public static void main(String[] args){
    System.out.println("Hello World");

    int[] array = {4, 1, 2, -2, 11, 15, 1, -1, -6, -4};
    int targetSum = 9;

    int[] resultado = Solution(array, targetSum);

    //Se o tamanho do array for maior que zero significa que a funcao encontrou o par.
    if(resultado.length > 0){
      System.out.println("Par encontrado: [" + resultado[0] + "," + resultado[1] + "]");
    }else{
      System.out.println("Nenhum par encontrado que some ao target");
    }
  }
}
