package br.furb.semantico;

import br.furb.common.Token;
import br.furb.utils.StringManipulationUtil;

public class SemanticStaticUtils {

	public static void throwSemanticException(String tipo1, String tipo2, String mensagemErro, Token token, String input)
			throws SemanticError {
		if (verificarTipoInvalido(tipo1, tipo2)) {
			throw new SemanticError(mensagemErro, StringManipulationUtil.getRowError(token.getPosition(), input));
		}
	}
	
	private static boolean verificarTipoInvalido(String tipo1, String tipo2) {
		return "bool".equalsIgnoreCase(tipo1) || "bool".equalsIgnoreCase(tipo2) || "string".equalsIgnoreCase(tipo1)
				|| "string".equalsIgnoreCase(tipo2);
	}
}
