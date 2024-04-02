import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Encriptografar choose1 = new Encriptografar();
        Decriptografar choose2 = new Decriptografar();
        System.out.println("Olá, qual opção deseja acessar?\n" +
                "----------------\n" +
                "1-Encriptografar\n" +
                "2-Decriptografar\n" +
                "3-Sair\n" +
                "----------------");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                choose1.menu();
                break;
            case 2:
                System.out.println("decript");
                break;
            case 3:
                System.out.println("sair");
                break;
        }
    }
}