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

package com.vecsight.dragonite.proxy.gui.model;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.io.InputStream;

public class ServerListCellInfo {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label labelName;

    @FXML
    private Label labelDomain;

    @FXML
    private ImageView imageServerIcon;

    private String name;

    private String countryCode;

    private String serverAddress;

    private int serverPort;

    private String password;

    private boolean obfs;

    private int mtu;

    public ServerListCellInfo(final String name, final String countryCode, final String serverAddress, final int serverPort, final String password, final boolean obfs, final int mtu) throws IOException {
        this.name = name;
        this.countryCode = countryCode;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.password = password;
        this.obfs = obfs;
        this.mtu = mtu;

        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ServerListCell.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public BorderPane updateAndGetCell() {
        labelName.setText(name);
        labelDomain.setText(serverAddress);

        final InputStream inputStream = getClass().getResourceAsStream("country/" + countryCode + ".png");
        if (inputStream != null) imageServerIcon.setImage(new Image(inputStream));
        else imageServerIcon.setImage(new Image(getClass().getResourceAsStream("country/GL.png")));

        return borderpane;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(final String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(final int serverPort) {
        this.serverPort = serverPort;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean isObfs() {
        return obfs;
    }

    public void setObfs(final boolean obfs) {
        this.obfs = obfs;
    }

    public int getMtu() {
        return mtu;
    }

    public void setMtu(final int mtu) {
        this.mtu = mtu;
    }
}
