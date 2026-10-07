package padroescomportamentais.state;

public class PacienteEstadoInternado extends PacienteEstado {

    private PacienteEstadoInternado() {};
    private static PacienteEstadoInternado instance = new PacienteEstadoInternado();
    public static PacienteEstadoInternado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Internado";
    }

    public boolean encaminharUti(Paciente paciente) {
        paciente.setEstado(PacienteEstadoEmUti.getInstance());
        return true;
    }

    public boolean darAlta(Paciente paciente) {
        paciente.setEstado(PacienteEstadoAlta.getInstance());
        return true;
    }

    public boolean registrarObito(Paciente paciente) {
        paciente.setEstado(PacienteEstadoObito.getInstance());
        return true;
    }
}
