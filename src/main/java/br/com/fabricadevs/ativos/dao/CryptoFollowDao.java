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
import br.com.fabricadevs.ativos.entity.CryptoFollow;
import br.com.fabricadevs.ativos.utils.DataBaseUtil;

@Service
public class CryptoFollowDao {

	@Autowired
	private DataBaseConfiguration dataSourceConfiguration;

	public Long createCrypto(CryptoFollow crypto) throws Exception {

		PreparedStatement prepStat = null;
		ResultSet rs = null;
		Connection conn = null;

		try {

			conn = DataBaseUtil.getDataSource(dataSourceConfiguration.getUrl(), dataSourceConfiguration.getUsername(),
					dataSourceConfiguration.getPassword()).getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(
					" INSERT INTO crypto_follow(crypto_id,higher_target_price,lower_target_price) VALUES (?,?,?)");

			prepStat = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);

			prepStat.setString(1, crypto.getCrypto().getId());

			prepStat.setDouble(2, crypto.getHigherTargetPrice());
			
			prepStat.setDouble(3, crypto.getLowerTargetPrice());
			
			prepStat.execute();
			rs = prepStat.getGeneratedKeys();
			if (rs.next()) {
				return rs.getLong(1);
			}

			return null;

		} catch (Exception e) {

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

	public void updateCrypto(CryptoFollow crypto, Long id) throws Exception {

		PreparedStatement prepStat = null;
		ResultSet rs = null;
		Connection conn = null;

		try {

			conn = DataBaseUtil.getDataSource(dataSourceConfiguration.getUrl(), dataSourceConfiguration.getUsername(),
					dataSourceConfiguration.getPassword()).getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(
					" UPDATE crypto_follow set crypto_id = ?,higher_target_price=?,lower_target_price=? where id = ?");

			prepStat = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);

			prepStat.setString(1, crypto.getCrypto().getId());

			prepStat.setDouble(2, crypto.getHigherTargetPrice());
			
			prepStat.setDouble(3, crypto.getLowerTargetPrice());
			
			prepStat.setLong(4, id);

			prepStat.executeUpdate();

		} catch (Exception e) {

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

	public List<CryptoFollow> findAll() throws Exception {
		PreparedStatement prepStat = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {

			conn = DataBaseUtil.getDataSource(dataSourceConfiguration.getUrl(), dataSourceConfiguration.getUsername(),
					dataSourceConfiguration.getPassword()).getConnection();
		
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT cf.id, cf.crypto_id, c.name, cf.higher_target_price,cf.lower_target_price FROM crypto_follow cf inner join cryptos c on cf.crypto_id = c.id ");
			
			prepStat = conn.prepareStatement(sql.toString());
			
			rs = prepStat.executeQuery();
			
			List<CryptoFollow> cryptoFollows = new ArrayList<CryptoFollow>();
			
			while(rs.next()) {
				Crypto crypto = new Crypto();
				crypto.setId(rs.getString("crypto_id"));
				crypto.setName(rs.getString("name"));
				CryptoFollow follow = new CryptoFollow();
				follow.setId(rs.getLong("id"));
				follow.setCrypto(crypto);
				follow.setHigherTargetPrice(rs.getDouble("higher_target_price"));
				follow.setLowerTargetPrice(rs.getDouble("lower_target_price"));
				cryptoFollows.add(follow);
			}
			
			return cryptoFollows;
			
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
