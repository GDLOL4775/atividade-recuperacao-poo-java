package nextgenbank;

public class ContaBancaria {

    private String titular;
    private int numeroConta;
    private double saldo;

    public String getTitular() {
        return titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Erro: saldo inicial nao pode ser negativo!");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Deposito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de deposito invalido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque nao autorizado. Saldo insuficiente ou valor invalido.");
        }
    }

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria();

        conta.setTitular("Maria Silva");
        conta.setNumeroConta(123456);
        conta.setSaldo(2500.00);

        System.out.println("========== EXTRATO BANCARIO ==========");
        System.out.println("Titular:       " + conta.getTitular());
        System.out.println("Numero Conta:  " + conta.getNumeroConta());
        System.out.println("Saldo Atual:   R$ " + conta.getSaldo());
        System.out.println("======================================");

        conta.depositar(500.00);
        conta.sacar(300.00);

        System.out.println("\nSaldo final: R$ " + conta.getSaldo());
    }
}