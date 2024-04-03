import java.util.Scanner;
import java.util.HashMap;

public class Decriptografar {
    //Utilização de um Hashmap para mapear as letras e os caraceteres em código morse
    //O hashmap funciona como se fosse um dicionário, com chaves e valores.
    HashMap<String, String> codigoMorse = new HashMap<String, String>();
    public Decriptografar() {
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

    //Criação do menu que será igual para as duas classes
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual método deseja utilizar?\n" +
                "---------\n" +
                "1-Cifra de César\n" +
                "2-Código Morse\n" +
                "---------");
        int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite a mensagem a ser decriptada:");
                    sc.nextLine();
                    String mensagemC = sc.nextLine().toUpperCase();
                    String mensagemEncriptadaCesar = cesar(mensagemC);
                    break;
                case 2:
                    System.out.println("Digite a mensagem a ser decriptada:");
                    sc.nextLine();
                    String mensagem = sc.nextLine();
                    String mensagemEncriptada = morse(mensagem);
                    break;
                default:
                    System.out.println("Por favor, insira uma entrada válida");
                    break;


            }
        }

            //Criação dos métodos de Decriptografar
            public String cesar (String mensagem){
            StringBuilder mensagemDecriptada = new StringBuilder();
            //O for itera, usando "caractere" sobre cada caractere de mensagem
            //confere se é uma letra, e se está em maiúsculo, se sim a base se torna o A maiúsculo, se não, o a minúsculo
            for (char caractere : mensagem.toCharArray()) {
                if (Character.isLetter(caractere)) {
                    char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                    //Aqui o cálculo é feito quase ao contrário do que foi feito na classe Encriptografar, para realizar exatamente o processo oposto
                    //O novo caractere é adicionado ao StringBuilder seguindo a conta de decriptografia
                    char novoCaractere = (char) ('A' + (caractere - 'A' - 3 + 26) % 26);
                    mensagemDecriptada.append(novoCaractere);
                } else {
                    mensagemDecriptada.append(caractere);
                }
            }
                System.out.println(mensagemDecriptada);
                return mensagemDecriptada.toString();
            }


            //O for itera sobre cada caractere do código
            public String morse (String mensagem){
                StringBuilder mensagemDecriptada = new StringBuilder();
                //Aqui, os itens dentro de mensagem serão adicionados em uma lista, separados por "\\s+"
                //que significa que onde estiver espaços em branco, independente da quantidade, será contado o fim de um caractere
                String[] lista = mensagem.split("\\s+");
                //O for itera com codigo dentro da lista, e pega o codigo dentro do Hashmap codigoMorse correspondente
                for (String codigo : lista) {
                    String caractere = codigoMorse.get(codigo);
                    if (caractere != null) {
                        mensagemDecriptada.append(caractere);
                    } else {
                        // Se o token não for encontrado no mapa, não se altera
                        mensagemDecriptada.append(codigo);
                    }
                }
                System.out.println(mensagemDecriptada);
                return mensagemDecriptada.toString();
            }


}


