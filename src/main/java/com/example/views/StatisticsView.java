package com.example.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value = "/statistics", layout = AppLayoutBasic.class)
@PageTitle("Statistics")
@PermitAll
public class StatisticsView extends VerticalLayout {
}
