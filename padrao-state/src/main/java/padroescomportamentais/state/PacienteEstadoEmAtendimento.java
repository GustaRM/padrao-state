package padroescomportamentais.state;

public class PacienteEstadoEmAtendimento extends PacienteEstado {

    private PacienteEstadoEmAtendimento() {};
    private static PacienteEstadoEmAtendimento instance = new PacienteEstadoEmAtendimento();
    public static PacienteEstadoEmAtendimento getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em atendimento";
    }

    public boolean internar(Paciente paciente) {
        paciente.setEstado(PacienteEstadoInternado.getInstance());
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
