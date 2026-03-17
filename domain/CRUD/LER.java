package CRUD;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LER {

    public static void ler(String user) {

        if (user == null || user.isEmpty()) {
            System.out.println("erro!! usuario vazio!");

        } else {
            try {
                Gson gson = new Gson();

                FileReader reader = new FileReader("Usuarios.json");
                Type listaJson = new TypeToken<List<Usuario>>() {}.getType();
                List<Usuario> createdUser = gson.fromJson(reader, listaJson);

                reader.close();

                if (createdUser == null) {
                    createdUser = new ArrayList<>();
                }

                for (Usuario u : createdUser) {
                    if (user.equals(u.getUser())) {
                        System.out.println("User: " + u.getUser());
                        System.out.println("Nome: " + u.getName());
                        System.out.println("Idade: " + u.getIdade());
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void main(String[] args) {
        LER.ler("xo.victor");
    }
}
