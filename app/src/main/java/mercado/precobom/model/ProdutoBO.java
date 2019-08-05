package mercado.precobom.model;

public class ProdutoBO {
    private Produto produto;

    public ProdutoBO(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public static boolean validaNome(Produto p){
        return p.getNome() != null;
    }

    public static boolean validaValor(Produto p){
        return p.getValor() != null;
    }

    public static boolean validaParcela(Produto p){
        return p.getParcela() != null;
    }
    public static boolean validaJuros(Produto p){
        return p.getJuros() != null;
    }

    public double valorJuros(){
        return (this.getProduto().getValor() * (this.getProduto().getJuros() / 100));
    }

    public double jurosParcela(){
        return valorJuros() / this.getProduto().getParcela();
    }

    public double valorParcelas(){
        return ((this.getProduto().getValor() / this.getProduto().getParcela()) + jurosParcela());
    }

    public double valorTotal(){
        return valorParcelas() * this.getProduto().getParcela();
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + "\n" +
                "Valor inicial: R$ " + produto.getValor() + "\n" +
                "Total de parcelas: " + produto.getParcela() + "\n" +
                "Valor das parcelas: R$ " + valorParcelas() + "\n" +
                "Total de juros: R$ " + valorJuros() + "\n" +
                "Valor total: R$ " + valorTotal();
    }
}
