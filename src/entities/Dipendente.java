package entities;

public class Dipendente {
    private double stipendioBase= 1000;
    private int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

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

    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public Dipendente(int matricola,Dipartimento dipartimento ) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio= stipendioBase;
        this.importoOrarioStraordinario =30;
        this.livello= Livello.OPERAIO;
    }
    public Dipendente(int matricola, double stipendio, Livello livello, Dipartimento dipartimento)∏{
        this.stipendio= stipendio;
        this.importoOrarioStraordinario =importoOrarioStraordinario;
    }

    public void stampaDatiDipendente(){
        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio Base: " + stipendioBase);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Importo Orario Straordinario: " + importoOrarioStraordinario);
        System.out.println("Livello: " + livello);
        System.out.println("Dipartimento: " + dipartimento);
    }
    public void promuovi(){
        if(this.livello==Livello.OPERAIO){
            this.livello = Livello.IMPIEGATO;
            this.stipendioBase= stipendioBase*1.2;
        } else if (this.livello==Livello.IMPIEGATO) {
            this.livello = Livello.QUADRO;
            this.stipendioBase= stipendioBase*1.5;
        } else if (this.livello==Livello.QUADRO) {
            this.livello = Livello.DIRIGENTE;
            this.stipendioBase= stipendioBase*2;
        } else {
            System.out.println("Error during promotion");
        }
        System.out.println("Il nuovo livello del dipendente è: "+ this.livello);
    }
    public static double calcolaPaga(Dipendente dipendente) {
        return dipendente.getStipendioBase();
    }
    public static double calcolaPaga(Dipendente dipendente, double oreStraordinario) {
        double pagaStraordinario = oreStraordinario * dipendente.getImportoOrarioStraordinario();
        return dipendente.getStipendioBase() + pagaStraordinario;
    }

}
