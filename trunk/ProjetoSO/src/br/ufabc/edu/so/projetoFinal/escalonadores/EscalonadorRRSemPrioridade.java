package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.util.List;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EscalonadorRRSemPrioridade implements Escalonador {

	int quantum = 2;
	LinkedList<Processo> listaProcesso;
	Map<Integer, Processo> diagramaTempExex;

	@Override
	public ResultItem execute(List<Processo> processos) {

		if (processos.isEmpty())
			return new ResultItem();

		diagramaTempExex = new HashMap<Integer, Processo>();

		//
		int numeroTrocas = 0;

		//
		Map<Processo, Integer> procTmpEspMap = new HashMap<Processo, Integer>();
		Map<Processo, Integer> procTmpRetMap = new HashMap<Processo, Integer>();

		int count = processos.size();
		// quantos processos terminaram
		int prontos = 0;
		// tempo atual
		int tempo = 0;
		// contador do quantum
		int tempoQuantum = 0;
		// lista ligada de processos
		listaProcesso = listaProcesso(processos);
		// pega o primeiro processo
		Processo atual = listaProcesso.pop();

		while (count != prontos) {

			// testes
			System.out.println("Processando: " + atual.getId() + " " + atual.getDuracao());
			System.out.println(atual.getProcessado() - 1 + " " + tempoQuantum + " " + tempo);

			diagramaTempExex.put(tempo, atual);

			// processa o processo atual e diminui em 1 o seu processado
			atual.setProcessado(atual.getProcessado() - 1);

			// incrementa quamtum e tempo
			tempoQuantum++;
			tempo++;

			// se quantum ja atingiu o valor de parametro ou o processo ja
			// terminou sua duraçao ( processado)
			if (tempoQuantum == quantum || atual.getProcessado() == 0) {
				// se nao terminou de ser processado vai para o fim da fila
				if (atual.getProcessado() != 0) {
					listaProcesso.addLast(atual);
				}
				// se ja terminou , nao entra na fila novamente e é marcado como
				// pronto
				else {
					atual.setFinished(true);
					int espera = tempo - atual.getDuracao() - atual.getHrCriacao();
					int retorno = atual.getDuracao() + espera;
					procTmpEspMap.put(atual, espera);
					procTmpRetMap.put(atual, retorno);

					prontos++;
				}

				numeroTrocas++;

				// zera quantum para o proximo processo
				tempoQuantum = 0;

				// se cabaou os processos , sai do loop
				if (listaProcesso.isEmpty())
					break;

				// caso contrario pega o primeiro da lista
				atual = listaProcesso.pop();
			}
		}

		float tmpMedioEsp = ToolsUtils.getTempoMedio(new ArrayList<Integer>(procTmpEspMap.values()));
		float tmpMediRetorno = ToolsUtils.getTempoMedio(new ArrayList<Integer>(procTmpRetMap.values()));

		return new ResultItem(tmpMedioEsp, tmpMediRetorno, numeroTrocas, diagramaTempExex);
	}

	// pega a lista de processos e faz um copia da mesma em linked list
	public LinkedList<Processo> listaProcesso(List<Processo> processos) {
		LinkedList<Processo> pro = new LinkedList<Processo>();
		for (int i = 0; i < processos.size(); i++) {
			Processo p = processos.get(i);
			int id = p.getId();
			int hrCriacao = p.getHrCriacao();
			int duracao = p.getDuracao();
			int prioridade = p.getPrioridade();
			Processo novo = new Processo(id, hrCriacao, duracao, prioridade);
			pro.add(novo);
		}

		return pro;

	}

	@Override
	public String getName() {
		return "RR sem Prioridade";
	}

}
