/**
 * Copyright (c) 2010-2024 Contributors to the openHAB project
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
package org.openhab.binding.hue.internal.api.dto.clip2.enums;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Enum for possible Zigbee states.
 *
 * @author Andrew Fiddian-Green - Initial contribution
 */
@NonNullByDefault
public enum ZigbeeStatus {
    CONNECTED,
    DISCONNECTED,
    CONNECTIVITY_ISSUE,
    UNIDIRECTIONAL_INCOMING;

    private static final Set<ZigbeeStatus> CONNECTIVITY_ISSUES = Set.of(DISCONNECTED, CONNECTIVITY_ISSUE);

    public static ZigbeeStatus of(@Nullable String value) {
        if (value != null) {
            try {
                return valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                // fall through
            }
        }
        return DISCONNECTED;
    }

    @Override
    public String toString() {
        String s = this.name().replace("_", " ");
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /**
     * Return true if the status is a connectivity issue
     */
    public boolean isConnectivityIssue() {
        return CONNECTIVITY_ISSUES.contains(this);
    }
}
