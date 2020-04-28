package com.cognizant.truyum;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	LOGGER.info("Start");
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    	MenuItemService service = (MenuItemService) context.getBean("menuItemService");
    	List<MenuItem> menuList = service.getMenuItemListAdmin();
    	LOGGER.debug("Menu Items:{}", menuList);
    	//System.out.println(menuList);
    	LOGGER.info("End");
    }
}
