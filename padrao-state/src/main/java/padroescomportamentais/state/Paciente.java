package padroescomportamentais.state;

public class Paciente {

    private String nome;
    private PacienteEstado estado;

    public Paciente() {
        this.estado = PacienteEstadoAguardandoAtendimento.getInstance();
    }

    public void setEstado(PacienteEstado estado) {
        this.estado = estado;
    }

    public boolean atender() {
        return estado.atender(this);
    }

    public boolean internar() {
        return estado.internar(this);
    }

    public boolean encaminharUti() {
        return estado.encaminharUti(this);
    }

    public boolean estabilizar() {
        return estado.estabilizar(this);
    }

    public boolean darAlta() {
        return estado.darAlta(this);
    }

    public boolean registrarObito() {
        return estado.registrarObito(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PacienteEstado getEstado() {
        return estado;
    }
}
