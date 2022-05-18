package es.ulpgc.eite.restaurantmenu.sections;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuItems;

/**
 * Created by Luis on marzo, 2022
 */
public interface SectionsContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void onDataUpdated(SectionsViewModel viewModel);
    void navigateToNextScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();
    void onStartersBtnClicked();
    void onMainCoursesBtnClicked();
    void onDessertsBtnClicked();
  }

  interface Model {
    MenuItems getStoredData();
    MenuItem getStoredData(MenuItem menuItem);
    void calcularPrecio(Integer c1,Integer c2,Integer c3);
    Integer obternetPrecio1(MenuItem menuItem);
    Integer obternetPrecio2(MenuItem menuItem);
    Integer obternetPrecio3(MenuItem menuItem);
    Integer getP();
  }

}
