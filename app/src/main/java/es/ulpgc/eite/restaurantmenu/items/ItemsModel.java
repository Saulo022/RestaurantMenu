package es.ulpgc.eite.restaurantmenu.items;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsModel implements ItemsContract.Model {

  public static String TAG = "RestaurantMenu.ItemsModel";

  private List<MenuItem> data;
  private MenuItem m1;
  private MenuItem m2;


  public ItemsModel() {
    data=new ArrayList<>();
  }

  @Override
  public List<MenuItem> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }
  @Override
  public MenuItem getStoredData1() {
    // Log.e(TAG, "getStoredData()");
    return m1;
  }
  @Override
  public MenuItem getStoredData2() {
    // Log.e(TAG, "getStoredData()");
    return m2;
  }

  @Override
  public List<MenuItem> añadirMenus(List<MenuItem> lista){
    data.add(m1);
    data.add(m2);

    lista = data;

    return lista;
  }

  @Override
  public void onDataFromPreviousScreen(MenuItem itemsSection1,MenuItem itemsSection2) {
    Log.e(TAG, "onDataFromPreviousScreen()");
    m1 = itemsSection1;
    m2 = itemsSection2;
  }

}