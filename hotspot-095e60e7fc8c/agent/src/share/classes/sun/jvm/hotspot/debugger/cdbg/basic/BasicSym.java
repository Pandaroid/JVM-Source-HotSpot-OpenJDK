/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

package sun.jvm.hotspot.debugger.cdbg.basic;

import sun.jvm.hotspot.debugger.cdbg.*;

public abstract class BasicSym implements Sym {
    private String name;

    protected BasicSym(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }

    public BlockSym asBlock() {
        return null;
    }

    public FunctionSym asFunction() {
        return null;
    }

    public GlobalSym asGlobal() {
        return null;
    }

    public LocalSym asLocal() {
        return null;
    }

    public boolean isBlock() {
        return (asBlock() != null);
    }

    public boolean isFunction() {
        return (asFunction() != null);
    }

    public boolean isGlobal() {
        return (asGlobal() != null);
    }

    public boolean isLocal() {
        return (asLocal() != null);
    }

    public boolean isLazy() {
        return false;
    }

    /**
     * Resolve type and symbol references in this symbol
     */
    public abstract void resolve(BasicCDebugInfoDataBase db, ResolveListener listener);
}
