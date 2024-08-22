package com.programandoascegas.agenda.services;

import com.programandoascegas.agenda.model.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
    }

    @Test
    void testCriar() {
        agenda.criar("Alice", "12345");
        Contato contato = agenda.ler("Alice");
        assertNotNull(contato);
        assertEquals("Alice", contato.getNome());
        assertEquals("12345", contato.getTelefone());
    }

    @Test
    void testLer() {
        agenda.criar("Bob", "67890");
        Contato contato = agenda.ler("Bob");
        assertNotNull(contato);
        assertEquals("Bob", contato.getNome());
        assertEquals("67890", contato.getTelefone());
    }

    @Test
    void testAtualizar() {
        agenda.criar("Charlie", "11111");
        boolean atualizado = agenda.atualizar("Charlie", "22222");
        assertTrue(atualizado);
        Contato contato = agenda.ler("Charlie");
        assertEquals("22222", contato.getTelefone());
    }

    @Test
    void testDeletar() {
        agenda.criar("Dave", "33333");
        boolean deletado = agenda.deletar("Dave");
        assertTrue(deletado);
        Contato contato = agenda.ler("Dave");
        assertNull(contato);
    }

    @Test
    void testListar() {
        agenda.criar("Eve", "44444");
        agenda.criar("Frank", "55555");
        assertEquals(2, agenda.listar().size());
    }
}
