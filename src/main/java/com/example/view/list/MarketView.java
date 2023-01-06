package com.example.view.list;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value = "/market", layout = AppLayoutBasic.class)
@PageTitle("Market")
@PermitAll
public class MarketView extends HorizontalLayout {
}
