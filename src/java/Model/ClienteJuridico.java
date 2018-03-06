package Model;

public class ClienteJuridico extends Pessoa {

//    private Pessoa pessoa;
    
    private int id;

    private String cnpj;

    private String ie;

    private String razao_social;

    private Login login;

//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }

//    public void add_pessoa(Pessoa pessoa) {
//
//    }

//    public void setPessoa(Pessoa pessoa) {
//
//    }

//    public Pessoa getPessoa() {
//        return pessoa;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIe() {
        return ie;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getRazao_social() {
        return razao_social;
    }

}
