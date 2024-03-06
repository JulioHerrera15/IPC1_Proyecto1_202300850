package logica;

public class Cita{
    private String especialidad;
    private String doctor;
    private String horario;
    private String motivo;

    public Cita(String especialidad, String doctor, String horario, String motivo){
        this.especialidad = especialidad;
        this.doctor = doctor;
        this.horario = horario;
        this.motivo = motivo;
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public String getDoctor(){
        return doctor;
    }

    public static boolean isCita(Cita citas2){
        
        throw new UnsupportedOperationException("Unimplemented method 'isCita'");
    }

    public String getHorario(){
        return horario;
    }

    public String getMotivo(){
        return motivo;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public void setDoctor(String doctor){
        this.doctor = doctor;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }

    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
    
}
