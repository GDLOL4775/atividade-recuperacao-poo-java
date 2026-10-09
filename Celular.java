package techrecycle;

public class Celular {

    public String marca;
    public String modelo;
    public double preco;
    public String estado;
    public String defeito;

    public static void main(String[] args) {

        Celular aparelho = new Celular();

        aparelho.marca = "Apple";
        aparelho.modelo = "iPhone 13";
        aparelho.preco = 1899.90;
        aparelho.estado = "Usado";
        aparelho.defeito = "Tela quebrada";

        System.out.println("========== RELATORIO DO APARELHO ==========");
        System.out.println("Marca:   " + aparelho.marca);
        System.out.println("Modelo:  " + aparelho.modelo);
        System.out.println("Preco:   R$ " + aparelho.preco);
        System.out.println("Estado:  " + aparelho.estado);
        System.out.println("Defeito: " + aparelho.defeito);
        System.out.println("============================================");
    }
}