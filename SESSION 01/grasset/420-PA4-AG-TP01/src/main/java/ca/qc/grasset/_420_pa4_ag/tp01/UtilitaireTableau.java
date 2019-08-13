package ca.qc.grasset._420_pa4_ag.tp01;

public class UtilitaireTableau {

    public UtilitaireTableau() {

        super();
    }

    /**
    * Chercher la dernière position dans le tableau de la valeur spécifiée.
    *
    *  test: x = [2, 3, 5]   y = 2  Résultat attendu = 0
    *
    *  @param tableau_ Tableau à rechercher
    *  @param y Valeur à rechercher
    *  @return Dernière position de y dans x; -1 si absent
    *  @throws NullPointerException si x est null
    */
    public int chercherDernierePositionValeur(
        final int[] tableau_,
        final int valeur_) {

        for (int index = tableau_.length - 1; index >= 0; index--) {
            if (tableau_[index] == valeur_) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Chercher la dernière position de la valeur 0
     *
     *  test: x = [0, 1, 0]   Résultat attendu = 2
     *
     * @param tableu_ Tableau à rechercher
     * @return Dernière position de 0 dans x; -1 si absent
     * @throws NullPointerException si x est null
     */
    public int chercherDernierePositionZero(final int[] tableu_) {

        for (int index = tableu_.length - 1; index >= 0; index--) {
            if (tableu_[index] == 0) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Compter les entiers impairs ou positifs dans un tableau.
     *
     *  test: x = [-3, -2, 0, 1, 4]   Résultat attendu = 3
     *
     * @param tableu_ Tableau à rechercher
     * @return Le nombre d'entier impairs ou positif dans x
     * @throws NullPointerException si x est null
     */
    public int compterEntierImpairOuPositif(
        final int[] tableu_) {

        int count = 0;

        for (int index = 0; index < tableu_.length; index++) {
            if ((tableu_[index] % 2 != 0) || (tableu_[index] > 0)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Compte les entiers positifs dans un tableau.
     *
     *  test: x = [-4, 2, 0, 2]   Résultat attendu = 2
     *
     * @param tableu Tableau à rechercher
     * @return Le nombre d'entier positif dans x
     * @throws NullPointerException si x is null
     */
    public int compterEntierPositif(
        final int[] tableu) {

        int count = 0;

        for (int index = 0; index < tableu.length; index++) {
            if (tableu[index] > 0) {
                count++;
            }
        }
        return count;
    }
}