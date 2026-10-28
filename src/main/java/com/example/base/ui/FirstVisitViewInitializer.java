package com.example.base.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

/** Adds a temporary class to a view the first time it is visited in a browser tab. */
@org.springframework.stereotype.Component
final class FirstVisitViewInitializer implements VaadinServiceInitListener {

    private static final int FIRST_VISIT_DURATION_MS = 2_000;

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiInitEvent -> uiInitEvent.getUI()
                .addAfterNavigationListener(navigationEvent -> navigationEvent.getActiveChain().stream()
                        .filter(Component.class::isInstance)
                        .map(Component.class::cast)
                        .filter(component -> component.getClass().isAnnotationPresent(Route.class))
                        .forEach(this::markFirstVisit)));
    }

    private void markFirstVisit(Component view) {
        view.getElement().executeJs("""
                const storageKey = 'first-visit:' + $0;
                if (window.sessionStorage.getItem(storageKey) === null) {
                  window.sessionStorage.setItem(storageKey, 'true');
                  this.classList.add('first-visit');
                  window.setTimeout(() => this.classList.remove('first-visit'), $1);
                }
                """, view.getClass().getName(), FIRST_VISIT_DURATION_MS);
    }
}
