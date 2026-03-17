package CRUD;

public class Usuario {

    public String user;
    public String name;
    public int idade;

    public Usuario(String user, String name,  int idade) {
        this.user = user;
        this.name = name;
        this.idade = idade;
    }
    public String getUser() {
        return user;
    }
    public String getName() {
        return this.name;
    }
    public int getIdade() {
        return this.idade;
    }
    public void setUser(String newUser) {
        this.user = user;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
