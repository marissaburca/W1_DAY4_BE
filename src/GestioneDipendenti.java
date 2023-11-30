import entities.Dipartimento;
import entities.Dipendente;
import entities.Livello;

public class GestioneDipendenti{
    public static void main(String[] args) {
        Dipendente[] dipendenti = {
                new Dipendente(1998, Dipartimento.PRODUZIONE),
                new Dipendente(1987, Dipartimento.PRODUZIONE),
                new Dipendente( 1980, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE,40),
                new Dipendente(1975, Livello.DIRIGENTE, Dipartimento.VENDITE,50)
        };

        for (Dipendente dipendente : dipendenti) {
            dipendente.promuovi();
            dipendente.stampaDatiDipendente();
        }
        double totalSalaries = 0;

        for (Dipendente dipendente : dipendenti) {
            double salary = dipendente.getStipendio();
            double importoOrarioStraordinario = dipendente.getImportoOrarioStraordinario();

            // Calcola la paga con 5 ore di straordinario per ciascun dipendente
            double salaryWithExtra = salary + (importoOrarioStraordinario * 5);

            totalSalaries +=salaryWithExtra;
        }

        System.out.println("La somma degli stipendi con 5 ore di straordinario per tutti i dipendenti è: " + totalSalaries);
    }
}