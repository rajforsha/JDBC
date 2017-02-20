package com.raj.shashi.test;

import java.sql.SQLException;
import java.util.List;

import com.raj.shashi.connection.ConnectionCheck;
import com.raj.shashi.connection.JdbcWrapper;
import com.raj.shashi.domain.Employee;

/**
 * @author vagrant
 *
 */
public class JdbcTest {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		new ConnectionCheck().getConnection();
		// String table = "CREATE TABLE EMP (" + "empId VARCHAR(20) primary
		// key," + "empName Varchar (30) not null,"
		// + "gender varchar(7)" + ");";
		// boolean val = new JdbcWrapper().createTable(table);
		// if (val) {
		// System.out.println("EMP table created successfully");
		// } else {
		// System.out.println("failed.");
		// }

		// Employee e1 = new Employee("12234", "shashi", "male");
		// new JdbcWrapper().createEmployeeRecord(e1);
		List<Employee> empList = new JdbcWrapper().getListOfEmployee();
		empList.stream().forEach(ob -> {
			System.out.println(ob);
		});

		System.out.println(new JdbcWrapper().getEmployeeById("22908930"));
	}

}
