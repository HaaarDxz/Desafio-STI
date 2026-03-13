package modelos;

public class Aluno {
    private String nome;
    private String matricula;
    private String email;
    private String uffmail;
    private String telefone;
    private String status;

    public Aluno(String nome, String matricula, String telefone, String email, String uffmail, String status) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.uffmail = uffmail;
        this.telefone = telefone;
        this.status = status;
    }


    public String getNome (){
        return nome;
    } 
    public String getMatricula (){
        return matricula;
    }
    public String getEmail (){
        return email;
    }
    public String getUffmail (){
        return uffmail;
    }
    public String getTelefone (){
        return telefone;
    }
    public String getStatus (){
        return status;
    }

    //verificar se a matrícula existe, se está ativa e se ja tem uffmail

    public boolean isAtivo() {
    return status.equalsIgnoreCase("Ativo");
    }
    public boolean temUffmail() {
    return !uffmail.isEmpty();
    }

    //Permissão para criar UFFmail
    public void criarUffmail(String novoEmail) {

    if (!isAtivo()) {
        System.out.println("Infelizmente sua matrícula está inativa. Você não pode criar UFFmail.");
        return;
    }

    if (temUffmail()) {
        System.out.println("Você já possui um UFFmail.");
        return;
    }

    this.uffmail = novoEmail;


    System.out.println("Tudo certo! Seu UFFmail será criado em instantes e você receberá sua primeria senha via SMS no número cadastrado.");
}
}
    
