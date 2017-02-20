package com.raj.shashi.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.raj.shashi.domain.Employee;

/**
 * @author vagrant
 *
 */
public class JdbcWrapper {
	private Connection conn;
	private Statement stmt;

	public JdbcWrapper() {
		conn = new ConnectionCheck().getConnection();
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Statement getStmt() {
		return stmt;
	}

	public Connection getConn() {
		return conn;
	}

	public int createRow(String query) {
		try {
			return getStmt().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Boolean createDatabase(String query) {
		try {
			return getStmt().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean createEmployeeRecord(Employee emp) {
		try {
			return getStmt().execute("Insert into EMP values('" + emp.getEmpId() + "','" + emp.getEmpName() + "','"
					+ emp.getGender() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Employee> getEmployeeById(String id) {
		try {
			mapper(getStmt().executeQuery("SELECT * From EMP where empId=22908930;"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Employee> getListOfEmployee() {
		try {
			return mapper(getStmt().executeQuery("SELECT * FROM EMP;"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> mapper(ResultSet result) {

		List<Employee> empList = new ArrayList<Employee>();
		try {
			while (result.next()) {
				String empId = result.getString("empId");
				String empName = result.getString("empName");
				String gender = result.getString("gender");
				empList.add(new Employee(empId, empName, gender));
			}
			return empList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
