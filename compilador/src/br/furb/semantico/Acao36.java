package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;

public class Acao36 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String idCase36 = listaID.get(0);

		if (!ts.containsKey(idCase36)) {
			throw new SemanticError(idCase36 + Messages.NOT_DECLARED,
					StringManipulationUtil.getRowError(token.getPosition(), input));
		}

		operadorRelacional = token.getLexeme();

		if (operadorRelacional.equalsIgnoreCase("+=") || operadorRelacional.equalsIgnoreCase("-=")) {
			codigo.add("ldloc " + idCase36);
			codigo.add("conv.r8");
		}

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
