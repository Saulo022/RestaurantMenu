package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
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
    if (state == null) {
      state = new SectionsState();
    }
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
    ItemsToSectionsState savedState = getStateFromNextScreen();
    if (savedState != null){
      if(savedState.botonPulsado == 1){
        if (savedState.itemSection.itemName=="First Starter"){
          Log.e(TAG, "onStart()"+savedState.itemSection.itemName);
          state.itemStarters = model.getStoredData(savedState.itemSection);
        } else if (savedState.itemSection.itemName=="First Main Course"){
          state.itemMainCourses = model.getStoredData(savedState.itemSection);
        } else if (savedState.itemSection.itemName=="First Dessert"){
          state.itemDesserts = model.getStoredData(savedState.itemSection);
        }
      }

    }
    view.get().onDataUpdated(state);
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
    MenuItem starter1 = new MenuItem();
    MenuItem starter2 = new MenuItem();
    Log.e(TAG, "onStartersBtnClicked()1");

    starter1.itemName = "First Starter";
    starter1.itemPrice = 10;

    starter2.itemName = "Second Starter";
    starter2.itemPrice= 9;

    Log.e(TAG, "onStartersBtnClicked()3");
    //desserts.itemsDesserts.add(dessert1);
    //desserts.itemsDesserts.add(dessert2);
    state.itemStarters1 = starter1;
    state.itemStarters2 = starter2;

    Log.e(TAG, "onStartersBtnClicked()4");
    SectionsToItemsState newState = new SectionsToItemsState();
    //newState.itemsSection = desserts.itemsDesserts;
    newState.menuItem1=state.itemStarters1;
    newState.menuItem2=state.itemStarters2;

    Log.e(TAG, "onStartersBtnClicked()5");
    passStateToNextScreen(newState);
    Log.e(TAG, "onStartersBtnClicked()6");
    view.get().navigateToNextScreen();
  }

  @Override
  public void onMainCoursesBtnClicked() {
    Log.e(TAG, "onMainCoursesBtnClicked()");

    // TODO: include some code if is necessary
    MenuItem mainCourse1 = new MenuItem();
    MenuItem mainCourse2 = new MenuItem();
    Log.e(TAG, "onMainCoursesBtnClicked()1");

    mainCourse1.itemName = "First Main Course";
    mainCourse1.itemPrice = 15;

    mainCourse2.itemName = "Second Main Course";
    mainCourse2.itemPrice= 18;

    Log.e(TAG, "onMainCoursesBtnClicked()3");
    //desserts.itemsDesserts.add(dessert1);
    //desserts.itemsDesserts.add(dessert2);
    state.itemMainCourses1 = mainCourse1;
    state.itemMainCourses2 = mainCourse2;

    Log.e(TAG, "onMainCoursesBtnClicked()4");
    SectionsToItemsState newState = new SectionsToItemsState();
    //newState.itemsSection = desserts.itemsDesserts;
    newState.menuItem1=state.itemMainCourses1;
    newState.menuItem2=state.itemMainCourses2;

    Log.e(TAG, "onMainCoursesBtnClicked()5");
    passStateToNextScreen(newState);
    Log.e(TAG, "onMainCoursesBtnClicked()6");
    view.get().navigateToNextScreen();
  }

  @Override
  public void onDessertsBtnClicked() {
    Log.e(TAG, "onDessertsBtnClicked()");

    // TODO: include some code if is necessary
    //MenuItems desserts = new MenuItems();
    MenuItem dessert1 = new MenuItem();
    MenuItem dessert2 = new MenuItem();
    Log.e(TAG, "onDessertssBtnClicked()1");

    dessert1.itemName = "First Dessert";
    dessert1.itemPrice = 7;

    dessert2.itemName = "Second Dessert";
    dessert2.itemPrice= 8;

    Log.e(TAG, "onDessertsBtnClicked()3");
    //desserts.itemsDesserts.add(dessert1);
    //desserts.itemsDesserts.add(dessert2);
    state.menuItemD1 = dessert1;
    state.menuItemD2 = dessert2;

    Log.e(TAG, "onDessertssBtnClicked()4");
    SectionsToItemsState newState = new SectionsToItemsState();
    //newState.itemsSection = desserts.itemsDesserts;
    newState.menuItem1=state.menuItemD1;
    newState.menuItem2=state.menuItemD2;

    Log.e(TAG, "onDessertssBtnClicked()5");
    passStateToNextScreen(newState);
    Log.e(TAG, "onDessertsBtnClicked()6");
    view.get().navigateToNextScreen();
  }

  private void passStateToNextScreen(SectionsToItemsState state) {
    mediator.setSectionsToItemsState(state);
  }

  private ItemsToSectionsState getStateFromNextScreen() {
    return mediator.getItemsToSectionsState();
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
