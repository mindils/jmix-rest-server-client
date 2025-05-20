package com.company.server.view.order;

import com.company.server.entity.Order;
import com.company.server.view.main.MainView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.selection.MultiSelectionEvent;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.component.PaginationComponent;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.component.layout.ViewLayout;
import io.jmix.flowui.component.pagination.SimplePagination;
import io.jmix.flowui.facet.SettingsFacet;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.view.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;


@Route(value = "orders", layout = MainView.class)
@ViewController("bgxlsx_Order.list")
@ViewDescriptor("order-list-view.xml")
@LookupComponent("ordersDataGrid")
@DialogMode(width = "64em")
public class OrderListView extends StandardListView<Order> {
  private static final Logger log = LoggerFactory.getLogger(OrderListView.class);
  @Autowired
  private DataManager dataManager;

  @ViewComponent
  private DataGrid<Order> ordersDataGrid;

  protected Map<Object, Order> crossPageSelection = new HashMap<>();

  private int generateSize = 10000;
  @ViewComponent
  private Span notificationBadge;
  @ViewComponent
  private CollectionContainer<Order> ordersDc;
  @ViewComponent
  private SettingsFacet settings;

  @Subscribe
  public void onInit(final InitEvent event) {

//    ViewLayout content = getContent();
//     getContent().getOwnComponent("ordersDataGrid");
//        List<Order> orders = new ArrayList<>(generateSize);
//        for (int i = 0; i < generateSize; i++) {
//            Order order = dataManager.create(Order.class);
//            order.setNumber(RandomStringUtils.randomAlphabetic(10));
//            order.setDate(LocalDate.now());
//            order.setDescription(RandomStringUtils.randomAlphabetic(20));
//            order.setTotalCount(i);
//            orders.add(order);
//        }
//        dataManager.saveAll(orders);
  }
}