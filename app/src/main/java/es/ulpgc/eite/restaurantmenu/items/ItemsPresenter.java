package es.ulpgc.eite.restaurantmenu.items;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;

/**
 * Created by Luis on marzo, 2022
 */
public class ItemsPresenter implements ItemsContract.Presenter {

  public static String TAG = "RestaurantMenu.ItemsPresenter";

  private WeakReference<ItemsContract.View> view;
  private ItemsState state;
  private ItemsContract.Model model;
  private AppMediator mediator;

  public ItemsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getItemsState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include some code if is necessary
    if (state == null) {
      state = new ItemsState();
    }
    SectionsToItemsState savedState = getStateFromPreviousScreen();
    if (savedState != null){

        model.onDataFromPreviousScreen(savedState.menuItem1,savedState.menuItem2);
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

      state.menu1 = model.getStoredData1();
      state.menu2 = model.getStoredData2();

    Log.e(TAG, "onResume()1");
      state.itemsSection = model.añadirMenus(state.itemsSection);
      //state.itemsSection.add(state.menu2);
    Log.e(TAG, "onResume()2");
      view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: include some code if is necessary
    view.get().navigateToPreviousScreen();
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
  public void onFirstBtnClicked() {
    Log.e(TAG, "onFirstBtnClicked()");

    // TODO: include some code if is necessary
    ItemsToSectionsState newState = new ItemsToSectionsState();
    newState.botonPulsado = 1;
    newState.itemSection = state.itemsSection.get(0);
    passStateToPreviousScreen(newState);
    onBackPressed();
  }

  @Override
  public void onSecondBtnClicked() {
    Log.e(TAG, "onSecondBtnClicked()");

    // TODO: include some code if is necessary
    ItemsToSectionsState newState = new ItemsToSectionsState();
    newState.botonPulsado = 2;
    newState.itemSection = state.itemsSection.get(1);
    passStateToPreviousScreen(newState);
    onBackPressed();
  }

  private SectionsToItemsState getStateFromPreviousScreen() {
    return mediator.getSectionsToItemsState();
  }

  private void passStateToPreviousScreen(ItemsToSectionsState state) {
    mediator.setItemsToSectionsState(state);
  }


  @Override
  public void injectView(WeakReference<ItemsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ItemsContract.Model model) {
    this.model = model;
  }

}
