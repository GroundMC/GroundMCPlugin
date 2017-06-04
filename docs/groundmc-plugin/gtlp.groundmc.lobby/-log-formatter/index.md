---
title: LogFormatter - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby](../index.html) / [LogFormatter](.)

# LogFormatter

`class LogFormatter : `[`Formatter`](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Formatter.html)

A custom [Formatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Formatter.html) for log files.
Inspired by [SimpleFormatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/SimpleFormatter.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `LogFormatter()`<br>A custom [Formatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Formatter.html) for log files. Inspired by [SimpleFormatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/SimpleFormatter.html) |

### Properties

| [date](date.html) | `val date: `[`Date`](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html)<br>A value of [Date](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html). It is more efficient to set the date every time than to construct a new [Date](http://docs.oracle.com/javase/6/docs/api/java/util/Date.html) object. |
| [format](format.html) | `val format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The format string used by this [Formatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Formatter.html). |

### Functions

| [format](format.html) | `fun format(record: `[`LogRecord`](http://docs.oracle.com/javase/6/docs/api/java/util/logging/LogRecord.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Format the given log record and return the formatted string. |

