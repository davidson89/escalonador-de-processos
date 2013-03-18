package br.ufabc.edu.so.projetoFinal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufabc.edu.so.projetoFinal.model.Processo;

public class ToolsUtils {

	public static List<Processo> getListaProcessos(String fileName) throws FileNotFoundException {
		try {
			Scanner scanner = new Scanner(new FileInputStream(fileName));
			List<Processo> processos = new ArrayList<Processo>();
			while (scanner.hasNextLine()) {
				String processo = scanner.nextLine();
				String[] values = processo.split(" ");
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
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException("Arquivo com formato incompativel para o mapeamento dos processos!");
		}
	}
	
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

}
