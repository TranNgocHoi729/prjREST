package com.xtel.connnectionPool;

import java.sql.Connection;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



public class HikariCPDataSource {
	private static HikariConfig hkrConfig = new HikariConfig();
	private static HikariDataSource hd;

	static {
		hkrConfig.setDriverClassName(DbConfiguration.DB_DRIVER);
		hkrConfig.setJdbcUrl(DbConfiguration.URL);
		hkrConfig.setUsername(DbConfiguration.USER_NAME);
		hkrConfig.setPassword(DbConfiguration.PASSWORD);
		hkrConfig.setMinimumIdle(DbConfiguration.DB_MIN_CONNECTIONS);
		hkrConfig.setMaximumPoolSize(DbConfiguration.DB_MAX_CONNECTIONS);
		hkrConfig.setIdleTimeout(100);
		hkrConfig.addDataSourceProperty("cachePrepStmts", "true");
		hkrConfig.addDataSourceProperty("prepStmtCacheSize", "250");
		hkrConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		hd = new HikariDataSource(hkrConfig);
	}

	public static Connection getConnection() throws Exception {
		return hd.getConnection();

	}
}
