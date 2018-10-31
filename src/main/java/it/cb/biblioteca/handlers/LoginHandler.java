package it.cb.biblioteca.handlers;
import it.cb.biblioteca.dao.UtenteDao;
import it.cb.biblioteca.dto.UtenteDto;
import it.cb.biblioteca.exceptions.AuthenticationException;
import it.cb.biblioteca.exceptions.ConcurrentModificationException;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.exceptions.RegistrationException;
import it.cb.biblioteca.model.Bibliotecario;
import it.cb.biblioteca.model.Studente;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.services.UtenteService;
import it.cb.biblioteca.utils.UtenteUtils;

public class LoginHandler {

	public UtenteDto autentica(String username, String password) throws AuthenticationException, DataException {
		UtenteDto retUser = null;
		UtenteDao uD = new UtenteDao();
		UtenteVo retUserVo = uD.findUtenteByUsernameAndPassword(username, password);
		if (retUserVo == null) {
			throw new AuthenticationException(LoginHandler.class.getName(),
					ErrorCodes.ERROR_CODE_SECURITY_WRONG_LOGIN);
		}
		retUser = UtenteUtils.fromVoToDto(retUserVo);

		return retUser;
		
//		int selectedMenu = 0;
//		MenuHandler mH = new MenuHandler();
//		do{
//			mH.displayMenu(retUser);
//			try {
//				Scanner scanner = new Scanner(System.in);
//				String menuStr = scanner.nextLine();
//				int menu = Integer.parseInt(menuStr);
//				System.out.println("Seleziona l'azione: \n");
//			}catch(Exception ex) {
//		
//			System.out.println("Men� inesistente"+ex.getMessage());
//				
//			}}while(selectedMenu != 0);
			
		//return retUser;
	}
	
	public void registrazione(String nome, String cognome, String cf, String ruolo, String username, String password) throws AuthenticationException, DataException, RegistrationException, ConcurrentModificationException {
		//check condition
		if (nome == null & cognome==null & cf == null & ruolo == null & username==null & password == null ) {
			throw new RegistrationException(LoginHandler.class.getName(),
			ErrorCodes.ERROR_CODE_REGISTRATION_NULL_FIELD);
		}

		UtenteVo retUser = new UtenteVo();
		if(ruolo.equals("studente")) {
			retUser = new Studente(nome,cognome,cf,username,password);
			}else if(ruolo.equals("bibliotecario"))
			{
				retUser = new Bibliotecario(nome,cognome,cf,username,password);
			}
		
		
		UtenteService uS = new UtenteService();
		uS.insertUtente(retUser);		
	}

	
	
	public void openUserMenu(UtenteVo user) throws NumberFormatException, DataException {
		MenuHandler mH = new MenuHandler();
		mH.displayMenu(user);
	}

	private void setCurrentUser(UtenteVo currentUser) {
		//TO DO: 
		}
}
