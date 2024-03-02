package com.example.exampledatabase.exampledatabase.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.exampledatabase.exampledatabase.model.Purchase;

@Repository
public class PurchaseRepository {

	private final JdbcTemplate jdbc;

	public PurchaseRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void storePurchase(Purchase purchase) {
		String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
		jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
	}

	public List<Purchase> findAllPurchase() {
		String sql = "SELECT * FROM PURCHASE";

		RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
			Purchase rowObject = new Purchase();
			rowObject.setId(r.getInt("id"));
			rowObject.setProduct(r.getString("product"));
			rowObject.setPrice(r.getBigDecimal("price"));
			return rowObject;
		};

		return jdbc.query(sql, purchaseRowMapper);
	}

}
