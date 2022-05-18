package es.ulpgc.eite.restaurantmenu.sections;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuItems;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsViewModel {

  // put the view state here
  public MenuItem itemStarters;
  public MenuItem itemMainCourses;
  public MenuItem itemDesserts;

  public MenuItem itemStarters1;
  public MenuItem itemStarters2;

  public MenuItem itemMainCourses1;
  public MenuItem itemMainCourses2;

  public MenuItem menuItemD1;
  public MenuItem menuItemD2;

  MenuItems desserts = new MenuItems();

  public Integer priceMenu1 = 0;
  public Integer priceMenu2 = 0;
  public Integer priceMenu3 = 0;

  public Integer priceMenu = 0;
}
