package com.fatec.scel.model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Servico {
	/**
	 * valida o formato da data
	 *
	 * @param data no formato yyyy/MM/dd
	 * @return true se a data estiver no formato valido e false para formato
	 *         invalido
	 */
	public boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	/**
	 * Objetivo - verificar se houve atraso na devolucao
	 *
	 * @param umEmprestimo
	 * @return int < 0 se estiver atrasado e > 0 se estiver no prazo retorna nulo se
	 *         o objeto emprestimo é nulo.
	 */
	public Integer verificaAtraso(Emprestimo umEmprestimo) {
		if (umEmprestimo != null) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			DateTime dataAtual = fmt.parseDateTime(new DateTime().toString(fmt));
			DateTime dataDevolucao = fmt.parseDateTime(umEmprestimo.getDataDevolucao());
			int dias = Days.daysBetween(dataAtual, dataDevolucao).getDays();
			return dias;
		} else {
			return null;
		}
	}
}