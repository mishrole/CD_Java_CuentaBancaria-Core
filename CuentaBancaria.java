import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class CuentaBancaria {
    public static int cuentasTotales = 0;
    public static double saldoTotal = 0.0;

    private String numeroCuenta = "";
    private double saldoAhorros;
    private double saldoCorriente;

    private String generarCuenta() {
        Random rand = new Random();
        String cuenta = "";
        for (int i = 0; i < 10; i++) {
            cuenta += rand.nextInt(9);
        }

        return cuenta;
    }

    public CuentaBancaria() {
        saldoAhorros = 0.0;
        saldoCorriente = 0.0;
        numeroCuenta = generarCuenta();
        cuentasTotales++;
    }

    public static int cuentasTotalesContador() {
        return cuentasTotales;
    }

    public static double saldosTotales() {
        return saldoTotal;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldoCuentaCorriente() {
        return saldoCorriente;
    }

    public double getSaldoCuentaAhorros() {
        return saldoAhorros;
    }

    private void setSaldoTotal() {
        saldoTotal = getSaldoCuentaAhorros() + getSaldoCuentaCorriente();
    }

    public boolean isValid(double total, double monto) {
        if (total - monto >= 0) {
            return true;
        }

        return false;
    }

    public void depositar(String tipo, double monto) {
        if (tipo.equals("ahorros")) {
            saldoAhorros += monto;
        } else if (tipo.equals("corriente")) {
            saldoCorriente += monto;
        }

        setSaldoTotal();
    }

    public void retirar(String tipo, double monto) {
        if (tipo.equals("ahorros")) {
            if (isValid(getSaldoCuentaAhorros(), monto)) {
                saldoAhorros -= monto;
            }
        } else if (tipo.equals("corriente")) {
            if (isValid(getSaldoCuentaCorriente(), monto)) {
                saldoCorriente -= monto;
            }
        }

        setSaldoTotal();
    }

    public void verSaldo() {
        Locale usa = new Locale("en", "US");
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);

        System.out.println(MessageFormat.format("Nº de Cuenta: {0}", getNumeroCuenta()));
        System.out.println(MessageFormat.format("Saldo de Cuenta de Ahorros: {0}", dollarFormat.format(getSaldoCuentaAhorros())));
        System.out.println(MessageFormat.format("Saldo de Cuenta Corriente: {0}", dollarFormat.format(getSaldoCuentaCorriente())));
        System.out.println(MessageFormat.format("Saldo total: {0}", dollarFormat.format(saldosTotales())));
    }

}