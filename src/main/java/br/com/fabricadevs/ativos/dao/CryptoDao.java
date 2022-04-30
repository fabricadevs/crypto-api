package br.com.fabricadevs.ativos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadevs.ativos.DataBaseConfiguration;
import br.com.fabricadevs.ativos.entity.Crypto;
import br.com.fabricadevs.ativos.utils.DataBaseUtil;

@Service
public class CryptoDao {

	@Autowired
	private DataBaseConfiguration dataSourceConfiguration;
	
	public void saveOrUpdate(Crypto crypto) throws Exception {
		
		PreparedStatement prepStat = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {

			conn = DataBaseUtil.getDataSource(dataSourceConfiguration.getUrl(), dataSourceConfiguration.getUsername(),
					dataSourceConfiguration.getPassword()).getConnection();
		
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT id FROM cryptos where id = ? ");
			
			prepStat = conn.prepareStatement(sql.toString());
			
			prepStat.setString(1, crypto.getId());
			
			rs = prepStat.executeQuery();
			
			if(!rs.next()) {
				createCrypto(crypto, conn);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			
			throw e;

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}

			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}

		}
	}

	private void createCrypto(Crypto crypto, Connection conn) throws Exception {
		
		PreparedStatement prepStat = null;
		
		try {

			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO cryptos VALUES (?,?)");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setString(1, crypto.getId());
			
			prepStat.setString(2, crypto.getName());
			 
			prepStat.execute();

		} catch (Exception e) {

			throw e;

		} finally {

			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (Exception e) {
				}
			}

		}
		
	}

	public List<Crypto> findAll() throws Exception {
		PreparedStatement prepStat = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {

			conn = DataBaseUtil.getDataSource(dataSourceConfiguration.getUrl(), dataSourceConfiguration.getUsername(),
					dataSourceConfiguration.getPassword()).getConnection();
		
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT id, name FROM cryptos order by name ");
			
			prepStat = conn.prepareStatement(sql.toString());
			
			rs = prepStat.executeQuery();
			
			List<Crypto> cryptos = new ArrayList<Crypto>();
			
			while(rs.next()) {
				Crypto crypto = new Crypto();
				crypto.setId(rs.getString("id"));
				crypto.setName(rs.getString("name"));
				cryptos.add(crypto);
			}
			
			return cryptos;
			
		} catch (Exception e) {

			e.printStackTrace();
			
			throw e;

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}

			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}

		}
		
	}
	
}
