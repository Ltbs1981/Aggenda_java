package com.programandoascegas.agenda.services;

import com.programandoascegas.agenda.model.Contato;

import java.util.List;
import java.util.ArrayList;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    // Método para criar um novo contato
    public void criar(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
    }

    // Método para ler um contato pelo nome
    public Contato ler(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null; // Retorna null se o contato não for encontrado
    }

    // Método para atualizar um contato existente
    public boolean atualizar(String nome, String novoTelefone) {
        Contato contato = ler(nome);
        if (contato != null) {
            contato.setTelefone(novoTelefone);
            return true;
        }
        return false; // Retorna false se o contato não for encontrado
    }

    // Método para deletar um contato pelo nome
    public boolean deletar(String nome) {
        Contato contato = ler(nome);
        if (contato != null) {
            contatos.remove(contato);
            return true;
        }
        return false; // Retorna false se o contato não for encontrado
    }

    // Método para listar todos os contatos
    public List<Contato> listar() {
        return new ArrayList<>(contatos); // Retorna uma cópia da lista de contatos
    }
}
