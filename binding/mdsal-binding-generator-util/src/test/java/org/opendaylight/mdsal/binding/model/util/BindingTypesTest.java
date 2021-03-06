/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.mdsal.binding.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.opendaylight.mdsal.binding.model.util.Types.typeForClass;

import org.junit.Test;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.BaseIdentity;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.DataRoot;
import org.opendaylight.yangtools.yang.binding.Identifiable;
import org.opendaylight.yangtools.yang.binding.Identifier;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.binding.Notification;
import org.opendaylight.yangtools.yang.binding.NotificationListener;
import org.opendaylight.yangtools.yang.binding.RpcService;

public class BindingTypesTest {

    @Test
    public void staticBindingTypesTest() {
        assertEquals("AUGMENTABLE", typeForClass(Augmentable.class), BindingTypes.AUGMENTABLE);
        assertEquals("AUGMENTATION", typeForClass(Augmentation.class), BindingTypes.AUGMENTATION);
        assertEquals("BASE_IDENTITY", typeForClass(BaseIdentity.class), BindingTypes.BASE_IDENTITY);
        assertEquals("DATA_OBJECT", typeForClass(DataObject.class), BindingTypes.DATA_OBJECT);
        assertEquals("DATA_ROOT", typeForClass(DataRoot.class), BindingTypes.DATA_ROOT);
        assertEquals("IDENTIFIABLE", typeForClass(Identifiable.class), BindingTypes.IDENTIFIABLE);
        assertEquals("IDENTIFIER", typeForClass(Identifier.class), BindingTypes.IDENTIFIER);
        assertEquals("INSTANCE_IDENTIFIER", typeForClass(InstanceIdentifier.class), BindingTypes.INSTANCE_IDENTIFIER);
        assertEquals("NOTIFICATION", typeForClass(Notification.class), BindingTypes.NOTIFICATION);
        assertEquals("NOTIFICATION_LISTENER", typeForClass(NotificationListener.class), BindingTypes.NOTIFICATION_LISTENER);
        assertEquals("RPC_SERVICE", typeForClass(RpcService.class), BindingTypes.RPC_SERVICE);
    }

    @Test(expected = NullPointerException.class)
    public void testAugmentableNull() {
        BindingTypes.augmentable(null);
    }

    @Test(expected = NullPointerException.class)
    public void testChildOfNull() {
        BindingTypes.childOf(null);
    }

    @Test
    public void testAugmentable() {
        assertNotNull(BindingTypes.augmentable(Types.objectType()));
    }

    @Test
    public void testChildOf() {
        assertNotNull(BindingTypes.childOf(Types.objectType()));
    }
}