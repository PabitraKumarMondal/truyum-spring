package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	@Query("SELECT m FROM MenuItem m WHERE m.active = 'true' and m.dateOfLaunch <= CURDATE()")
	public List<MenuItem> findAllCurrentActiveMenuItems();
}
