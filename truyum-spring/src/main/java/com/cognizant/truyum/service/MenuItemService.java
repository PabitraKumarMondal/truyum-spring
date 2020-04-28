package com.cognizant.truyum.service;

import java.util.List;
//import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service("menuItemService")
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);
	
	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin(){
		LOGGER.info("Start");
		//return menuItemDao.getMenuItemListAdmin();
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer(){		
		LOGGER.info("Start");
		return menuItemRepository.findAllCurrentActiveMenuItems();
	}
	
	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		LOGGER.info("End");		
	}
	
	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Start");
		return menuItemRepository.getOne(menuItemId);
	}
}
