package dcc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoas {

    private String nome;
    private Integer tempoHospedagem;
    private TiposPessoas tipoPessoa;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Pessoas(String nome, Integer tempoHospedagem, TiposPessoas tipoPessoa, LocalDateTime dataInicio) {
        this.nome = nome;
        this.tempoHospedagem = tempoHospedagem;
        this.tipoPessoa = tipoPessoa;
        this.dataInicio = dataInicio;
        this.dataFim = dataInicio.plusDays(tempoHospedagem);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTempoHospedagem() {
        return tempoHospedagem;
    }

    public void setTempoHospedagem(Integer tempoHospedagem) {
        this.tempoHospedagem = tempoHospedagem;
    }

    public TiposPessoas getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TiposPessoas tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    
    public String getDataInicioString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataInicio.format(formatter);
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    
    public String getDataFimString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataFim.format(formatter);
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

}
