package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;
import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuItems;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsPresenter implements SectionsContract.Presenter {

  public static String TAG = "RestaurantMenu.SectionsPresenter";

  private WeakReference<SectionsContract.View> view;
  private SectionsState state;
  private SectionsContract.Model model;
  private AppMediator mediator;

  public SectionsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getSectionsState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include some code if is necessary

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include some code if is necessary
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onStartersBtnClicked() {
    Log.e(TAG, "onStartersBtnClicked()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onMainCoursesBtnClicked() {
    Log.e(TAG, "onMainCoursesBtnClicked()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDessertsBtnClicked() {
    Log.e(TAG, "onDessertsBtnClicked()");

    // TODO: include some code if is necessary
    //MenuItems desserts = new MenuItems();
    MenuItem dessert1 = new MenuItem();
    MenuItem dessert2 = new MenuItem();
    Log.e(TAG, "onStartersBtnClicked()1");

    dessert1.itemName = "First Dessert";
    dessert1.itemPrice = 7;

    dessert2.itemName = "Second Dessert";
    dessert2.itemPrice= 8;

    Log.e(TAG, "onStartersBtnClicked()3");
    //desserts.itemsDesserts.add(dessert1);
    //desserts.itemsDesserts.add(dessert2);
    state.menuItemD1 = dessert1;
    state.menuItemD2 = dessert2;

    Log.e(TAG, "onStartersBtnClicked()4");
    SectionsToItemsState newState = new SectionsToItemsState();
    //newState.itemsSection = desserts.itemsDesserts;
    newState.menuItem1=state.menuItemD1;
    newState.menuItem2=state.menuItemD2;

    Log.e(TAG, "onStartersBtnClicked()5");
    passStateToNextScreen(newState);
    Log.e(TAG, "onStartersBtnClicked()6");
    view.get().navigateToNextScreen();
  }

  private void passStateToNextScreen(SectionsToItemsState state) {
    mediator.setSectionsToItemsState(state);
  }

  @Override
  public void injectView(WeakReference<SectionsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SectionsContract.Model model) {
    this.model = model;
  }

}
