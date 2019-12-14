package br.furb.semantico;

import br.furb.common.AnalysisError;

public class SemanticError extends AnalysisError {
	public SemanticError(String msg, int position, char character) {
		super(msg, position, character);
	}
	
	public SemanticError(String msg, int position) {
		super(msg, position);
	}

	public SemanticError(String msg) {
		super(msg);
	}
}
