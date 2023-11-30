package entities;

public class Dipendente {
    //dichiaro tutti gli attributi
    private double stipendioBase= 1000;
    private int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    //dichiaro i setter e i getter
    public void setLivello(Livello livello) {
        this.livello = livello;
    }

    public Livello getLivello() {
        return livello;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
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

    //imposto costruttori, per avere uno stampino per ogni nuovo dipendente che creerò
    public Dipendente(int matricola,Dipartimento dipartimento ) {
        this.matricola = matricola; // assegno direttamente matricola
        this.dipartimento = dipartimento; // assegno direttamente tipo dipartimento
        this.stipendio= getStipendioBase(); //leggo il valore
        this.importoOrarioStraordinario = 30; //fisso un valore di default per i nuovi generati
        this.livello= Livello.OPERAIO; //set valido per tutti i nuovi dipendenti generati con costruttore
    }
    public Dipendente(int matricola,Livello livello, Dipartimento dipartimento, double importoOrarioStraordinario){
        this.stipendioBase= getStipendioBase();  //leggo il valore
        this.stipendio=getStipendio();  //leggo il valore
        this.matricola = matricola; // assegno direttamente matricola
        this.livello = livello; // assegno direttamente tipo livello
        this.dipartimento = dipartimento; // assegno direttamente tipo dipartimento
        this.importoOrarioStraordinario = importoOrarioStraordinario; // assegno direttamente valore
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
            this.stipendio= stipendioBase*1.2;
        } else if (this.livello==Livello.IMPIEGATO) {
            this.livello = Livello.QUADRO;
            this.stipendio=stipendioBase*1.5;
        } else if (this.livello==Livello.QUADRO) {
            this.livello = Livello.DIRIGENTE;
            this.stipendio= stipendioBase*2;
        } else {
            this.livello = Livello.DIRIGENTE;
            this.stipendio= stipendioBase*2;
            System.out.println("Error during promotion");
        }
        System.out.println("Il nuovo livello del dipendente è: "+ this.livello);

        //promuovo i dipendenti in base al loro livello
    }

}
