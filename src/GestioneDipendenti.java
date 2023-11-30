import entities.Dipartimento;
import entities.Dipendente;
import entities.Livello;

public class GestioneDipendenti{
    public static void main(String[] args) {
        //il mio main istanzia i dipendenti con array di "Dipendente"
        Dipendente[] dipendenti = {
                new Dipendente(1998, Dipartimento.PRODUZIONE),
                new Dipendente(1987, Dipartimento.PRODUZIONE),
                new Dipendente( 1980, Dipartimento.AMMINISTRAZIONE,
                        Dipendente.stipendioBase * 1.2, 50, Livello.IMPIEGATO),
                new Dipendente(1975,Dipartimento.VENDITE,
                        Dipendente.stipendioBase * 2, 70, Livello.DIRIGENTE)
        };

        System.out.println("State of employees before promotion ****************************");
        //con ciclo for (sinstassi suggerita da java) stampo lo stato di ogni dipendente prima di fare
        //qualunque modifica.La traccia non lo richiede, ma consente di vedere se ciò che abbiamo fatto è giusto
        for (Dipendente dipendente : dipendenti) {
            dipendente.stampaDatiDipendente();
            System.out.println("****************************");
        }

        //con altro ciclo for promuovo ogni dipendente e ne stampo nuovamente lo stato coi dati aggiornati
        System.out.println("State of employee after promotion *****************************+");
        /*for (Dipendente dipendente : dipendenti) {
            dipendente.promuovi();
            dipendente.stampaDatiDipendente();
            System.out.println("****************************");
        }*/
        //traccia ambigua, ora promuovo un solo operaio e un solo impiegato
        dipendenti[1].promuovi();
        dipendenti[1].stampaDatiDipendente();
        System.out.println("****************************");
        dipendenti[2].promuovi();
        dipendenti[2].stampaDatiDipendente();
        System.out.println("****************************");

        //setto valore iniziale 0 per poi sommarlo di volta in volta ad ogni ciclo for con il valore di
        //salaryWithExtra ..che applica il metodo calcolaPaga ad ogni dipendente.
        double totalSalaries = 0;

        for (Dipendente dipendente : dipendenti) {
            double salaryWithExtra = Dipendente.calcolaPaga(dipendente, 5); // 5 ore di straordinario
            totalSalaries += salaryWithExtra;
        }
        //a calcolo terminato, stampo il risultato :D
        System.out.println("The sum of the salaries considering 5 hours of extra for everybody is : " + totalSalaries);
    }
}


