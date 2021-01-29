package platformbuilders.io.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Idade {

	public static int calcular(Date dataNascimento) {
		int idade = 0;
		if (dataNascimento != null) 
			idade = Period.between(convertToLocalDateViaInstant(dataNascimento), LocalDate.now()).getYears();
		return idade;
	}

	private static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
