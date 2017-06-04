---
title: Meta - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.database.table](../index.html) / [Meta](.)

# Meta

`object Meta : Table`

Meta table to handle upgrades to the database

### Properties

| [CURRENT_TABLE_VER](-c-u-r-r-e-n-t_-t-a-b-l-e_-v-e-r.html) | `val CURRENT_TABLE_VER: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The latest version of the database. Used to track the upgrade process and to determine what upgrades to do. |
| [version](version.html) | `val version: Column<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`<br>Column to hold the current database version. Updated on upgrades. |

### Functions

| [upgradeDatabase](upgrade-database.html) | `fun upgradeDatabase(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Upgrades the database by performing the needed modifications to the database. |

