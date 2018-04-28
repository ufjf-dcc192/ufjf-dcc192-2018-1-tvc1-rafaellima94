<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="dcc.Pessoas"%>
<%@page import="dcc.ListaDePessoas"%>
<%@include file="jspf/header.jspf" %>
    <div class="container">
        <h2 class="mb-4">Pessoas Cadastradas</h2>
        <div class="col-6">
            <table class="table table-sm table-bordered mx-auto">
                <tbody>
                    <tr>
                        <th>Nome</th>
                        <th>Tipo Pessoa</th>
                        <th>Data Início</th>
                        <th>Tempo (Dias)</th>
                    </tr>
                    <%
                        for (Pessoas pessoa : ListaDePessoas.getInstance()) {
                    %>
                    <tr>
                        <td>
                            <%=pessoa.getNome()%>
                        </td>
                        <td>
                            <%=pessoa.getTipoPessoa().getTipo()%>
                        </td>
                        <td>
                            <%=pessoa.getDataInicioString()%>
                        </td>
                        <td>
                            <%=pessoa.getTempoHospedagem()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
<%@include file="jspf/footer.jspf" %>