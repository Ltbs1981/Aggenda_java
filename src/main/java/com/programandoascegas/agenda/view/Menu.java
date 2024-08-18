package com.programandoascegas.agenda.view;

import com.programandoascegas.agenda.model.Contato;
import com.programandoascegas.agenda.services.Agenda;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Agenda agenda;

    public Menu() {
        this.agenda = new Agenda();
    }

    public void exibirMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\nMenu de Contatos:");
            System.out.println("1. Criar Contato");
            System.out.println("2. Ver Contato");
            System.out.println("3. Atualizar Contato");
            System.out.println("4. Deletar Contato");
            System.out.println("5. Exibir Lista de Contatos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomeCriar = teclado.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefoneCriar = teclado.nextLine();
                    agenda.criar(nomeCriar, telefoneCriar);
                    System.out.println("Contato criado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do contato para ver: ");
                    String nomeVer = teclado.nextLine();
                    Contato contato = agenda.ler(nomeVer);
                    if (contato != null) {
                        System.out.println("Nome: " + contato.getNome());
                        System.out.println("Telefone: " + contato.getTelefone());
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do contato para atualizar: ");
                    String nomeAtualizar = teclado.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = teclado.nextLine();
                    if (agenda.atualizar(nomeAtualizar, novoTelefone)) {
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do contato para deletar: ");
                    String nomeDeletar = teclado.nextLine();
                    if (agenda.deletar(nomeDeletar)) {
                        System.out.println("Contato deletado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 5:
                    List<Contato> contatos = agenda.listar();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        System.out.println("Lista de Contatos:");
                        for (Contato c : contatos) {
                            System.out.println("Nome: " + c.getNome() + ", Telefone: " + c.getTelefone());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        teclado.close();
    }
}
