<%@page import="dcc.Pessoas"%>
<%@include file="jspf/header.jspf" %>
    <div class="container">
        <h2 class="mb-4">Anfitri�o/Intercambista Encontrado</h2>
        <div class="col-6">
            <%
                String novaPessoa = (String) request.getAttribute("novaPessoa");
                Pessoas intercambista = (Pessoas) request.getAttribute("intercambista");
                Pessoas anfitriao = (Pessoas) request.getAttribute("anfitriao");
                
                if ("anfitriao".equals(novaPessoa)) {
            %>
            <h4>Parab�ns, <%=anfitriao.getNome()%></h4>
            <p>Encontramos um intercambista para se hospedar com voc�.</p>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Nome: <%=intercambista.getNome()%></li>
                <li class="list-group-item">Data de chegada: <%=intercambista.getDataInicioString()%></li>
                <li class="list-group-item">Tempo de estadia: <%=intercambista.getTempoHospedagem()%> dias</li>
                <li class="list-group-item">Data de sa�da: <%=intercambista.getDataFimString()%></li>
            </ul>
            <%
                } else {
            %>
            <h4>Parab�ns, <%=intercambista.getNome()%></h4>
            <p>Encontramos um intercambista para se hospedar com voc�.</p>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Nome: <%=anfitriao.getNome()%></li>
                <li class="list-group-item">Tipo: <%=anfitriao.getTipoPessoa().getTipo()%></li>
                <li class="list-group-item">Data de chegada: <%=anfitriao.getDataInicioString()%></li>
                <li class="list-group-item">Tempo de estadia: <%=anfitriao.getTempoHospedagem()%> dias</li>
                <li class="list-group-item">Data de sa�da: <%=anfitriao.getDataFimString()%></li>
            </ul>
            <% 
                }
            %>
        </div>
    </div>
<%@include file="jspf/footer.jspf" %>