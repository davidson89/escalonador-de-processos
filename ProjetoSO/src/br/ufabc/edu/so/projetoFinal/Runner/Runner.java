package br.ufabc.edu.so.projetoFinal.Runner;

import java.io.FileNotFoundException;
import java.util.List;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;

public class Runner {

	public Runner(String urlFile) {
		try {
			
			List<Processo> processos = ToolsUtils.getListaProcessos(urlFile);
			ResultBuilder resultBuilder = new ResultBuilder();
			resultBuilder.print(processos);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Runner(args[0]);
	}

}
