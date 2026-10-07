package padroescomportamentais.state;

public class PacienteEstadoEmUti extends PacienteEstado {

    private PacienteEstadoEmUti() {};
    private static PacienteEstadoEmUti instance = new PacienteEstadoEmUti();
    public static PacienteEstadoEmUti getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em UTI";
    }

    public boolean estabilizar(Paciente paciente) {
        paciente.setEstado(PacienteEstadoInternado.getInstance());
        return true;
    }

    public boolean registrarObito(Paciente paciente) {
        paciente.setEstado(PacienteEstadoObito.getInstance());
        return true;
    }
}
