package it.cb.biblioteca.utils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

	public enum OrariBiblioteca {

		MONDAY(DayOfWeek.MONDAY,"09:30","12:00","14:00","19:00"),
		TUESDAY(DayOfWeek.TUESDAY,"09:30","12:00","14:00","19:00"),
		WEDNESDAY(DayOfWeek.WEDNESDAY,"09:30","12:00","14:00","19:00"),
		THURSDAY(DayOfWeek.THURSDAY,"09:30","12:00","14:00","19:00"),
		FRIDAY(DayOfWeek.FRIDAY,"09:30","12:00","14:00","19:00"),
		SATURDAY(DayOfWeek.SATURDAY,"09:30","12:00","14:00","19:00");
		
		private final DayOfWeek giornoSettimana;
		private final String aperturaMattina;
		private final String chiusuraMattina;
		private final String aperturaPomeriggio;
		private final String chiusuraPomeriggio;
		
		private OrariBiblioteca(DayOfWeek giornoSettimana,String aMattina, String cMattina, String aPomeriggio, String cPomeriggio) {
			this.giornoSettimana=giornoSettimana;
			this.aperturaMattina = aMattina;
			this.chiusuraMattina = cMattina;
			this.aperturaPomeriggio = aPomeriggio;
			this.chiusuraPomeriggio = cPomeriggio;
		}
		
		public static boolean isOpen(LocalDateTime now) {
			LocalDate nowDate=now.toLocalDate();
			LocalTime nowTime=now.toLocalTime();
			if (nowDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				System.out.println("La biblioteca � chiusa");
				return false;
			}
			for(OrariBiblioteca e: OrariBiblioteca.values())
			{
				if(nowDate.getDayOfWeek().equals(e.giornoSettimana)) {
					if ( (nowTime.isAfter(LocalTime.parse(e.aperturaMattina))) && (nowTime.isBefore(LocalTime.parse(e.chiusuraMattina))) || 
							(nowTime.isAfter(LocalTime.parse(e.aperturaPomeriggio))) && (nowTime.isBefore(LocalTime.parse(e.chiusuraPomeriggio))) )
					{
						System.out.println("Accesso al menu noleggio consentito");
						return true;
					}
				}
			}
			System.out.println("La biblioteca � chiusa");
			return false;
		}
		public String getaMattina() {
			return aperturaMattina;
		}

		public String getcMattina() {
			return chiusuraMattina;
		}

		public String getaPomeriggio() {
			return aperturaPomeriggio;
		}

		public String getcPomeriggio() {
			return chiusuraPomeriggio;
		}
		
		
		
	}

