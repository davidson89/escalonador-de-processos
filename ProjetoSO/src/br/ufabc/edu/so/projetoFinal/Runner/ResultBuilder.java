package br.ufabc.edu.so.projetoFinal.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import br.ufabc.edu.so.projetoFinal.escalonadores.Escalonador;
import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorFCFS;
import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorRRComPrioridade;
import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorRRSemPrioridade;
import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorSJFNaoPreemptivo;
import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorSJFPreemptivo;
import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;

/**
 * Classe responsavel por imprimir o resultado das execuções de cada algoritomo de escalonamento
 * @author davidson
 *
 */
public class ResultBuilder {

	private List<Escalonador> escalonadores;
	
	public ResultBuilder() {
		escalonadores = new ArrayList<Escalonador>();
		escalonadores.add(new EscalonadorFCFS());
		escalonadores.add(new EscalonadorRRComPrioridade());
		escalonadores.add(new EscalonadorRRSemPrioridade());
		escalonadores.add(new EscalonadorSJFNaoPreemptivo());
		escalonadores.add(new EscalonadorSJFPreemptivo());
	}
	
	/**
	 * Imprime o resultado de cada execução
	 * @param processos
	 */
	public void print(List<Processo> processos) {
		
		for (Escalonador escalonador : escalonadores) {
			List<Processo> procs = this.clonaLista(processos);
			ResultItem result = escalonador.execute(procs);
			System.out.println("Escalonador: " + escalonador.getName());
			this.printResult(result);
			System.out.println();
		}
	}
	
	/**
	 * Clona a lista de processos para que um escalonador não interfira no resultado de outro.
	 * @param procs processos a serem clonados
	 * @return uma nova lista identica a passada como parametro
	 */
	public List<Processo> clonaLista(List<Processo> procs) {
		List<Processo> processos = new ArrayList<Processo>();
		for (Processo processo : procs) {
			processos.add(processo.clone());
		}
		return processos;
	}
	
	public void printResult(ResultItem result) {
		System.out.println("Tempo médio de espera: " + result.getTempoMedioEspera());
		System.out.println("Tempo médio de retorno: " + result.getTempoMedioRetorno());
		System.out.println("Numero de trocas de contexto: " + result.getNumeroTrocas());
		System.out.println("Instante   -   Processo");
		for(Entry<String, Processo> entry : result.getDiagramaTempExex().entrySet()) {
			System.out.printf(" %s \t  %9s%d\n", entry.getKey(),"P", entry.getValue().getId());
		}
	}
	

}
