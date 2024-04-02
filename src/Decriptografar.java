import java.util.Scanner;
import java.util.HashMap;

public class Decriptografar {
    HashMap<String, String> codigoMorse = new HashMap<String, String>();
    public Decriptografar(){
        //Passar no GPT pra trocar o map
        codigoMorse.put(".-", "A");
        codigoMorse.put("-...", "B");
        codigoMorse.put("-.-.", "C");
        codigoMorse.put("-..", "D");
        codigoMorse.put(".", "E");
        codigoMorse.put("..-.", "F");
        codigoMorse.put("--.", "G");
        codigoMorse.put("....", "H");
        codigoMorse.put("..", "I");
        codigoMorse.put(".---", "J");
        codigoMorse.put("-.-", "K");
        codigoMorse.put(".-..", "L");
        codigoMorse.put("--", "M");
        codigoMorse.put("-.", "N");
        codigoMorse.put("---", "O");
        codigoMorse.put(".--.", "P");
        codigoMorse.put("--.-", "Q");
        codigoMorse.put(".-.", "R");
        codigoMorse.put("...", "S");
        codigoMorse.put("-", "T");
        codigoMorse.put("..-", "U");
        codigoMorse.put("...-", "V");
        codigoMorse.put(".--", "W");
        codigoMorse.put("-..-", "X");
        codigoMorse.put("-.--", "Y");
        codigoMorse.put("--..", "Z");
        codigoMorse.put("-----", "0");
        codigoMorse.put(".----", "1");
        codigoMorse.put("..---", "2");
        codigoMorse.put("...--", "3");
        codigoMorse.put("....-", "4");
        codigoMorse.put(".....", "5");
        codigoMorse.put("-....", "6");
        codigoMorse.put("--...", "7");
        codigoMorse.put("---..", "8");
        codigoMorse.put("----.", "9");
        codigoMorse.put("/", " ");  //
    }















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
                System.out.println("Digite a mensagem a ser decriptada: (Considere maiúsculas e minúsculas)");
                sc.nextLine();
                String mensagemC = sc.nextLine();
                String mensagemEncriptadaCesar = cesar(mensagemC);
                break;
            case 2:
                System.out.println("Digite a mensagem a ser decriptada:");
                sc.nextLine();
                String mensagem = sc.nextLine();
                String mensagemEncriptada = morse(mensagem);
                break;
            default:
                System.out.println("blz");
                break;
        }
    }










    //Mudar metodo
    public String cesar(String mensagem){
        StringBuilder mensagemDecriptada = new StringBuilder();
        for (char caractere : mensagem.toCharArray()) {
            if (Character.isLetter(caractere)) {
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                char novoCaractere = (char) ('A' + (caractere - 'A' - 3 + 26) % 26);
                mensagemDecriptada.append(novoCaractere);
            } else {
                mensagemDecriptada.append(caractere);
            }
        }
        System.out.println(mensagemDecriptada);
        return mensagemDecriptada.toString();
    }






    //Mudar metodo
    public String morse(String mensagem){
        StringBuilder mensagemDecriptada = new StringBuilder();
        String[] lista = mensagem.split("\\s+");

        for (String codigo : lista) {
            String caractere = codigoMorse.get(codigo);
            if (caractere != null) {
                mensagemDecriptada.append(caractere);
            } else {
                // Se o token não for encontrado no mapa, mantenha-o como está
                mensagemDecriptada.append(codigo);
            }
        }
        System.out.println(mensagemDecriptada);
        return mensagemDecriptada.toString();
    }


}
//Tratamento de erros

//QUando muda de maiúscula pra miníscula na hora de decriptografar tá mudando tudo errado




