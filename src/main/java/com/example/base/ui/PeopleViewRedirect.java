package com.example.base.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("people")
public class PeopleViewRedirect extends Div implements BeforeEnterObserver {
  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    event.forwardTo("/people/directory");
  }
}
