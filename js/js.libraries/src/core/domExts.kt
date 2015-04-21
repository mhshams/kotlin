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

package kotlin.js.dom.html

import java.util.*

private class HTMLCollectionListView(val collection : HTMLCollection) : AbstractList<HTMLElement>() {
    override fun size(): Int = collection.length.toInt()

    override fun get(index: Int): HTMLElement = if (index in 0..size() - 1) collection.item(index)!! else throw IndexOutOfBoundsException("index $index is not in range [0 .. ${size() - 1})")
}

public fun HTMLCollection.asList() : List<HTMLElement> = HTMLCollectionListView(this)

