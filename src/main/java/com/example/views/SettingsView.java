package com.example.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value = "settings", layout = AppLayoutBasic.class)
@PageTitle("Settings")
@PermitAll
public class SettingsView extends HorizontalLayout {
}
