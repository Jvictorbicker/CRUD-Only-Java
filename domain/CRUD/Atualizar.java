package CRUD;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Atualizar {

    public static void atualizar(String user, String newUser, String name, int idade) {
        try {
            Gson gson = new Gson();

            //le o arquivo
            FileReader reader = new FileReader("usuarios.json");
            Type listaJson = new TypeToken<List<Usuario>>(){}.getType();
            List <Usuario> createUser = gson.fromJson(reader, listaJson);

            reader.close();

            if (createUser == null) {
                createUser = new ArrayList<>();
            }

            for (int i = 0; i < createUser.size(); i++) {
                Usuario u = createUser.get(i);
                if (u.getUser().equals(user)) {
                    u.setUser(newUser);
                    u.setName(name);
                    u.setIdade(idade);
                    break;
                }
            }

            FileWriter writer = new FileWriter("usuarios.json");
            gson.toJson(createUser, writer);

            writer.close();

        } catch (Exception e) {
            System.out.println("impossivel atualizar");
        }
    }

    public static void main(String[] args) {
        Atualizar.atualizar("xo.victor", "victorr", "joaoo", 19);
    }

}
