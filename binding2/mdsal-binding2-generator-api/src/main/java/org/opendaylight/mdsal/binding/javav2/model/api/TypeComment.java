/*
 * Copyright (c) 2018 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.mdsal.binding.javav2.model.api;

import com.google.common.annotations.Beta;
import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * Dedicated type for holding a class comment. It exposes a javadoc-encoded string.
 *
 * @author Robert Varga
 */
@Beta
@FunctionalInterface
@NonNullByDefault
public interface TypeComment {

    /**
     * Return a javadoc snippet. This snippet is guaranteed to be safe for direct inclusion in a Java block comment.
     *
     * @return Javadoc snippet.
     */
    String getJavadoc();
}
