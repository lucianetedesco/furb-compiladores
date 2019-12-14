package br.furb.sintatico;

import br.furb.common.AnalysisError;

public class SyntaticError extends AnalysisError {
	
	public SyntaticError(String msgEncontrado, int position, String character, String msgEsperado) {
		super(msgEncontrado + " " + ("$".equalsIgnoreCase(character) ? "fim de arquivo" : character) + " " + msgEsperado, position);
	}
	
	public SyntaticError(String msg, int position) {
		super(msg, position);
	}

	public SyntaticError(String msg) {
		super(msg);
	}
}
