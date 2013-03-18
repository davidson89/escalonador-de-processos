package br.ufabc.edu.so.projetoFinal.Runner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map.Entry;

import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorFCFS;
import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;

public class Runner {

	public Runner() {
		try {
			List<Processo> processos = ToolsUtils.getListaProcessos(System.getProperty("user.dir")+ "/src/br/ufabc/edu/so/projetoFinal/Runner/processos.txt");
			ResultBuilder resultBuilder = new ResultBuilder();
			resultBuilder.print(processos);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new Runner();
	}

}
