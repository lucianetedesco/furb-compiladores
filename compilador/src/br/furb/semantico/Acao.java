package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;

public interface Acao {
	SemanticVariables execute(String tipo,
			String operadorRelacional,
			List<String> codigo,
			Map<String, String> ts,
			List<String> listaID,
			Deque<String> pilhaDeTipos,
			Deque<String> pilhaDeRotulos,
			int ctLabel,
			Token token, 
			String input) throws SemanticError;
}
