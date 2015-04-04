/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.codegen.intrinsics;

import kotlin.ExtensionFunction1;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.codegen.Callable;
import org.jetbrains.kotlin.codegen.CallableMethod;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.InstructionAdapter;

import static org.jetbrains.kotlin.codegen.AsmUtil.correctElementType;

public class ArrayGet extends IntrinsicMethod {

    @NotNull
    @Override
    public Callable toCallable(@NotNull CallableMethod method) {
        return new MappedCallable(method, new ExtensionFunction1<MappedCallable, InstructionAdapter, Unit>() {
            @Override
            public Unit invoke(
                    MappedCallable callable,
                    InstructionAdapter adapter
            ) {
                Type type = correctElementType(callable.calcReceiverType());
                adapter.aload(type);
                return Unit.INSTANCE$;
            }
        });
    }
}
