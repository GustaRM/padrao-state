package padroescomportamentais.state;

public class Main {

    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        paciente.setNome("Maria Souza");

        System.out.println(paciente.getNome() + ": " + paciente.getNomeEstado());
        paciente.atender();
        System.out.println(paciente.getNome() + ": " + paciente.getNomeEstado());
        paciente.internar();
        System.out.println(paciente.getNome() + ": " + paciente.getNomeEstado());
        paciente.encaminharUti();
        System.out.println(paciente.getNome() + ": " + paciente.getNomeEstado());
        paciente.estabilizar();
        System.out.println(paciente.getNome() + ": " + paciente.getNomeEstado());
        paciente.darAlta();
        System.out.println(paciente.getNome() + ": " + paciente.getNomeEstado());
        System.out.println("Atender após alta? " + paciente.atender());
    }
}
