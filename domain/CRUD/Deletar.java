package CRUD;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class Deletar {

    public static void deletar(String user) {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader("usuarios.json");
            Type listaJSON = new TypeToken<List<Usuario>>() {}.getType();
            List<Usuario> createdUser = gson.fromJson(reader, listaJSON);

            reader.close();

            for (int i = 0; i < createdUser.size(); i++) {
                Usuario u = createdUser.get(i);
                if (user.equals(u.getUser())) {
                    createdUser.remove(createdUser.get(i));
                    break;
                }
            }

            FileWriter writer = new FileWriter("usuarios.json");
            gson.toJson(createdUser, writer);

            writer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Deletar.deletar("xo.victor");
    }
}
