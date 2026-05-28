package abstracts;

public abstract class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String login;
    private String senha;

    public Usuario(int id, String nome, String cpf, String telefone, String login, String senha) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String login, String senha) {

        return this.login.equals(login) && this.senha.equals(senha);
    }

    public void logout() {

        System.out.println("Logout realizado");
    }

    public abstract void exibirDados();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
