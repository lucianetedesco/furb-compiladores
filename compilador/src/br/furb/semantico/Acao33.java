package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;
import br.furb.utils.Types64;

public class Acao33 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String lexeme = token.getLexeme();

		if (!ts.containsKey(lexeme)) {
			throw new SemanticError(lexeme + Messages.NOT_DECLARED,
					StringManipulationUtil.getRowError(token.getPosition(), input));
		}

		String tipoID = ts.get(lexeme);
		pilhaDeTipos.push(tipoID);
		codigo.add("ldloc " + lexeme);

		if (tipoID.equals(Types64.INT)) {
			codigo.add("conv.r8");
		}

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
