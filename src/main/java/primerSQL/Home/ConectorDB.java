package primerSQL.Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorDB {

	private String usuario;
	private String contra;
	private String url;
	private Connection conexion;
	private Statement st;

	public ConectorDB() {
		this.usuario = "root";
		this.contra = "15903";
		this.url = "jdbc:mysql://localhost:3306/employees";
		this.st = null;
	}

	public ConectorDB(String login, String password, String url) {
		super();
		this.usuario = login;
		this.contra = password;
		this.url = url;
		this.st = null;
	}

	public Connection testConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, contra);
			if (conexion != null) {
				this.st = conexion.createStatement();
				System.out.println("[Success] La conexion con la base de datos fue exitosa.");
			} else
				System.out.println("[Error] Ocurrio un problema con la conexion con la base de datos.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexion;
	}


	/**
	 * {url}: de conexión para la base de datos mysql es 
	 * 		>>>		jdbc:mysql://localhost:3306/employees 		<<< 
	 * donde [jdbc] es la API, [mysql] es la base de datos, 
	 * [localhost] es el nombre del servidor en el que se ejecuta mysql, 
	 * tambien podemos usar la direccion IP , [3306] es el numero de puerto y
	 * [employees] es el nombre de la base de datos. Podemos usar cualquier base de
	 * datos, en tal caso, necesitamos reemplazar el sonoo con nuestro nombre de
	 * base de datos.
	 * 
	 */ 
	// Campos-> {employees.employees} [emp_no] [birth_date] [first_name] [last_name] [gender] [hire_date]
	
	/**
	 * Recibe por parametro el nombre de la base de datos a establer conexion
	 * @param db
	 */
	public void test2(String db) {
		System.out.println("-------- MySQL JDBC Conexion Prueba ------------");
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Controlador no encontrado !!");
            return;
        }
		System.out.println("MySQL JDBC Controlador detectado!");
        Connection connect = null;
		try {
            connect = DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/" + db, 
            		"root", 
            		"15903"
            		);
            System.out.println("[Success] Conexion SQL a la base de datos establecida!");
            
            /*
             *  Consulta*******************************************************************************************
             */
            ResultSet resultadoQuery = st.executeQuery(
						"select e.emp_no, e.first_name, e.last_name \r\n"+ 
						"from employees as e\r\n" + 
						"inner join titles as t\r\n" + 
						"on e.emp_no = t.emp_no\r\n" + 
						"where t.title= 'Engineer'\r\n" + 
						"and e.last_name = 'Benzmuller';"
						);
            
				System.out.println("ID\tNombre\t\tApellido");
				while (resultadoQuery.next())
					System.out.println(resultadoQuery.getInt(1) + "\t" + resultadoQuery.getString(2) + "\t\t"
							+ resultadoQuery.getString(3));
			//*****************************************************************************************************

        } catch (SQLException e) {
            System.out.println("[Error] La conexion fallo! Comprobar consola de salida");
            return;
        } 
		
		
		/**
		 * Cierra la conexion, exista o no una conexion establecida
		 */
		finally {
            try
            {
                if(connect != null)
                    connect.close();
                System.out.println("Conexion cerrada !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}
}
