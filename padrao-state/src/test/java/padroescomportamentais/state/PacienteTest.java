package padroescomportamentais.state;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    void setUp() {
        paciente = new Paciente();
        paciente.setNome("Maria Souza");
    }

    // ---------- estado inicial ----------

    @Test
    void estadoInicialEhAguardandoAtendimento() {
        assertEquals("Aguardando atendimento", paciente.getNomeEstado());
    }

    @Test
    void aguardandoAtendimentoSoPermiteAtender() {
        assertFalse(paciente.internar());
        assertFalse(paciente.encaminharUti());
        assertFalse(paciente.estabilizar());
        assertFalse(paciente.darAlta());
        assertFalse(paciente.registrarObito());
        assertEquals("Aguardando atendimento", paciente.getNomeEstado());
        assertTrue(paciente.atender());
    }

    // ---------- transições válidas ----------

    @Test
    void atenderLevaParaEmAtendimento() {
        assertTrue(paciente.atender());
        assertEquals("Em atendimento", paciente.getNomeEstado());
    }

    @Test
    void emAtendimentoPodeSerInternado() {
        paciente.atender();
        assertTrue(paciente.internar());
        assertEquals("Internado", paciente.getNomeEstado());
    }

    @Test
    void emAtendimentoPodeReceberAlta() {
        paciente.atender();
        assertTrue(paciente.darAlta());
        assertEquals("Alta", paciente.getNomeEstado());
    }

    @Test
    void internadoPodeIrParaUti() {
        paciente.atender();
        paciente.internar();
        assertTrue(paciente.encaminharUti());
        assertEquals("Em UTI", paciente.getNomeEstado());
    }

    @Test
    void utiPodeEstabilizarEVoltarParaInternado() {
        paciente.atender();
        paciente.internar();
        paciente.encaminharUti();
        assertTrue(paciente.estabilizar());
        assertEquals("Internado", paciente.getNomeEstado());
    }

    @Test
    void internadoPodeReceberAlta() {
        paciente.atender();
        paciente.internar();
        assertTrue(paciente.darAlta());
        assertEquals("Alta", paciente.getNomeEstado());
    }

    @Test
    void fluxoCompletoComPassagemPelaUti() {
        assertTrue(paciente.atender());
        assertTrue(paciente.internar());
        assertTrue(paciente.encaminharUti());
        assertTrue(paciente.estabilizar());
        assertTrue(paciente.darAlta());
        assertEquals("Alta", paciente.getNomeEstado());
    }

    @Test
    void obitoPodeSerRegistradoEmAtendimentoInternadoOuUti() {
        Paciente p1 = new Paciente();
        p1.atender();
        assertTrue(p1.registrarObito());
        assertEquals("Óbito", p1.getNomeEstado());

        Paciente p2 = new Paciente();
        p2.atender();
        p2.internar();
        assertTrue(p2.registrarObito());
        assertEquals("Óbito", p2.getNomeEstado());

        Paciente p3 = new Paciente();
        p3.atender();
        p3.internar();
        p3.encaminharUti();
        assertTrue(p3.registrarObito());
        assertEquals("Óbito", p3.getNomeEstado());
    }

    // ---------- transições inválidas ----------

    @Test
    void emAtendimentoNaoPodeIrDiretoParaUtiNemEstabilizar() {
        paciente.atender();
        assertFalse(paciente.encaminharUti());
        assertFalse(paciente.estabilizar());
        assertFalse(paciente.atender());
        assertEquals("Em atendimento", paciente.getNomeEstado());
    }

    @Test
    void internadoNaoPodeSerAtendidoNemInternadoNovamente() {
        paciente.atender();
        paciente.internar();
        assertFalse(paciente.atender());
        assertFalse(paciente.internar());
        assertFalse(paciente.estabilizar());
        assertEquals("Internado", paciente.getNomeEstado());
    }

    @Test
    void utiNaoPodeReceberAltaDireta() {
        paciente.atender();
        paciente.internar();
        paciente.encaminharUti();
        assertFalse(paciente.darAlta());
        assertFalse(paciente.internar());
        assertEquals("Em UTI", paciente.getNomeEstado());
    }

    @Test
    void altaEhEstadoFinal() {
        paciente.atender();
        paciente.darAlta();
        assertFalse(paciente.atender());
        assertFalse(paciente.internar());
        assertFalse(paciente.encaminharUti());
        assertFalse(paciente.estabilizar());
        assertFalse(paciente.darAlta());
        assertFalse(paciente.registrarObito());
        assertEquals("Alta", paciente.getNomeEstado());
    }

    @Test
    void obitoEhEstadoFinal() {
        paciente.atender();
        paciente.registrarObito();
        assertFalse(paciente.atender());
        assertFalse(paciente.internar());
        assertFalse(paciente.encaminharUti());
        assertFalse(paciente.estabilizar());
        assertFalse(paciente.darAlta());
        assertFalse(paciente.registrarObito());
        assertEquals("Óbito", paciente.getNomeEstado());
    }

    // ---------- estados como singletons ----------

    @Test
    void estadosSaoSingletons() {
        assertSame(PacienteEstadoInternado.getInstance(), PacienteEstadoInternado.getInstance());
        paciente.atender();
        paciente.internar();
        Paciente outro = new Paciente();
        outro.atender();
        outro.internar();
        assertSame(paciente.getEstado(), outro.getEstado());
    }

    @Test
    void pacientesTemEstadosIndependentes() {
        Paciente outro = new Paciente();
        paciente.atender();
        assertEquals("Em atendimento", paciente.getNomeEstado());
        assertEquals("Aguardando atendimento", outro.getNomeEstado());
    }
}
