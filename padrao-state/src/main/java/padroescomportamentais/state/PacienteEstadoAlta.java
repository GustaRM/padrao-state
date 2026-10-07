package padroescomportamentais.state;

public class PacienteEstadoAlta extends PacienteEstado {

    private PacienteEstadoAlta() {};
    private static PacienteEstadoAlta instance = new PacienteEstadoAlta();
    public static PacienteEstadoAlta getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Alta";
    }

}
