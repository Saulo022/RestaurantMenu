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

  public MenuItem menuItemD1;
  public MenuItem menuItemD2;

  MenuItems desserts = new MenuItems();

  public Integer priceMenu = 0;
}
