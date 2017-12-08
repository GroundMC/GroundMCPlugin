---
title: LogFormatter - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby](../index.html) / [LogFormatter](.)

# LogFormatter

`class LogFormatter : Formatter`

A custom [Formatter](#) for log files.
Inspired by [SimpleFormatter](#)

### Constructors

| [&lt;init&gt;](-init-.html) | `LogFormatter()`<br>A custom [Formatter](#) for log files. Inspired by [SimpleFormatter](#) |

### Properties

| [date](date.html) | `val date: Date`<br>A value of [Date](#). It is more efficient to set the date every time than to construct a new [Date](#) object. |
| [format](format.html) | `val format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The format string used by this [Formatter](#). |

### Functions

| [format](format.html) | `fun format(record: LogRecord): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Format the given log record and return the formatted string. |

