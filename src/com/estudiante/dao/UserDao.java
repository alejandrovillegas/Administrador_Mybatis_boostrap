package com.estudiante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import map.EstudiantesMapper;
import model.Estudiantes;
import model.EstudiantesExample;

import com.estudiante.model.user;
import com.estudiante.dao.DaoEstudiantes;
import com.estudiante.util.DbUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDao implements DaoEstudiantes {

    Connection connection=null;
    EstudiantesMapper estudiantesMapper;
	
	public UserDao(){
		connection = DbUtil.getConnection();
	     ApplicationContext beanFactoryMyBatis = new ClassPathXmlApplicationContext(new String[] {"/ConfigurationProperties.xml"});
	     estudiantesMapper = (EstudiantesMapper) beanFactoryMyBatis.getBean("EstudiantesMapper");
	     System.out.println("connectionnnection");
	}
	@Override
    public void addEmployee(Estudiantes employee) {
    // TODO Auto-generated method stub
    
        estudiantesMapper.insert(employee); 
    }

    @Override
    public void updateEmployee(Estudiantes employee) {
    // TODO Auto-generated method stub
        estudiantesMapper.updateByPrimaryKey(employee);
    }
    @Override
    public void deleteEmployee(Estudiantes employee) {
    // TODO Auto-generated method stub
       int id = employee.getId();
       estudiantesMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<Estudiantes> getAllEmployees() {
    // TODO Auto-generated method stub
        
        List<Estudiantes> employees = new ArrayList<Estudiantes>();
        EstudiantesExample estudiantesExample = new EstudiantesExample();
        employees= estudiantesMapper.selectByExample(estudiantesExample);
        return employees;
    }
    
    @Override
    public List<Estudiantes> getAllestudiantes(int id) {
    // TODO Auto-generated method stub
        
        List<Estudiantes> employees = new ArrayList<Estudiantes>();
        EstudiantesExample estudiantesExample = new EstudiantesExample();
        estudiantesExample.createCriteria().andIdEqualTo(id);
        employees= estudiantesMapper.selectByExample(estudiantesExample);
        return employees;
    }


    @Override
    public Estudiantes getEmployeeById(int id) {
   	 // TODO Auto-generated method stub

   	 Estudiantes employee = null;

   	 try{

   		 employee= estudiantesMapper.selectByPrimaryKey(id);

   	 }
   	 catch(Exception e){
   		 e.printStackTrace();
   	 }

   	 return employee;
    }
    
    @Override
    public List<Estudiantes> getAllestudiantesById(int id) {
        
        List<Estudiantes> employees = new ArrayList<Estudiantes>();
        EstudiantesExample estudiantesExample = new EstudiantesExample();
        estudiantesExample.createCriteria().andIdEqualTo(id);
        employees= estudiantesMapper.selectByExample(estudiantesExample);
        return employees;
    }
//private Connection connection;
//	public UserDao() {
//		connection = DbUtil.getConnection();
//	}
//	public void addUser(user user) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("insert into Estudiantes(id,nombre,n1,n2,n3,n4) values (?, ?, ?, ?, ?, ? )");
//			// Parameters start with 1
//			preparedStatement.setInt(1, user.getid());
//			preparedStatement.setString(2, user.getNombre());
//			preparedStatement.setDouble(3, user.getn1());
//			preparedStatement.setDouble(4, user.getn2());
//			preparedStatement.setDouble(5, user.getn3());
//			preparedStatement.setDouble(6, user.getn4());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//		
//	public void deleteUser(int id) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("delete from Estudiantes where id=?");
//			// Parameters start with 1
//			preparedStatement.setInt(1, id);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public void updateUser(user user) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update Estudiantes set nombre=?, n1=?, n2=?, n3=?, n4=?" + "where id=?");
//			// Parameters start with 1
//			
//			preparedStatement.setString(1, user.getNombre());
//			preparedStatement.setDouble(2, user.getn1());
//			preparedStatement.setDouble(3, user.getn2());
//			preparedStatement.setDouble(4, user.getn3());
//			preparedStatement.setDouble(5, user.getn4());
//			preparedStatement.setInt(6, user.getid());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public List<Estudiantes> getAllUsers() {
//		List<user> users = new ArrayList<user>();
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from Estudiantes");
//			while (rs.next()) {
//				user user = new user();
//				user.setid(rs.getInt("id"));
//				user.setNombre(rs.getString("nombre"));
//				user.setn1(rs.getInt("n1"));
//				user.setn2(rs.getInt("n2"));
//				user.setn3(rs.getInt("n3"));
//				user.setn4(rs.getInt("n4"));
//
//				users.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}
//	
//	public user getUserById(int userId) {
//		user user = new user();
//		try {
//			PreparedStatement preparedStatement = connection.
//					prepareStatement("select * from Estudiantes where id=?");
//			preparedStatement.setInt(1, userId);
//			ResultSet rs = preparedStatement.executeQuery();
//			if (rs.next()) {
//				user.setid(rs.getInt("id"));
//				user.setNombre(rs.getString("nombre"));
//				user.setn1(rs.getInt("n1"));
//				user.setn2(rs.getInt("n2"));
//				user.setn3(rs.getInt("n3"));
//				user.setn4(rs.getInt("n4"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}
//	
}
