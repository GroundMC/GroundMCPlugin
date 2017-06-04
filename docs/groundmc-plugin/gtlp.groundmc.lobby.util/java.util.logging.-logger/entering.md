---
title: entering - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [java.util.logging.Logger](index.html) / [entering](.)

# entering

`fun `[`Logger`](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Logger.html)`.entering(kClass: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<*>, sourceMethod: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Extension to [Logger](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Logger.html) to use [Logger.entering](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Logger.html#entering(java.lang.String, java.lang.String)) with [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)es.

### Parameters

`kClass` - the class that the code is in

`sourceMethod` - the method to log.