package CRUD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Criar {

    public void create(String user, String name, int idade) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            // Le o JSON
            FileReader reader = new FileReader("usuarios.json");
            Type listaJSON = new TypeToken<List<Usuario>>() {}.getType();
            List<Usuario> createUser = gson.fromJson(reader, listaJSON);

            reader.close();

            //caso  arquivo esteja vazio
            if (createUser == null) {
                createUser = new ArrayList<>();
            }

            // Adiciona novo usuario
            createUser.add(new Usuario(user, name, idade));

            // Salva no JSON
            FileWriter writer = new FileWriter("usuarios.json");

            gson.toJson(createUser, writer);
            writer.close();

        } catch (IOException e) {
            System.out.println("impossivel criar");
        }
    }

    public static void main (String[] args) {
        Criar criar = new Criar();

        criar.create("xo.victor", "joao", 19);
        criar.create("peter", "pedro", 19);
    }
}
