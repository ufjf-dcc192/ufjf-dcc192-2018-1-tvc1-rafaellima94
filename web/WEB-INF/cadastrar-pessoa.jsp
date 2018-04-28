<%@page import="dcc.ListaDeTiposDePessoas"%>
<%@page import="dcc.TiposPessoas"%>
<%@include file="jspf/header.jspf" %>
    <div class="container">
        <h2 class="mb-4">Cadastrar-se</h2>
        <div class="col-6">
            <form method="POST">
                <label for="nome">Nome</label>
                <input class="form-control" type="text" id="nome" name="nome" />
                <label for="tipoPessoa">Tipo de Pessoa</label>
                <select class="form-control" id="tipoPessoa" name="tipoPessoa">
                    <%
                        for (TiposPessoas tipoPessoa : ListaDeTiposDePessoas.getInstance()) {
                    %>
                    <option value="<%=tipoPessoa.getId()%>"><%=tipoPessoa.getTipo()%></option>
                    <%
                        }
                    %>
                </select>
                <label for="dataInicio">Data de Início da Hospedagem</label>
                <input class="form-control" type="date" id="dataInicio" name="dataInicio" />
                <label for="tempoHospedagem">Tempo de Hospedagem</label>
                <input class="form-control" type="number" id="tempoHospedagem" name="tempoHospedagem" />
                <button class="btn btn-success" type="submit">Cadastrar</button>
            </form>
        </div>
    </div>
<%@include file="jspf/footer.jspf" %>