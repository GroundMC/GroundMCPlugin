
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

  public static boolean debug = false;

  @Test
  public void test001() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test001"); }

    gtlp.groundmc.lobby.enums.VisibilityStates visibilityStates0 = gtlp.groundmc.lobby.enums.VisibilityStates.FRIENDS;
    org.junit.Assert.assertTrue("'" + visibilityStates0 + "' != '" + gtlp.groundmc.lobby.enums.VisibilityStates.FRIENDS + "'", visibilityStates0.equals(gtlp.groundmc.lobby.enums.VisibilityStates.FRIENDS));

  }

  @Test
  public void test002() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test002"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry lobbyCommandRegistry0 = new gtlp.groundmc.lobby.registry.LobbyCommandRegistry();

  }

  @Test
  public void test003() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test003"); }

    gtlp.groundmc.lobby.enums.GMCType gMCType0 = gtlp.groundmc.lobby.enums.GMCType.SILENT;
    org.junit.Assert.assertTrue("'" + gMCType0 + "' != '" + gtlp.groundmc.lobby.enums.GMCType.SILENT + "'", gMCType0.equals(gtlp.groundmc.lobby.enums.GMCType.SILENT));

  }

  @Test
  public void test004() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test004"); }

    org.bukkit.OfflinePlayer offlinePlayer0 = null;
    org.bukkit.OfflinePlayer offlinePlayer1 = null;
    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship(offlinePlayer0, offlinePlayer1, dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test005() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test005"); }

    java.util.UUID uUID0 = null;
    java.util.UUID uUID1 = null;
    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship(uUID0, uUID1, dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test006() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test006"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("hi!");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test007() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test007"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)(short)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-1024));

  }

  @Test
  public void test008() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test008"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("hi!");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test009() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test009"); }

    gtlp.groundmc.lobby.inventory.LobbyInventoryHolder.Companion companion0 = gtlp.groundmc.lobby.inventory.LobbyInventoryHolder.Companion;
    org.bukkit.entity.Player player1 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.inventory.LobbyInventoryHolder lobbyInventoryHolder2 = companion0.forPlayer(player1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test010() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test010"); }

    org.bukkit.inventory.ItemStack itemStack0 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.util.NBTItemExt nBTItemExt1 = new gtlp.groundmc.lobby.util.NBTItemExt(itemStack0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test011() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test011"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "hi!", "hi!", "", "hi!", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandLobby0.execute(commandSender1, command2, "", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test012() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test012"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandLobby0.execute(commandSender1, command2, "", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test013() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test013"); }

    gtlp.groundmc.lobby.enums.VisibilityStates visibilityStates0 = gtlp.groundmc.lobby.enums.VisibilityStates.NONE;
    org.junit.Assert.assertTrue("'" + visibilityStates0 + "' != '" + gtlp.groundmc.lobby.enums.VisibilityStates.NONE + "'", visibilityStates0.equals(gtlp.groundmc.lobby.enums.VisibilityStates.NONE));

  }

  @Test
  public void test014() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test014"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriend commandFriend1 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str2 = commandFriend1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriend1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));

  }

  @Test
  public void test015() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test015"); }

    gtlp.groundmc.lobby.enums.GMCType gMCType0 = gtlp.groundmc.lobby.enums.GMCType.NONE;
    org.junit.Assert.assertTrue("'" + gMCType0 + "' != '" + gtlp.groundmc.lobby.enums.GMCType.NONE + "'", gMCType0.equals(gtlp.groundmc.lobby.enums.GMCType.NONE));

  }

  @Test
  public void test016() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test016"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test017() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test017"); }

    gtlp.groundmc.lobby.enums.GMCType gMCType0 = gtlp.groundmc.lobby.enums.GMCType.TP;
    org.junit.Assert.assertTrue("'" + gMCType0 + "' != '" + gtlp.groundmc.lobby.enums.GMCType.TP + "'", gMCType0.equals(gtlp.groundmc.lobby.enums.GMCType.TP));

  }

  @Test
  public void test018() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test018"); }

    gtlp.groundmc.lobby.enums.GMCType gMCType0 = gtlp.groundmc.lobby.enums.GMCType.HIDE_PLAYERS;
    org.junit.Assert.assertTrue("'" + gMCType0 + "' != '" + gtlp.groundmc.lobby.enums.GMCType.HIDE_PLAYERS + "'", gMCType0.equals(gtlp.groundmc.lobby.enums.GMCType.HIDE_PLAYERS));

  }

  @Test
  public void test019() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test019"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("groundmc.lobby.hide_players", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test020() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test020"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "friend", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str7 = commandFriend0.getTabCompletion(commandSender1, command2, "groundmc.lobby.hide_players", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test021() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test021"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str6 = commandLobby0.getTabCompletion(commandSender2, command3, "lobby", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));

  }

  @Test
  public void test022() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test022"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = commandLobby0.getCommandHelp(locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));

  }

  @Test
  public void test023() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test023"); }

    gtlp.groundmc.lobby.enums.VisibilityStates visibilityStates0 = gtlp.groundmc.lobby.enums.VisibilityStates.ALL;
    org.junit.Assert.assertTrue("'" + visibilityStates0 + "' != '" + gtlp.groundmc.lobby.enums.VisibilityStates.ALL + "'", visibilityStates0.equals(gtlp.groundmc.lobby.enums.VisibilityStates.ALL));

  }

  @Test
  public void test024() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test024"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "friend", "lobby", "hi!", "friend", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandCoins0.execute(commandSender1, command2, "lobby", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test025() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test025"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.util.Locale locale1 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array2 = commandFriend0.getCommandHelp(locale1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test026() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test026"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.hide_players", "groundmc.lobby.hide_players", "", "lobby", "hi!", "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandVanish0.execute(commandSender1, command2, "", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test027() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test027"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("friend", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test028() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test028"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "lobby", "" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str7 = commandFriend0.getTabCompletion(commandSender1, command2, "lobby", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test029() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test029"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)'#');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 35840);

  }

  @Test
  public void test030() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test030"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array5 = new java.lang.String[] { "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str6 = commandVanish0.getTabCompletion(commandSender1, command2, "lobby", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test031() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test031"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(35840);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 36700160);

  }

  @Test
  public void test032() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test032"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array5 = new java.lang.String[] { "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandLobby0.execute(commandSender1, command2, "lobby", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test033() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test033"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.util.Locale locale1 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array2 = commandCoins0.getCommandHelp(locale1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test034() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test034"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = null;
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandCoins0.execute(commandSender1, command2, "lobby", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test035() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test035"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    org.bukkit.command.CommandSender commandSender1 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromCommandSender(commandSender1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test036() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test036"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.util.Locale locale1 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array2 = commandLobby0.getCommandHelp(locale1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test037() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test037"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandVanish0.execute(commandSender1, command2, "hi!", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test038() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test038"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = commandFriend0.getCommandHelp(locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));

  }

  @Test
  public void test039() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test039"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test040() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test040"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "friend", "lobby", "" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandVanish0.getTabCompletion(commandSender1, command2, "lobby", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test041() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test041"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("", "groundmc.lobby.hide_players", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test042() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test042"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("friend", "GMCrx", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test043() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test043"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandCoins commandCoins1 = new gtlp.groundmc.lobby.commands.CommandCoins();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandCoins1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test044() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test044"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("groundmc.lobby.hide_players");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test045() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test045"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array6 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandFriend0.execute(commandSender3, command4, "lobby", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test046() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test046"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(byte)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test047() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test047"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "groundmc.lobby.hide_players", "lobby", "groundmc.lobby.hide_players", "lobby", "" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandCoins0.execute(commandSender1, command2, "friend", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test048() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test048"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.hide_players", "GMCrx", "hi!", "", "friend", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandLobby0.getTabCompletion(commandSender1, command2, "friend", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test049() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test049"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("groundmc.lobby.hide_players", "lobby", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test050() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test050"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array5 = new java.lang.String[] { "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str6 = commandVanish0.getTabCompletion(commandSender1, command2, "friend", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test051() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test051"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "hi!", "friend", "lobby", "friend", "groundmc.lobby.silent", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandFriends0.getTabCompletion(commandSender1, command2, "groundmc.lobby.hide_players", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test052() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test052"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str6 = commandFriend0.getTabCompletion(commandSender2, command3, "GMCrx", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test053() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test053"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "lobby", "hi!", "groundmc.lobby.hide_players", "hi!", "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandFriend0.getTabCompletion(commandSender1, command2, "GMCrx", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test054() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test054"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "lobby", "groundmc.lobby.hide_players", "groundmc.lobby.hide_players", "friend", "groundmc.lobby.hide_players", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandLobby0.execute(commandSender2, command3, "", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test055() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test055"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.util.Locale locale1 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array2 = commandFriends0.getCommandHelp(locale1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test056() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test056"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "hi!", "groundmc.lobby.hide_players", "hi!", "hi!", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandFriend0.execute(commandSender2, command3, "friend", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test057() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test057"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)(short)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 10240);

  }

  @Test
  public void test058() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test058"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str5 = commandVanish0.getTabCompletion(commandSender1, command2, "vanish", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test059() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test059"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandFriends0.execute(commandSender1, command2, "lobby", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test060() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test060"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriends commandFriends1 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str2 = commandFriends1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriends1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));

  }

  @Test
  public void test061() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test061"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 102400);

  }

  @Test
  public void test062() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test062"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "friends", "friends", "groundmc.lobby.silent", "GMCrx", "friends", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender1, command2, "hi!", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test063() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test063"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str5 = commandCoins0.getTabCompletion(commandSender1, command2, "vanish", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test064() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test064"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandFriend0.execute(commandSender2, command3, "friends", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test065() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test065"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "", "friends", "vanish", "groundmc.lobby.hide_players", "", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandFriend0.getTabCompletion(commandSender2, command3, "", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test066() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test066"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandFriend0.execute(commandSender3, command4, "groundmc.lobby.silent", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test067() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test067"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("groundmc.lobby.hide_players");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test068() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test068"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "friends", "groundmc.lobby.hide_players", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriends0.getTabCompletion(commandSender1, command2, "", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test069() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test069"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = commandCoins0.getCommandHelp(locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));

  }

  @Test
  public void test070() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test070"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.util.Locale locale1 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array2 = commandVanish0.getCommandHelp(locale1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test071() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test071"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("friends");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test072() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test072"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandLobby0.execute(commandSender2, command3, "groundmc.lobby.hide_players", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test073() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test073"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "friend", "vanish", "groundmc.lobby.silent", "GMChide", "" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandVanish0.execute(commandSender2, command3, "friend", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test074() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test074"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("groundmc.lobby.silent");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test075() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test075"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "GMCrx", "groundmc.lobby.silent", "groundmc.lobby.hide_players", "vanish", "GMCrx", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandVanish0.getTabCompletion(commandSender2, command3, "coins", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test076() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test076"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "groundmc.lobby.silent", "hi!", "groundmc.lobby.hide_players", "friend", "groundmc.lobby.silent", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandCoins0.execute(commandSender2, command3, "", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test077() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test077"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("groundmc.lobby.hide_players", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test078() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test078"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMCrx", "GMCrx", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test079() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test079"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1048576);

  }

  @Test
  public void test080() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test080"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array5 = commandFriend0.getCommandHelp(locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));

  }

  @Test
  public void test081() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test081"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "lobby", "GMChide", "hi!", "lobby", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandFriends0.getTabCompletion(commandSender2, command3, "vanish", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test082() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test082"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriend commandFriend1 = new gtlp.groundmc.lobby.commands.CommandFriend();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriend1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test083() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test083"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(35840);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-1073741824));

  }

  @Test
  public void test084() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test084"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMCrx", "groundmc.lobby.hide_players", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test085() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test085"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("GMChide");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test086() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test086"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "friend", "GMCrx", "GMChide", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandCoins0.getTabCompletion(commandSender3, command4, "vanish", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test087() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test087"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("hi!");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test088() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test088"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array6 = new java.lang.String[] { "GMCrx", "groundmc.lobby.hide_players", "groundmc.lobby.silent", "hi!", "" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array8 = i18n0.getStrings(str_array6, "lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test089() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test089"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "friend", "hi!", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandCoins0.getTabCompletion(commandSender3, command4, "friends", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test090() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test090"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "coins", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandCoins0.getTabCompletion(commandSender3, command4, "hi!", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test091() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test091"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 104857600);

  }

  @Test
  public void test092() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test092"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array7 = new java.lang.String[] { "groundmc.lobby.hide_players", "groundmc.lobby.hide_players", "groundmc.lobby.hide_players", "friend", "groundmc.lobby.hide_players", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array9 = i18n0.getStrings(str_array7, "");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test093() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test093"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(104857600);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test094() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test094"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("coins", "");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test095() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test095"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("GMChide");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test096() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test096"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "hi!", "coins", "vanish", "friend", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandFriend0.getTabCompletion(commandSender1, command2, "groundmc.lobby.hide_players", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test097() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test097"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("GMCrx", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test098() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test098"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = resourceBundleCache1.get("coins", locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));

  }

  @Test
  public void test099() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test099"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("coins");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test100() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test100"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(10240);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 10485760);

  }

  @Test
  public void test101() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test101"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test102() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test102"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array1 = null;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = i18n0.getStrings(str_array1, locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test103() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test103"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test104() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test104"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str5 = commandCoins0.getTabCompletion(commandSender1, command2, "groundmc.lobby.silent", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test105() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test105"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = resourceBundleCache1.get("vanish", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));

  }

  @Test
  public void test106() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test106"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMChide", "GMCrx", "hi!", "groundmc.lobby.hide_players", "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandFriends0.getTabCompletion(commandSender1, command2, "vanish", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test107() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test107"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array4 = new java.lang.String[] { "coins", "coins", "groundmc.lobby.hide_players" };
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = i18n0.getStrings(str_array4, locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test108() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test108"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("friend", "groundmc.lobby.silent", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test109() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test109"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array2 = new java.lang.String[] { "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);

  }

  @Test
  public void test110() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test110"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.hide_players", "coins", "GMChide", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender3, command4, "groundmc.lobby.silent", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test111() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test111"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array4 = new java.lang.String[] { "vanish", "coins", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = i18n0.getStrings(str_array4, "GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test112() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test112"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "lobby", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriends0.getTabCompletion(commandSender2, command3, "", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test113() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test113"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "friend", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriends0.getTabCompletion(commandSender2, command3, "vanish", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test114() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test114"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "groundmc.lobby.hide_players", "", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandVanish0.getTabCompletion(commandSender1, command2, "GMCrx", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test115() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test115"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("groundmc.lobby.silent");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = resourceBundleCache1.get("groundmc.lobby.vanish", locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "groundmc.lobby.silent"+ "'", str2.equals("groundmc.lobby.silent"));

  }

  @Test
  public void test116() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test116"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = commandCoins0.getCommandHelp(locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));

  }

  @Test
  public void test117() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test117"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("hi!", "vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test118() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test118"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "friends", "", "vanish", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandFriends0.execute(commandSender1, command2, "hi!", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test119() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test119"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("friends");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test120() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test120"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "lobby", "groundmc.lobby.silent", "" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandFriends0.getTabCompletion(commandSender2, command3, "coins", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test121() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test121"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "", "hi!", "hi!", "GMCrx", "groundmc.lobby.hide_players", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandFriend0.execute(commandSender3, command4, "groundmc.lobby.hide_players", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test122() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test122"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "groundmc.lobby.hide_players", "", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriend0.getTabCompletion(commandSender1, command2, "GMCrx", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test123() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test123"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str5 = commandCoins0.getTabCompletion(commandSender1, command2, "coins", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test124() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test124"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "vanish", "friends", "hi!", "friends", "hi!", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandFriends0.execute(commandSender1, command2, "coins", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test125() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test125"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandCoins0.getTabCompletion(commandSender3, command4, "groundmc.lobby.hide_players", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test126() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test126"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array3 = new java.lang.String[] { "GMCrx", "friends" };
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array5 = i18n0.getStrings(str_array3, locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array3);

  }

  @Test
  public void test127() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test127"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandVanish commandVanish1 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str2 = commandVanish1.getName();
    java.lang.String str3 = commandVanish1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandVanish1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));

  }

  @Test
  public void test128() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test128"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)'a');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 99328);

  }

  @Test
  public void test129() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test129"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandVanish commandVanish1 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str2 = commandVanish1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandVanish1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));

  }

  @Test
  public void test130() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test130"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandFriend0.execute(commandSender6, command7, "vanish", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test131() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test131"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = commandFriend0.getCommandHelp(locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));

  }

  @Test
  public void test132() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test132"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("vanish", "friend", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test133() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test133"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandFriends0.execute(commandSender2, command3, "GMChide", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test134() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test134"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array15 = new java.lang.String[] { "groundmc.lobby.vanish", "groundmc.lobby.hide_players", "lobby", "groundmc.lobby.vanish", "GMChide", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b16 = commandFriend0.execute(commandSender6, command7, "vanish", str_array15);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);

  }

  @Test
  public void test135() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test135"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandFriend0.execute(commandSender5, command6, "friend", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test136() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test136"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("groundmc.lobby.vanish", "groundmc.lobby.vanish", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test137() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test137"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandVanish0.execute(commandSender2, command3, "friend", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test138() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test138"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("friends", "groundmc.lobby.silent");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test139() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test139"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = resourceBundleCache1.get("", locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));

  }

  @Test
  public void test140() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test140"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = commandLobby0.getCommandHelp(locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));

  }

  @Test
  public void test141() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test141"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array7 = commandFriend0.getCommandHelp(locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));

  }

  @Test
  public void test142() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test142"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)(byte)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1024);

  }

  @Test
  public void test143() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test143"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array6 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str7 = commandCoins0.getTabCompletion(commandSender3, command4, "lobby", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test144() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test144"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test145() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test145"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("GMC", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test146() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test146"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandLobby0.execute(commandSender2, command3, "lobby", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test147() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test147"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array5 = new java.lang.String[] { "friend" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandVanish0.execute(commandSender1, command2, "friends", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test148() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test148"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "GMC", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandFriend0.getTabCompletion(commandSender6, command7, "vanish", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test149() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test149"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = commandVanish0.getCommandHelp(locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));

  }

  @Test
  public void test150() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test150"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMCrx", "hi!", "friends", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandFriends0.execute(commandSender2, command3, "GMChide", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test151() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test151"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("coins");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test152() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test152"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandLobby commandLobby1 = new gtlp.groundmc.lobby.commands.CommandLobby();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandLobby1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test153() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test153"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandLobby0.execute(commandSender2, command3, "", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test154() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test154"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = commandFriends0.getCommandHelp(locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));

  }

  @Test
  public void test155() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test155"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandLobby0.execute(commandSender2, command3, "friend", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test156() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test156"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = i18n0.getString("hi!", "groundmc.lobby.vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');

  }

  @Test
  public void test157() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test157"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(byte)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 10485760);

  }

  @Test
  public void test158() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test158"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "GMC", "" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str7 = commandFriend0.getTabCompletion(commandSender1, command2, "lobby", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test159() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test159"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "GMC", "groundmc.lobby.hide_players", "hi!", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandFriend0.getTabCompletion(commandSender1, command2, "vanish", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test160() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test160"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "GMChide", "groundmc.lobby.hide_players", "friends", "groundmc.lobby.vanish", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandCoins0.getTabCompletion(commandSender4, command5, "", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test161() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test161"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = resourceBundleCache1.get("", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + ""+ "'", str2.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + ""+ "'", str3.equals(""));

  }

  @Test
  public void test162() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test162"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "vanish", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandVanish0.execute(commandSender1, command2, "GMCrx", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test163() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test163"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "hi!", "vanish", "vanish", "vanish", "hi!", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandCoins0.execute(commandSender3, command4, "vanish", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test164() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test164"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("hi!", "groundmc.lobby.hide_players", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test165() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test165"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test166() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test166"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "GMCx", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandCoins0.execute(commandSender3, command4, "lobby", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test167() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test167"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test168() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test168"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);

  }

  @Test
  public void test169() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test169"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] { "hi!", "GMCrx", "groundmc.lobby.vanish", "coins", "GMC" };
    java.util.Locale locale8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array9 = i18n0.getStrings(str_array7, locale8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test170() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test170"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = commandVanish0.getCommandHelp(locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));

  }

  @Test
  public void test171() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test171"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandCoins commandCoins1 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str2 = commandCoins1.getName();
    java.lang.String str3 = commandCoins1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandCoins1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));

  }

  @Test
  public void test172() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test172"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "", "GMCrx", "lobby", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender3, command4, "", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test173() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test173"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandLobby commandLobby1 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str2 = commandLobby1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandLobby1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));

  }

  @Test
  public void test174() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test174"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "lobby", "groundmc.lobby.silent", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandVanish0.execute(commandSender2, command3, "lobby", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test175() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test175"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "lobby", "groundmc.lobby.silent", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandFriends0.execute(commandSender2, command3, "vanish", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test176() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test176"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("groundmc.lobby.silent");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("coins", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test177() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test177"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = i18n0.getString("groundmc.lobby.vanish", "GMC");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');

  }

  @Test
  public void test178() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test178"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "GMC", "groundmc.lobby.vanish", "GMCx", "GMCx", "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandVanish0.execute(commandSender3, command4, "GMChide", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test179() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test179"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.hide_players", "coins", "hi!", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandLobby0.execute(commandSender3, command4, "groundmc.lobby.hide_players", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test180() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test180"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = null;
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandLobby0.execute(commandSender1, command2, "groundmc.lobby.silent", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test181() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test181"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = resourceBundleCache1.get("friends", locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "GMCrx"+ "'", str4.equals("GMCrx"));

  }

  @Test
  public void test182() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test182"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test183() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test183"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("lobby", "GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test184() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test184"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMC", "", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test185() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test185"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender8 = null;
    org.bukkit.command.Command command9 = null;
    java.lang.String[] str_array13 = new java.lang.String[] { "friend", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandFriend0.getTabCompletion(commandSender8, command9, "GMChide", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test186() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test186"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "GMCx", "", "" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandVanish0.execute(commandSender1, command2, "groundmc.lobby.hide_players", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test187() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test187"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = i18n0.getString("GMChide", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');

  }

  @Test
  public void test188() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test188"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = resourceBundleCache1.get("friends", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + ""+ "'", str2.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + ""+ "'", str3.equals(""));

  }

  @Test
  public void test189() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test189"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.vanish", "GMCx", "friend", "groundmc.lobby.silent", "friend", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender1, command2, "GMChide", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test190() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test190"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array13 = new java.lang.String[] { "lobby", "hi!", "", "coins", "GMC" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandFriend0.getTabCompletion(commandSender5, command6, "GMCrx", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test191() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test191"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array5 = new java.lang.String[] { "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandLobby0.execute(commandSender1, command2, "", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test192() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test192"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.lang.String str5 = resourceBundleCache1.getName();
    java.lang.String str6 = resourceBundleCache1.getName();
    java.util.Locale locale8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str9 = resourceBundleCache1.get("vanish", locale8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "GMCrx"+ "'", str4.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "GMCrx"+ "'", str5.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "GMCrx"+ "'", str6.equals("GMCrx"));

  }

  @Test
  public void test193() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test193"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "GMC", "vanish", "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriends0.getTabCompletion(commandSender1, command2, "GMChide", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test194() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test194"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "hi!", "groundmc.lobby.vanish", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandFriends0.execute(commandSender1, command2, "lobby", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test195() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test195"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandCoins commandCoins1 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str2 = commandCoins1.getName();
    java.lang.String str3 = commandCoins1.getName();
    java.lang.String str4 = commandCoins1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandCoins1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));

  }

  @Test
  public void test196() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test196"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandCoins0.execute(commandSender2, command3, "GMChide", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test197() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test197"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "friend", "groundmc.lobby.admin", "groundmc.lobby.admin", "", "GMCx", "GMCx" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandLobby0.getTabCompletion(commandSender3, command4, "coins", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test198() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test198"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("groundmc.lobby.silent");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = resourceBundleCache1.get("", locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "groundmc.lobby.silent"+ "'", str2.equals("groundmc.lobby.silent"));

  }

  @Test
  public void test199() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test199"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "groundmc.lobby.hide_players", "groundmc.lobby.silent", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandCoins0.execute(commandSender3, command4, "groundmc.lobby.hide_players", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test200() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test200"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array5 = commandCoins0.getCommandHelp(locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));

  }

  @Test
  public void test201() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test201"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array4 = new java.lang.String[] { "GMC", "GMC" };
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = i18n0.getStrings(str_array4, locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test202() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test202"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "coins", "lobby", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandFriends0.execute(commandSender1, command2, "hi!", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test203() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test203"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandVanish0.execute(commandSender4, command5, "groundmc.lobby.admin", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test204() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test204"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "vanish", "hi!", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandVanish0.execute(commandSender2, command3, "groundmc.lobby.vanish", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test205() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test205"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array15 = new java.lang.String[] { "vanish", "friend", "GMC", "groundmc.lobby.vanish", "GMChide", "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b16 = commandFriend0.execute(commandSender6, command7, "groundmc.lobby.admin", str_array15);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);

  }

  @Test
  public void test206() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test206"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array6 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandLobby0.execute(commandSender3, command4, "friends", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test207() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test207"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test208() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test208"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("lobby", "lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test209() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test209"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array3 = new java.lang.String[] { "groundmc.lobby.hide_players", "groundmc.lobby.vanish" };
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array5 = i18n0.getStrings(str_array3, locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array3);

  }

  @Test
  public void test210() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test210"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 10485760);

  }

  @Test
  public void test211() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test211"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array13 = new java.lang.String[] { "groundmc.lobby.hide_players", "GMChide", "groundmc.lobby.hide_players", "", "", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b14 = commandVanish0.execute(commandSender4, command5, "friend", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test212() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test212"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("groundmc.lobby.hide_players", "GMC", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test213() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test213"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "friend", "GMChide", "GMC" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandLobby0.execute(commandSender3, command4, "groundmc.lobby.hide_players", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test214() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test214"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender7 = null;
    org.bukkit.command.Command command8 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandFriend0.execute(commandSender7, command8, "groundmc.lobby.hide_players", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test215() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test215"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array6 = new java.lang.String[] { "groundmc.lobby.hide_players", "vanish", "GMCry", "vanish" };
    java.util.Locale locale7 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array8 = i18n0.getStrings(str_array6, locale7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test216() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test216"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMC", "GMCx", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test217() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test217"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandVanish0.execute(commandSender5, command6, "vanish", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test218() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test218"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandCoins0.execute(commandSender3, command4, "vanish", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test219() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test219"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "friends" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str7 = commandCoins0.getTabCompletion(commandSender2, command3, "friend", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test220() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test220"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandVanish0.getTabCompletion(commandSender5, command6, "hi!", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test221() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test221"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str5 = commandFriends0.getTabCompletion(commandSender1, command2, "groundmc.lobby.admin", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test222() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test222"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.hide_players", "lobby", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandVanish0.execute(commandSender4, command5, "GMC", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test223() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test223"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("GMCx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test224() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test224"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "GMChide", "vanish", "vanish", "groundmc.lobby.hide_players", "groundmc.lobby.vanish", "GMC" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandVanish0.getTabCompletion(commandSender2, command3, "GMChide", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test225() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test225"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array9 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandFriend0.getTabCompletion(commandSender6, command7, "groundmc.lobby.admin", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test226() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test226"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "lobby", "coins", "GMCry", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandCoins0.getTabCompletion(commandSender3, command4, "", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test227() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test227"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array14 = new java.lang.String[] { "coins", "groundmc.lobby.vanish", "coins", "friend", "groundmc.lobby.vanish", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b15 = commandVanish0.execute(commandSender5, command6, "friends", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);

  }

  @Test
  public void test228() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test228"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array4 = new java.lang.String[] { "groundmc.lobby.silent", "friend", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = i18n0.getStrings(str_array4, "lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test229() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test229"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.lang.String str5 = resourceBundleCache1.getName();
    java.lang.String str6 = resourceBundleCache1.getName();
    java.util.Locale locale8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str9 = resourceBundleCache1.get("lobby", locale8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "GMCrx"+ "'", str4.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "GMCrx"+ "'", str5.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "GMCrx"+ "'", str6.equals("GMCrx"));

  }

  @Test
  public void test230() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test230"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    java.lang.String str8 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender9 = null;
    org.bukkit.command.Command command10 = null;
    java.lang.String[] str_array14 = new java.lang.String[] { "friend", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b15 = commandFriend0.execute(commandSender9, command10, "groundmc.lobby.silent", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "friend"+ "'", str8.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);

  }

  @Test
  public void test231() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test231"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriends0.getTabCompletion(commandSender3, command4, "groundmc.lobby.vanish", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test232() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test232"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("GMChide");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test233() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test233"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("", "vanish", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test234() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test234"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(102400);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test235() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test235"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = commandFriends0.getCommandHelp(locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));

  }

  @Test
  public void test236() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test236"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "groundmc.lobby.admin", "groundmc.lobby.vanish", "GMCsilent", "", "coins", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandLobby0.execute(commandSender2, command3, "friends", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test237() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test237"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "GMCrx", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriend0.getTabCompletion(commandSender2, command3, "", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test238() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test238"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("groundmc.lobby.silent", "groundmc.lobby.silent");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test239() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test239"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.util.Locale locale7 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array8 = commandFriend0.getCommandHelp(locale7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));

  }

  @Test
  public void test240() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test240"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(99328);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 101711872);

  }

  @Test
  public void test241() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test241"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandCoins0.execute(commandSender4, command5, "GMCry", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test242() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test242"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("", "groundmc.lobby.vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test243() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test243"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "GMCrx", "groundmc.lobby.admin", "vanish", "GMCrx", "GMChide", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandLobby0.execute(commandSender3, command4, "coins", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test244() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test244"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "lobby", "groundmc.lobby.vanish", "GMCry", "GMC", "vanish", "GMC" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandFriends0.execute(commandSender2, command3, "GMCx", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test245() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test245"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("GMCry");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test246() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test246"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "", "GMCry", "vanish", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandFriends0.getTabCompletion(commandSender2, command3, "groundmc.lobby.admin", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test247() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test247"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test248() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test248"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "GMCx", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandCoins0.getTabCompletion(commandSender5, command6, "groundmc.lobby.silent", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test249() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test249"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = i18n0.getString("GMCsilent", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');

  }

  @Test
  public void test250() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test250"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "coins", "lobby", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandVanish0.execute(commandSender2, command3, "groundmc.lobby.vanish", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test251() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test251"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("GMCry");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test252() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test252"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.vanish", "friends", "groundmc.lobby.admin", "GMCx", "vanish", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandFriends0.execute(commandSender1, command2, "GMCry", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test253() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test253"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test254() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test254"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("GMCsilent");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test255() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test255"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = commandCoins0.getCommandHelp(locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));

  }

  @Test
  public void test256() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test256"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "coins", "GMC", "groundmc.lobby.vanish", "GMCsilent", "groundmc.lobby.silent", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandLobby0.getTabCompletion(commandSender1, command2, "GMCrx", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test257() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test257"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array4 = new java.lang.String[] { "GMCry", "groundmc.lobby.silent", "GMCrx" };
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = i18n0.getStrings(str_array4, locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test258() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test258"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array14 = new java.lang.String[] { "GMC", "coins", "GMCry", "GMCry", "GMChide", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str15 = commandVanish0.getTabCompletion(commandSender5, command6, "GMChide", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);

  }

  @Test
  public void test259() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test259"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test260() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test260"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-1024));

  }

  @Test
  public void test261() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test261"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriends commandFriends1 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str2 = commandFriends1.getName();
    java.lang.String str3 = commandFriends1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriends1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));

  }

  @Test
  public void test262() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test262"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array13 = new java.lang.String[] { "lobby", "groundmc.lobby.silent", "coins", "hi!", "GMCx", "groundmc.lobby.admin" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b14 = commandFriends0.execute(commandSender4, command5, "lobby", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test263() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test263"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array3 = new java.lang.String[] { "friend", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array5 = i18n0.getStrings(str_array3, "lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array3);

  }

  @Test
  public void test264() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test264"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array14 = new java.lang.String[] { "GMCx", "lobby", "coins", "friend", "groundmc.lobby.hide_players", "GMCx" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str15 = commandVanish0.getTabCompletion(commandSender5, command6, "GMC", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);

  }

  @Test
  public void test265() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test265"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "GMCrx", "friends", "GMCx", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandCoins0.getTabCompletion(commandSender1, command2, "groundmc.lobby.admin", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test266() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test266"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("GMC");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test267() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test267"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)(byte)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 102400);

  }

  @Test
  public void test268() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test268"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 32768);

  }

  @Test
  public void test269() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test269"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMCry" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandCoins0.getTabCompletion(commandSender5, command6, "groundmc.lobby.admin", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test270() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test270"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(short)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-1048576));

  }

  @Test
  public void test271() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test271"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array1 = new java.lang.String[] {  };
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array3 = i18n0.getStrings(str_array1, locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array1);

  }

  @Test
  public void test272() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test272"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("friend", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test273() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test273"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandVanish0.execute(commandSender2, command3, "coins", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test274() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test274"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("lobby", "groundmc.lobby.admin", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test275() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test275"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandVanish0.execute(commandSender2, command3, "GMC", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test276() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test276"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "GMCx", "vanish", "friend", "friends", "hi!", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandCoins0.getTabCompletion(commandSender1, command2, "groundmc.lobby.silent", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test277() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test277"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandCoins0.getTabCompletion(commandSender4, command5, "groundmc.lobby.hide_players", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test278() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test278"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandVanish0.execute(commandSender1, command2, "friends", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test279() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test279"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "friend", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandCoins0.execute(commandSender4, command5, "lobby", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test280() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test280"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = commandVanish0.getCommandHelp(locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));

  }

  @Test
  public void test281() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test281"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "GMC", "lobby", "friend", "GMCry" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandFriend0.execute(commandSender1, command2, "GMCrx", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test282() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test282"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] { "friend", "vanish", "friend", "friend", "GMCry", "GMCsilent" };
    java.util.Locale locale9 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array10 = i18n0.getStrings(str_array8, locale9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test283() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test283"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("hi!", "", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test284() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test284"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandVanish0.getTabCompletion(commandSender4, command5, "groundmc.lobby.admin", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test285() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test285"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("GMChide", "friends");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test286() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test286"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "GMCrx", "", "groundmc.lobby.vanish", "GMCx", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandFriends0.execute(commandSender4, command5, "lobby", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test287() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test287"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array13 = new java.lang.String[] { "GMChide", "lobby", "hi!", "friend", "groundmc.lobby.silent", "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandFriends0.getTabCompletion(commandSender4, command5, "coins", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test288() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test288"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    java.lang.String str8 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender9 = null;
    org.bukkit.command.Command command10 = null;
    java.lang.String[] str_array15 = new java.lang.String[] { "GMC", "vanish", "groundmc.lobby.hide_players" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b16 = commandFriend0.execute(commandSender9, command10, "coins", str_array15);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "friend"+ "'", str8.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);

  }

  @Test
  public void test289() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test289"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "hi!", "friends", "friends", "friend", "friend", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandFriend0.getTabCompletion(commandSender2, command3, "lobby", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test290() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test290"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandFriends0.execute(commandSender3, command4, "friend", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test291() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test291"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("friends", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test292() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test292"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1048576);

  }

  @Test
  public void test293() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test293"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "groundmc.lobby.silent", "", "GMC", "groundmc.lobby.vanish", "GMChide", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandCoins0.getTabCompletion(commandSender2, command3, "GMChide", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test294() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test294"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandFriends0.execute(commandSender2, command3, "vanish", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test295() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test295"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "GMCx", "GMCry" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandCoins0.execute(commandSender1, command2, "GMCrx", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test296() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test296"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandVanish0.getTabCompletion(commandSender4, command5, "", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));

  }

  @Test
  public void test297() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test297"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandFriends0.execute(commandSender1, command2, "", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test298() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test298"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "GMCry", "groundmc.lobby.admin", "GMCrx", "hi!", "groundmc.lobby.silent", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandFriends0.execute(commandSender2, command3, "GMChide", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test299() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test299"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "GMCry", "GMChide", "GMCrx", "lobby", "GMC" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandVanish0.getTabCompletion(commandSender4, command5, "vanish", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test300() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test300"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] { "hi!", "groundmc.lobby.vanish", "GMCsilent", "GMCx", "GMC" };
    java.util.Locale locale8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array9 = i18n0.getStrings(str_array7, locale8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test301() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test301"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array5 = commandFriends0.getCommandHelp(locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));

  }

  @Test
  public void test302() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test302"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "hi!", "groundmc.lobby.vanish", "GMChide", "vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandFriend0.execute(commandSender5, command6, "GMCx", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test303() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test303"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("groundmc.lobby.admin", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test304() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test304"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array4 = new java.lang.String[] { "friend", "GMChide", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = i18n0.getStrings(str_array4, "lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test305() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test305"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandVanish0.execute(commandSender1, command2, "GMCrx", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test306() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test306"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array14 = new java.lang.String[] { "GMCsilent", "groundmc.lobby.vanish", "friend", "groundmc.lobby.admin", "GMCry" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str15 = commandFriend0.getTabCompletion(commandSender6, command7, "GMCx", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);

  }

  @Test
  public void test307() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test307"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = null;
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandFriends0.execute(commandSender4, command5, "GMCry", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));

  }

  @Test
  public void test308() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test308"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriend commandFriend1 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str2 = commandFriend1.getName();
    java.lang.String str3 = commandFriend1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriend1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));

  }

  @Test
  public void test309() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test309"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "GMCrx", "GMCsilent" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandVanish0.getTabCompletion(commandSender3, command4, "coins", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test310() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test310"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMCsilent", "GMCx", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandVanish0.execute(commandSender3, command4, "GMCsilent", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test311() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test311"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = null;
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandCoins0.execute(commandSender1, command2, "", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test312() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test312"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array6 = new java.lang.String[] { "friends", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b7 = commandFriends0.execute(commandSender1, command2, "friend", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test313() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test313"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMCry", "", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test314() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test314"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandCoins0.getTabCompletion(commandSender4, command5, "GMChide", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test315() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test315"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "friend", "coins", "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandVanish0.execute(commandSender2, command3, "", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test316() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test316"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test317() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test317"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("groundmc.lobby.silent", "GMCsilent", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test318() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test318"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "GMChide", "GMC", "GMCx", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandFriends0.getTabCompletion(commandSender1, command2, "GMCx", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test319() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test319"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array13 = new java.lang.String[] { "groundmc.lobby.hide_players", "GMChide", "vanish", "GMChide", "friend", "GMCry" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b14 = commandFriend0.execute(commandSender4, command5, "lobby", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test320() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test320"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "GMCsilent", "friends", "GMCx", "hi!", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandCoins0.getTabCompletion(commandSender3, command4, "groundmc.lobby.hide_players", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test321() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test321"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.silent", "friends", "groundmc.lobby.admin", "groundmc.lobby.hide_players", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandLobby0.getTabCompletion(commandSender2, command3, "hi!", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test322() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test322"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandVanish0.execute(commandSender3, command4, "friends", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test323() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test323"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((-1024));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-1073741824));

  }

  @Test
  public void test324() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test324"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMCry", "coins", "GMCry" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandLobby0.execute(commandSender3, command4, "GMChide", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test325() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test325"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array14 = new java.lang.String[] { "vanish", "GMCry", "GMC", "GMCsilent", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str15 = commandVanish0.getTabCompletion(commandSender6, command7, "GMCrx", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);

  }

  @Test
  public void test326() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test326"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("GMCx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test327() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test327"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("friends", "groundmc.lobby.vanish", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test328() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test328"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "groundmc.lobby.vanish", "groundmc.lobby.silent", "vanish", "friends", "GMCrx", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandFriends0.execute(commandSender3, command4, "groundmc.lobby.hide_players", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test329() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test329"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("GMC", "");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test330() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test330"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = i18n0.getString("GMCsilent", "GMC");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');

  }

  @Test
  public void test331() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test331"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("friends");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test332() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test332"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "GMChide", "groundmc.lobby.hide_players", "coins", "lobby", "", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandFriends0.getTabCompletion(commandSender1, command2, "groundmc.lobby.silent", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test333() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test333"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = i18n0.getString("GMCrx", "coins");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');

  }

  @Test
  public void test334() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test334"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(10240);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-2147483648));

  }

  @Test
  public void test335() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test335"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "coins", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandFriends0.execute(commandSender3, command4, "", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test336() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test336"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = resourceBundleCache1.get("GMC", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));

  }

  @Test
  public void test337() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test337"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMCry", "friend", "GMChide", "hi!", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandLobby0.execute(commandSender1, command2, "coins", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test338() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test338"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = i18n0.getString("friend", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');

  }

  @Test
  public void test339() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test339"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str8 = commandFriends0.getTabCompletion(commandSender3, command4, "GMCsilent", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test340() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test340"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)(short)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test341() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test341"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandLobby commandLobby1 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str2 = commandLobby1.getName();
    java.lang.String str3 = commandLobby1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandLobby1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));

  }

  @Test
  public void test342() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test342"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(99328);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1073741824);

  }

  @Test
  public void test343() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test343"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMCsilent", "lobby", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test344() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test344"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array15 = new java.lang.String[] { "GMCrx", "hi!", "groundmc.lobby.admin", "groundmc.lobby.admin", "groundmc.lobby.admin", "groundmc.lobby.admin" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str16 = commandFriend0.getTabCompletion(commandSender6, command7, "vanish", str_array15);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);

  }

  @Test
  public void test345() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test345"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(1073741824);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test346() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test346"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("GMCry", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test347() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test347"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "coins", "lobby", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandCoins0.execute(commandSender2, command3, "", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test348() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test348"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(10485760);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-2147483648));

  }

  @Test
  public void test349() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test349"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = i18n0.getString("groundmc.lobby.admin", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');

  }

  @Test
  public void test350() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test350"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str7 = commandFriends0.getTabCompletion(commandSender3, command4, "lobby", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));

  }

  @Test
  public void test351() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test351"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "groundmc.lobby.hide_players", "GMC", "GMC", "GMCry", "coins", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandFriend0.execute(commandSender1, command2, "vanish", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test352() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test352"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    java.lang.String[] str_array9 = new java.lang.String[] { "groundmc.lobby.silent", "vanish", "GMC", "GMCx", "coins", "groundmc.lobby.silent" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array11 = i18n0.getStrings(str_array9, "GMCx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test353() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test353"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    gtlp.groundmc.lobby.util.I18n i18n4 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char5 = i18n4.getColorChar();
    java.lang.String[] str_array6 = new java.lang.String[] {  };
    java.lang.String[] str_array8 = i18n4.getStrings(str_array6, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandFriends0.getTabCompletion(commandSender1, command2, "GMCrx", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test354() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test354"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    java.lang.String[] str_array10 = new java.lang.String[] {  };
    java.lang.String[] str_array12 = i18n8.getStrings(str_array10, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandFriend0.getTabCompletion(commandSender5, command6, "lobby", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test355() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test355"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandVanish commandVanish1 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str2 = commandVanish1.getName();
    java.lang.String str3 = commandVanish1.getName();
    java.lang.String str4 = commandVanish1.getName();
    java.lang.String str5 = commandVanish1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandVanish1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));

  }

  @Test
  public void test356() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test356"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("groundmc.lobby.vanish");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test357() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test357"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array7 = commandVanish0.getCommandHelp(locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));

  }

  @Test
  public void test358() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test358"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("groundmc.lobby.hide_players", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test359() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test359"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1024);

  }

  @Test
  public void test360() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test360"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender8 = null;
    org.bukkit.command.Command command9 = null;
    java.lang.String[] str_array16 = new java.lang.String[] { "groundmc.lobby.silent", "GMChide", "groundmc.lobby.admin", "lobby", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str17 = commandFriend0.getTabCompletion(commandSender8, command9, "lobby", str_array16);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);

  }

  @Test
  public void test361() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test361"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    java.lang.String[] str_array11 = new java.lang.String[] {  };
    java.lang.String[] str_array13 = i18n9.getStrings(str_array11, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandVanish0.getTabCompletion(commandSender6, command7, "", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test362() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test362"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.util.Locale locale2 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str3 = i18n0.getString("groundmc.lobby.vanish", locale2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);

  }

  @Test
  public void test363() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test363"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandVanish0.execute(commandSender2, command3, "groundmc.lobby.admin", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test364() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test364"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = i18n0.getString("friend", "GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');

  }

  @Test
  public void test365() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test365"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandFriends0.getTabCompletion(commandSender3, command4, "groundmc.lobby.admin", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test366() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test366"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b5 = commandVanish0.execute(commandSender1, command2, "GMCrx", str_array4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test367() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test367"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandCoins0.getTabCompletion(commandSender2, command3, "lobby", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test368() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test368"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    java.lang.String str3 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    java.lang.String[] str_array9 = new java.lang.String[] {  };
    java.lang.String[] str_array11 = i18n7.getStrings(str_array9, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandLobby0.getTabCompletion(commandSender4, command5, "GMCrx", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test369() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test369"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(1024);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1073741824);

  }

  @Test
  public void test370() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test370"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("groundmc.lobby.hide_players");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test371() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test371"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    java.lang.String[] str_array11 = new java.lang.String[] {  };
    java.lang.String[] str_array13 = i18n9.getStrings(str_array11, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandVanish0.getTabCompletion(commandSender6, command7, "groundmc.lobby.admin", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test372() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test372"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandLobby0.execute(commandSender2, command3, "lobby", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test373() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test373"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes(32768);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 33554432);

  }

  @Test
  public void test374() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test374"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = i18n0.getString("groundmc.lobby.silent", "friend");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test375() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test375"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = i18n0.getString("", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');

  }

  @Test
  public void test376() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test376"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "friends", "groundmc.lobby.vanish", "groundmc.lobby.admin" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandVanish0.getTabCompletion(commandSender5, command6, "friend", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test377() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test377"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandCoins commandCoins1 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str2 = commandCoins1.getName();
    java.lang.String str3 = commandCoins1.getName();
    java.lang.String str4 = commandCoins1.getName();
    java.lang.String str5 = commandCoins1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandCoins1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "coins"+ "'", str5.equals("coins"));

  }

  @Test
  public void test378() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test378"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "GMChide", "groundmc.lobby.hide_players", "hi!", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandFriend0.getTabCompletion(commandSender3, command4, "GMCsilent", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test379() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test379"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    java.lang.String[] str_array11 = new java.lang.String[] {  };
    java.lang.String[] str_array13 = i18n9.getStrings(str_array11, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandVanish0.getTabCompletion(commandSender6, command7, "GMCsilent", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test380() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test380"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("friend");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test381() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test381"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    java.lang.String[] str_array2 = new java.lang.String[] { "groundmc.lobby.admin" };
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);

  }

  @Test
  public void test382() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test382"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = resourceBundleCache1.get("coins", locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));

  }

  @Test
  public void test383() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test383"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    java.lang.String str4 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    java.lang.String[] str_array10 = new java.lang.String[] {  };
    java.lang.String[] str_array12 = i18n8.getStrings(str_array10, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandFriends0.getTabCompletion(commandSender5, command6, "GMCsilent", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friends"+ "'", str4.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test384() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test384"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    java.util.Locale locale8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array9 = commandFriend0.getCommandHelp(locale8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));

  }

  @Test
  public void test385() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test385"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriends commandFriends1 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str2 = commandFriends1.getName();
    java.lang.String str3 = commandFriends1.getName();
    java.lang.String str4 = commandFriends1.getName();
    java.lang.String str5 = commandFriends1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriends1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friends"+ "'", str4.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friends"+ "'", str5.equals("friends"));

  }

  @Test
  public void test386() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test386"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((-1024));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == (-1048576));

  }

  @Test
  public void test387() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test387"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "groundmc.lobby.admin", "groundmc.lobby.hide_players", "GMC", "hi!" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandFriends0.execute(commandSender4, command5, "GMCry", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test388() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test388"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender3, command4, "groundmc.lobby.silent", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test389() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test389"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    java.lang.String str4 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "groundmc.lobby.hide_players", "GMCsilent", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandFriends0.execute(commandSender5, command6, "", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friends"+ "'", str4.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test390() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test390"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender3, command4, "GMCsilent", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test391() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test391"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCx");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("groundmc.lobby.admin", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test392() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test392"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandCoins0.getTabCompletion(commandSender2, command3, "vanish", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test393() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test393"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriends commandFriends1 = new gtlp.groundmc.lobby.commands.CommandFriends();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriends1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test394() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test394"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    java.lang.String[] str_array9 = new java.lang.String[] {  };
    java.lang.String[] str_array11 = i18n7.getStrings(str_array9, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandFriends0.getTabCompletion(commandSender4, command5, "GMChide", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test395() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test395"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandCoins0.getTabCompletion(commandSender3, command4, "groundmc.lobby.hide_players", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test396() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test396"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] { "GMChide", "GMCsilent", "", "GMChide", "friend" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array10 = i18n0.getStrings(str_array8, "GMCx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test397() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test397"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    char char11 = i18n9.getColorChar();
    char char12 = i18n9.getColorChar();
    char char13 = i18n9.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n14 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char15 = i18n14.getColorChar();
    java.lang.String[] str_array16 = new java.lang.String[] {  };
    java.lang.String[] str_array18 = i18n14.getStrings(str_array16, "groundmc.lobby.vanish");
    java.lang.String[] str_array20 = i18n9.getStrings(str_array18, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str21 = commandVanish0.getTabCompletion(commandSender6, command7, "GMC", str_array20);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array20);

  }

  @Test
  public void test398() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test398"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMCx", "GMCsilent", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test399() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test399"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("GMCrx", "coins", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test400() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test400"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("GMCrx");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test401() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test401"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    java.lang.String[] str_array6 = new java.lang.String[] { "lobby", "", "GMCrx" };
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array8 = i18n0.getStrings(str_array6, "GMC");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test402() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test402"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "lobby", "GMCsilent", "", "groundmc.lobby.vanish" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandVanish0.execute(commandSender2, command3, "GMC", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test403() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test403"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandLobby0.getTabCompletion(commandSender2, command3, "", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test404() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test404"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = resourceBundleCache1.get("", locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + ""+ "'", str2.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + ""+ "'", str3.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + ""+ "'", str4.equals(""));

  }

  @Test
  public void test405() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test405"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    char char5 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str8 = i18n0.getString("GMCry", "lobby");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');

  }

  @Test
  public void test406() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test406"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = i18n0.getString("friends", locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);

  }

  @Test
  public void test407() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test407"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array7 = new java.lang.String[] { "friends", "GMChide", "" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b8 = commandVanish0.execute(commandSender1, command2, "coins", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);

  }

  @Test
  public void test408() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test408"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "GMCsilent", "", "friends" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandLobby0.getTabCompletion(commandSender3, command4, "", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test409() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test409"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str19 = commandVanish0.getTabCompletion(commandSender4, command5, "coins", str_array16);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);

  }

  @Test
  public void test410() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test410"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("friend");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("groundmc.lobby.hide_players", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test411() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test411"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "friends" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandFriends0.getTabCompletion(commandSender4, command5, "GMCsilent", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test412() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test412"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    char char7 = i18n5.getColorChar();
    char char8 = i18n5.getColorChar();
    char char9 = i18n5.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n10 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char11 = i18n10.getColorChar();
    java.lang.String[] str_array12 = new java.lang.String[] {  };
    java.lang.String[] str_array14 = i18n10.getStrings(str_array12, "groundmc.lobby.vanish");
    java.lang.String[] str_array16 = i18n5.getStrings(str_array14, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str17 = commandLobby0.getTabCompletion(commandSender2, command3, "", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);

  }

  @Test
  public void test413() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test413"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("GMCy");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test414() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test414"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str6 = commandVanish0.getTabCompletion(commandSender2, command3, "GMCrx", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));

  }

  @Test
  public void test415() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test415"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    java.lang.String[] str_array9 = new java.lang.String[] {  };
    java.lang.String[] str_array11 = i18n7.getStrings(str_array9, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b12 = commandFriend0.execute(commandSender4, command5, "vanish", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test416() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test416"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandVanish0.getTabCompletion(commandSender3, command4, "friends", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test417() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test417"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    java.lang.String str4 = commandFriends0.getName();
    java.util.Locale locale5 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array6 = commandFriends0.getCommandHelp(locale5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friends"+ "'", str4.equals("friends"));

  }

  @Test
  public void test418() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test418"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    java.lang.String str4 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    java.lang.String[] str_array10 = new java.lang.String[] {  };
    java.lang.String[] str_array12 = i18n8.getStrings(str_array10, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandFriends0.getTabCompletion(commandSender5, command6, "GMCy", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friends"+ "'", str4.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test419() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test419"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    char char5 = i18n0.getColorChar();
    char char6 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str9 = i18n0.getString("GMCrx", "groundmc.lobby.hide_players");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');

  }

  @Test
  public void test420() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test420"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    java.lang.String[] str_array10 = new java.lang.String[] {  };
    java.lang.String[] str_array12 = i18n8.getStrings(str_array10, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandVanish0.getTabCompletion(commandSender5, command6, "groundmc.lobby.hide_players", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test421() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test421"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("GMCy");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test422() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test422"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 104857600);

  }

  @Test
  public void test423() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test423"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandLobby0.getTabCompletion(commandSender2, command3, "coins", str_array7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test424() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test424"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    char char8 = i18n6.getColorChar();
    char char9 = i18n6.getColorChar();
    char char10 = i18n6.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    java.lang.String[] str_array13 = new java.lang.String[] {  };
    java.lang.String[] str_array15 = i18n11.getStrings(str_array13, "groundmc.lobby.vanish");
    java.lang.String[] str_array17 = i18n6.getStrings(str_array15, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str18 = commandVanish0.getTabCompletion(commandSender3, command4, "GMCry", str_array15);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);

  }

  @Test
  public void test425() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test425"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandCoins commandCoins1 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str2 = commandCoins1.getName();
    java.lang.String str3 = commandCoins1.getName();
    java.lang.String str4 = commandCoins1.getName();
    java.lang.String str5 = commandCoins1.getName();
    java.lang.String str6 = commandCoins1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandCoins1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "coins"+ "'", str5.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "coins"+ "'", str6.equals("coins"));

  }

  @Test
  public void test426() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test426"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    java.lang.String str8 = commandFriend0.getName();
    java.lang.String str9 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender10 = null;
    org.bukkit.command.Command command11 = null;
    gtlp.groundmc.lobby.util.I18n i18n13 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char14 = i18n13.getColorChar();
    java.lang.String[] str_array15 = new java.lang.String[] {  };
    java.lang.String[] str_array17 = i18n13.getStrings(str_array15, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str18 = commandFriend0.getTabCompletion(commandSender10, command11, "vanish", str_array17);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "friend"+ "'", str8.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str9 + "' != '" + "friend"+ "'", str9.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);

  }

  @Test
  public void test427() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test427"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    gtlp.groundmc.lobby.util.I18n i18n4 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char5 = i18n4.getColorChar();
    java.lang.String[] str_array6 = new java.lang.String[] {  };
    java.lang.String[] str_array8 = i18n4.getStrings(str_array6, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b9 = commandVanish0.execute(commandSender1, command2, "groundmc.lobby.hide_players", str_array6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test428() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test428"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((int)'#');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 36700160);

  }

  @Test
  public void test429() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test429"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandFriends0.execute(commandSender3, command4, "GMChide", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test430() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test430"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str19 = commandCoins0.getTabCompletion(commandSender4, command5, "", str_array18);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);

  }

  @Test
  public void test431() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test431"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    char char4 = i18n0.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    java.lang.String[] str_array11 = i18n0.getStrings(str_array9, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str14 = i18n0.getString("GMChide", "groundmc.lobby.admin");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char4 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test432() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test432"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str19 = commandFriend0.getTabCompletion(commandSender4, command5, "lobby", str_array18);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);

  }

  @Test
  public void test433() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test433"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    java.lang.String[] str_array8 = new java.lang.String[] { "groundmc.lobby.vanish", "GMChide", "coins", "GMChide" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandVanish0.getTabCompletion(commandSender1, command2, "hi!", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);

  }

  @Test
  public void test434() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test434"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array11 = new java.lang.String[] { "", "GMCrx", "coins" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandCoins0.getTabCompletion(commandSender5, command6, "groundmc.lobby.hide_players", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test435() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test435"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    char char8 = i18n6.getColorChar();
    char char9 = i18n6.getColorChar();
    char char10 = i18n6.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    java.lang.String[] str_array13 = new java.lang.String[] {  };
    java.lang.String[] str_array15 = i18n11.getStrings(str_array13, "groundmc.lobby.vanish");
    java.lang.String[] str_array17 = i18n6.getStrings(str_array15, "friends");
    // The following exception was thrown during execution in test generation
    try {
    boolean b18 = commandFriends0.execute(commandSender3, command4, "", str_array17);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);

  }

  @Test
  public void test436() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test436"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    java.lang.String[] str_array8 = new java.lang.String[] {  };
    java.lang.String[] str_array10 = i18n6.getStrings(str_array8, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str11 = commandLobby0.getTabCompletion(commandSender3, command4, "friends", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test437() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test437"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender8 = null;
    org.bukkit.command.Command command9 = null;
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    java.lang.String[] str_array13 = new java.lang.String[] {  };
    java.lang.String[] str_array15 = i18n11.getStrings(str_array13, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str16 = commandFriend0.getTabCompletion(commandSender8, command9, "GMC", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);

  }

  @Test
  public void test438() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test438"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = resourceBundleCache1.get("GMCx", locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + ""+ "'", str2.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + ""+ "'", str3.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + ""+ "'", str4.equals(""));

  }

  @Test
  public void test439() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test439"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str19 = commandFriends0.getTabCompletion(commandSender4, command5, "lobby", str_array16);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);

  }

  @Test
  public void test440() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test440"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    char char10 = i18n8.getColorChar();
    char char11 = i18n8.getColorChar();
    char char12 = i18n8.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n13 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char14 = i18n13.getColorChar();
    java.lang.String[] str_array15 = new java.lang.String[] {  };
    java.lang.String[] str_array17 = i18n13.getStrings(str_array15, "groundmc.lobby.vanish");
    java.lang.String[] str_array19 = i18n8.getStrings(str_array17, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str20 = commandCoins0.getTabCompletion(commandSender5, command6, "lobby", str_array17);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array19);

  }

  @Test
  public void test441() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test441"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    gtlp.groundmc.lobby.util.I18n i18n4 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char5 = i18n4.getColorChar();
    char char6 = i18n4.getColorChar();
    char char7 = i18n4.getColorChar();
    char char8 = i18n4.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    java.lang.String[] str_array11 = new java.lang.String[] {  };
    java.lang.String[] str_array13 = i18n9.getStrings(str_array11, "groundmc.lobby.vanish");
    java.lang.String[] str_array15 = i18n4.getStrings(str_array13, "friends");
    // The following exception was thrown during execution in test generation
    try {
    boolean b16 = commandFriends0.execute(commandSender1, command2, "GMCrx", str_array13);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);

  }

  @Test
  public void test442() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test442"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    java.lang.String str3 = commandLobby0.getName();
    java.lang.String str4 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandLobby0.getTabCompletion(commandSender5, command6, "hi!", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "lobby"+ "'", str4.equals("lobby"));

  }

  @Test
  public void test443() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test443"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandFriends0.getTabCompletion(commandSender2, command3, "coins", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test444() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test444"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    java.lang.String str3 = commandLobby0.getName();
    java.lang.String str4 = commandLobby0.getName();
    java.lang.String str5 = commandLobby0.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array7 = commandLobby0.getCommandHelp(locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "lobby"+ "'", str4.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "lobby"+ "'", str5.equals("lobby"));

  }

  @Test
  public void test445() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test445"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    char char5 = i18n0.getColorChar();
    char char6 = i18n0.getColorChar();
    char char7 = i18n0.getColorChar();
    java.lang.String[] str_array8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array10 = i18n0.getStrings(str_array8, "friend");
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');

  }

  @Test
  public void test446() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test446"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("groundmc.lobby.admin");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test447() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test447"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    char char7 = i18n5.getColorChar();
    char char8 = i18n5.getColorChar();
    char char9 = i18n5.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n10 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char11 = i18n10.getColorChar();
    java.lang.String[] str_array12 = new java.lang.String[] {  };
    java.lang.String[] str_array14 = i18n10.getStrings(str_array12, "groundmc.lobby.vanish");
    java.lang.String[] str_array16 = i18n5.getStrings(str_array14, "coins");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str17 = commandFriend0.getTabCompletion(commandSender2, command3, "GMCsilent", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);

  }

  @Test
  public void test448() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test448"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    java.lang.String[] str_array12 = new java.lang.String[] { "groundmc.lobby.vanish", "", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b13 = commandVanish0.execute(commandSender6, command7, "", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

  @Test
  public void test449() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test449"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    java.lang.String[] str_array9 = new java.lang.String[] {  };
    java.lang.String[] str_array11 = i18n7.getStrings(str_array9, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str12 = commandFriends0.getTabCompletion(commandSender4, command5, "GMC", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);

  }

  @Test
  public void test450() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test450"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.lang.String str5 = resourceBundleCache1.getName();
    java.util.Locale locale7 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str8 = resourceBundleCache1.get("GMCrx", locale7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + ""+ "'", str2.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + ""+ "'", str3.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + ""+ "'", str4.equals(""));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + ""+ "'", str5.equals(""));

  }

  @Test
  public void test451() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test451"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    char char10 = i18n8.getColorChar();
    char char11 = i18n8.getColorChar();
    char char12 = i18n8.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n13 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char14 = i18n13.getColorChar();
    java.lang.String[] str_array15 = new java.lang.String[] {  };
    java.lang.String[] str_array17 = i18n13.getStrings(str_array15, "groundmc.lobby.vanish");
    java.lang.String[] str_array19 = i18n8.getStrings(str_array17, "coins");
    // The following exception was thrown during execution in test generation
    try {
    boolean b20 = commandVanish0.execute(commandSender5, command6, "vanish", str_array19);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array19);

  }

  @Test
  public void test452() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test452"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array10 = new java.lang.String[] { "GMCsilent", "lobby" };
    // The following exception was thrown during execution in test generation
    try {
    boolean b11 = commandVanish0.execute(commandSender5, command6, "GMCx", str_array10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);

  }

  @Test
  public void test453() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test453"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    char char4 = i18n0.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    char char7 = i18n5.getColorChar();
    char char8 = i18n5.getColorChar();
    char char9 = i18n5.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n10 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char11 = i18n10.getColorChar();
    java.lang.String[] str_array12 = new java.lang.String[] {  };
    java.lang.String[] str_array14 = i18n10.getStrings(str_array12, "groundmc.lobby.vanish");
    java.lang.String[] str_array16 = i18n5.getStrings(str_array14, "coins");
    java.util.Locale locale17 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array18 = i18n0.getStrings(str_array16, locale17);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char4 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);

  }

  @Test
  public void test454() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test454"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    java.lang.String[] str_array11 = new java.lang.String[] {  };
    java.lang.String[] str_array13 = i18n9.getStrings(str_array11, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str14 = commandFriend0.getTabCompletion(commandSender6, command7, "groundmc.lobby.admin", str_array11);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);

  }

  @Test
  public void test455() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test455"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    java.lang.String str5 = commandCoins0.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array7 = commandCoins0.getCommandHelp(locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "coins"+ "'", str5.equals("coins"));

  }

  @Test
  public void test456() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test456"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    char char11 = i18n9.getColorChar();
    char char12 = i18n9.getColorChar();
    char char13 = i18n9.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n14 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char15 = i18n14.getColorChar();
    java.lang.String[] str_array16 = new java.lang.String[] {  };
    java.lang.String[] str_array18 = i18n14.getStrings(str_array16, "groundmc.lobby.vanish");
    java.lang.String[] str_array20 = i18n9.getStrings(str_array18, "coins");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str21 = commandVanish0.getTabCompletion(commandSender6, command7, "hi!", str_array18);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array20);

  }

  @Test
  public void test457() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test457"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand2 = companion0.getCommand("friend");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test458() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test458"); }

    gtlp.groundmc.lobby.util.I18nUtils i18nUtils0 = gtlp.groundmc.lobby.util.I18nUtils.INSTANCE;
    // The following exception was thrown during execution in test generation
    try {
    java.util.Locale locale2 = i18nUtils0.getLocaleFromString("coins");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18nUtils0);

  }

  @Test
  public void test459() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test459"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str19 = commandFriends0.getTabCompletion(commandSender4, command5, "GMCrx", str_array18);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);

  }

  @Test
  public void test460() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test460"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMCrx");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.lang.String str3 = resourceBundleCache1.getName();
    java.lang.String str4 = resourceBundleCache1.getName();
    java.util.Locale locale6 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = resourceBundleCache1.get("GMCx", locale6);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "GMCrx"+ "'", str2.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "GMCrx"+ "'", str3.equals("GMCrx"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "GMCrx"+ "'", str4.equals("GMCrx"));

  }

  @Test
  public void test461() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test461"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("friend");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("friend", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test462() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test462"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n2 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char3 = i18n2.getColorChar();
    java.lang.String[] str_array4 = new java.lang.String[] {  };
    java.lang.String[] str_array6 = i18n2.getStrings(str_array4, "groundmc.lobby.vanish");
    java.util.Locale locale7 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array8 = i18n0.getStrings(str_array4, locale7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array6);

  }

  @Test
  public void test463() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test463"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("groundmc.lobby.vanish", "lobby", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test464() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test464"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n3 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char4 = i18n3.getColorChar();
    char char5 = i18n3.getColorChar();
    char char6 = i18n3.getColorChar();
    char char7 = i18n3.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    java.lang.String[] str_array10 = new java.lang.String[] {  };
    java.lang.String[] str_array12 = i18n8.getStrings(str_array10, "groundmc.lobby.vanish");
    java.lang.String[] str_array14 = i18n3.getStrings(str_array12, "friends");
    gtlp.groundmc.lobby.util.I18n i18n15 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char16 = i18n15.getColorChar();
    char char17 = i18n15.getColorChar();
    char char18 = i18n15.getColorChar();
    char char19 = i18n15.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n20 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char21 = i18n20.getColorChar();
    java.lang.String[] str_array22 = new java.lang.String[] {  };
    java.lang.String[] str_array24 = i18n20.getStrings(str_array22, "groundmc.lobby.vanish");
    java.lang.String[] str_array26 = i18n15.getStrings(str_array24, "coins");
    java.lang.String[] str_array28 = i18n3.getStrings(str_array24, "groundmc.lobby.hide_players");
    java.util.Locale locale29 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array30 = i18n0.getStrings(str_array28, locale29);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char4 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char16 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char17 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char18 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char19 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char21 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array28);

  }

  @Test
  public void test465() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test465"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "coins");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str19 = commandCoins0.getTabCompletion(commandSender4, command5, "groundmc.lobby.hide_players", str_array16);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);

  }

  @Test
  public void test466() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test466"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes((-2147483648));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test467() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test467"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    java.lang.String str3 = commandLobby0.getName();
    java.lang.String str4 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    char char10 = i18n8.getColorChar();
    char char11 = i18n8.getColorChar();
    char char12 = i18n8.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n13 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char14 = i18n13.getColorChar();
    java.lang.String[] str_array15 = new java.lang.String[] {  };
    java.lang.String[] str_array17 = i18n13.getStrings(str_array15, "groundmc.lobby.vanish");
    java.lang.String[] str_array19 = i18n8.getStrings(str_array17, "friends");
    gtlp.groundmc.lobby.util.I18n i18n20 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char21 = i18n20.getColorChar();
    char char22 = i18n20.getColorChar();
    char char23 = i18n20.getColorChar();
    char char24 = i18n20.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n25 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char26 = i18n25.getColorChar();
    java.lang.String[] str_array27 = new java.lang.String[] {  };
    java.lang.String[] str_array29 = i18n25.getStrings(str_array27, "groundmc.lobby.vanish");
    java.lang.String[] str_array31 = i18n20.getStrings(str_array29, "coins");
    java.lang.String[] str_array33 = i18n8.getStrings(str_array29, "groundmc.lobby.hide_players");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str34 = commandLobby0.getTabCompletion(commandSender5, command6, "GMChide", str_array29);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "lobby"+ "'", str4.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char21 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char23 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char24 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char26 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array33);

  }

  @Test
  public void test468() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test468"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("GMChide");
    java.util.Locale locale3 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str4 = resourceBundleCache1.get("GMCx", locale3);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test469() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test469"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    org.bukkit.command.CommandSender commandSender1 = null;
    org.bukkit.command.Command command2 = null;
    gtlp.groundmc.lobby.util.I18n i18n4 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char5 = i18n4.getColorChar();
    char char6 = i18n4.getColorChar();
    char char7 = i18n4.getColorChar();
    char char8 = i18n4.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    java.lang.String[] str_array11 = new java.lang.String[] {  };
    java.lang.String[] str_array13 = i18n9.getStrings(str_array11, "groundmc.lobby.vanish");
    java.lang.String[] str_array15 = i18n4.getStrings(str_array13, "friends");
    gtlp.groundmc.lobby.util.I18n i18n16 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char17 = i18n16.getColorChar();
    char char18 = i18n16.getColorChar();
    char char19 = i18n16.getColorChar();
    char char20 = i18n16.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n21 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char22 = i18n21.getColorChar();
    java.lang.String[] str_array23 = new java.lang.String[] {  };
    java.lang.String[] str_array25 = i18n21.getStrings(str_array23, "groundmc.lobby.vanish");
    java.lang.String[] str_array27 = i18n16.getStrings(str_array25, "coins");
    java.lang.String[] str_array29 = i18n4.getStrings(str_array25, "groundmc.lobby.hide_players");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str30 = commandLobby0.getTabCompletion(commandSender1, command2, "groundmc.lobby.vanish", str_array29);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char17 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char18 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char19 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char20 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array29);

  }

  @Test
  public void test470() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test470"); }

    gtlp.groundmc.lobby.util.I18n.ResourceBundleCache resourceBundleCache1 = new gtlp.groundmc.lobby.util.I18n.ResourceBundleCache("groundmc.lobby.hide_players");
    java.lang.String str2 = resourceBundleCache1.getName();
    java.util.Locale locale4 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = resourceBundleCache1.get("hi!", locale4);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "groundmc.lobby.hide_players"+ "'", str2.equals("groundmc.lobby.hide_players"));

  }

  @Test
  public void test471() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test471"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    char char5 = i18n0.getColorChar();
    java.util.Locale locale7 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str8 = i18n0.getString("GMCx", locale7);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');

  }

  @Test
  public void test472() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test472"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b10 = commandFriends0.execute(commandSender2, command3, "GMChide", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test473() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test473"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    java.lang.String[] str_array2 = new java.lang.String[] {  };
    java.lang.String[] str_array4 = i18n0.getStrings(str_array2, "groundmc.lobby.vanish");
    char char5 = i18n0.getColorChar();
    char char6 = i18n0.getColorChar();
    java.util.Locale locale8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str9 = i18n0.getString("friends", locale8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char5 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');

  }

  @Test
  public void test474() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test474"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    char char4 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str7 = i18n0.getString("GMC", "");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char4 == '&');

  }

  @Test
  public void test475() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test475"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    java.lang.String[] str_array9 = new java.lang.String[] { "groundmc.lobby.vanish", "groundmc.lobby.hide_players", "GMCsilent" };
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str10 = commandCoins0.getTabCompletion(commandSender3, command4, "GMCx", str_array9);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);

  }

  @Test
  public void test476() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test476"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    char char4 = i18n0.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    java.lang.String[] str_array7 = new java.lang.String[] {  };
    java.lang.String[] str_array9 = i18n5.getStrings(str_array7, "groundmc.lobby.vanish");
    java.lang.String[] str_array11 = i18n0.getStrings(str_array9, "friends");
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    char char14 = i18n12.getColorChar();
    char char15 = i18n12.getColorChar();
    char char16 = i18n12.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n17 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char18 = i18n17.getColorChar();
    java.lang.String[] str_array19 = new java.lang.String[] {  };
    java.lang.String[] str_array21 = i18n17.getStrings(str_array19, "groundmc.lobby.vanish");
    java.lang.String[] str_array23 = i18n12.getStrings(str_array21, "coins");
    java.lang.String[] str_array25 = i18n0.getStrings(str_array21, "groundmc.lobby.hide_players");
    gtlp.groundmc.lobby.util.I18n i18n26 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char27 = i18n26.getColorChar();
    char char28 = i18n26.getColorChar();
    char char29 = i18n26.getColorChar();
    char char30 = i18n26.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n31 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char32 = i18n31.getColorChar();
    java.lang.String[] str_array33 = new java.lang.String[] {  };
    java.lang.String[] str_array35 = i18n31.getStrings(str_array33, "groundmc.lobby.vanish");
    java.lang.String[] str_array37 = i18n26.getStrings(str_array35, "coins");
    java.util.Locale locale38 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String[] str_array39 = i18n0.getStrings(str_array35, locale38);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char4 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char16 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char18 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char27 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char28 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char29 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char30 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char32 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array37);

  }

  @Test
  public void test477() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test477"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getKilobytes((-2147483648));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test478() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test478"); }

    org.joda.time.DateTime dateTime2 = null;
    // The following exception was thrown during execution in test generation
    try {
    gtlp.groundmc.lobby.Relationship relationship3 = new gtlp.groundmc.lobby.Relationship("", "GMCry", dateTime2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test479() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test479"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 1048576);

  }

  @Test
  public void test480() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test480"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    char char8 = i18n6.getColorChar();
    char char9 = i18n6.getColorChar();
    char char10 = i18n6.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    java.lang.String[] str_array13 = new java.lang.String[] {  };
    java.lang.String[] str_array15 = i18n11.getStrings(str_array13, "groundmc.lobby.vanish");
    java.lang.String[] str_array17 = i18n6.getStrings(str_array15, "friends");
    gtlp.groundmc.lobby.util.I18n i18n18 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char19 = i18n18.getColorChar();
    char char20 = i18n18.getColorChar();
    char char21 = i18n18.getColorChar();
    char char22 = i18n18.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n23 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char24 = i18n23.getColorChar();
    java.lang.String[] str_array25 = new java.lang.String[] {  };
    java.lang.String[] str_array27 = i18n23.getStrings(str_array25, "groundmc.lobby.vanish");
    java.lang.String[] str_array29 = i18n18.getStrings(str_array27, "coins");
    java.lang.String[] str_array31 = i18n6.getStrings(str_array27, "groundmc.lobby.hide_players");
    gtlp.groundmc.lobby.util.I18n i18n32 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char33 = i18n32.getColorChar();
    char char34 = i18n32.getColorChar();
    char char35 = i18n32.getColorChar();
    char char36 = i18n32.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n37 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char38 = i18n37.getColorChar();
    java.lang.String[] str_array39 = new java.lang.String[] {  };
    java.lang.String[] str_array41 = i18n37.getStrings(str_array39, "groundmc.lobby.vanish");
    java.lang.String[] str_array43 = i18n32.getStrings(str_array41, "friends");
    java.lang.String[] str_array45 = i18n6.getStrings(str_array43, "GMCsilent");
    // The following exception was thrown during execution in test generation
    try {
    boolean b46 = commandLobby0.execute(commandSender3, command4, "groundmc.lobby.admin", str_array45);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char19 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char20 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char21 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char24 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char33 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char34 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char35 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char36 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char38 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array39);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array41);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array45);

  }

  @Test
  public void test481() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test481"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    java.lang.String str3 = commandVanish0.getName();
    java.lang.String str4 = commandVanish0.getName();
    java.lang.String str5 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    char char11 = i18n9.getColorChar();
    char char12 = i18n9.getColorChar();
    char char13 = i18n9.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n14 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char15 = i18n14.getColorChar();
    java.lang.String[] str_array16 = new java.lang.String[] {  };
    java.lang.String[] str_array18 = i18n14.getStrings(str_array16, "groundmc.lobby.vanish");
    java.lang.String[] str_array20 = i18n9.getStrings(str_array18, "friends");
    gtlp.groundmc.lobby.util.I18n i18n21 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char22 = i18n21.getColorChar();
    char char23 = i18n21.getColorChar();
    char char24 = i18n21.getColorChar();
    char char25 = i18n21.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n26 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char27 = i18n26.getColorChar();
    java.lang.String[] str_array28 = new java.lang.String[] {  };
    java.lang.String[] str_array30 = i18n26.getStrings(str_array28, "groundmc.lobby.vanish");
    java.lang.String[] str_array32 = i18n21.getStrings(str_array30, "coins");
    java.lang.String[] str_array34 = i18n9.getStrings(str_array30, "groundmc.lobby.hide_players");
    gtlp.groundmc.lobby.util.I18n i18n35 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char36 = i18n35.getColorChar();
    char char37 = i18n35.getColorChar();
    char char38 = i18n35.getColorChar();
    char char39 = i18n35.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n40 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char41 = i18n40.getColorChar();
    java.lang.String[] str_array42 = new java.lang.String[] {  };
    java.lang.String[] str_array44 = i18n40.getStrings(str_array42, "groundmc.lobby.vanish");
    java.lang.String[] str_array46 = i18n35.getStrings(str_array44, "friends");
    java.lang.String[] str_array48 = i18n9.getStrings(str_array46, "GMCsilent");
    // The following exception was thrown during execution in test generation
    try {
    boolean b49 = commandVanish0.execute(commandSender6, command7, "vanish", str_array48);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "vanish"+ "'", str3.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "vanish"+ "'", str4.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "vanish"+ "'", str5.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char23 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char24 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char25 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char27 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n35);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char36 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char37 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char38 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char39 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n40);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char41 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array46);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array48);

  }

  @Test
  public void test482() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test482"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandFriend commandFriend1 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str2 = commandFriend1.getName();
    java.lang.String str3 = commandFriend1.getName();
    java.lang.String str4 = commandFriend1.getName();
    java.lang.String str5 = commandFriend1.getName();
    java.lang.String str6 = commandFriend1.getName();
    java.lang.String str7 = commandFriend1.getName();
    java.lang.String str8 = commandFriend1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandFriend1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "friend"+ "'", str8.equals("friend"));

  }

  @Test
  public void test483() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test483"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    char char8 = i18n6.getColorChar();
    char char9 = i18n6.getColorChar();
    char char10 = i18n6.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    java.lang.String[] str_array13 = new java.lang.String[] {  };
    java.lang.String[] str_array15 = i18n11.getStrings(str_array13, "groundmc.lobby.vanish");
    java.lang.String[] str_array17 = i18n6.getStrings(str_array15, "friends");
    gtlp.groundmc.lobby.util.I18n i18n18 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char19 = i18n18.getColorChar();
    char char20 = i18n18.getColorChar();
    char char21 = i18n18.getColorChar();
    char char22 = i18n18.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n23 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char24 = i18n23.getColorChar();
    java.lang.String[] str_array25 = new java.lang.String[] {  };
    java.lang.String[] str_array27 = i18n23.getStrings(str_array25, "groundmc.lobby.vanish");
    java.lang.String[] str_array29 = i18n18.getStrings(str_array27, "coins");
    java.lang.String[] str_array31 = i18n6.getStrings(str_array27, "groundmc.lobby.hide_players");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str32 = commandVanish0.getTabCompletion(commandSender3, command4, "friend", str_array31);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char19 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char20 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char21 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char24 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array31);

  }

  @Test
  public void test484() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test484"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    java.lang.String str4 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    java.lang.String[] str_array8 = null;
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str9 = commandFriends0.getTabCompletion(commandSender5, command6, "hi!", str_array8);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friends"+ "'", str4.equals("friends"));

  }

  @Test
  public void test485() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test485"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    gtlp.groundmc.lobby.util.I18n i18n5 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char6 = i18n5.getColorChar();
    char char7 = i18n5.getColorChar();
    char char8 = i18n5.getColorChar();
    char char9 = i18n5.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n10 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char11 = i18n10.getColorChar();
    java.lang.String[] str_array12 = new java.lang.String[] {  };
    java.lang.String[] str_array14 = i18n10.getStrings(str_array12, "groundmc.lobby.vanish");
    java.lang.String[] str_array16 = i18n5.getStrings(str_array14, "friends");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str17 = commandVanish0.getTabCompletion(commandSender2, command3, "GMChide", str_array16);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char6 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);

  }

  @Test
  public void test486() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test486"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender8 = null;
    org.bukkit.command.Command command9 = null;
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    char char13 = i18n11.getColorChar();
    char char14 = i18n11.getColorChar();
    char char15 = i18n11.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n16 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char17 = i18n16.getColorChar();
    java.lang.String[] str_array18 = new java.lang.String[] {  };
    java.lang.String[] str_array20 = i18n16.getStrings(str_array18, "groundmc.lobby.vanish");
    java.lang.String[] str_array22 = i18n11.getStrings(str_array20, "coins");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str23 = commandFriend0.getTabCompletion(commandSender8, command9, "GMCx", str_array20);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char17 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array22);

  }

  @Test
  public void test487() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test487"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    java.lang.String str8 = commandFriend0.getName();
    java.lang.String str9 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender10 = null;
    org.bukkit.command.Command command11 = null;
    gtlp.groundmc.lobby.util.I18n i18n13 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char14 = i18n13.getColorChar();
    char char15 = i18n13.getColorChar();
    char char16 = i18n13.getColorChar();
    char char17 = i18n13.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n18 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char19 = i18n18.getColorChar();
    java.lang.String[] str_array20 = new java.lang.String[] {  };
    java.lang.String[] str_array22 = i18n18.getStrings(str_array20, "groundmc.lobby.vanish");
    java.lang.String[] str_array24 = i18n13.getStrings(str_array22, "friends");
    gtlp.groundmc.lobby.util.I18n i18n25 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char26 = i18n25.getColorChar();
    char char27 = i18n25.getColorChar();
    char char28 = i18n25.getColorChar();
    char char29 = i18n25.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n30 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char31 = i18n30.getColorChar();
    java.lang.String[] str_array32 = new java.lang.String[] {  };
    java.lang.String[] str_array34 = i18n30.getStrings(str_array32, "groundmc.lobby.vanish");
    java.lang.String[] str_array36 = i18n25.getStrings(str_array34, "coins");
    java.lang.String[] str_array38 = i18n13.getStrings(str_array34, "groundmc.lobby.hide_players");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str39 = commandFriend0.getTabCompletion(commandSender10, command11, "lobby", str_array38);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "friend"+ "'", str8.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str9 + "' != '" + "friend"+ "'", str9.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char14 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char16 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char17 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char19 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array22);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char26 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char27 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char28 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char29 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char31 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array34);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array36);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array38);

  }

  @Test
  public void test488() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test488"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender2 = null;
    org.bukkit.command.Command command3 = null;
    java.lang.String[] str_array5 = new java.lang.String[] {  };
    // The following exception was thrown during execution in test generation
    try {
    boolean b6 = commandFriend0.execute(commandSender2, command3, "groundmc.lobby.hide_players", str_array5);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array5);

  }

  @Test
  public void test489() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test489"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    char char3 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str6 = i18n0.getString("groundmc.lobby.hide_players", "friend");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char3 == '&');

  }

  @Test
  public void test490() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test490"); }

    gtlp.groundmc.lobby.util.I18n i18n0 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char1 = i18n0.getColorChar();
    char char2 = i18n0.getColorChar();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.String str5 = i18n0.getString("friends", "GMChide");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char1 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char2 == '&');

  }

  @Test
  public void test491() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test491"); }

    gtlp.groundmc.lobby.commands.CommandVanish commandVanish0 = new gtlp.groundmc.lobby.commands.CommandVanish();
    java.lang.String str1 = commandVanish0.getName();
    java.lang.String str2 = commandVanish0.getName();
    org.bukkit.command.CommandSender commandSender3 = null;
    org.bukkit.command.Command command4 = null;
    gtlp.groundmc.lobby.util.I18n i18n6 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char7 = i18n6.getColorChar();
    char char8 = i18n6.getColorChar();
    char char9 = i18n6.getColorChar();
    char char10 = i18n6.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n11 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char12 = i18n11.getColorChar();
    java.lang.String[] str_array13 = new java.lang.String[] {  };
    java.lang.String[] str_array15 = i18n11.getStrings(str_array13, "groundmc.lobby.vanish");
    java.lang.String[] str_array17 = i18n6.getStrings(str_array15, "friends");
    gtlp.groundmc.lobby.util.I18n i18n18 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char19 = i18n18.getColorChar();
    char char20 = i18n18.getColorChar();
    char char21 = i18n18.getColorChar();
    char char22 = i18n18.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n23 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char24 = i18n23.getColorChar();
    java.lang.String[] str_array25 = new java.lang.String[] {  };
    java.lang.String[] str_array27 = i18n23.getStrings(str_array25, "groundmc.lobby.vanish");
    java.lang.String[] str_array29 = i18n18.getStrings(str_array27, "coins");
    java.lang.String[] str_array31 = i18n6.getStrings(str_array27, "groundmc.lobby.hide_players");
    gtlp.groundmc.lobby.util.I18n i18n32 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char33 = i18n32.getColorChar();
    char char34 = i18n32.getColorChar();
    char char35 = i18n32.getColorChar();
    char char36 = i18n32.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n37 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char38 = i18n37.getColorChar();
    java.lang.String[] str_array39 = new java.lang.String[] {  };
    java.lang.String[] str_array41 = i18n37.getStrings(str_array39, "groundmc.lobby.vanish");
    java.lang.String[] str_array43 = i18n32.getStrings(str_array41, "friends");
    java.lang.String[] str_array45 = i18n6.getStrings(str_array43, "GMCsilent");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str46 = commandVanish0.getTabCompletion(commandSender3, command4, "friend", str_array45);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "vanish"+ "'", str1.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "vanish"+ "'", str2.equals("vanish"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char7 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array13);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array15);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array17);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char19 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char20 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char21 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n23);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char24 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array25);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array27);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array29);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array31);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char33 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char34 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char35 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char36 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n37);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char38 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array39);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array41);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array43);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array45);

  }

  @Test
  public void test492() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test492"); }

    gtlp.groundmc.lobby.commands.CommandLobby commandLobby0 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str1 = commandLobby0.getName();
    java.lang.String str2 = commandLobby0.getName();
    java.lang.String str3 = commandLobby0.getName();
    java.lang.String str4 = commandLobby0.getName();
    java.lang.String str5 = commandLobby0.getName();
    org.bukkit.command.CommandSender commandSender6 = null;
    org.bukkit.command.Command command7 = null;
    gtlp.groundmc.lobby.util.I18n i18n9 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char10 = i18n9.getColorChar();
    char char11 = i18n9.getColorChar();
    char char12 = i18n9.getColorChar();
    char char13 = i18n9.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n14 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char15 = i18n14.getColorChar();
    java.lang.String[] str_array16 = new java.lang.String[] {  };
    java.lang.String[] str_array18 = i18n14.getStrings(str_array16, "groundmc.lobby.vanish");
    java.lang.String[] str_array20 = i18n9.getStrings(str_array18, "friends");
    gtlp.groundmc.lobby.util.I18n i18n21 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char22 = i18n21.getColorChar();
    char char23 = i18n21.getColorChar();
    char char24 = i18n21.getColorChar();
    char char25 = i18n21.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n26 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char27 = i18n26.getColorChar();
    java.lang.String[] str_array28 = new java.lang.String[] {  };
    java.lang.String[] str_array30 = i18n26.getStrings(str_array28, "groundmc.lobby.vanish");
    java.lang.String[] str_array32 = i18n21.getStrings(str_array30, "coins");
    java.lang.String[] str_array34 = i18n9.getStrings(str_array30, "groundmc.lobby.hide_players");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str35 = commandLobby0.getTabCompletion(commandSender6, command7, "GMCry", str_array34);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "lobby"+ "'", str1.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "lobby"+ "'", str4.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "lobby"+ "'", str5.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char12 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char15 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n21);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char23 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char24 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char25 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char27 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array34);

  }

  @Test
  public void test493() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test493"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("friend");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test494() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test494"); }

    gtlp.groundmc.lobby.commands.CommandFriends commandFriends0 = new gtlp.groundmc.lobby.commands.CommandFriends();
    java.lang.String str1 = commandFriends0.getName();
    java.lang.String str2 = commandFriends0.getName();
    java.lang.String str3 = commandFriends0.getName();
    org.bukkit.command.CommandSender commandSender4 = null;
    org.bukkit.command.Command command5 = null;
    gtlp.groundmc.lobby.util.I18n i18n7 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char8 = i18n7.getColorChar();
    char char9 = i18n7.getColorChar();
    char char10 = i18n7.getColorChar();
    char char11 = i18n7.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    java.lang.String[] str_array18 = i18n7.getStrings(str_array16, "friends");
    gtlp.groundmc.lobby.util.I18n i18n19 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char20 = i18n19.getColorChar();
    char char21 = i18n19.getColorChar();
    char char22 = i18n19.getColorChar();
    char char23 = i18n19.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n24 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char25 = i18n24.getColorChar();
    java.lang.String[] str_array26 = new java.lang.String[] {  };
    java.lang.String[] str_array28 = i18n24.getStrings(str_array26, "groundmc.lobby.vanish");
    java.lang.String[] str_array30 = i18n19.getStrings(str_array28, "coins");
    java.lang.String[] str_array32 = i18n7.getStrings(str_array28, "groundmc.lobby.hide_players");
    gtlp.groundmc.lobby.util.I18n i18n33 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char34 = i18n33.getColorChar();
    char char35 = i18n33.getColorChar();
    char char36 = i18n33.getColorChar();
    char char37 = i18n33.getColorChar();
    gtlp.groundmc.lobby.util.I18n i18n38 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char39 = i18n38.getColorChar();
    java.lang.String[] str_array40 = new java.lang.String[] {  };
    java.lang.String[] str_array42 = i18n38.getStrings(str_array40, "groundmc.lobby.vanish");
    java.lang.String[] str_array44 = i18n33.getStrings(str_array42, "friends");
    java.lang.String[] str_array46 = i18n7.getStrings(str_array44, "GMCsilent");
    // The following exception was thrown during execution in test generation
    try {
    boolean b47 = commandFriends0.execute(commandSender4, command5, "hi!", str_array44);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friends"+ "'", str1.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friends"+ "'", str2.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friends"+ "'", str3.equals("friends"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char8 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char10 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char11 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array18);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n19);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char20 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char21 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char22 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char23 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n24);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char25 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array26);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array28);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array30);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array32);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n33);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char34 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char35 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char36 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char37 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n38);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char39 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array40);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array42);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array44);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array46);

  }

  @Test
  public void test495() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test495"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    // The following exception was thrown during execution in test generation
    try {
    boolean b2 = companion0.hasCommand("groundmc.lobby.admin");
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test496() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test496"); }

    int i1 = gtlp.groundmc.lobby.util.ExtensionsKt.getMegabytes(36700160);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test497() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test497"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.ILobbyCommand iLobbyCommand1 = null;
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand(iLobbyCommand1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);

  }

  @Test
  public void test498() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test498"); }

    gtlp.groundmc.lobby.commands.CommandFriend commandFriend0 = new gtlp.groundmc.lobby.commands.CommandFriend();
    java.lang.String str1 = commandFriend0.getName();
    java.lang.String str2 = commandFriend0.getName();
    java.lang.String str3 = commandFriend0.getName();
    java.lang.String str4 = commandFriend0.getName();
    java.lang.String str5 = commandFriend0.getName();
    java.lang.String str6 = commandFriend0.getName();
    java.lang.String str7 = commandFriend0.getName();
    java.lang.String str8 = commandFriend0.getName();
    org.bukkit.command.CommandSender commandSender9 = null;
    org.bukkit.command.Command command10 = null;
    gtlp.groundmc.lobby.util.I18n i18n12 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char13 = i18n12.getColorChar();
    java.lang.String[] str_array14 = new java.lang.String[] {  };
    java.lang.String[] str_array16 = i18n12.getStrings(str_array14, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    boolean b17 = commandFriend0.execute(commandSender9, command10, "groundmc.lobby.hide_players", str_array14);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "friend"+ "'", str1.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "friend"+ "'", str2.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "friend"+ "'", str3.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "friend"+ "'", str4.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "friend"+ "'", str5.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "friend"+ "'", str6.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "friend"+ "'", str7.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "friend"+ "'", str8.equals("friend"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char13 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array14);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array16);

  }

  @Test
  public void test499() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test499"); }

    gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion companion0 = gtlp.groundmc.lobby.registry.LobbyCommandRegistry.Companion;
    gtlp.groundmc.lobby.commands.CommandLobby commandLobby1 = new gtlp.groundmc.lobby.commands.CommandLobby();
    java.lang.String str2 = commandLobby1.getName();
    java.lang.String str3 = commandLobby1.getName();
    java.lang.String str4 = commandLobby1.getName();
    // The following exception was thrown during execution in test generation
    try {
    companion0.registerCommand((gtlp.groundmc.lobby.commands.ILobbyCommand)commandLobby1);
      org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(companion0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "lobby"+ "'", str2.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "lobby"+ "'", str3.equals("lobby"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "lobby"+ "'", str4.equals("lobby"));

  }

  @Test
  public void test500() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test500"); }

    gtlp.groundmc.lobby.commands.CommandCoins commandCoins0 = new gtlp.groundmc.lobby.commands.CommandCoins();
    java.lang.String str1 = commandCoins0.getName();
    java.lang.String str2 = commandCoins0.getName();
    java.lang.String str3 = commandCoins0.getName();
    java.lang.String str4 = commandCoins0.getName();
    org.bukkit.command.CommandSender commandSender5 = null;
    org.bukkit.command.Command command6 = null;
    gtlp.groundmc.lobby.util.I18n i18n8 = gtlp.groundmc.lobby.util.I18n.INSTANCE;
    char char9 = i18n8.getColorChar();
    java.lang.String[] str_array10 = new java.lang.String[] {  };
    java.lang.String[] str_array12 = i18n8.getStrings(str_array10, "groundmc.lobby.vanish");
    // The following exception was thrown during execution in test generation
    try {
    java.util.List<java.lang.String> list_str13 = commandCoins0.getTabCompletion(commandSender5, command6, "groundmc.lobby.hide_players", str_array12);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "coins"+ "'", str1.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "coins"+ "'", str2.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "coins"+ "'", str3.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "coins"+ "'", str4.equals("coins"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(i18n8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(char9 == '&');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNotNull(str_array12);

  }

}
