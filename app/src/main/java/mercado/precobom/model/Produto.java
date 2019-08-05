package mercado.precobom.model;

public class Produto {
    private String nome;
    private Double valor;
    private Integer parcela;
    private Double juros;

    public Produto() {
    }

    public Produto(String nome, Double valor, Integer parcela, Double juros) {
        this.nome = nome;
        this.valor = valor;
        this.parcela = parcela;
        this.juros = juros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor){
        try{
            this.valor = Double.parseDouble(valor);
        } catch (Exception e){
            this.valor = null;
        }

    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public void setParcela(String parcela){
        try {
            this.parcela = Integer.parseInt(parcela);
        } catch (Exception e){
            this.parcela = null;
        }
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public void setJuros(String juros){
        try {
            this.juros = Double.parseDouble(juros);
        } catch (Exception e){
            this.juros = null;
        }
    }

}
