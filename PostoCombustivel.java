package fuelsmart;

public class PostoCombustivel {

    private String[] tiposCombustivel;
    private double[] precosLitro;
    private int[] litrosDisponiveis;

    public PostoCombustivel(String[] tipos, double[] precos, int[] litros) {
        this.tiposCombustivel = tipos;
        this.precosLitro = precos;
        this.litrosDisponiveis = litros;
    }

    public void monitoramentoGlobal() {
        System.out.println("========== STATUS DAS BOMBAS ==========");
        for (int i = 0; i < tiposCombustivel.length; i++) {
            System.out.printf("%d. %-20s | Preco: R$ %.2f | Estoque: %d litros%n",
                    (i + 1),
                    tiposCombustivel[i],
                    precosLitro[i],
                    litrosDisponiveis[i]);
        }
        System.out.println("=======================================");
    }

    public double avaliacaoPatrimonial() {
        double total = 0;
        for (int i = 0; i < tiposCombustivel.length; i++) {
            total += precosLitro[i] * litrosDisponiveis[i];
        }
        return total;
    }

    public void analiseInventario() {
        int maior = 0;
        int menor = 0;

        for (int i = 1; i < litrosDisponiveis.length; i++) {
            if (litrosDisponiveis[i] > litrosDisponiveis[maior]) {
                maior = i;
            }
            if (litrosDisponiveis[i] < litrosDisponiveis[menor]) {
                menor = i;
            }
        }

        System.out.println("========== ANALISE DE INVENTARIO ==========");
        System.out.println("Maior estoque: " + tiposCombustivel[maior] +
                " (" + litrosDisponiveis[maior] + " litros)");
        System.out.println("Menor estoque: " + tiposCombustivel[menor] +
                " (" + litrosDisponiveis[menor] + " litros) -> PEDIDO URGENTE");
        System.out.println("===========================================");
    }

    public void vender(int indice, int litrosVendidos) {
        if (indice < 0 || indice >= tiposCombustivel.length) {
            System.out.println("Combustivel invalido!");
            return;
        }

        if (litrosVendidos <= 0) {
            System.out.println("Quantidade invalida!");
            return;
        }

        if (litrosVendidos > litrosDisponiveis[indice]) {
            System.out.println("Estoque insuficiente de " + tiposCombustivel[indice] +
                    "! Disponivel: " + litrosDisponiveis[indice] + " litros.");
            return;
        }

        litrosDisponiveis[indice] -= litrosVendidos;
        double valor = litrosVendidos * precosLitro[indice];

        System.out.printf("Venda realizada: %d litros de %s | Valor: R$ %.2f%n",
                litrosVendidos, tiposCombustivel[indice], valor);
    }

    public void reabastecer(int indice, int litrosAdicionados) {
        if (indice < 0 || indice >= tiposCombustivel.length) {
            System.out.println("Combustivel invalido!");
            return;
        }

        if (litrosAdicionados <= 0) {
            System.out.println("Quantidade invalida!");
            return;
        }

        litrosDisponiveis[indice] += litrosAdicionados;
        System.out.println("Reabastecimento: +" + litrosAdicionados +
                " litros de " + tiposCombustivel[indice] +
                ". Novo estoque: " + litrosDisponiveis[indice] + " litros.");
    }

    public static void main(String[] args) {

        String[] tipos = {"Gasolina Aditivada", "Etanol", "Diesel S10"};
        double[] precos = {6.49, 4.29, 5.89};
        int[] litros = {12000, 8000, 15000};

        PostoCombustivel posto = new PostoCombustivel(tipos, precos, litros);

        posto.monitoramentoGlobal();

        System.out.println("\nValor total em estoque: R$ " +
                String.format("%.2f", posto.avaliacaoPatrimonial()));

        posto.analiseInventario();

        System.out.println();
        posto.vender(0, 50);
        posto.vender(1, 9000);

        System.out.println();
        posto.reabastecer(1, 5000);

        System.out.println();
        posto.monitoramentoGlobal();
    }
}