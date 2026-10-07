package padroescomportamentais.state;

public class PacienteEstadoAguardandoAtendimento extends PacienteEstado {

    private PacienteEstadoAguardandoAtendimento() {};
    private static PacienteEstadoAguardandoAtendimento instance = new PacienteEstadoAguardandoAtendimento();
    public static PacienteEstadoAguardandoAtendimento getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Aguardando atendimento";
    }

    public boolean atender(Paciente paciente) {
        paciente.setEstado(PacienteEstadoEmAtendimento.getInstance());
        return true;
    }
}
