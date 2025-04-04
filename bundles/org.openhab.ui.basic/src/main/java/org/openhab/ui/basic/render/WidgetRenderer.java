/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.ui.basic.render;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.model.sitemap.sitemap.Widget;
import org.openhab.ui.basic.internal.WebAppConfig;

/**
 * This interface must be implemented by classes, which can render HTML for the WebApp UI for certain widget types.
 *
 * @author Kai Kreuzer - Initial contribution and API
 * @author Vlad Ivanov - BasicUI changes
 */
@NonNullByDefault
public interface WidgetRenderer {

    /**
     * Defines, whether this renderer can handle a given widget
     *
     * @param w the widget to check
     * @return true, if this renderer can handle the widget
     */
    boolean canRender(Widget w);

    /**
     * Produces HTML code for a given widget and writes it to a string builder.
     *
     * @param w the widget to produce HTML code for
     * @param sb the string builder to append the HTML code to
     * @return a list of widgets that need to be rendered as children of the widget; the HTML code in sb should contain
     *         a "%children%" placeholder for them.
     * @throws RenderException if an error occurs during rendering
     */
    EList<Widget> renderWidget(Widget w, StringBuilder sb, String sitemap) throws RenderException;

    /**
     * Applies a servlet configuration to the renderer
     *
     * @param config servlet configuration
     */
    void setConfig(WebAppConfig config);
}
