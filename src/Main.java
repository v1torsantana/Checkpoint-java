import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Criação do Scanner para leitura dos inputs
        Scanner sc = new Scanner(System.in);
        //Instanciando duas variáveis com os tipos das classes
        Encriptografar choose1 = new Encriptografar();
        Decriptografar choose2 = new Decriptografar();
        //Criação do menu principal
        System.out.println("Olá, qual opção deseja acessar?\n" +
                "----------------\n" +
                "1-Encriptografar\n" +
                "2-Decriptografar\n" +
                "3-Sair\n" +
                "----------------");
        String escolha = sc.nextLine();
        //Switch com as escolhas do menu principal
        //Aqui o try e o catch servem para capturar entradas no formato String, que não foram tratadas simplesmente com o default
        try{
            int opcao = Integer.parseInt(escolha);
            switch (opcao) {
                case 1:
                    choose1.menu();
                    break;
                case 2:
                    choose2.menu();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Por favor, insira uma entrada válida");
            }

        }
        catch(NumberFormatException e){
            System.out.println("Por favor, insira uma entrada válida");
        }
    }
}

