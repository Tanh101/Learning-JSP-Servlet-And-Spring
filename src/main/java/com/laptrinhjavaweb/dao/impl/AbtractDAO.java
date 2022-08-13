package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.jboss.weld.util.Types;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.mysql.cj.xdevapi.Type;

public class AbtractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demoservlet";
			Connection conn = DriverManager.getConnection(url, "root", "606902");
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pre = conn.prepareStatement(sql);
			setParameter(pre, parameters);
			rs = pre.executeQuery();
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				return null;
			}
		}
		return null;
	}

	private void setParameter(PreparedStatement pre, Object... parameters) {

		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					pre.setLong(index, (Long) (parameter));
				} else if (parameter instanceof String) {
					pre.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					pre.setInt(index, (int) parameter);
				} else if (parameter instanceof Boolean) {
					pre.setBoolean(index, (boolean) parameter);
				}else if(parameter instanceof Timestamp) {
					pre.setTimestamp(index, (Timestamp) parameter);
				}else if(parameter == null) {
					pre.setString(index, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();
			return id;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				return null;
			}
		}
		return id;
	}

}
