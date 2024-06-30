package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {

    private final JdbcTemplate jdbcTemplate;
    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo getShippingInfo(Long id) {
        String sql = "SELCT * from shippingInfo where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public int checkShippingInfo() {
        String sql = "select count(*) from shippingInfo";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void changeShippingInfo(String status, Long id) {
        String sql = "UPDATE shippingInfo set status =? where id= ? ";
        jdbcTemplate.update(sql, status, id);
    }

    public void createShippingInfo(ShippingInfo info) {
        String sql = "INSERT INTO shippingInfo (id, status) VALUES (?, ?)";
        jdbcTemplate.update(sql, info.getId(), info.getStatus());
    }
}
