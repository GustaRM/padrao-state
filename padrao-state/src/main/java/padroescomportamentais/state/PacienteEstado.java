package padroescomportamentais.state;

public abstract class PacienteEstado {

    public abstract String getEstado();

    public boolean atender(Paciente paciente) {
        return false;
    }

    public boolean internar(Paciente paciente) {
        return false;
    }

    public boolean encaminharUti(Paciente paciente) {
        return false;
    }

    public boolean estabilizar(Paciente paciente) {
        return false;
    }

    public boolean darAlta(Paciente paciente) {
        return false;
    }

    public boolean registrarObito(Paciente paciente) {
        return false;
    }
}
