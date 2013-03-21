package br.ufabc.edu.so.projetoFinal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufabc.edu.so.projetoFinal.model.Processo;

public class ToolsUtils {

	/**
	 * Gera os processos de um determinado arquivo
	 * @param fileName nome do arquivo contendo os processos
	 * @return Lista de processos
	 * @throws FileNotFoundException caso o arquivo não seja encontrado
	 * @throws RuntimeException caso o arquivo não esteja no padrão, para criação dos processos
	 */
	public static List<Processo> getListaProcessos(String fileName) throws FileNotFoundException, RuntimeException {
		try {
			Scanner scanner = new Scanner(new FileInputStream(fileName));
			List<Processo> processos = new ArrayList<Processo>();
			while (scanner.hasNextLine()) {
				String processo = scanner.nextLine();
				String[] values = processo.split(" ");
				if(values.length != 4) {
					scanner.close();
					throw new RuntimeException("Arquivo com formato incompativel para o mapeamento dos processos!");
				}
				int id = Integer.parseInt(values[0]);
				int hrCriacao = Integer.parseInt(values[1]);
				int duracao = Integer.parseInt(values[2]);
				int prioridade = Integer.parseInt(values[3]);
				processos.add(new Processo(id, hrCriacao, duracao, prioridade, false));
			}
			scanner.close();
			return processos;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Não foi possivel encontrar o arquivo: " + fileName);
		}
	}
	
	/**
	 * Calcula a media dos valores passados na lista
	 * @param valores valores a tirar a media
	 * @return resultado da media
	 */
	public static float getTempoMedio(List<Integer> valores) {
		int valorMedio = 0;
		for (Integer valor : valores) {
			valorMedio+=valor;
		}
		if(valores.size() == 0) {
			return 0;
		}
		return ((float)valorMedio/(float)valores.size());
	}
        
        	/**
	 * Clona a lista de processos para que um escalonador não interfira no resultado de outro.
	 * @param procs processos a serem clonados
	 * @return uma nova lista identica a passada como parametro
	 */
	public static List<Processo> clonaLista(List<Processo> procs) {
		List<Processo> processos = new ArrayList<Processo>();
		for (Processo processo : procs) {
			processos.add(processo.clone());
		}
		return processos;
	}

}
