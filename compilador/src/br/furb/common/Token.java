package br.furb.common;

public class Token {
	private int id;
	private String lexeme;
	private int position;

	public String getClasse(int id) {

		if (id >= 7 && id <= 28) {
			return "palavra reservada";
		}

		if (id == 2) {
			return "identificador";
		}

		if (id == 3) {
			return "constante inteira";
		}

		if (id == 4) {
			return "constante real";
		}

		if (id == 5) {
			return "constante string";
		}

		if (id == 6) {
			return "constante caracter";
		}

		if (id > 28 || id <= 48) {
			return "símbolo especial";
		}

		return "";
	}

	public Token(int id, String lexeme, int position) {
		this.id = id;
		this.lexeme = lexeme;
		this.position = position;
	}

	public final int getId() {
		return id;
	}

	public final int getRow(String text) {

		String[] arrayLines = text.split("\n");
		int line = 0;
		int countLine = 0;

		for (int i = 0; i < arrayLines.length; i++) {

			arrayLines[i] += "\n";
			countLine += arrayLines[i].length();

			if (countLine > position) {
				line += i + 1;

				break;
			}
		}

		return line == 0 ? line + 1 : line;
	}

	public final String getLexeme() {
		return lexeme;
	}

	public final int getPosition() {
		return position;
	}

	public String toString() {
//        return id+" ( "+lexeme+" ) @ "+position;
		return "Erro na linha " + position + " - " + getClasse(id);
	};
}
