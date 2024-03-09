package logica;

public class Horario {
    protected Doctor doctor;
    protected int contadorCitas;
    protected String horarioEscogido;
    public Horario (Doctor doctor, int contadorCitas, String horarioEscogido) {
        this.doctor = doctor;
        this.contadorCitas = contadorCitas;
        this.horarioEscogido = horarioEscogido;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public int getContadorCitas() {
        return contadorCitas;
    }
    public void setContadorCitas(int contadorCitas) {
        this.contadorCitas = contadorCitas;
    }
    public String getHorarioEscogido() {
        return horarioEscogido;
    }
    public void setHorarioEscogido(String horarioEscogido) {
        this.horarioEscogido = horarioEscogido;
    }
}
