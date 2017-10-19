/*
 * Copyright (c) 2018 Pantheon Technologies, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.mdsal.dom.api;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.data.api.schema.NormalizedNode;
import org.opendaylight.yangtools.yang.data.api.schema.tree.StoreTreeNode;
import org.opendaylight.yangtools.yang.model.api.SchemaPath;

/**
 * Interface implemented by an individual operation implementation. This API allows for dispatch implementations, e.g.
 * an individual object handling a multitude of operations.
 *
 * @author Robert Varga
 */
@Beta
@NonNullByDefault
public interface DOMOperationImplementation {
    /**
     * An implementation of an {@code action}.
     */
    @FunctionalInterface
    interface Action {
        /**
         * Initiate invocation of the RPC. Implementations of this method are expected to not block.
         *
         * @param type SchemaPath of the action to be invoked. This path refers to an effective action instantiated on
         *             top of the conceptual {@link StoreTreeNode}.
         * @param path {@link DOMDataTreeIdentifier} of parent data node which action attached to.
         * @param input Input arguments
         * @param callback Callback to invoke with the invocation result
         * @param callbackExecutor Executor to use for executing the callback
         * @throws NullPointerException if any of the arguments is null
         */
        void invokeAction(SchemaPath type, DOMDataTreeIdentifier path, NormalizedNode<?, ?> input,
                DOMOperationCallback callback, Executor callbackExecutor);
    }

    /**
     * An implementation of an {@code rpc}.
     */
    @FunctionalInterface
    interface Rpc {
        /**
         * Initiate invocation of the RPC. Implementations of this method are expected to not block.
         *
         * @param type QName of the RPC to be invoked
         * @param input Input arguments
         * @param callback Callback to invoke with the invocation result
         * @param callbackExecutor Executor to use for executing the callback
         * @throws NullPointerException if any of the arguments is null
         */
        void invokeRpc(QName type, NormalizedNode<?, ?> input, DOMOperationCallback callback,
                Executor callbackExecutor);
    }

    /**
     * Return the relative invocation cost of this implementation. Default implementation returns 0.
     *
     * @return Non-negative cost of invoking this implementation.
     */
    default long invocationCost() {
        return 0;
    }
}
