// Usar biblioteca padrão para abrir e ler o CSV linha por linha, e guardas os objetos em lista
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import modelos.Aluno;


public class main {
    public static void main(String[] args) {

        // Leitura do arquivo CSV com Hashmap para facilitar a busca pelo aluno

        HashMap<String, Aluno> alunos = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("alunos.csv"));
            String linha;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",", -1);
                Aluno aluno = new Aluno(
                    dados[0],
                    dados[1],
                    dados[2],
                    dados[3],
                    dados[4],
                    dados[5]
                );
                alunos.put(aluno.getMatricula(), aluno);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    
         //Início do formulário
         
      

    Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a matrícula:");
        String matricula = scanner.nextLine();

        Aluno aluno = alunos.get(matricula);

    if (aluno == null) {
        System.out.println("Aluno não encontrado.");
        return;
    }

    ArrayList<String> sugestoes = gerarSugestoes(aluno.getNome());

    System.out.println("Aqui estão algumas sugestões de UFFmail com base no seu nome:");

    for (int i = 0; i < sugestoes.size(); i++) {
        System.out.println((i + 1) + " - " + sugestoes.get(i));
    }

    System.out.println("Escolha uma das opções de UFFmail:");
    int escolha = scanner.nextInt();

    String emailEscolhido = sugestoes.get(escolha - 1);

    aluno.criarUffmail(emailEscolhido);
    }

    public static ArrayList<String> gerarSugestoes(String nome) {

        String[] partes = nome.toLowerCase().split(" ");
        String primeiro = partes[0];
        String ultimo = partes[partes.length - 1];
        String segundo = partes.length > 1 ? partes[1] : "";

        ArrayList<String> emails = new ArrayList<>();

        emails.add(primeiro + "_" + segundo+ "@id.uff.br");
        emails.add(primeiro + "." + ultimo + "@id.uff.br");
        emails.add(primeiro.charAt(0) + ultimo + "@id.uff.br");
        emails.add(primeiro + "." + segundo + "@id.uff.br");
        emails.add(primeiro + ultimo + "@id.uff.br");

        return emails;
    }
}
