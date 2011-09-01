package com.vaadin.addon.touchkit.itest;

import java.util.Date;

import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.Switch;
import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Slider;
import com.vaadin.ui.Table;

public class Tabsheet extends AbstractTouchKitIntegrationTest {

    public Tabsheet() {

        TabBarView tabBarView = new TabBarView();

        tabBarView.addTab(getTable(), "First", new ThemeResource(
                "../runo/icons/64/folder.png"));
        tabBarView.addTab(getDateSelector(), "Other", new ThemeResource(
                "../runo/icons/64/document.png"));
        tabBarView.addTab(getComboBox(), "Third", new ThemeResource(
                "../runo/icons/64/document-pdf.png"));
        tabBarView.addTab(getFields(), "4th", new ThemeResource(
                "../runo/icons/64/email.png"));

        setContent(tabBarView);

    }

    private Component getFields() {
        CssLayout cssLayout = new CssLayout();
        VerticalComponentGroup verticalComponentGroup = new VerticalComponentGroup();
        verticalComponentGroup.setCaption("Some fields");

        Slider slider = new Slider("Slide this");
        slider.setIcon(new ThemeResource("../runo/icons/64/email.png"));
        slider.setWidth("100%");
        verticalComponentGroup.addComponent(slider);
        Component s = new Switch("Switch this");
        s.setIcon(new ThemeResource("../runo/icons/64/folder.png"));
        verticalComponentGroup.addComponent(s);
        verticalComponentGroup.addComponent(new NumberField("Numbers only"));
        verticalComponentGroup.addComponent(new DateField("Date please"));
        cssLayout.addComponent(verticalComponentGroup);
        return cssLayout;
    }

    private Table getTable() {
        Table table = new Table();
        table.addContainerProperty("Col1", String.class, "some random data");
        table.addContainerProperty("Number", String.class, "123");
        table.addContainerProperty("Date", Date.class, new Date(1314886401678l));
        for (int i = 0; i < 100; i++) {
            table.addItem();
        }
        return table;
    }

    private Component getDateSelector() {
        InlineDateField inlineDateField = new InlineDateField();
        inlineDateField.setValue(new Date(1314886401678l));
        return inlineDateField;
    }

    private Component getComboBox() {
        ComboBox comboBox = new ComboBox();
        for (int i = 0; i < 100; i++) {
            comboBox.addItem("Item " + i);
        }

        comboBox.setValue("Item " + 2);
        return comboBox;
    }
}
