package br.furb.semantico;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;

public class Acao31 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		for (String id : listaID) {
			if (ts.containsKey(id)) {
				throw new SemanticError(id + Messages.ALREADY_DECLARED,StringManipulationUtil.getRowError(token.getPosition(), input));
			}

			ts.put(id, tipo);
			codigo.add(".locals(" + tipo + " " + id + ")");
		}

		listaID = new ArrayList<String>();

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
