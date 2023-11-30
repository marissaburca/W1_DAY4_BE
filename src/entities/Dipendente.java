package entities;

public class Dipendente {
    //dichiaro tutti gli attributi
    public static double stipendioBase= 1000;
    private int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    //dichiaro i setter e i getter
    public void setLivello(Livello livello) {
        this.livello = livello;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public int getMatricola() {
        return matricola;
    }


    //imposto costruttori, per avere uno stampino per ogni nuovo dipendente che creerò
    public Dipendente(int matricola,Dipartimento dipartimento ) {
        this.matricola = matricola; // assegno matricola durante new
        this.dipartimento = dipartimento; // assegno dipartimento durante new
        this.stipendio= Dipendente.stipendioBase; //leggo il valore che ho messo come static
        this.importoOrarioStraordinario = 30; //fisso un valore di default per i nuovi generati
        this.livello= Livello.OPERAIO; //set valido per tutti i nuovi dipendenti generati con costruttore
    }
    public Dipendente(int matricola, Dipartimento dipartimento, double stipendio, double importoOrarioStraordinario,
                      Livello livello){
        this(matricola, dipartimento);//richiamo primo costruttore, ricorda regola DRY
        this.stipendio = stipendio; // lo assegno col new
        this.importoOrarioStraordinario = importoOrarioStraordinario;// lo assegno col new
        this.livello = livello;// lo assegno col new
    }

    //metodi
    public void stampaDatiDipendente(){
        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio Base: " + stipendioBase);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Importo Orario Straordinario: " + importoOrarioStraordinario);
        System.out.println("Livello: " + livello);
        System.out.println("Dipartimento: " + dipartimento);

        //stampo tutti i dati degli dipendenti
    }
    public void promuovi(){
        if(this.livello==Livello.OPERAIO){
            this.livello = Livello.IMPIEGATO;
            this.stipendio= Dipendente.stipendioBase*1.2;
        } else if (this.livello==Livello.IMPIEGATO) {
            this.livello = Livello.QUADRO;
            this.stipendio=Dipendente.stipendioBase*1.5;
        } else if (this.livello==Livello.QUADRO) {
            this.livello = Livello.DIRIGENTE;
            this.stipendio= Dipendente.stipendioBase*2;
        } else {
            System.out.println("Error during promotion. "  + this.getMatricola() +" is already 'DIRIGENTE'");
        }
        System.out.println("Il nuovo livello del dipendente è: "+ this.livello);

        //promuovo i dipendenti in base al loro livello, verifico livello del dipendente e lo setto
        //in base alla necessità di salire di uno, fermandomi al dirigente
    }
    public static double calcolaPaga(Dipendente dipendente) {
        return dipendente.getStipendio();
    }
    //impostato su richiesta della consegna, ma non utilizzato

    public static double calcolaPaga(Dipendente dipendente, int hoursExtra) {
        double salary = dipendente.getStipendio();
        double extra = dipendente.getImportoOrarioStraordinario() * hoursExtra;
        return salary + extra;
    }
    //gli do come parametri il dipendente e le ore extra. Per ognuno legge lo stipendio,
    //calcola l'importo extra in base a importo orario straordinario e al numero di ore che gli passo,
    //ritorna somma di salario + extra del singolo dipendente (per fare somma faccio ciclo for per ogni dipendente ;)

}
