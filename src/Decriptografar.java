import java.util.Scanner;
public class Decriptografar {
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual método deseja utilizar?"+
                "---------\n"+
                "1-Cifra de César\n"+
                "2-Código Morse\n"+
                "---------");
        int escolha = sc.nextInt();
        switch (escolha){
            case 1:
                cesar();
                break;
            case 2:
                morse();
                break;
            default:
                System.out.println("blz");
                break;
        }
    }

    public String cesar(){
        System.out.println("aushusf");
        return "andsj";
    }
    public String morse(){
        System.out.println("ausd");
        return "asudsa";
    }
}

