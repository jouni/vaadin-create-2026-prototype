package com.example.base.ui;

import com.example.LucideIcon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.sidenav.SideNavVariant;
import com.vaadin.flow.router.Layout;

@Layout
public final class MainLayout extends AppLayout {

    MainLayout() {
        UI.getCurrentOrThrow().addClassName("aura-accent-neutral");

        addToNavbar(new Div(
                createPrimaryNavigation(),
                createSecondaryNavigation(),
                createUserMenu()));
        addToDrawer(new Div(
                createPeopleNavigation(),
                createPayrollNavigation(),
                createFinanceNavigation(),
                createEngageNavigation()));
    }

    private SideNav createPrimaryNavigation() {
        var nav = new SideNav();
        nav.addThemeVariants(SideNavVariant.AURA_FILLED);
        nav.addItem(
                item("Home", "", LucideIcon.HOUSE, false),
                item("People", "people", LucideIcon.USERS, true),
                item("Payroll", "payroll", LucideIcon.SQUARE_PERCENT, true),
                item("Finance", "finance", LucideIcon.BANKNOTE, true),
                item("Engage", "engage", LucideIcon.TRENDING_UP, true),
                item("IT", "it", LucideIcon.LAPTOP, false),
                item("Reports", "reports", LucideIcon.CHART_NO_AXES_COLUMN, false),
                item("Automations", "automations", LucideIcon.ZAP, false));
        return nav;
    }

    private SideNav createSecondaryNavigation() {
        var nav = new SideNav();
        nav.setLabel("Secondary Navigation");
        nav.addThemeVariants(SideNavVariant.AURA_FILLED);
        nav.addItem(
                item("Admin", "admin", LucideIcon.COG, false),
                item("Users", "users", LucideIcon.USERS, false),
                item("Logs", "logs", LucideIcon.LOGS, false));
        return nav;
    }

    private Button createUserMenu() {
        var avatar = new Avatar("Vaadin");
        avatar.addThemeVariants(AvatarVariant.SMALL);
        var menuButton = new Button(avatar);
        menuButton.setAriaLabel("Open user menu");
        menuButton.addThemeVariants(ButtonVariant.TERTIARY);
        menuButton.addClassName("user-menu");

        ContextMenu menu = new ContextMenu(menuButton);
        menu.setOpenOnClick(true);
        menu.getElement().setProperty("position", "end-bottom");
        menu.addClassName("user-menu");

        // Workspace switcher
        Avatar workspaceAvatar = new Avatar("Vaadin");
        workspaceAvatar.addThemeVariants(AvatarVariant.XSMALL);
        // workspaceAvatar.setImage("images/vaadin-logo.png");

        MenuItem workspace = menu.addItem("Vaadin");
        workspace.addComponentAsFirst(workspaceAvatar);

        SubMenu accounts = workspace.getSubMenu();

        // Account header
        var email = new HorizontalLayout(LucideIcon.USER_CIRCLE.create(), new Span("jouni@vaadin.com"));
        email.setPadding(true);
        accounts.addComponent(email);

        // Workspace choices
        Avatar vaadinAvatar = new Avatar("Vaadin");
        vaadinAvatar.addThemeVariants(AvatarVariant.XSMALL);
        vaadinAvatar.setImage("images/vaadin-logo.png");

        MenuItem vaadin = accounts.addItem("Vaadin");
        vaadin.addComponentAsFirst(vaadinAvatar);

        Avatar personalAvatar = new Avatar("Jouni");
        personalAvatar.addThemeVariants(AvatarVariant.XSMALL);
        personalAvatar.setAbbreviation("JO");

        MenuItem personal = accounts.addItem("Personal account");
        personal.addComponentAsFirst(personalAvatar);

        vaadin.setCheckable(true);
        personal.setCheckable(true);
        vaadin.setChecked(true);

        vaadin.addClickListener(e -> {
            vaadin.setChecked(true);
            personal.setChecked(false);
        });

        personal.addClickListener(e -> {
            vaadin.setChecked(false);
            personal.setChecked(true);
        });

        // Account actions
        MenuItem createWorkspace = accounts.addItem("Create or join a workspace");
        createWorkspace.addComponentAsFirst(LucideIcon.PLUS.create());

        accounts.addSeparator();

        MenuItem addAccount = accounts.addItem("Add account");
        addAccount.addComponentAsFirst(LucideIcon.PLUS.create());

        // Main menu
        menu.addSeparator();

        MenuItem teammates = menu.addItem("Add teammates");
        teammates.addComponentAsFirst(LucideIcon.USERS.create());

        MenuItem workspaceSettings = menu.addItem("Workspace settings");
        workspaceSettings.addComponentAsFirst(LucideIcon.BUILDING_2.create());

        MenuItem personalization = menu.addItem("Personalization");
        personalization.addComponentAsFirst(LucideIcon.PALETTE.create());

        MenuItem profile = menu.addItem("Profile");
        profile.addComponentAsFirst(LucideIcon.CIRCLE_USER_ROUND.create());

        MenuItem settings = menu.addItem("Settings");
        settings.addComponentAsFirst(LucideIcon.SETTINGS.create());

        menu.addSeparator();

        // Help submenu
        MenuItem help = menu.addItem("Help");
        help.addComponentAsFirst(LucideIcon.LIFE_BUOY.create());

        SubMenu helpMenu = help.getSubMenu();
        helpMenu.addItem("Help center");
        helpMenu.addItem("Contact support");

        // Sign out
        MenuItem logout = menu.addItem("Log out");
        logout.addComponentAsFirst(LucideIcon.LOG_OUT.create());

        return menuButton;
    }

    private Component createPeopleNavigation() {
        var nav = sectionNavigation("People",
                item("Directory", "people/directory"),
                item("Org Chart", "people/org-chart"),
                item("Time Off", "people/time-off"),
                item("Onboarding", "people/onboarding"),
                item("Benefits", "people/benefits"),
                item("Compensation", "people/compensation"));

        var navWrapper = new Div(subNavToggle("people"), nav, new Hr(), new Button("Add Person", LucideIcon.USER_PLUS.create()));
        navWrapper.addClassNames("sub-nav", "people-navigation");
        return navWrapper;
    }

    private Component createPayrollNavigation() {
        var nav = sectionNavigation("Payroll",
                item("Cycles", "payroll/cycles"),
                item("Anytime Pay", "payroll/anytime-pay"),
                item("Tax Documents", "payroll/tax-documents"),
                item("Payroll Reports", "payroll/reports"),
                item("General Ledger", "payroll/ledger"));

        var navWrapper = new Div(subNavToggle("payroll"), nav);
        navWrapper.addClassNames("sub-nav", "payroll-navigation");
        return navWrapper;
    }

    private Component createFinanceNavigation() {
        var nav = sectionNavigation("Finance",
                item("Overview", "finance/overview"),
                item("Pay", "finance/pay"),
                item("Balances", "finance/balances"),
                item("Payment History", "finance/payment-history"),
                item("Billing", "finance/billing"),
                item("Expenses", "finance/expenses"),
                item("Contractor Adjustments", "finance/contractor-adjustments"),
                item("Expense Card", "finance/expense-card"),
                item("Liability Payments", "finance/liability-payments"),
                item("Liability Payment Dates", "finance/liability-payment-dates"));

        var navWrapper = new Div(subNavToggle("finance"), nav);
        navWrapper.addClassNames("sub-nav", "finance-navigation");
        return navWrapper;
    }

    private Component createEngageNavigation() {
        var nav = sectionNavigation("Engage",
                item("Hub", "engage/hub"),
                item("Reviews", "engage/reviews"),
                item("Goals", "engage/goals"),
                item("Learning", "engage/learning"),
                item("Career", "engage/career"),
                item("Development", "engage/development"),
                item("Surveys", "engage/surveys"),
                item("Templates", "engage/templates"));


        var navWrapper = new Div(subNavToggle("engage"), nav);
        navWrapper.addClassNames("sub-nav", "engage-navigation");
        return navWrapper;
    }

    private SideNav sectionNavigation(String label, SideNavItem... items) {
        var nav = new SideNav();
        nav.setLabel(label);
        nav.addItem(items);
        return nav;
    }

    private SideNavItem item(String label, String path) {
        var item =  new SideNavItem(label, path);
        item.setMatchNested(true);
        return item;
    }

    private SideNavItem item(String label, String path, LucideIcon icon, boolean hasDrawer) {
        var item = new SideNavItem(label, path, icon.create());
        item.setMatchNested(true);
        Tooltip.forComponent(item).withText(label).withHoverDelay(1500).withPosition(Tooltip.TooltipPosition.END)
                .withAriaLinkMode(Tooltip.AriaLinkMode.NONE);

        if (hasDrawer) {
            item.addClassNames("has-drawer", path.split("/")[0]);
        }
        return item;
    }

    private DrawerToggle subNavToggle(String route) {
        var toggle = new DrawerToggle();
        toggle.addThemeVariants(ButtonVariant.TERTIARY);
        toggle.addClickListener(e -> {
            var ui = UI.getCurrentOrThrow();
            String currentRoute = ui
                    .getInternals()
                    .getActiveViewLocation()
                    .getPath();

            if (!currentRoute.startsWith(route)) {
                UI.getCurrentOrThrow().navigate(route);
            }
        });
        return toggle;
    }
}
