package model;

public class Relatorio {

    private String dataRelatorio;
    private String conteudo;
    private String responsavel;

    public Relatorio(String dataRelatorio,
                     String conteudo,
                     String responsavel) {

        this.dataRelatorio = dataRelatorio;
        this.conteudo = conteudo;
        this.responsavel = responsavel;
    }

    public void gerarRelatorio() {

        System.out.println("Relatório gerado com sucesso");
    }

    public void mostrarRelatorio() {

        System.out.println("===== RELATÓRIO =====");
        System.out.println("Data: " + dataRelatorio);
        System.out.println("Responsável: " + responsavel);
        System.out.println("Conteúdo: " + conteudo);
    }

    public void gerarRelatorio(String tipo) {

        System.out.println("Relatório do tipo " + tipo + " gerado");
    }

    public String getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(String dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}