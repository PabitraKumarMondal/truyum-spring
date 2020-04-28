package com.cognizant.truyum;

import java.util.List;
import java.util.Set;

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
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    	MenuItemService service = (MenuItemService) context.getBean("menuItemService");
    	List<MenuItem> adminList = service.getMenuItemListAdmin();
    	System.out.println(adminList);
    }
}
