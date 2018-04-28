package dcc;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home", "/cadastrar-pessoa", "/pessoas-cadastradas"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sp = request.getServletPath();

        if ("/cadastrar-pessoa".equals(sp)) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/cadastrar-pessoa.jsp");
            rd.forward(request, response);
        } else if ("/home".equals(sp)) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
            rd.forward(request, response);
        } else if ("/pessoas-cadastradas".equals(sp)) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pessoas-cadastradas.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Integer tempoHospedagem = Integer.parseInt(request.getParameter("tempoHospedagem"));
        TiposPessoas tipoPessoa = ListaDeTiposDePessoas.getInstance().get(Integer.parseInt(request.getParameter("tipoPessoa")) - 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataInicioString = request.getParameter("dataInicio");
        LocalDate ld = LocalDate.parse(dataInicioString, formatter);
        LocalDateTime dataInicio = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
        Pessoas novaPessoa = new Pessoas(nome, tempoHospedagem, tipoPessoa, dataInicio);
        List<Pessoas> todasPessoas = ListaDePessoas.getInstance();
        boolean match = false;

        if (!compararTodasPessoas(todasPessoas, novaPessoa)) {
            for (Pessoas pessoa : todasPessoas) {
                if (pessoa.getDataInicioString().equals(novaPessoa.getDataInicioString()) &&
                        Objects.equals(pessoa.getTempoHospedagem(), novaPessoa.getTempoHospedagem())) {
                    if(novaPessoa.getTipoPessoa().getId() != 3 && pessoa.getTipoPessoa().getId() == 3) {
                        request.setAttribute("novaPessoa", "intercambista");
                        request.setAttribute("intercambista", pessoa);
                        request.setAttribute("anfitriao", novaPessoa);
                        todasPessoas.remove(pessoa);
                        match = true;
                    } else if (novaPessoa.getTipoPessoa().getId() == 3 && pessoa.getTipoPessoa().getId() != 3) {
                        request.setAttribute("novaPessoa", "anfitriao");
                        request.setAttribute("intercambista", pessoa);
                        request.setAttribute("anfitriao", novaPessoa);
                        todasPessoas.remove(pessoa);
                        match = true;
                    }
                }
            }
            
            if (match) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/hospedagem-encontrada.jsp");
                rd.forward(request, response);
            } else {    
                todasPessoas.add(novaPessoa);    
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
            rd.forward(request, response);
        }
    }
    
    private boolean compararTodasPessoas(List<Pessoas> p1, Pessoas p2) {
        for (Pessoas p : p1) {
            if (p.getNome().equals(p2.getNome()) && 
                    p.getDataInicioString().equals(p2.getDataInicioString()) && 
                    Objects.equals(p.getTempoHospedagem(), p2.getTempoHospedagem()) && 
                    Objects.equals(p.getTipoPessoa().getId(), p2.getTipoPessoa().getId())) {
                return true;
            }
        }
            
        return false;
    }

}
