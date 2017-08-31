/*
 * VECTORSIGHT CONFIDENTIAL
 * ------------------------
 * Copyright (c) [2015] - [2017]
 * VectorSight Systems Co., Ltd.
 * All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Toby Huang <t@vecsight.com>, June 2017
 */

package com.vecsight.dragonite.proxy.gui;

import com.jfoenix.controls.JFXListView;
import com.vecsight.dragonite.ProxyGUIBuildConfig;
import com.vecsight.dragonite.proxy.gui.model.ServerListCell;
import com.vecsight.dragonite.proxy.gui.model.ServerListCellInfo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class GUIMain extends Application {

    @FXML
    private JFXListView<ServerListCellInfo> serverListView;

    private static final String PRODUCT_NAME = "Dragonite Proxy GUI";

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        fxmlLoader.setController(this);
        final Parent root = fxmlLoader.load();

        final Scene scene = new Scene(root);

        primaryStage.setTitle(PRODUCT_NAME + " v" + ProxyGUIBuildConfig.VERSION);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));

        primaryStage.setScene(scene);
        primaryStage.show();

        final ObservableList<ServerListCellInfo> observableList = FXCollections.observableArrayList();
        observableList.add(new ServerListCellInfo("captain", "US", "captain.vecsight.com",
                6666, "hahaha", false, 1300));
        observableList.add(new ServerListCellInfo("yoshino", "JP", "yoshino.vecsight.com",
                6666, "hahaha", false, 1300));
        observableList.add(new ServerListCellInfo("lxd", "CN", "lxd.vecsight.com",
                6666, "hahaha", false, 1300));
        observableList.add(new ServerListCellInfo("gce", "TW", "tw1.vecsight.com",
                6666, "hahaha", false, 1300));
        observableList.add(new ServerListCellInfo("local", "LC", "localhost",
                6666, "hahaha", false, 1300));
        observableList.add(new ServerListCellInfo("not exists", "UK", "fuckme.lol",
                6666, "hahaha", false, 1300));
        serverListView.setItems(observableList);
        serverListView.setCellFactory(param -> new ServerListCell());
    }
}
