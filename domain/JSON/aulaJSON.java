package JSON;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class aulaJSON {
    public static void main(String[] args) {

        // converte objeto para json

        Gson gson = new Gson();

        Usuario user = new Usuario("joao", 19);

        String json = gson.toJson(user);

        System.out.println(json);

        // converte json para objeto

        String json2 = "{\"nome\":\"Joao\",\"idade\":22}";
        Usuario user2 = gson.fromJson(json2, Usuario.class);

        System.out.println(user.nome + user.idade);

        // Salva JSON em arquivo

        try {
            FileWriter writer = new FileWriter("usuarios.json");

            gson.toJson(user,writer);
            writer.close();

        } catch (IOException e) {
            System.out.println("erro ao salvar");
        }

        // Ler JSON em arquivo

        try {
            FileReader reader = new FileReader("usuarios.json");

            Usuario user3 = gson.fromJson(reader, Usuario.class);
            reader.close();

        } catch (IOException e) {
            System.out.println("erro ao carregar");
        }

    }
}