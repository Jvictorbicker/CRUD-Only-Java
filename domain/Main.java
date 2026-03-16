import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Usuario user = new Usuario("joao", 19);

        String json = gson.toJson(user);

        System.out.println(json);
    }
}