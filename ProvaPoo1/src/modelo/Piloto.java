package modelo;

public class Piloto extends Pessoa {

    private int matricula;
    private String aeronave;
    
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getAeronave() {
        return aeronave;
    }
    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

}