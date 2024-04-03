import java.util.Scanner;
import java.util.HashMap;

public class Encriptografar {
    //Utilização de um Hashmap para mapear as letras e os caraceteres em código morse
    //O hashmap funciona como se fosse um dicionário, com chaves e valores.
    HashMap<String, String> codigoMorse = new HashMap<String, String>();
        public Encriptografar(){
            codigoMorse.put("A", ".-");
            codigoMorse.put("B", "-...");
            codigoMorse.put("C", "-.-.");
            codigoMorse.put("D", "-..");
            codigoMorse.put("E", ".");
            codigoMorse.put("F", "..-.");
            codigoMorse.put("G", "--.");
            codigoMorse.put("H", "....");
            codigoMorse.put("I", "..");
            codigoMorse.put("J", ".---");
            codigoMorse.put("K", "-.-");
            codigoMorse.put("L", ".-..");
            codigoMorse.put("M", "--");
            codigoMorse.put("N", "-.");
            codigoMorse.put("O", "---");
            codigoMorse.put("P", ".--.");
            codigoMorse.put("Q", "--.-");
            codigoMorse.put("R", ".-.");
            codigoMorse.put("S", "...");
            codigoMorse.put("T", "-");
            codigoMorse.put("U", "..-");
            codigoMorse.put("V", "...-");
            codigoMorse.put("W", ".--");
            codigoMorse.put("X", "-..-");
            codigoMorse.put("Y", "-.--");
            codigoMorse.put("Z", "--..");
            codigoMorse.put("0", "-----");
            codigoMorse.put("1", ".----");
            codigoMorse.put("2", "..---");
            codigoMorse.put("3", "...--");
            codigoMorse.put("4", "....-");
            codigoMorse.put("5", ".....");
            codigoMorse.put("6", "-....");
            codigoMorse.put("7", "--...");
            codigoMorse.put("8", "---..");
            codigoMorse.put("9", "----.");
            codigoMorse.put(" ", "/");
        }
    //Criação do menu que será igual para as duas classes
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual método deseja utilizar?\n"+
                "---------\n"+
                "1-Cifra de César\n"+
                "2-Código Morse\n"+
                "---------");
        int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite a mensagem a ser encriptada:");
                    sc.nextLine();
                    String mensagemC = sc.nextLine();
                    String mensagemEncriptadaCesar = cesar(mensagemC);
                    break;
                case 2:
                    System.out.println("Digite a mensagem a ser encriptada:");
                    sc.nextLine();
                    String mensagem = sc.nextLine().toUpperCase();
                    String mensagemEncriptada = morse(mensagem);
                    break;
                default:
                    System.out.println("Por favor, insira uma entrada válida\n");
                    break;
            }
        }


        //Criação dos métodos de encriprografar
        public String cesar(String mensagem){
        StringBuilder mensagemEncriptada = new StringBuilder();
        //O for itera, usando "caractere" sobre cada caractere de mensagem
        //Confere se é uma letra, e se está em maiúsculo, se sim a base se torna o A maiúsculo, se não, o a minúsculo
        for (char caractere : mensagem.toCharArray()) {
            if (Character.isLetter(caractere)) {
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                //O novo caractere é adicionado ao StringBuilder seguindo a conta de criptografia
                char novoCaractere = (char) ((caractere - base + 3) % 26 + base);
                mensagemEncriptada.append(novoCaractere);
            } else {
                mensagemEncriptada.append(caractere);
            }
        }
        System.out.println(mensagemEncriptada);
        return mensagemEncriptada.toString();
    }

    //O for itera sobre cada caractere de mensagem
    public String morse(String mensagem){
        StringBuilder mensagemEncriptada = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            mensagemEncriptada.append(" ");
            char caractere = mensagem.charAt(i);
            if (caractere == ' ') {
                mensagemEncriptada.append("/");
                continue;
            }
            //Se o Hashmap codigoMorse conter a string de valor igual ao do caractere iterado, a mensagemEncriptada receberá o valor correspondente ao
            //contido no Hashmap, de acordo com o que o usuário digitou
            if (codigoMorse.containsKey(String.valueOf(caractere))) {
                mensagemEncriptada.append(codigoMorse.get(String.valueOf(caractere)));
            } else {
                // Se o caractere não estiver no mapa, não se altera
                mensagemEncriptada.append(caractere);
            }
        }
        System.out.println(mensagemEncriptada);
        return mensagemEncriptada.toString();
    }


}