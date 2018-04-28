package dcc;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTiposDePessoas {

    private static List<TiposPessoas> tiposPessoas;

    public static List<TiposPessoas> getInstance() {
        if (tiposPessoas == null) {
            tiposPessoas = new ArrayList<>();
            tiposPessoas.add(new TiposPessoas(1, "Aluno"));
            tiposPessoas.add(new TiposPessoas(2, "Docente"));
            tiposPessoas.add(new TiposPessoas(3, "Intercambista"));
            tiposPessoas.add(new TiposPessoas(4, "TAE"));
            tiposPessoas.add(new TiposPessoas(5, "Terceirizado"));
        }
        
        return tiposPessoas;
    }
}
