---
title: Permission - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.enums](../index.html) / [Permission](.)

# Permission

`enum class Permission`

Enum to store permissions as strings.
Consolidates all permissions into one enum.

### Enum Values

| [ADMIN](-a-d-m-i-n.html) | The administrator permission. Players with this permission usually have full control over the functionality of the plugin. |
| [HIDE_PLAYERS](-h-i-d-e_-p-l-a-y-e-r-s.html) | Players with this permission are allowed to hide other players from their view. |
| [SILENT](-s-i-l-e-n-t.html) | Players with this permission are allowed to silence their chat. |
| [VANISH](-v-a-n-i-s-h.html) | Players with this permission are allowed to vanish and become invisible to other players. |

### Constructors

| [&lt;init&gt;](-init-.html) | `Permission(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Enum to store permissions as strings. Consolidates all permissions into one enum. |

### Properties

| [id](id.html) | `val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The string representation of this permission. Can be used in plugins that manage permissions. |

