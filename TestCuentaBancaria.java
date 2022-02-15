public class TestCuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        cuenta1.depositar("ahorros", 500.0);
        cuenta1.depositar("corriente", 800.0);

        cuenta1.retirar("ahorros", 100.0);
        cuenta1.retirar("corriente", 400.0);

        cuenta1.verSaldo();

        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta2.depositar("ahorros", 1200.0);
        cuenta2.depositar("corriente", 800.0);

        cuenta2.verSaldo();

        System.out.println(CuentaBancaria.cuentasTotalesContador());
    }
}