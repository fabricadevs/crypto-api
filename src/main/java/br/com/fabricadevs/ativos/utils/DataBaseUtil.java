package br.com.fabricadevs.ativos.utils;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataBaseUtil {

	private static DataSource dataSource;

	public static DataSource getDataSource(String ip, String porta, String banco, String name, String pass)
			throws PropertyVetoException {

		return getDataSource("jdbc:mysql://" + ip + ":" + porta + "/" + banco + "?autoReconnect=true", name, pass);

	}

	public static DataSource getDataSource(String url, String name, String pass) throws PropertyVetoException {

		if (dataSource == null) {
			
			BasicDataSource dataSourceBasic = new BasicDataSource();

			dataSourceBasic.setDriverClassName("com.mysql.jdbc.Driver");

			dataSourceBasic.setUsername(name);

			dataSourceBasic.setPassword(pass);

			dataSourceBasic.setUrl(url);

			dataSource = dataSourceBasic;
			
			return dataSource;

		} else {

			return dataSource;

		}

	}

}
