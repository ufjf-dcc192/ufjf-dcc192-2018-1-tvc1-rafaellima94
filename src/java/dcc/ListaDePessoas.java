package dcc;

import java.util.ArrayList;
import java.util.List;

public class ListaDePessoas {
    private static List<Pessoas> pessoas;

    public static List<Pessoas> getInstance() {
        if (pessoas == null) {
            pessoas = new ArrayList<>();
        }
        
        return pessoas;
    }
}
