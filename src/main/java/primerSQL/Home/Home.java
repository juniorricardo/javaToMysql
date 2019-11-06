package primerSQL.Home;
/**
 * 
 * @author Cina
 *
 */
public class Home {

	
	public static void main(String[] args) {

		ConectorDB miConector = new ConectorDB();
		miConector.testConexion();
		miConector.test2("employees");
		
	}

}
