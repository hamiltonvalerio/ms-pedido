package br.com.pedido.mspedido.adapter.input.dto;

public class PedidoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double total;
    private String status;

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, String nome, String descricao, Double total, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
