package ca.qc.grasset._420_pa4_ag.lab01;

public class Factorielle {

    public static void main(
        final String[] args) {

        Factorielle factorielle = new Factorielle();

        int n, result;
        if (args.length != 1) {
            System.out.println("Utilisation: factorielle n, n >=0\n");
            return;
        }

        n = Integer.valueOf(args[1]);

        result = factorielle.generer(n);
        System.out.format("Factorielle %d = %d\n", n, result);

        return;
    }

    int generer(
        final int n) {

        int result = 1;
        if (n == 0) {
            return result;
        }
        result = generer(n - 1) * n;
        return result;
    }

}
