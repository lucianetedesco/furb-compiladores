package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;
import br.furb.utils.Types64;

public class Acao34 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String idCase34 = listaID.get(0);
		listaID.remove(0);

		if (!ts.containsKey(idCase34)) {
			throw new SemanticError(idCase34 + Messages.NOT_DECLARED,
					StringManipulationUtil.getRowError(token.getPosition(), input));
		}

		String tipoIDCase34 = ts.get(idCase34);

		if (operadorRelacional.equalsIgnoreCase("+=")) {
			codigo.add("add");
		} else if (operadorRelacional.equalsIgnoreCase("-=")) {
			codigo.add("sub");
		}

		if (tipoIDCase34.equals(Types64.INT)) {
			codigo.add("conv.i8");
		}

		codigo.add("stloc " + idCase34);

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
