package daggersampletests.fo2rist.github.com.daggersampletests.util

import kotlin.reflect.KProperty

inline fun <reified T> printObjectProperties(obj: T, title: String? = null) {
    println()

    title?.let { println("* $it *") }

    T::class.members
            .filter { it is KProperty<*> }
            .forEach { println(getShortReferenceName(it.call(obj)!!)) }
}

/** Creates string with class name and hash without the package name. */
fun getShortReferenceName(obj: Any): String = "${obj::class.simpleName}@${Integer.toHexString(obj.hashCode())}"

