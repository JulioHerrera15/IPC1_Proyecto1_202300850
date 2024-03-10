package logica;


public class Cita{
    private String especialidad;
    private String doctor;
    private String fecha;
    private String hora;
    private String motivo;
    private String paciente;
    private String codigoPaciente;
    public String codigoDoctor;

    public Cita(String fecha,String hora,String paciente, String motivo,  String especialidad, String doctor, String codigoPaciente, String codigoDoctor){
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.motivo = motivo;        
        this.especialidad = especialidad;
        this.doctor = doctor;
        this.codigoPaciente = codigoPaciente;
        this.codigoDoctor = codigoDoctor;
        
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public String getDoctor(){
        return doctor;
    }

   public String getPaciente(){
        return paciente;
    }

    
    public String getFecha(){
        return fecha;
    }

    public String getHora(){
        return hora;
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

    public void setFecha(String horario){
        this.fecha = horario;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public void setMotivo(String motivo){
        this.motivo = motivo;
    }

    public void setPaciente(String paciente){
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
            "fecha=" + fecha +
            ", hora=" + hora +
            ", paciente=" + paciente +
            ", motivo=" + motivo +
            ", especialidad=" + especialidad +
            ", doctor=" + doctor +
            ", codigoDoctor=" + codigoDoctor +
            '}';
    }

    public String getCodigoDoctor(){
        return codigoDoctor;
    }

    public void setCodigoDoctor(String codigoDoctor){
        this.codigoDoctor = codigoDoctor;
    }

    public String getCodigoPaciente(){
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente){
        this.codigoPaciente = codigoPaciente;
    }
    
}
